package com.example.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends ArrayAdapter<Task> {

    private ArrayList<Task> tasks;
    private Context context;
    private TextView tvID;
    private TextView tvDesc;
    private TextView tvDate;

    public adapter(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        tasks = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }
        // getView() is the method ListView will call to get the
        //  View object every time ListView needs a row
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // The usual way to get the LayoutInflater object to
            //  "inflate" the XML file into a View object
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // "Inflate" the row.xml as the layout for the View object
            View rowView = inflater.inflate(R.layout.row, parent, false);

            // Get the TextView object
            tvID = rowView.findViewById(R.id.tvID);
            tvDesc = rowView.findViewById(R.id.tvDesc);
            tvDate = rowView.findViewById(R.id.tvDate);



            // The parameter "position" is the index of the
            //  row ListView is requesting.
            //  We get back the food at the same index.
            Task task = tasks.get(position);
            // Set the TextView to show the food



            //change to integer
            tvID.setText(Integer.toString(task.getId()));
            tvDesc.setText(task.getDescription());
            tvDate.setText(task.getDate());


            // Return the nicely done up View to the ListView
            return rowView;


        }
    }