package fr.hervedarritchon.tutorials.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import fr.hervedarritchon.tutorials.technical.JsonMapperProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;

/**
 * Created by throdo/ahdi7503 on 11/03/2015.
 */
@ApplicationPath("api/v1")
public class RestConfig extends ResourceConfig {

    public RestConfig() {
        packages("fr.hervedarritchon.tutorials");
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        register(JsonMapperProvider.class);
        register(JacksonJsonProvider.class);
    }
}
