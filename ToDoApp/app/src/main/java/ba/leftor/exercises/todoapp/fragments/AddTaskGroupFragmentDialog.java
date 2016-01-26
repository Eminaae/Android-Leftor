package ba.leftor.exercises.todoapp.fragments;

import android.support.v4.app.DialogFragment;

import ba.leftor.exercises.todoapp.models.TaskGroup;

/**
 * Created by Emina on 25.1.2016.
 */
public class AddTaskGroupFragmentDialog extends DialogFragment {

    private OnInteractionListener listener;

    public interface OnInteractionListener{
        void save(TaskGroup taskGroup);
    }
}
