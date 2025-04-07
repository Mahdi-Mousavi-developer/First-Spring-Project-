package ir.maktabsharif.controler;



import ir.maktabsharif.model.ToDo;
import ir.maktabsharif.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private ToDoService todoService;

    @GetMapping
    public String getAllTodos(Model model) {
        model.addAttribute("todos", todoService.getAllToDo());
        return "index";
    }

    @PostMapping
    public String createTodo(@ModelAttribute ToDo todo) {
        todoService.createToDo(todo);
        return "redirect:/todos";
    }

    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable Long id, @ModelAttribute ToDo todo) {
        todoService.updateToDo(id, todo);
        return "redirect:/todos";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteToDo(id);
        return "redirect:/todos";
    }
}
