package sg.edu.rp.c346.c302_photostoreclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private ListView lvCategories;
    ArrayList<Photo> alCategories = new ArrayList<Photo>();
    ArrayAdapter<Photo> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }
    protected void onResume() {
        super.onResume();
        lvCategories = (ListView) findViewById(R.id.listView);
        aa = new Adapter2(this, R.layout.row1, alCategories);
        lvCategories.setAdapter(aa);

        Intent i = getIntent();
        String id = i.getStringExtra("id");
        HttpRequest request = new HttpRequest
                ("http://10.0.2.2/C302_P06/getPhotoStoreByCategory.php?category_id="+id);
        request.setOnHttpResponseListener(mHttpResponseListener);
        request.setMethod("GET");
        request.execute();
        // Code for step 1 end
    }

    // Code for step 2 start
    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response){

                    // process response here
                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        for (int i=0; i<jsonArray.length(); i++){
                            JSONObject jsonObj = jsonArray.getJSONObject(i);

                            int photoID = jsonObj.getInt("category_id");
                            String photoTitle = jsonObj.getString("title");
                            String photoDescription = jsonObj.getString("description");
                            String photoImage = jsonObj.getString("image");
                            String photoCreatedBy = jsonObj.getString("created_by");
                            Photo p = new Photo(photoTitle,photoDescription,photoImage,photoCreatedBy);
                            alCategories.add(p);

                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                    aa.notifyDataSetChanged();
                }
            };

    // Code for step 2 end

}
