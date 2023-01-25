package org.example.controler;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.example.dao.TodoDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

}
