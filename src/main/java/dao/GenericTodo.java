package dao;

import com.mongodb.MongoClient;
import model.DBNote;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Named;
import java.net.UnknownHostException;

@Named
@Stateless
public class GenericTodo implements TodoDao{

    private MongoCollection todoCollection;

    @PostConstruct
    private void initDB(){
        try {
            // Get an instance of Mongo
            MongoClient client = new MongoClient("localhost", 27017);
            Jongo jongo = new Jongo(client.getDB("todosDB"));
            todoCollection = jongo.getCollection("todos");

        } catch (UnknownHostException ex) {
            System.out.println("Exception" + ex);
            //Logger.getLogger(GenericTodo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DBNote getTodo(int todoId){
            return  todoCollection.findOne("{todoId: #}", todoId).as(DBNote.class);
    }
}

