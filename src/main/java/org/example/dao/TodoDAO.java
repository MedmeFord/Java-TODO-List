package org.example.dao;

import org.example.model.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoDAO {
   private final JdbcTemplate jdbcTemplate;

   @Autowired
    public TodoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TodoList> showAllTask() {
       return jdbcTemplate.query("SELECT * FROM tasks", new TodoMapper());
    }

    public TodoList showTask(Integer id) {
       return (TodoList) jdbcTemplate.query("SELECT * FROM tasks WHERE id=?", new Object[]{id}, new TodoMapper())
               .stream().findAny().orElse(null);
    }

    public void editTask(Integer id, TodoList updatedTask) {
        jdbcTemplate.update("UPDATE tasks SET nametask=?, title=?, done=? WHERE id=?",
                updatedTask.getNameTask(), updatedTask.getTitleTask(), id);
    }
}
