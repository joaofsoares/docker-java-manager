package com.github.docker.manager.test;

import com.github.docker.manager.DockerManager;
import com.github.docker.manager.model.RepositoryStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.when;

public class DockerRepositoryTest {

    @Mock
    private DockerManager dockerManager;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRepositoryList() {

        when(dockerManager.getRepositoryList())
                .thenReturn(RepositoryStorage.newInstance()
                        .withRepositories(new ArrayList<>(Arrays.asList("slackware", "debian", "openSUSE"))));

        RepositoryStorage repositoryList = dockerManager.getRepositoryList();

        Assert.assertEquals(repositoryList.getRepositories().size(), 3);

    }

    @Test
    public void testRepositoryListEmpty() {

        when(dockerManager.getRepositoryList())
                .thenReturn(RepositoryStorage.newInstance()
                        .withRepositories(new ArrayList<>()));

        RepositoryStorage repositoryList = dockerManager.getRepositoryList();

        Assert.assertEquals(repositoryList.getRepositories().size(), 0);

    }


}
