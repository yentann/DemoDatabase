package com.example.demodatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnTask;
    TextView tvResults;
    ListView lv;
    ArrayAdapter<Task> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       btnInsert = findViewById(R.id.buttonInsert);
       btnTask = findViewById(R.id.buttonTask);
       tvResults = findViewById(R.id.textView);
       lv = (ListView) this.findViewById(R.id.lv);


        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask("Submit RJ", "25 Apr 2016");
                db.close();
            }
        });

        btnTask.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<Task> data = db.getTasks();
                db.close();

                //String txt = "";
                //for (int i = 0; i < data.size(); i++) {
                    //Debug using Logcat
                    //Log.d("Database Content", i +". "+data.get(i));
                  //  txt += i + ". " + data.get(i) + "\n";
                //}
              //  tvResults.setText(txt);



                aa = new adapter(MainActivity.this, R.layout.row, data);
                lv.setAdapter(aa);
                 }
              });


            }
}
