package fr.hervedarritchon.tutorials.provider;

import fr.hervedarritchon.tutorials.model.Todo;
import fr.hervedarritchon.tutorials.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;

/**
 * Root resource (exposed at "todos" path)
 */
@Path("todos")
public class TodosResource {

    @Context
    private UriInfo ui;

    @Autowired
    private TodoService todoService;

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Todo getItJson(@PathParam("id") String key) {
        return todoService.getTodo(key);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewTodo(Todo todo) {
        UriBuilder ub = ui.getAbsolutePathBuilder();
        String id = todoService.addTodo(todo);
        URI createdURI = ub.path(id).build();
        return Response.created(createdURI).build();
    }

    public TodosResource() {
    }
}
