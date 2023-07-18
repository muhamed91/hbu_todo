package ch.hbu_todo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="category")
public class CategoryDbo {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryColor() {
        return categoryColor;
    }

    public void setCategoryColor(String categoryColor) {
        this.categoryColor = categoryColor;
    }

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

     @Column()
     private  String categoryName;

    @Column()
    private  String categoryColor;

    @OneToMany(mappedBy = "category")
    private List<TodoDbo> todos;

}
