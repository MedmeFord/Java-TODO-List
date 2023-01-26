package org.example.controler;

import org.example.dao.TodoDAO;
import org.example.model.TodoList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {
    private final TodoDAO todoDAO;

    public TodoController(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    @GetMapping("/myTask")
    public String showAllTask(Model model){
        model.addAttribute("tasks", todoDAO.showAllTask());
        return "/TodoController/myTaskPage";
    }

    @GetMapping("/myTask/newTask")
    public String createNewTaskPage(@ModelAttribute("newTasks") TodoList todoList) {
        return "/TodoController/createNewTask";
    }

    @PostMapping("/myTask/newTask")
    public String createNewTask(@ModelAttribute("createTask") TodoList todoList) {
        todoDAO.createTask(todoList);

        return "redirect:/myTask";
    }
    @GetMapping("/myTask/{id}")
    public String showTaskOfId(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("myTask", todoDAO.showTask(id));
        return "/TodoController/showTaskOfIdPage";
    }

    @GetMapping("/myTask/{id}/edit")
    public String showEditPage(@PathVariable("id") Integer id ,Model model) {
        model.addAttribute("tasks", todoDAO.showTask(id));
        return "/TodoController/editTaskPage";
    }

    @PatchMapping("/myTask/{id}/edit")
    public String updateEditPage(@PathVariable("id") Integer id, @ModelAttribute("tasks") TodoList todoList, boolean done) {
        todoDAO.editTask(id , todoList, done);
        return "redirect:/myTask";
    }

    @DeleteMapping("/myTask/{id}")
    public String delete(@PathVariable("id") Integer id) {
        todoDAO.deleteTask(id);
        return "redirect:/myTask";
    }

}
