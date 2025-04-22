package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.model.Todo;
import spring.service.TodoService;

import java.util.List;

@Controller
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/todos/{id}")
    public String getTodo(@PathVariable int id, Model model) {
        model.addAttribute("todo", todoService.getOne(id));

        return "TodoView";
    }

    @RequestMapping("/todos")
    @ResponseBody
    public List<Todo> todos() {
        return  todoService.getAll();
    }
}
