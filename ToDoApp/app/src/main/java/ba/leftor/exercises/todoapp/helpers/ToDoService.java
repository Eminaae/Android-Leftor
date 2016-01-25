package ba.leftor.exercises.todoapp.helpers;

import java.util.List;

import ba.leftor.exercises.todoapp.models.TaskGroup;

/**
 * Created by Emina on 25.1.2016.
 */
public class ToDoService {

    private List<TaskGroup> taskGroupList;

    public ToDoService() {
    }

    public List<TaskGroup> getTaskGroupList() {
        if(taskGroupList == null){
            taskGroupList = TaskGroup.mock();
        }
        return taskGroupList;
    }
}
