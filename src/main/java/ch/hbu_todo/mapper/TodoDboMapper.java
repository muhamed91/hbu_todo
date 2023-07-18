package ch.hbu_todo.mapper;

import ch.hbu_todo.dto.TodoDto;
import ch.hbu_todo.entities.CategoryDbo;
import ch.hbu_todo.entities.TodoDbo;
import org.springframework.stereotype.Controller;

@Controller
public class TodoDboMapper {
    public static TodoDbo dtoToDbo(TodoDto todoDto, CategoryDbo category) {

        if(category == null) {
            return null;
        }

        TodoDbo todoDbo = new TodoDbo();
        todoDbo.setId(todoDto.getId());
        todoDbo.setText(todoDto.getText());
        todoDbo.setDuedate(todoDto.getDueDate());
        todoDbo.setPriority(todoDto.getPriority());
        todoDbo.setCategory(category);
        return todoDbo;
    }

}
