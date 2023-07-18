package ch.hbu_todo.services;

import ch.hbu_todo.dto.TodoDto;
import ch.hbu_todo.entities.TodoDbo;
import ch.hbu_todo.mapper.TodoDtoMapper;
import ch.hbu_todo.repositories.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;
    private final CategoryService categoryService;

    private final TodoDtoMapper todoDtoMapper;

    public TodoServiceImpl(TodoRepository todoRepository, TodoDtoMapper todoDtoMapper, CategoryService categoryService) {
        this.todoRepository = todoRepository;
        this.todoDtoMapper = todoDtoMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void create(TodoDbo todo) {
    this.todoRepository.save(todo);
    }

    @Override
    public TodoDto getById(Integer id) {
        Optional<TodoDbo> todoDboOptional = this.todoRepository.findById(id);

        if (todoDboOptional.isPresent()) {
            TodoDbo todoDbo = todoDboOptional.get();
            return TodoDtoMapper.map(todoDbo);
        } else {
            return null;
        }

    }

    @Override
    public List<TodoDto> getAll() {
      return  TodoDtoMapper.map(this.todoRepository.findAll());
    }

    @Override
    public TodoDto update(Integer id, TodoDto updatedTodoDto) {
        Optional<TodoDbo> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isPresent()) {
            TodoDbo existingTodo = optionalTodo.get();
            existingTodo.setText(updatedTodoDto.getText());
            existingTodo.setDuedate(updatedTodoDto.getDueDate());
            existingTodo.setPriority(updatedTodoDto.getPriority());
            existingTodo.setCategory(categoryService.categoryDbo(updatedTodoDto.getCategory()));
            existingTodo.setDone(updatedTodoDto.isDone());

            TodoDbo savedTodo = todoRepository.save(existingTodo);

            return TodoDtoMapper.map(savedTodo);
        } else {
            throw new EntityNotFoundException("Todo with ID " + id + " not found.");
        }
    }

    @Override
    public void delete(Integer id) {
        this.todoRepository.deleteById(id);
    }
}
