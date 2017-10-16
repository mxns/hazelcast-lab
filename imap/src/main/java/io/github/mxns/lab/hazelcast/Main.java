package io.github.mxns.lab.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class Main {
    public static void main(String[] args) throws IOException {
        String baseUri = "http://" + args[0] + ":8080/maps/";
        InputStream url = Main.class.getClassLoader().getResourceAsStream("hazelcast.xml");
        Config cfg = new XmlConfigBuilder(url).build();
        Hazelcast.getOrCreateHazelcastInstance(cfg);
        ResourceConfig rc = new ResourceConfig().packages("io.github.mxns.lab.hazelcast.resources");
        GrizzlyHttpServerFactory.createHttpServer(URI.create(baseUri), rc);
    }
}

