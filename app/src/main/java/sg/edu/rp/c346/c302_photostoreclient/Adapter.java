package sg.edu.rp.c346.c302_photostoreclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Category> {
    private ArrayList<Category> req;
    private Context context;
    private TextView tv1, tv2;

    public Adapter(Context context, int resource, ArrayList<Category> objects) {
        super(context, resource, objects);
        req = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tv1 = (TextView) rowView.findViewById(R.id.tv1);
        tv2 = (TextView) rowView.findViewById(R.id.tv2);

        Category currentEntry = req.get(position);


        tv1.setText(currentEntry.getName());

        tv2.setText(currentEntry.getDescription());
        return rowView;
    }


}
