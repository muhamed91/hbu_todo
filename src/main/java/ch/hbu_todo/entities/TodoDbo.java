package ch.hbu_todo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name ="todo")
public class TodoDbo {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDate getDuedate() {
        return duedate;
    }

    public void setDuedate(LocalDate duedate) {
        this.duedate = duedate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public CategoryDbo getCategory() {
        return category;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "todo_task")
    private String text;

    @Column()
    private  boolean done;

    @Column(name = "duedate")
    private LocalDate duedate;


    @Column(name="priority")
    private Integer priority;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryDbo category;

    public void setCategory(CategoryDbo category) {
        this.category = category;
    }
}


