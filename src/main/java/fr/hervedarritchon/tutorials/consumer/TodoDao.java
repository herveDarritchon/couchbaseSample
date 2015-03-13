package fr.hervedarritchon.tutorials.consumer;

import com.couchbase.client.CouchbaseClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.hervedarritchon.tutorials.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * Created by throdo/ahdi7503 on 11/03/2015.
 */
@Repository("todoDao")
public class TodoDao {

    @Autowired
    private CouchbaseClient client;

    @Autowired
    private ObjectMapper mapper;


    public void addItemToCluster(String key, Todo todo) {
        try {
            final String todoToStore = mapper.writeValueAsString(todo);
            client.set(key, todoToStore);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public Todo getItemFromCluster(String key) {
        Todo todoRetrieved = null;
        try {
            todoRetrieved = mapper.readValue((String) client.get(key), Todo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return todoRetrieved;
    }

}
