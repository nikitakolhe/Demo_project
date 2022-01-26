package com.ugam1.core.utils;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public  class Network {
    private static final String USER_AGENT = "Mozilla/5.0";

    public static String readJson(String url) {

        try {

            URL requestURL = new URL(url);

            HttpsURLConnection connection = (HttpsURLConnection) requestURL.openConnection();

            connection.setRequestMethod("GET");

            connection.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {

                BufferedReader line = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String inputLine;

                StringBuffer sb = new StringBuffer();

                while ((inputLine = line.readLine()) != null) {

                    sb.append(inputLine);

                }

                line.close();

                return sb.toString();

            }

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return "";

    }
}