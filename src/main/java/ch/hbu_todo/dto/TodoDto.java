package ch.hbu_todo.dto;

import java.time.LocalDate;

public class TodoDto {
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isDone() {
        return done;
    }

    private String text;

    private LocalDate dueDate;

    private Integer priority;

    private boolean done;

    private Integer category;

    private String categoryName;

    private String categoryColor;

    public String getCategoryColor() {
        return categoryColor;
    }

    public void setCategoryColor(String categoryColor) {
        this.categoryColor = categoryColor;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }


    public void setPriority(Integer priority) {
        this.priority = priority;
    }


    public Integer getPriority() {
        return priority;
    }
}
