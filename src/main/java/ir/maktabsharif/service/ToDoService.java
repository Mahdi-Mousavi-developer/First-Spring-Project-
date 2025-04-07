package ir.maktabsharif.service;

import ir.maktabsharif.model.ToDo;
import ir.maktabsharif.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private TodoRepository todoRepository;

    public ToDo createToDo(ToDo todo){
        return todoRepository.create(todo);
    }
    public List<ToDo> getAllToDo(){
        return todoRepository.getAll();
    }
    public void deleteToDo(long id){
        todoRepository.delete(id);
    }
    public ToDo updateToDo(Long id, ToDo todo){
        return todoRepository.update(todo);
    }
}
