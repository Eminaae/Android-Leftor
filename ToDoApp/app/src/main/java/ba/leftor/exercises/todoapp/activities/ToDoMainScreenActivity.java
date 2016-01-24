package ba.leftor.exercises.todoapp.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import ba.leftor.exercises.todoapp.R;
import ba.leftor.exercises.todoapp.fragments.ToDoGroupFragment;

/**
 * Created by Emina on 24.1.2016.
 */
public class ToDoMainScreenActivity extends AppCompatActivity implements ToDoGroupFragment.OnFragmentInteractionListener{

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton fab;
    private ToDoMainScreenAdapter toDoMainScreenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_main_screen);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        toDoMainScreenAdapter = new ToDoMainScreenAdapter(getSupportFragmentManager());
        viewPager.setAdapter(toDoMainScreenAdapter);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        setSupportActionBar(toolbar);
        tabLayout.setupWithViewPager(viewPager);
    }



    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public class ToDoMainScreenAdapter extends FragmentStatePagerAdapter{

        public ToDoMainScreenAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ToDoGroupFragment.newInstance("ee", "ee");
        }


        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position){
            return "fragment" + position;
        }
    }
}
