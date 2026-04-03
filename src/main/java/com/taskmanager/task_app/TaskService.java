package com.taskmanager.task_app;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    
    public List<Task> getAllTasks() {
        
        if (tasks.isEmpty()) {
            tasks.add(new Task(1L, "Learn Spring Boot", false));
            tasks.add(new Task(2L, "Build a REST API", false));
            tasks.add(new Task(3L, "Write Unit Tests", false));
        }
        
        return tasks;
    }
    public void addTask(Task task) {
        tasks.add(task);
    }
}
