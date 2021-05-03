package au.edu.canberra.listviewactionbarmenuapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Bundle extras = getIntent().getExtras();
        String title = extras.getString("title");
        int imageRes = extras.getInt("imageResource");
        Date date = new Date( extras.getLong("date", 0));

        TextView tv = (TextView) findViewById(R.id.textViewLarge);
        tv.setText(title);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(imageRes);
        tv = (TextView) findViewById(R.id.textViewSmall);
        tv.setText(date.toString());


    }

}
