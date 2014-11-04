package service;


import dao.TodoDao;
import model.DBNote;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Stateless
@Named
public class TodoNotes implements Todo{

    @Inject
    private TodoDao genericTodo;

    public DBNote getTodo(int todoId){
        return genericTodo.getTodo(todoId);
    }
}
