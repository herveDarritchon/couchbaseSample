package fr.hervedarritchon.tutorials.model;

import org.joda.time.DateTime;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

/**
 * Created by throdo/ahdi7503 on 10/03/2015.
 */
@XmlRootElement
public class Todo {

    private String id;

    private String label;

    private String description;

    private DateTime dueDate;

    private String userId;

    public DateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(DateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Todo() {
        super();
    }

    public Todo(String label, String description, DateTime dueDate, String userId) {
        super();
        this.label = label;
        this.description = description;
        this.dueDate = dueDate;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        if (!description.equals(todo.description)) return false;
        if (!dueDate.equals(todo.dueDate)) return false;
        if (!id.equals(todo.id)) return false;
        if (!label.equals(todo.label)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + label.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + dueDate.hashCode();
        return result;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
