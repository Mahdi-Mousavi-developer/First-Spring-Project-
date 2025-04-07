package ir.maktabsharif.repository;

import ir.maktabsharif.model.ToDo;

import java.util.List;

public interface TodoRepository {
    void delete(long id);
    ToDo create(ToDo todo);
    ToDo update(ToDo todo );
    List<ToDo> getAll();
}
