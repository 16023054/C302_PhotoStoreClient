package sg.edu.rp.c346.c302_photostoreclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter2 extends ArrayAdapter<Photo>{
    private ArrayList<Photo> req;
    private Context context;
    private TextView tv1, tv2,tv3,tv4;

    public Adapter2(Context context, int resource, ArrayList<Photo> objects) {
        super(context, resource, objects);
        req = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row1, parent, false);

        tv1 = (TextView) rowView.findViewById(R.id.tv1);
        tv2 = (TextView) rowView.findViewById(R.id.tv2);
        tv3 = (TextView) rowView.findViewById(R.id.tv3);
        tv4 = (TextView) rowView.findViewById(R.id.tv4);

        Photo currentEntry = req.get(position);


        tv1.setText(currentEntry.getTitle());
        tv2.setText(currentEntry.getDescription());
        tv3.setText(currentEntry.getCreated_by());
        tv4.setText(currentEntry.getImage());

        return rowView;
    }
}
