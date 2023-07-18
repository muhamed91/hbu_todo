package ch.hbu_todo.mapper;

import ch.hbu_todo.dto.TodoDto;
import ch.hbu_todo.entities.TodoDbo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class TodoDtoMapper {

    public static TodoDto map(TodoDbo todoDbo) {
        if(todoDbo == null) {
            return null;
        }

        TodoDto dto = new TodoDto();
        dto.setId(todoDbo.getId());
        dto.setText(todoDbo.getText());
        dto.setDueDate(todoDbo.getDuedate());
        dto.setCategory(todoDbo.getCategory().getId());
        dto.setCategoryName(todoDbo.getCategory().getCategoryName());
        dto.setCategoryColor(todoDbo.getCategory().getCategoryColor());
        dto.setDone(todoDbo.isDone());
        dto.setPriority(todoDbo.getPriority());
        return  dto;
    }


    public static List<TodoDto> map(List<TodoDbo> todoDbos) {
        if (todoDbos == null) {
            return Collections.emptyList();
        }

        List<TodoDto> dtoTodos = new ArrayList<>();

        for (TodoDbo todoDbo : todoDbos) {
            TodoDto dto = (TodoDto) TodoDtoMapper.map(todoDbo);
            if(dto != null) {
                dtoTodos.add(dto);
            }

        }

        return dtoTodos;
    }


}
