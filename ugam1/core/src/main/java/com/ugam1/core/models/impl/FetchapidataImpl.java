package com.ugam1.core.models.impl;

import com.ugam1.core.models.Fetchapidata;
import com.ugam1.core.utils.Network;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.json.JSONArray;
import org.json.JSONObject;

@Model(adaptables = Resource.class,
        adapters = Fetchapidata.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class FetchapidataImpl implements Fetchapidata {
    final Logger log = LoggerFactory.getLogger(FetchapidataImpl.class);
    @Inject
    String pageNo;
    @Override
    public List<Map<String, String>> getData() throws JSONException, IOException {

        String response = Network.readJson(getUrl());
        JSONObject jsonObject =  new JSONObject(response);
        log.info(String.valueOf(jsonObject));
        JSONArray jsonArray1 = jsonObject.getJSONArray("data");
        log.info("==============="+jsonArray1);
        log.info("==============="+jsonArray1.length());
        List<Map<String, String>> userList = new ArrayList<>();
        for (int i=0;i<jsonArray1.length();i++){
            Map<String,String> user =new HashMap<>();
            user.put("fname",jsonArray1.getJSONObject(i).getString("first_name"));
            user.put("lname",jsonArray1.getJSONObject(i).getString("last_name"));
            user.put("email",jsonArray1.getJSONObject(i).getString("email"));
            user.put("avatar",jsonArray1.getJSONObject(i).getString("avatar"));
            userList.add(user);
        }
        log.info("===list==="+userList);
        return userList;
    }


    @Override
    public String getUrl() {
        return "https://reqres.in/api/users?page="+pageNo;
    }
}