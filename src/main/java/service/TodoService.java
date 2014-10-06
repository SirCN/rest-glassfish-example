package service;


import javax.enterprise.context.Dependent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Dependent
public class TodoService {

    public List<HashMap> findAll(){
        return this.mockFindAll();
    }

    public HashMap findById(int id){
        return this.mockFindId(id);
    }

    /*
        The "mock" methods below are only added due to demo purpose. Do not do it
        like this unless it's for demo!
     */

    private List<HashMap> mockFindAll(){
        HashMap todo = new HashMap();
        List<HashMap> todos = new ArrayList<>();

        todo.put("Title", "This is a title");
        todo.put("Description", "Tnis is a description");
        todo.put("Done",false);

        for(int i = 0; i < 10; i++){
            todos.add(todo);
        }

        return todos;
    }

    private HashMap mockFindId(int id){
        List<HashMap> todos = this.mockFindAll();
        return todos.get(id);
    }
}
