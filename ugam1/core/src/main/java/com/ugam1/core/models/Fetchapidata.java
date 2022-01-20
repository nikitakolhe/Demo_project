package com.ugam1.core.models;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Fetchapidata  {
    public List<Map<String,String>> getData() throws JSONException, IOException;
    public String getmultiUrl();

}
