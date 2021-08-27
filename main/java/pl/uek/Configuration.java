package pl.uek;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public final class Configuration {

    private final Properties properties = new Properties();
    public static final Configuration INSTANCE = new Configuration();

    private Configuration() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("local.properties").getFile());

        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }

    public URL getGridUrl() {
        String gridUrl = properties.getProperty("hub.url");
        try {
            return new URL(gridUrl);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}