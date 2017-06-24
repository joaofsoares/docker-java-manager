package com.github.docker.manager;

import com.github.docker.manager.model.RepositoryStorage;
import com.github.docker.manager.repository.DockerRepository;

public class DockerManager {

    private String dockerAddress;

    /**
     * @param dockerAddress dockerAddres format http://address:port
     */
    public DockerManager(String dockerAddress) {

        this.dockerAddress = dockerAddress;

    }

    /**
     * Method returns all the repositories in docker
     *
     * @return ResitoryStorage
     * save all repositories names
     */
    public RepositoryStorage getRepositoryList() {

        return DockerRepository.getRepositoryList(dockerAddress);

    }

}
