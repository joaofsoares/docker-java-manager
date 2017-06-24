package com.github.docker.manager.model;

import java.util.ArrayList;

public class RepositoryStorage {

    private ArrayList<String> repositories;

    public RepositoryStorage() {

    }

    public static RepositoryStorage newInstance() {

        return new RepositoryStorage();

    }

    public RepositoryStorage withRepositories(ArrayList<String> arrayList) {

        this.repositories = arrayList;

        return this;

    }

    public ArrayList<String> getRepositories() {
        return repositories;
    }

    public void setRepositories(ArrayList<String> repositories) {
        this.repositories = repositories;
    }
}
