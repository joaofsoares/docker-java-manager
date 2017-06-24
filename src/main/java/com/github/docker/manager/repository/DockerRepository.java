package com.github.docker.manager.repository;

import com.github.docker.manager.DockerManager;
import com.github.docker.manager.json.ConvertJsonToObject;
import com.github.docker.manager.model.RepositoryStorage;
import com.github.docker.manager.service.HttpUrlConnection;
import org.apache.http.HttpResponse;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DockerRepository {

    private final static Logger logger = Logger.getLogger(DockerManager.class.getName());

    public static RepositoryStorage getRepositoryList(String dockerAddress) {

        try {

            HttpResponse response = HttpUrlConnection.requestGET(dockerAddress + "/v2/_catalog");

            if (response != null && response.getStatusLine().getStatusCode() == 200) {

                String responseJson = HttpUrlConnection.getResponseString(response);

                return ConvertJsonToObject.convertJsonToStorageRepository(responseJson);

            }

            return RepositoryStorage.newInstance().withRepositories(new ArrayList<>());

        } catch (Exception e) {

            logger.log(Level.SEVERE, e.getMessage());

        }

        return RepositoryStorage.newInstance().withRepositories(new ArrayList<>());

    }

}
