package ch.hbu_todo.mapper;

import ch.hbu_todo.dto.CategoryDto;
import ch.hbu_todo.entities.CategoryDbo;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryDboMapper {
    public static CategoryDbo dtoTodbo(CategoryDto categoryDto) {
        CategoryDbo dbo = new CategoryDbo();
        dbo.setId(categoryDto.getId());
        dbo.setCategoryName(categoryDto.getCategoryName());
        dbo.setCategoryColor(categoryDto.getCategoryColor());

        return dbo;
    }
}
