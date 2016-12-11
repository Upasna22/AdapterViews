package edu.upasna.cs478.proj2_atmp2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView.AdapterContextMenuInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MainGridActivity extends AppCompatActivity {

    protected static final String EXTRA_RES_ID = "POS";

    String[] names = {
            "Accura",
            "Audi",
            "BMW",
            "Honda",
            "Jaguar",
            "Ford"
    };

    int[] img_ids = {
            R.drawable.accura,
            R.drawable.audi,
            R.drawable.bmw,
            R.drawable.honda,
            R.drawable.jaguar,
            R.drawable.mustang
    };

    String[] URLs = {
            "http://www.acura.com/",
            "https://www.audiusa.com/",
            "http://www.bmwusa.com/",
            "http://www.honda.com/",
            "http://www.jaguarusa.com/index.html",
            "http://www.ford.com/"
    };

    ArrayList<ArrayList<String>> dealer = new ArrayList<ArrayList<String>>();

    public MainGridActivity() {
        //HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        //ArrayList<ArrayList<String>> dealer = new ArrayList<ArrayList<String>>();
        ArrayList<String> acc = new ArrayList<String>();
        acc.add("Car Dealer 1 - address 1");
        acc.add("Car Dealer 2 - address 2");
        acc.add("Car Dealer 3 - address 3");
        ArrayList<String> aud = new ArrayList<String>();
        aud.add("Car Dealer 1 - address 1");
        aud.add("Car Dealer 2 - address 2");
        aud.add("Car Dealer 3 - address 3");
        ArrayList<String> bm = new ArrayList<String>();
        bm.add("Car Dealer 1 - address 1");
        bm.add("Car Dealer 2 - address 2");
        bm.add("Car Dealer 3 - address 3");
        ArrayList<String> hon = new ArrayList<String>();
        hon.add("Car Dealer 1 - address 1");
        hon.add("Car Dealer 2 - address 2");
        hon.add("Car Dealer 3 - address 3");
        ArrayList<String> jag = new ArrayList<String>();
        hon.add("Car Dealer 1 - address 1");
        hon.add("Car Dealer 2 - address 2");
        hon.add("Car Dealer 3 - address 3");
        ArrayList<String> ford = new ArrayList<String>();
        hon.add("Car Dealer 1 - address 1");
        hon.add("Car Dealer 2 - address 2");
        hon.add("Car Dealer 3 - address 3");
        //map.put(0,acc);
        //map.put(1,aud);
        //map.put(2,bm);
        //map.put(3,hon);
        //map.get(Object)

        dealer.add(acc);
        dealer.add(aud);
        dealer.add(bm);
        dealer.add(hon);
        dealer.add(jag);
        dealer.add(ford);

   }
    public int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("MainGridActivity", "At main grid activity");

        setContentView(R.layout.activity_main_grid);
        GridView grid = (GridView) findViewById(R.id.gridView);
        //GridAdapter adapt = new GridAdapter(MainGridActivity.this,names,img_ids);
        grid.setAdapter(new GridAdapter(MainGridActivity.this, names, img_ids));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Log.i("MainGridActivity", "After onclicklistener");
                //Toast.makeText(MainGridActivity.this, "You Clicked at " + names[+position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainGridActivity.this, DisplayActivity.class);

                // Add the ID of the thumbnail to display as an Intent Extra
                intent.putExtra(EXTRA_RES_ID, img_ids[position]);
                flag = 1;
                intent.putExtra("FLAG",flag);
                intent.putExtra("Url_I_need", URLs[position]);

                startActivity(intent);
                flag = 0;

            }
        });
        registerForContextMenu(grid);
    }

    // CONTEXT MENU
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "View Large Size Image");
        menu.add(0, v.getId(), 0, "Official Web Page");
        menu.add(0, v.getId(), 0, "Car Dealers");
    }

    public boolean onContextItemSelected(MenuItem item) {

        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;

        if (item.getTitle() == "View Large Size Image") {

            Intent intent1 = new Intent(MainGridActivity.this, DisplayActivity.class);
            intent1.putExtra(EXTRA_RES_ID, img_ids[index]);
            intent1.putExtra("Source","second");
            startActivity(intent1);
            Toast.makeText(this, "function 1 called", Toast.LENGTH_SHORT).show();

        }
        else if (item.getTitle() == "Official Web Page") {

            String url = URLs[index];
            Intent browserInt = new Intent(Intent.ACTION_VIEW);
            browserInt.setData(Uri.parse(url));
            startActivity(browserInt);

            Toast.makeText(this, "function 2 called", Toast.LENGTH_SHORT).show();

        } else if (item.getTitle() == "Car Dealers") {

            Intent intent2 = new Intent(MainGridActivity.this,ListViewActivity.class);
            intent2.putExtra("Item",dealer.get(index));
            startActivity(intent2);
            Toast.makeText(this, "function 3 called", Toast.LENGTH_SHORT).show();
        }
        return true;



    }

    public void function3(int id){
        Toast.makeText(this, "function 2 called", Toast.LENGTH_SHORT).show();
    }
}

