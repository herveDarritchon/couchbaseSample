package fr.hervedarritchon.tutorials.technical;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Created by throdo/ahdi7503 on 13/03/2015.
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JsonMapperProvider implements ContextResolver<ObjectMapper> {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public ObjectMapper getContext(Class<?> arg0) {
        return objectMapper;
    }

}