package ba.leftor.exercises.todoapp.models;

/**
 * Created by Emina on 24.1.2016.
 */
public class TaskPriority {

    public static final String LOW = "Low";
    public static final String MEDIUM = "Medium";
    public static final String HIGH = "High";
    public static final String VERY_HIGH = "Very high";

    private String priorityId;
    private String priorityName;

    public TaskPriority() {
    }

    public TaskPriority(String priorityId, String priorityName) {
        this.priorityId = priorityId;
        this.priorityName = priorityName;
    }

    public String getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(String priorityId) {
        this.priorityId = priorityId;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    @Override
    public String toString() {
        return this.priorityName;
    }
}
