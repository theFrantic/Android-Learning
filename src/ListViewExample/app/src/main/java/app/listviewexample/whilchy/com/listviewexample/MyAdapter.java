package app.listviewexample.whilchy.com.listviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by daniel on 30/11/14.
 */
public class MyAdapter extends ArrayAdapter<String> {

    public MyAdapter(Context context, String[] values) {
        super(context, R.layout.row_layout_2, values);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater theInflator =  LayoutInflater.from(getContext());

        View theView = theInflator.inflate(R.layout.row_layout_2, parent, false);

        String tvShow = getItem(position);

        TextView theTextView = (TextView) theView.findViewById(R.id.textView1);
        theTextView.setText(tvShow);

        ImageView theImageView = (ImageView) theView.findViewById(R.id.imageView1);
        theImageView.setImageResource(R.drawable.ic_tv_24px);

        return theView;

    }
}
