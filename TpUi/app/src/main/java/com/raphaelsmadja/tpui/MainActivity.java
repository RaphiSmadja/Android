package com.raphaelsmadja.tpui;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends ListActivity {
    final String[] days = new String[]{
            "MON","TUE","WED","THU","FRI","SAT","SUN",
            "MON","TUE","WED","THU","FRI","SAT","SUN",
            "MON","TUE","WED","THU","FRI","SAT","SUN",
            "MON","TUE","WED","THU","FRI","SAT","SUN",
            "MON","TUE","WED","THU","FRI","SAT","SUN"
    };

    List<Student> students = Arrays.asList(
            new Student("AFONSO", "Mickael"),
            new Student("AFONSO2", "Mickael"),
            new Student("AFONSO3", "Mickael"),
            new Student("AFONSO4", "Mickael"),
            new Student("AFONSO5", "Mickael"),
            new Student("AFONSO6", "Mickael"),
            new Student("AFONSO7", "Mickael"),
            new Student("AFONSO8", "Mickael")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*ArrayAdapter<String> dayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                        days);*/
        StudentAdapter studentAdapter =
                new StudentAdapter(this,students);

        setListAdapter(studentAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String day = getListAdapter().getItem(position).toString();
        Toast.makeText(this, day, Toast.LENGTH_SHORT).show();
    }
}
