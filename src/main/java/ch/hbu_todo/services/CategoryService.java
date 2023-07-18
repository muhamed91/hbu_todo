package ch.hbu_todo.services;

import ch.hbu_todo.dto.CategoryDto;
import ch.hbu_todo.entities.CategoryDbo;

import java.util.List;

public interface CategoryService {

    CategoryDbo create(CategoryDbo category);

    CategoryDto getById(Integer id);

    List<CategoryDto> getAll();

    CategoryDto  update(Integer id, CategoryDto  category);

    CategoryDbo categoryDbo(Integer id);

    void delete(Integer id);
}
