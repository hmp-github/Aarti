package com.aarti.hmp.app.aarti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter  {
    String[] result;
    String[] description;
    Context context;
    int[] imageId;
    private static LayoutInflater inflater = null;

    public CustomAdapter(MainActivity mainActivity, String[] prgmNameList,String[] prgmDetailList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result = prgmNameList;
        context = mainActivity;
        imageId = prgmImages;
        description = prgmDetailList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder {
        TextView item_title;
        TextView item_detail;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.list, null);
        holder.item_title = (TextView) rowView.findViewById(R.id.item_title);
        holder.item_detail = (TextView) rowView.findViewById(R.id.item_detail);
        holder.img = (ImageView) rowView.findViewById(R.id.image_View);
        holder.item_title.setText(result[position]);
        holder.item_detail.setText(description[position]);
        holder.img.setImageResource(imageId[position]);

        //      rowView.setOnClickListener(new View.OnClickListener() {
        ///          @Override
        //     public void onClick(View v) {
        // TODO Auto-generated method stub
        //        Toast.makeText(context, "You Clicked " + result[position], Toast.LENGTH_LONG).show();


        // }
        //  });
        return rowView;
    }
}
