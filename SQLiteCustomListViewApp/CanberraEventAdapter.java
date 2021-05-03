package au.edu.canberra.listviewactionbarmenuapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tashvi G on 13/03/2017.
 */
 public class CanberraEventAdapter extends ArrayAdapter<CanberraEvent> {
    ArrayList<CanberraEvent> events;
    public CanberraEventAdapter(Context context, int resource, ArrayList<CanberraEvent> objects) {
        super(context, resource, objects);
        events = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.my_listview_item, parent, false);
        }

        CanberraEvent event = events.get(position);

        ImageView icon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
        icon.setImageResource(R.mipmap.ic_neon_night);



        TextView title = (TextView) convertView.findViewById(R.id.textViewTitle);
        title.setText(event.getTitle());
        if (position % 2 == 0){
            convertView.setBackgroundColor(Color.parseColor("#ccffff"));
        }else{
            convertView.setBackgroundColor(Color.parseColor("#ffffe6"));
        }

        return convertView;
    }



    public CanberraEventAdapter(Context context, int resource) {
        super(context, resource);
    }
}
