package com.loop.troop.design.adapter;

import java.io.InputStream;

public class ResourceLoader {


    private ResourceLoader() {
    }

    /**
     * Reads a file from the classpath.
     *
     * @param resourcePath path relative to classpath, e.g., "data/sample.json"
     * @return InputStream to read the file
     * @throws IllegalArgumentException if file not found
     */
    public static InputStream getResourceAsStream(String resourcePath) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath);
        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + resourcePath);
        }
        return is;
    }
}
