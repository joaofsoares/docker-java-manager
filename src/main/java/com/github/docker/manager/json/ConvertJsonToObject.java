package com.github.docker.manager.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.docker.manager.model.RepositoryStorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConvertJsonToObject {

    private final static Logger logger = Logger.getLogger(ConvertJsonToObject.class.getName());

    public static RepositoryStorage convertJsonToStorageRepository(String json) {

        try {

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(json, RepositoryStorage.class);

        } catch (IOException e) {

            logger.log(Level.SEVERE, e.getMessage());

        }

        return RepositoryStorage.newInstance().withRepositories(new ArrayList<>());

    }

}
