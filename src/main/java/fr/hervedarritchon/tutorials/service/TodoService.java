package fr.hervedarritchon.tutorials.service;

import fr.hervedarritchon.tutorials.consumer.TodoDao;
import fr.hervedarritchon.tutorials.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by throdo/ahdi7503 on 11/03/2015.
 */
@Service("todoService")
public class TodoService {

    @Autowired
    private TodoDao todoDao;

    public String addTodo(Todo todo) {
        String id = UUID.randomUUID().toString();
        todo.setId(id);
        todoDao.addItemToCluster(id, todo);
        return id;
    }

    public Todo getTodo(String key) {
        return todoDao.getItemFromCluster(key);
    }
}
