package dao;

import model.DBNote;

public interface TodoDao {
    public DBNote getTodo(int todoId);
}
