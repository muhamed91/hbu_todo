package ch.hbu_todo.mapper;

import ch.hbu_todo.dto.CategoryDto;
import ch.hbu_todo.entities.CategoryDbo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class CategoryDtoMapper {

    public static CategoryDto map(CategoryDbo categoryDbo) {
        if(categoryDbo == null) {
            return null;
        }

        CategoryDto dto = new CategoryDto();
        dto.setId(categoryDbo.getId());
        dto.setCategoryName(categoryDbo.getCategoryName());
        dto.setCategoryColor(categoryDbo.getCategoryColor());
        return  dto;
    }


    public static List<CategoryDto> map(List<CategoryDbo> categoryDbos) {
        if (categoryDbos == null) {
            return Collections.emptyList();
        }

        List<CategoryDto> dtoCategories = new ArrayList<>();
        for (CategoryDbo categoryDbo : categoryDbos) {
            CategoryDto dto = CategoryDtoMapper.map(categoryDbo);
            if(dto != null) {
                dtoCategories.add(dto);
            }
        }

        return dtoCategories;
    }
    
}
