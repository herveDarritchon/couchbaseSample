package fr.hervedarritchon.tutorials.config;

import com.couchbase.client.CouchbaseClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.util.ArrayList;

/**
 * Created by throdo/ahdi7503 on 11/03/2015.
 */
@Configuration
@ComponentScan(basePackages = "fr.hervedarritchon.tutorials")
public class SpringConfig {

    @Bean (name="couchbaseClient")
    public CouchbaseClient retrieveCouchbaseClient() {
        ArrayList<URI> nodes = new ArrayList<>();

        // Add one or more nodes of your cluster (exchange the IP with yours)
        nodes.add(URI.create("http://127.0.0.1:8091/pools"));

        // Try to connect to the client
        CouchbaseClient client = null;
        try {
            client = new CouchbaseClient(nodes, "default", "");
        } catch (Exception e) {
            System.err.println("Error connecting to Couchbase: " + e.getMessage());
            System.exit(1);
        }

        return client;
    }

}
