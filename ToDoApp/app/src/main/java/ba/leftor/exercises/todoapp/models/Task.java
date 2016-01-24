package ba.leftor.exercises.todoapp.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emina on 24.1.2016.
 */
public class Task {

    private String taskName;
    private String taskDescription;
    private String priority;
    private String status;
    private int groupId;

    public Task() {
    }

    public Task(String taskName, String taskDescription, int groupId) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.groupId = groupId;
    }

    public Task(String taskName, String taskDescription, String priority, String status, int groupId) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.priority = priority;
        this.status = status;
        this.groupId = groupId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<Task> createTaskList(int taskNum){
       List<Task> taskList = new ArrayList<>();
        for(int i = 0; i < taskNum -1; i++){
            Task task = new Task(taskName, taskDescription, groupId);
            taskList.add(task);
        }
        return taskList;
    }

    @Override
    public String toString() {
        return this.taskName;
    }
}
