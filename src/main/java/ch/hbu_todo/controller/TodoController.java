package ch.hbu_todo.controller;

import ch.hbu_todo.dto.TodoDto;
import ch.hbu_todo.mapper.TodoDboMapper;
import ch.hbu_todo.repositories.TodoRepository;
import ch.hbu_todo.services.CategoryService;
import ch.hbu_todo.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class TodoController {

    private final CategoryService categoryService;
    private final TodoService todoService;
    private final TodoDboMapper todoDboMapper;
    private final TodoRepository todoRepository;


    public TodoController(CategoryService categoryService, TodoService todoService, TodoDboMapper todoDboMapper, TodoRepository todoRepository) {
        this.categoryService = categoryService;
        this.todoService = todoService;
        this.todoDboMapper = todoDboMapper;
        this.todoRepository = todoRepository;
    }


    @GetMapping("/")
    public String index(Model model, TodoDto todo) {

        model.addAttribute("categories", this.categoryService.getAll());
        model.addAttribute("todo", todo);
        return "index";
    }

    @PostMapping("/addTodo")
     public String addTodo(Model model, @ModelAttribute TodoDto todo) {
        this.todoService.create(TodoDboMapper.dtoToDbo(todo, this.categoryService.categoryDbo(todo.getCategory())));
        return "redirect:/list-todos";
    }


    @GetMapping("/list-todos")
    public String listTodo(Model model, @ModelAttribute TodoDto todo) {
        List<TodoDto> todos = this.todoService.getAll();

        if (todos.isEmpty()) {
            return "holiday";
        }

        model.addAttribute("todos", todos);
        return "list";

    }


    @GetMapping("/update-status/{id}")
    public String updateTodoStatus(Model model, @PathVariable("id") Integer id) {
        TodoDto todo = this.todoService.getById(id);
            boolean isDone = !todo.isDone();
            todo.setDone(isDone);
            this.todoService.update(id, todo);
        model.addAttribute("todo", todo);
        return "redirect:/list-todos";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Integer id, Model model) {
        this.todoService.delete(id);
        return "redirect:/list-todos";
    }


    @GetMapping("/update/{id}")
    public String updateTodo(@PathVariable Integer id, @ModelAttribute TodoDto todo, Model model) {
        todo.setDueDate(todo.getDueDate());
        model.addAttribute("todo", this.todoService.getById(id));
        model.addAttribute("categories", this.categoryService.getAll());
        return "update-todo";
    }


    @PostMapping("/updateTodo/{id}")
    public String updateTodo(@PathVariable Integer id, Model model, @ModelAttribute TodoDto todo, @RequestParam(name = "todoDate") LocalDate todoDate) {
        todo.setDueDate(todoDate);
        this.todoService.update(id, todo);
        model.addAttribute("todo", todo);
        model.addAttribute("categories", this.categoryService.getAll());
        return "redirect:/update/{id}";
    }


    @GetMapping("/sort/category")
    public String categorySort(Model model) {
        boolean sortCatEnabled = false;
        List<TodoDto> todos = this.todoService.getAll();
        todos.sort(Comparator.comparing(TodoDto::getCategory));
        sortCatEnabled = true;
        model.addAttribute("sortCatEnabled", sortCatEnabled);
        model.addAttribute("todos", todos);
        return "list";
    }


    @GetMapping("/sort/date")
    public String dateSort(Model model) {
        boolean sortDateEnabled = false;
        List<TodoDto> todos = this.todoService.getAll();
        todos.sort(Comparator.comparing(TodoDto::getDueDate));
        sortDateEnabled = true;
        model.addAttribute("sortDateEnabled", sortDateEnabled);
        model.addAttribute("todos", todos);
        return "list";
    }



    @GetMapping("/sort/prio")
    public String prioritySort(Model model) {
        boolean sortPrioEnabled = false;
        List<TodoDto> todos = this.todoService.getAll();
        todos.sort(Comparator.comparingInt(TodoDto::getPriority));
        sortPrioEnabled = true;
        model.addAttribute("sortPrioEnabled", sortPrioEnabled);
        model.addAttribute("todos", todos);
        return "list";
    }


    @GetMapping("/done")
    public String doneFilter(Model model) {
        List<TodoDto> todos = this.todoService.getAll();
        List<TodoDto> doneTodos = new ArrayList<>();

        for (TodoDto todo : todos) {
            if (todo.isDone()) {
                doneTodos.add(todo);
            }
        }
        model.addAttribute("todos", doneTodos);
        return "list";
    }

}


