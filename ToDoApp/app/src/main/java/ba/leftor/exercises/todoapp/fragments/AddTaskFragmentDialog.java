package ba.leftor.exercises.todoapp.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import ba.leftor.exercises.todoapp.R;
import ba.leftor.exercises.todoapp.models.Task;
import ba.leftor.exercises.todoapp.models.TaskGroup;

/**
 * Created by Emina on 25.1.2016.
 */
public class AddTaskFragmentDialog extends DialogFragment implements View.OnClickListener {

    public static final String TAG_ADD_TASK = "Add new task";
    public static final String CANCEL_DIALOG = "Cancel dialog";
    private TaskGroup taskGroup;
    private List<TaskGroup> taskGroupList;
    private EditText newTaskName;
    private EditText newTaskDescription;
    private Spinner taskGroupSpinner;
    private Button addTaskBtn;
    private Button cancelTaskBtn;
    private ArrayAdapter<TaskGroup> taskGroupArrayAdapter;
    private OnInteractionListener listener;

    public AddTaskFragmentDialog() {
        setRetainInstance(true);
    }

    public static AddTaskFragmentDialog newInstance(TaskGroup taskGroup, List<TaskGroup> taskGroups){
        AddTaskFragmentDialog fragmentDialog = new AddTaskFragmentDialog();
        fragmentDialog.taskGroup = taskGroup;
        fragmentDialog.taskGroupList = taskGroups;
        return fragmentDialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.dialog_add_task, container, false);
        this.newTaskName = (EditText) view.findViewById(R.id.edit_task_name_dialog);
        this.newTaskDescription = (EditText) view.findViewById(R.id.edit_task_description_dialog);
        this.taskGroupSpinner = (Spinner) view.findViewById(R.id.select_task_group_spinner);
        this.addTaskBtn = (Button) view.findViewById(R.id.task_dialog_add_new_task_btn);
        addTaskBtn.setTag(TAG_ADD_TASK);
        this.cancelTaskBtn = (Button) view.findViewById(R.id.task_dialog_cancel_btn);
        cancelTaskBtn.setTag(CANCEL_DIALOG);
        this.taskGroupArrayAdapter = new ArrayAdapter<TaskGroup>(getActivity(),android.R.layout.simple_spinner_item, taskGroupList);
        this.taskGroupSpinner.setAdapter(taskGroupArrayAdapter);
        this.taskGroupArrayAdapter.notifyDataSetChanged();
        this.taskGroupSpinner.setSelection(taskGroupList.indexOf(taskGroup));

        addTaskBtn.setOnClickListener(this);
        cancelTaskBtn.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View view) {
        if(view.getTag().equals(TAG_ADD_TASK) || listener != null){
            TaskGroup selectedGroup = (TaskGroup) taskGroupSpinner.getSelectedItem();
            Task task = new Task();
            task.setTaskName(newTaskName.getText().toString());
            newTaskDescription.setText(newTaskDescription.getText().toString());
            task.setGroupId(selectedGroup.getGroupId());
            listener.save(task, selectedGroup);
            dismiss();//to close dialog
        }
        if(view.getTag().equals(CANCEL_DIALOG)){
            dismiss();
        }
    }

    public AddTaskFragmentDialog setListener(OnInteractionListener listener){
        this.listener = listener;
        return this;
    }


    public interface OnInteractionListener{
        void save(Task task, TaskGroup taskGroup);
    }
}
