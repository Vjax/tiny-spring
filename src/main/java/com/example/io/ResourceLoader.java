package com.example.io;

import org.junit.Assert;

import java.io.File;
import java.net.URL;

public class ResourceLoader {

    public Resource getResource(String location) throws Exception{
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
