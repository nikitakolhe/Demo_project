package com.ugam1.core.models.Impl;
import com.day.cq.commons.date.InvalidDateException;
import com.ugam1.core.schedulers.Ugam1Scheduler;
import com.adobe.fd.fp.util.PortalUtils;
import com.ugam1.core.config.SchedulerConfiguration;
import com.day.cq.commons.date.DateUtil;
import com.day.cq.replication.*;
import com.ugam1.core.models.Update;
import com.ugam1.core.utils.ResolverUtil;
import org.apache.commons.logging.Log;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.security.auth.login.LoginException;
import java.util.Calendar;

@Component(immediate = true)
public class ReplicationProcessor implements Preprocessor {
    private static final Logger log = LoggerFactory.getLogger(ReplicationProcessor.class);
    @Reference
    private ResourceResolverFactory resourceResolverFactory;
    @Reference
    Update update;
    String path1="/content/ugam1/us/en/schedulers/jcr:content/root/container/scheduler";
    @Reference
    private Replicator replicator;
    @Override
    public void preprocess(final ReplicationAction replicationAction,
                           final ReplicationOptions replicationOptions) throws ReplicationException {

        if (replicationAction == null || !ReplicationActionType.ACTIVATE.equals(replicationAction.getType())) {
            return;
        }
        String path = replicationAction.getPath();
        if(path.equals("/content/ugam1/us/en/schedulers")){
            log.debug("path equal");
            ResourceResolver serviceResourceResolver = null;
            try {
                log.debug("===============inside try====================");
                serviceResourceResolver = ResolverUtil.newResolver(resourceResolverFactory);
                Session session = serviceResourceResolver.adaptTo(Session.class);
                Resource resource = serviceResourceResolver.getResource("/content/ugam1/us/en/schedulers/jcr:content/root/container/scheduler");
                Node node = resource.adaptTo(Node.class);

                if(node.getProperty("Time") == DateUtil.parseISO8601(DateUtil.getISO8601Date(Calendar.getInstance())))
                {
                    log.debug("===============inside if==============");
                }else {
                    log.debug("===============inside else====================");
                    update.update(path1);

                }
                    session.save();
                    session.logout();

            } catch (LoginException | RepositoryException | InvalidDateException | org.apache.sling.api.resource.LoginException e) {
                e.printStackTrace();
            }

        }
        try {
            log.debug(path);
        }
        catch (Exception e) {
            log.debug(e.getMessage());
        }
    }

}
