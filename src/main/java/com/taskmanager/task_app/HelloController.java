package com.taskmanager.task_app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class HelloController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Task Manager!";
    }
    @GetMapping("/status")
    public String getStatus() {
        return new String(""+ "Task Manager is running smoothly!     All systems are operational. No issues detected.");
    }
    @GetMapping("/tasks")
    public List<Task> getSampleTask(){
        
        return taskService.getAllTasks();
    }
    @PostMapping("/tasks")
    public String addTask(@RequestBody Task task) {
        //TODO: process POST request
        taskService.addTask(task);
        return "Task added successfully!";
    }
    
}
