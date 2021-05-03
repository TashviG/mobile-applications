package au.edu.canberra.assignment1_u3165466;

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

public class ListActivity extends AppCompatActivity {

    ArrayList<ContactDetails> events = new ArrayList<ContactDetails>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
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
        events.add(new ContactDetails("Park Jinyoung","fivhvuhh"));
        events.add(new ContactDetails("Kim Myungsoo","unxsccbj cme  ejcoekca;eck " ));
        events.add(new ContactDetails("Kim Taehyung","cwkcnkencnkc"));




        ArrayAdapter<ContactDetails> adapter = new ArrayAdapter<ContactDetails>(
                this, android.R.layout.simple_list_item_1, events);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ContactDetails cdetails = events.get(position);
                        Intent intent = new Intent(view.getContext(), EventActivity.class);
                        intent.putExtra("title", cdetails.getTitle());
                        intent.putExtra("text", cdetails.gettext());
                        //intent.putExtra("date", cbrevent.getDateString());
                        startActivity(intent);
                    }
                });


    }
    public void Scan_Activity(View v){
        Intent intent = new Intent(this, Scan_Activity.class);
        startActivity(intent);
    }

}
