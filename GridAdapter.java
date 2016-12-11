package edu.upasna.cs478.proj2_atmp2;

/**
 * Created by upsi2 on 9/25/2016.
 */
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class GridAdapter extends  BaseAdapter{

    private Context mCont;
    private final String[] names;
    private final int[] img_ids;



    public GridAdapter(Context c,String[] names,int[] img_ids ) {
        mCont = c;
        this.img_ids = img_ids;
        this.names = names;
    }



    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = (LayoutInflater) mCont
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View grid1 = new View(mCont);
        if (convertView == null) {


            grid1 = inflater.inflate(R.layout.grid_item, null);
            TextView textView = (TextView) grid1.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid1.findViewById(R.id.grid_image);
            textView.setText(names[position]);
            imageView.setImageResource(img_ids[position]);
        } else {
            grid1 = (View) convertView;
        }

        return grid1;
    }
}


