package model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jongo.marshall.jackson.oid.Id;

import java.util.Objects;


public class DBNote {

    @Id
    @JsonIgnore
    private String _id;

    private  int todoId;

    private  String heading;

    private  String body;



    public DBNote(int id, String heading, String body){
        this.todoId = id;
        this.heading = heading;
        this.body = body;
    }

    // dummy constructor
    public DBNote(){

    }

    public int getTodoId(){
        return todoId;
    }

    public String getHeading(){
        return heading;
    }

    public String getBody(){
        return body;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this._id);
        hash = 59 * hash + Objects.hashCode(this.todoId);
        hash = 59 * hash + Objects.hashCode(this.heading);
        hash = 59 * hash + Objects.hashCode(this.body);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DBNote other = (DBNote) obj;
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }

        if (!Objects.equals(this.todoId, other.todoId)) {
            return false;
        }

        if (!Objects.equals(this.heading, other.heading)) {
            return false;
        }
        if (!Objects.equals(this.body, other.body)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Todo{" + ", todoId=" + todoId + ", heading=" + heading + ", body=" + body + '}';
    }
}
