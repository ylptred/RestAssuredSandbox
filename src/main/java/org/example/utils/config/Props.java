package org.example.utils.config;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;
import java.nio.file.Files;

public class Props {
    public static String url;

    public Props() throws IOException {
        InputStream inputStream = Files.newInputStream(Paths.get("src/test/java/resources/config/config.properties"),
                StandardOpenOption.READ);
        Properties config = new Properties();
        config.load(inputStream);
        url = config.getProperty("megamarket.url");
    }
}