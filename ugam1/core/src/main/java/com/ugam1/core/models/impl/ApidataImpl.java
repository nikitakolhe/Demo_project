package com.ugam1.core.models.impl;
import com.ugam1.core.models.Apidata;
import com.ugam1.core.utils.Network;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import java.util.Iterator;

@Model(adaptables = Resource.class,
        adapters = Apidata.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ApidataImpl implements Apidata{
    final Logger LOG = LoggerFactory.getLogger(ApidataImpl.class);
    @Inject
    String url;
    private String message;
    private String email;
    private String firstname;
    private String lastname;
    private String image;
    @Override
    public String getUrl() {
        return "https://reqres.in/api/users/"+url;
    }

    @Override
    public String getMessage() throws JSONException {

        String response = Network.readJson("https://reqres.in/api/users/"+url);
        JSONObject jsonObject =  new JSONObject(response);
        Iterator x = jsonObject.keys();
        JSONArray jsonArray = new JSONArray();
        while (x.hasNext()){
            String key = (String) x.next();
            jsonArray.put(jsonObject.get(key));
        }
        email = jsonArray.getJSONObject(0).getString("email");
        firstname = jsonArray.getJSONObject(0).getString("first_name");
        lastname = jsonArray.getJSONObject(0).getString("last_name");
        image = jsonArray.getJSONObject(0).getString("avatar");
        return response;
    }

    public String getFirstName(){
        return firstname;
    }

    @Override
    public String getLastName() {
        return lastname;
    }

    @Override
    public String getImage() {
        String path=image.replaceAll("https://reqres.in/img/faces/","/content/dam/ugam1/");
        return path;
    }

    @Override
    public String getEmail() {
        return email;
    }
}
