package ch.hbu_todo.controller;

import ch.hbu_todo.dto.CategoryDto;
import ch.hbu_todo.dto.TodoDto;
import ch.hbu_todo.mapper.CategoryDboMapper;
import ch.hbu_todo.services.CategoryService;
import ch.hbu_todo.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CategoryController {

    private final CategoryService categoryService;
    private final TodoService todoService;

    public CategoryController(CategoryService categoryService, TodoService todoService) {
        this.categoryService = categoryService;
        this.todoService = todoService;
    }


    @GetMapping("/add-category")
    public String addCategories(Model model, @ModelAttribute CategoryDto category) {
        model.addAttribute("category", category);
        return "create-category";
    }

    @PostMapping("/add-new-category")
    public String addTodo(Model model, @ModelAttribute CategoryDto category) {
        this.categoryService.create(CategoryDboMapper.dtoTodbo(category));
        return "redirect:/categories";
    }

    @GetMapping("/categories")
    public String index(Model model, CategoryDto cats) {

        List<CategoryDto> categories = categoryService.getAll();
        List<TodoDto> allTodos = todoService.getAll();

        Map<String, Integer> todoCountsByCategory = new HashMap<>();
        for (CategoryDto category : categories) {
            String categoryName = category.getCategoryName();
            List<TodoDto> todosForCategory = allTodos.stream()
                    .filter(todo -> todo.getCategoryName().contains(categoryName))
                    .toList();
            int todoCountForCategory = todosForCategory.size();
            todoCountsByCategory.put(categoryName, todoCountForCategory);
        }

        model.addAttribute("categories", this.categoryService.getAll());
        model.addAttribute("todoCountsByCategory", todoCountsByCategory);
        return "categories";
    }

    @GetMapping("categories/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Integer id, Model model) {
        this.categoryService.delete(id);
        return "redirect:/categories";
    }
}
