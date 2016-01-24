package ba.leftor.exercises.todoapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import ba.leftor.exercises.todoapp.R;

/**
 * Created by Emina on 23.1.2016.
 */
public class WelcomeScreenActivity extends AppCompatActivity implements View.OnClickListener, Runnable{

    private long timeout = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
        TextView textView = (TextView) findViewById(R.id.welcome_screen);
        textView.setOnClickListener(this);
        new Handler().postDelayed(this, timeout);
    }

    @Override
    public void onClick(View v) {
        run();

    }

    @Override
    public void run() {
        Intent intent = new Intent(this, ToDoMainScreenActivity.class);
        startActivity(intent);
    }
}
