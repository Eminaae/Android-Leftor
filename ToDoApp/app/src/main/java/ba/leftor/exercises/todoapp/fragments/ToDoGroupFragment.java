package ba.leftor.exercises.todoapp.fragments;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ba.leftor.exercises.todoapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoGroupFragment extends Fragment {


    private OnFragmentInteractionListener listener;
    public ToDoGroupFragment() {
        // Required empty public constructor
    }

    public static ToDoGroupFragment newInstance(String param1, String param2){
        ToDoGroupFragment fragment = new ToDoGroupFragment();
        Bundle bundle = new Bundle();
        bundle.putString("ee", param1);
        bundle.putString("ee", param2);
        fragment.setArguments(bundle);

        return fragment;
    }

    public interface OnFragmentInteractionListener{
        public void onFragmentInteraction(Uri uri);
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_group, container, false);
    }


}
