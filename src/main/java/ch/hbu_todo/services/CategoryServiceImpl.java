package ch.hbu_todo.services;

import ch.hbu_todo.dto.CategoryDto;
import ch.hbu_todo.entities.CategoryDbo;
import ch.hbu_todo.mapper.CategoryDtoMapper;
import ch.hbu_todo.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryDtoMapper categoryDtoMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryDtoMapper categoryDtoMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryDtoMapper = categoryDtoMapper;
    }
    @Override
    public CategoryDbo create(CategoryDbo category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public CategoryDto getById(Integer id) {
        CategoryDbo categoryDbo = this.categoryRepository.findById(id).get();
        return CategoryDtoMapper.map(categoryDbo);
    }

    @Override
    public List<CategoryDto> getAll() {
        return CategoryDtoMapper.map(categoryRepository.findAll());
    }

    @Override
    public CategoryDto update(Integer id, CategoryDto category) {
        return null;
    }

    @Override
    public CategoryDbo categoryDbo(Integer id) {
        return this.categoryRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        this.categoryRepository.deleteById(id);
    }
}
