package com.taskmanager.task_app;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public void addTask(Task task) {
        logger.info("Adding task: " + task.getTitle());
        taskRepository.save(task);
    }
    public boolean updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setCompleted(updatedTask.isCompleted());
            taskRepository.save(task);
            return true;
        }).orElse(false);
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
