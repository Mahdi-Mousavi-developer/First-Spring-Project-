package ir.maktabsharif.repository.Impl;

import ir.maktabsharif.model.ToDo;
import ir.maktabsharif.repository.TodoRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ToDoRepositoryImpl implements TodoRepository {

    private EntityManagerFactory emf;
    private Class<? extends ir.maktabsharif.model.ToDo> ToDo;


    @Override
    public void delete(long id) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        ToDo foundedToDo = entityManager.find(ToDo ,id);
        try {
            transaction.begin();
            entityManager.remove(foundedToDo);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public ToDo create(ToDo todo) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(todo);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
            return todo;
        }

    }

    @Override
    public ToDo update(ToDo todo) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            ToDo foundedToDo = entityManager.find(ToDo ,todo.getId());
            transaction.begin();
            foundedToDo.setId(todo.getId());
            foundedToDo.setCompleted(todo.getCompleted());
            entityManager.persist(foundedToDo);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        return todo;
    }

    @Override
    public List<ToDo> getAll() {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Query query = null;

            query = entityManager.createQuery("select c from ToDo c");

        return query.getResultList();
    }
}
