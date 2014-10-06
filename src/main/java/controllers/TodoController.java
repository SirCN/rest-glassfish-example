package controllers;


import service.TodoService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/todos")
public class TodoController {

    @Inject
    private TodoService todoService;


    @GET
    @Produces(APPLICATION_JSON)
    public Response getTodos(){

        HashMap<String,List> response = new HashMap<>();
        response.put("todos",todoService.findAll());

        return Response.ok(response).build();
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getTodo(@PathParam("id") int id){

        return Response.ok(todoService.findById(id)).build();
    }

}
