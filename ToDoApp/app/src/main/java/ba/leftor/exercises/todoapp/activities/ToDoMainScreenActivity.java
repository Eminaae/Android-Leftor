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
import android.view.View;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;
import java.util.List;

import ba.leftor.exercises.todoapp.R;
import ba.leftor.exercises.todoapp.fragments.ToDoGroupFragment;
import ba.leftor.exercises.todoapp.models.TaskGroup;

/**
 * Created by Emina on 24.1.2016.
 */
public class ToDoMainScreenActivity extends AppCompatActivity implements ToDoGroupFragment.OnFragmentInteractionListener,
        View.OnClickListener{

    public static final String TAG_ADD_NEW_TASK = "Add a new task";
    public static final String TAG_ADD_NEW_GROUP = "Add a new task group";
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton fab;
    private ToDoMainScreenAdapter toDoMainScreenAdapter;
    private List<TaskGroup>taskGroupList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_main_screen);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        taskGroupList = TaskGroup.mock();

        toDoMainScreenAdapter = new ToDoMainScreenAdapter(getSupportFragmentManager(), taskGroupList);
        viewPager.setAdapter(toDoMainScreenAdapter);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        setSupportActionBar(toolbar);
        tabLayout.setupWithViewPager(viewPager);
        buildFAB();
    }



    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * Creating Floating Action Button
     */
    private void buildFAB() {
        //creating main floating button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_plus);
        //creating subbuttons
        ImageView iconGroup = new ImageView(this);
        iconGroup.setImageResource(R.drawable.icon);
        ImageView iconTask = new ImageView(this);
        iconTask.setImageResource(R.drawable.icon);
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        SubActionButton newTaskBtn = itemBuilder.setContentView(iconGroup).build();
        SubActionButton newGroupBtn = itemBuilder.setContentView(iconTask).build();
        newTaskBtn.setTag(TAG_ADD_NEW_TASK);
        newTaskBtn.bringToFront();
        newGroupBtn.setTag(TAG_ADD_NEW_GROUP);
        newTaskBtn.setOnClickListener(this);
        newGroupBtn.setOnClickListener(this);

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(newTaskBtn)
                .addSubActionView(newGroupBtn)
                .attachTo(fab)
                .build();
    }


    @Override
    public void onClick(View view) {
        if(view.getTag().equals(TAG_ADD_NEW_TASK)){
            TaskGroup taskGroup = taskGroupList.get(viewPager.getCurrentItem());

        }
        if(view.getTag().equals(TAG_ADD_NEW_GROUP)){
            TaskGroup taskGroup = taskGroupList.get(viewPager.getCurrentItem());
        }
        closeOptionsMenu();
    }


    @Override
    public void onAddTaskGroup() {
       TaskGroup taskGroup = taskGroupList.get(viewPager.getCurrentItem());

    }


    public class ToDoMainScreenAdapter extends FragmentStatePagerAdapter{
        private final List<TaskGroup> taskGroupList;

        public ToDoMainScreenAdapter(FragmentManager fm, List<TaskGroup> taskGroupList) {
            super(fm);
            this.taskGroupList = taskGroupList == null ? new ArrayList<TaskGroup>(): taskGroupList;
        }

        @Override
        public Fragment getItem(int position) {
            return ToDoGroupFragment.newInstance(taskGroupList.get(position));
        }


        @Override
        public int getCount() {
            return taskGroupList == null ? 0 : taskGroupList.size();
        }

        @Override
        public CharSequence getPageTitle(int position){
            return taskGroupList.get(position).getGroupName();
        }
    }
}
