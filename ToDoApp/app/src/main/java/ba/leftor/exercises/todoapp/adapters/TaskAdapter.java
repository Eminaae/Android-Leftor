package ba.leftor.exercises.todoapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ba.leftor.exercises.todoapp.R;
import ba.leftor.exercises.todoapp.models.Task;

/**
 * Created by Emina on 25.1.2016.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private List<Task> taskList = new ArrayList<>();
    private RecyclerView recyclerView;



    public TaskAdapter(List<Task> tasks) {
        this.taskList = tasks == null ? new ArrayList<Task>() : tasks;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view_task_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.bindTaskModel(task);

    }

    @Override
    public int getItemCount() {
        return taskList == null ? 0 :taskList.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{

        public TextView taskName;
        public TextView taskDescription;
        private Task task;

        public ViewHolder(View itemView) {
            super(itemView);
            taskName = (TextView) itemView.findViewById(R.id.task_name);
            taskDescription = (TextView) itemView.findViewById(R.id.task_description);
        }

        public void bindTaskModel(Task bindTask){
            task = bindTask;
            taskName.setText(task.getTaskName());
            taskDescription.setText(task.getTaskDescription());

        }
    }
}
