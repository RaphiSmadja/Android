package com.esgi.test.tptest.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.esgi.test.tptest.R;
import com.esgi.test.tptest.model.SimpleObject;
import com.esgi.test.tptest.touchwithcare.Constants;

import java.util.List;

public class ThirdActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        List<SimpleObject> list = (List<SimpleObject>) getIntent().getI(Constants.DATA, 0);

        //Order the list maybe
        ArrayAdapter<SimpleObject> adapter = new ArrayAdapter<SimpleObject>(this, android.R.layout.simple_list_item_1,list);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String score = getListAdapter().getItem(position).toString();
        Toast.makeText(this, score, Toast.LENGTH_SHORT).show();
    }
}
