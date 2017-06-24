package com.github.docker.manager.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpUrlConnection {

    private final static Logger logger = Logger.getLogger(HttpUrlConnection.class.getName());

    public static HttpResponse requestGET(String url) {

        try {

            HttpClient httpClient = HttpClientBuilder.create().build();

            HttpGet request = new HttpGet(url);

            return httpClient.execute(request);

        } catch (IOException e) {

            logger.log(Level.SEVERE, e.getMessage());

        }

        return null;

    }

    public static String getResponseString(HttpResponse response) {

        try {

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();

            String line = "";

            while ((line = rd.readLine()) != null) {

                result.append(line);

            }

            return result.toString();

        } catch (IOException e) {

            logger.log(Level.SEVERE, e.getMessage());

        }

        return null;

    }

}
