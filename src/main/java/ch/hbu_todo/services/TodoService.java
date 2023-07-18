package ch.hbu_todo.services;

import ch.hbu_todo.dto.TodoDto;
import ch.hbu_todo.entities.TodoDbo;

import java.util.List;

public interface TodoService {

    void create(TodoDbo todo);

    TodoDto getById(Integer id);

    List<TodoDto> getAll();

    TodoDto update(Integer id, TodoDto todo);

    void delete(Integer id);
}
