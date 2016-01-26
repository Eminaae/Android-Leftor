package ba.leftor.exercises.todoapp.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import ba.leftor.exercises.todoapp.R;
import ba.leftor.exercises.todoapp.models.TaskGroup;

/**
 * Created by Emina on 25.1.2016.
 */
public class AddTaskGroupFragmentDialog extends DialogFragment {

    private TaskGroup taskGroup;
    private EditText newGroupName;
    private Button addNewGroup;
    private Button cancelDialog;
    private List<TaskGroup> taskGroupList;

    private OnInteractionListener listener;

    public interface OnInteractionListener{
        void save(TaskGroup taskGroup);
    }

    public static AddTaskGroupFragmentDialog newInstance(TaskGroup taskGroup, List<TaskGroup> taskGroups){
        AddTaskGroupFragmentDialog fragmentDialog = new AddTaskGroupFragmentDialog();
        fragmentDialog.taskGroup = taskGroup;
        fragmentDialog.taskGroupList = taskGroups;
        return fragmentDialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.dialog_add_task_group, container, false);
        this.newGroupName = (EditText) view.findViewById(R.id.edit_task_group_name_dialog);
        this.addNewGroup = (Button) view.findViewById(R.id.task_dialog_add_new_group_btn);
        this.cancelDialog = (Button) view.findViewById(R.id.task_group_dialog_cancel_btn);

        onClickAddNewGroup();

        onClickCancelDialog();

        return view;

    }

    private void onClickCancelDialog() {
        this.cancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void onClickAddNewGroup() {
        this.addNewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    TaskGroup taskGroup = new TaskGroup();
                    taskGroup.setGroupName(newGroupName.getText().toString());
                    listener.save(taskGroup);
                    dismiss();
                }
            }
        });
    }

    @Override
    public void onAttach(Activity activity){
        try{
            this.listener = (OnInteractionListener)activity;
        }catch (ClassCastException e){
            throw new RuntimeException("If you wannt to use AddTaskGroupFragmentDialog, you have to implement" + OnInteractionListener.class);
        }
        super.onAttach(activity);
    }


}
