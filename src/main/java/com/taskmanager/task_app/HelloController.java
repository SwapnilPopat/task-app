package com.taskmanager.task_app;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class HelloController {

    @Autowired
    private TaskService taskService;

        private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

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
                logger.error("Task added: controller 1");

        taskService.addTask(task);
        logger.info("Task added: controller " + task.getTitle());
        return "Task added successfully!";
    }
    @PutMapping("/tasks/{id}")
    public String updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        
        boolean updated = taskService.updateTask(id, updatedTask);
        if (updated) {
            return "Task updated successfully!";
        } else {
            return "Task not found!";
        }
    }
    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted successfully!";
    }
}
