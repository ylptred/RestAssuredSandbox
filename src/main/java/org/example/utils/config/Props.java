package org.example.utils.config;

import groovy.xml.XmlParser;

import java.io.*;
import java.util.Properties;

public class Props {
    public static String url;

    public Props() throws IOException {
        File configFile = new File("src/test/java/resources/config/config.properties");
        InputStream inputStream = new FileInputStream(configFile);
        Properties config = new Properties();
        config.load(inputStream);
        url = config.getProperty("megamarket.url");
    }
}