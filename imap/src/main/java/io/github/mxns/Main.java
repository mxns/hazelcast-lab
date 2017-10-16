package io.github.mxns;

import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class Main {
    static final String BASE_URI = "http://0.0.0.0:8080/maps/";

    public static void main(String[] args) throws IOException {
        InputStream url = Main.class.getClassLoader().getResourceAsStream("hazelcast.xml");
        Config cfg = new XmlConfigBuilder(url).build();
        Hazelcast.getOrCreateHazelcastInstance(cfg);
        ResourceConfig rc = new ResourceConfig().packages("io.github.mxns");
        GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }
}

