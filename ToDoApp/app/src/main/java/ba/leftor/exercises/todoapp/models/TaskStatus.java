package ba.leftor.exercises.todoapp.models;

/**
 * Created by Emina on 24.1.2016.
 */
public class TaskStatus {

    public static final String COMPLETED = "Completed";
    public static final String IN_PROGRESS = "In progress";
    public static final String QUIT = "Qiut";
    public static final String NOT_STARTED = "Not started";

    private long statusId;
    private String statusName;

    public TaskStatus() {
    }

    public TaskStatus(long statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return this.statusName;
    }
}
