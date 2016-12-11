package edu.upasna.cs478.proj2_atmp2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;



public class DisplayActivity extends AppCompatActivity {

    String[] URLs = {
            "http://www.acura.com/",
            "https://www.audiusa.com/",
            "http://www.bmwusa.com/",
            "http://www.honda.com/",
            "http://www.jaguarusa.com/index.html",
            "http://www.ford.com/"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_display);
        Intent intent =getIntent();
        //int imageInt = getIntent().getIntExtra("Image Int", R.drawable.oops);
        //int viewInt = getIntent().getIntExtra("View_image",0);
        //
        // String src =getIntent().getStringExtra("Source");
        int flag = getIntent().getIntExtra("FLAG",0);

        ImageView image = new ImageView(getApplicationContext());
        //ImageView image = (ImageView)findViewById(R.id.imageView);
       image.setImageResource(intent.getIntExtra(MainGridActivity.EXTRA_RES_ID,0));
        setContentView(image);
        if(flag ==1 )
        {
            //ImageView image = (ImageView)findViewById(R.id.imageView);
            //image.setImageResource(imageInt);
            //setContentView(image);
            image.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    final String url = getIntent().getStringExtra("Url_I_need");
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse(url));
                    startActivity(browserIntent);
                }

            });

        }
        //else if(src =="second")
        //{
         //   ImageView image = (ImageView)findViewById(R.id.imageView);
          //  image.setImageResource(viewInt);
          // setContentView(image);

       // }
    }
}
