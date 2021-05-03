package au.edu.canberra.listviewactionbarmenuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

//import static au.edu.canberra.listviewactionbarmenuapp.R.id.listView;

public class ListViewActivity extends AppCompatActivity {
    ArrayList<CanberraEvent> events = new ArrayList<CanberraEvent>();
    CanberraEventDbHelper mydb = new CanberraEventDbHelper(
            this, "CanberraEventDb", null, 4);




    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
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


        //events.add(new CanberraEvent("Neon Night", R.drawable.neon_night, new Date(2017,3,3)));
        //events.add(new CanberraEvent("Lights! Canberra! Actions!", R.drawable.lights_canberra_actionss, new Date(2017,3,10)));
        //events.add(new CanberraEvent("National Portrait Gallery Late Night", R.drawable.national_portrait_gallery, new Date(2017,3,3)));
        events = mydb.getAllEvents();
        if (events.isEmpty()) {
            mydb.insertEvent(new CanberraEvent("Neon Night", R.drawable.neon_night, new Date(2017, 3, 3)));
            mydb.insertEvent(new CanberraEvent("Lights! Canberra! Actions!", R.drawable.lights_canberra_actionss, new Date(2017, 3, 10)));
            mydb.insertEvent(new CanberraEvent("National Portrait Gallery Late Night", R.drawable.national_portrait_gallery, new Date(2017, 3, 3)));
            events = mydb.getAllEvents();
        }

        //ArrayAdapter<CanberraEvent> adapter = new ArrayAdapter<CanberraEvent>(
                //this, android.R.layout.simple_list_item_1, events);
        CanberraEventAdapter adapter = new CanberraEventAdapter(
                this, R.layout.my_listview_item, events);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        CanberraEvent cbrevent = events.get(position);
                        Intent intent = new Intent(view.getContext(), EventActivity.class);
                        intent.putExtra("title", cbrevent.title);
                        intent.putExtra("imageResource", cbrevent.imageResource);
                        intent.putExtra("date", cbrevent.date);
                        startActivity(intent);
                    }
                });




    }

}
