package org.example;

public class Task {
    String name;
    String description;
    Priority priority;
    public Task(String name, String description, Priority priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Priority getPriority() {
        return priority;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name + " - " + description;
    }
}
