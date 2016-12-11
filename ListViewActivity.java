package edu.upasna.cs478.proj2_atmp2;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class ListViewActivity extends ListActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        ArrayList<String> data =new ArrayList<String>();
        data = getIntent().getStringArrayListExtra("Item");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.activity_list_view,data);
        lv.setAdapter(arrayAdapter);

        lv = getListView();

    }
}
