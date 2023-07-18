package ch.hbu_todo.repositories;

import ch.hbu_todo.entities.CategoryDbo;
import ch.hbu_todo.entities.TodoDbo;
import jakarta.persistence.Entity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends CrudRepository<TodoDbo, Integer> {

    List<TodoDbo> findAll();

    Optional<TodoDbo> findById(Integer id);

    void deleteById(Integer id);

}
