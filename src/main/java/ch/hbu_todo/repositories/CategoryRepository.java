package ch.hbu_todo.repositories;

import ch.hbu_todo.entities.CategoryDbo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<CategoryDbo, Integer> {

    List<CategoryDbo> findAll();

}
