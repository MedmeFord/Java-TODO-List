package org.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class TodoList {
    private Integer id;
    private String nameTask;
    private String titleTask;
    private boolean done;

    public TodoList() {
    }

    public TodoList(Integer id, String nameTask, String titleTask, boolean done) {
        this.id = id;
        this.nameTask = nameTask;
        this.titleTask = titleTask;
        this.done = done;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getTitleTask() {
        return titleTask;
    }

    public void setTitleTask(String titleTask) {
        this.titleTask = titleTask;
    }
}
