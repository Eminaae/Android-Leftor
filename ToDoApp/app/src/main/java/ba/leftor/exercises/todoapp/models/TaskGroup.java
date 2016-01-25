package ba.leftor.exercises.todoapp.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emina on 24.1.2016.
 */
public class TaskGroup {

    private int groupId;
    private String groupName;

    private List<Task> taskList = new ArrayList<>();

    public TaskGroup() {
    }

    public TaskGroup(int groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.taskList = new ArrayList<>();
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public static List<TaskGroup> mock(){

        List<TaskGroup> taskGroupList = new ArrayList<>();
        TaskGroup house = new TaskGroup(0, "House");
        TaskGroup work = new TaskGroup(1, "Work");
        TaskGroup sport = new TaskGroup(2, "Sport");
        taskGroupList.add(house);
        taskGroupList.add(work);
        taskGroupList.add(sport);

        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task("Cleaning", "Living room", house.getGroupId()));
        taskList.add(new Task("Washing", "Dishes", house.getGroupId()));

        taskList.add(new Task("Writing", "Email", work.getGroupId()));
        taskList.add(new Task("Climbing", "Cliff", sport.getGroupId()));

        sport.addAll(taskList);

        return taskGroupList;
    }

    public static List<TaskGroup> createTaskGroup(int groupNum) {
        List<TaskGroup> taskGroups = new ArrayList<>();
        for (int i = 0; i < groupNum; i++) {
            taskGroups.add(new TaskGroup());
        }
        return taskGroups;
    }

    public void addAll(List<Task> tasks){
        this.taskList.addAll(tasks);
    }

    public void add(Task task){
        this.taskList.add(task);

    }
    @Override
    public String toString() {
        return this.groupName;
    }
}
