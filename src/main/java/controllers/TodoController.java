package controllers;


import model.DBNote;
import service.Todo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/todos")
@javax.enterprise.context.RequestScoped
public class TodoController {

    @Inject
    private Todo todoNotes;


    @GET
    @Produces(APPLICATION_JSON)
    public Response getTodos(){
        return Response.status(200).build();
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getTodo(@PathParam("id") int id) {
        if (id < 0) {
            return Response.status(404).build();
        }

       DBNote todo = todoNotes.getTodo(id);

       // MongoDB return null if nothing found
       if(todo == null){
           return Response.status(404).build();
       }

        return Response.ok(todo).build();

    }

}
