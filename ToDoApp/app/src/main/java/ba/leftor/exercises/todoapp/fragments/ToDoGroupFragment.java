package ba.leftor.exercises.todoapp.fragments;


import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ba.leftor.exercises.todoapp.R;
import ba.leftor.exercises.todoapp.adapters.TaskAdapter;
import ba.leftor.exercises.todoapp.models.Task;
import ba.leftor.exercises.todoapp.models.TaskGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoGroupFragment extends Fragment implements AddTaskFragmentDialog.OnInteractionListener {

    private OnFragmentInteractionListener listener;
    private RecyclerView recyclerView;
    private Task task;
    private TaskGroup taskGroup;
    private TaskAdapter taskAdapter;
    private List<Task> tasks;

    public ToDoGroupFragment() {
        // Required empty public constructor
    }

    public static ToDoGroupFragment newInstance(TaskGroup taskGroup){
        ToDoGroupFragment fragment = new ToDoGroupFragment();
        fragment.taskGroup = taskGroup;
        return fragment;
    }

    @Override
    public void save(Task task, TaskGroup taskGroup) {
        taskGroup.add(task);
        this.taskAdapter.notifyItemInserted(taskGroup.getTaskList().indexOf(task));

    }

    public interface OnFragmentInteractionListener{
        public void onFragmentInteraction(Uri uri);
        void onAddTaskGroup();
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_to_do_group, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.todo_recycler_view);
        this.taskAdapter = new TaskAdapter(this.taskGroup.getTaskList());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(taskAdapter);

        taskAdapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


}
