package org.example.dao;

import org.example.model.TodoList;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoMapper implements RowMapper {
    @Override
    public TodoList mapRow(ResultSet rs, int rowNum) throws SQLException {
        TodoList todoList = new TodoList();

        todoList.setId(rs.getInt("id"));
        todoList.setNameTask(rs.getString("nametask"));
        todoList.setTitleTask(rs.getString("titletask"));
        todoList.setDone(rs.getBoolean("done"));

        return todoList;
    }
}
