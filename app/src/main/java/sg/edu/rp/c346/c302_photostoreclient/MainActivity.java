package sg.edu.rp.c346.c302_photostoreclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvCategories;
    ArrayList<Category> alCategories = new ArrayList<Category>();

    ArrayAdapter<Category> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvCategories = (ListView)findViewById(R.id.listViewCategories);
        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Intent i = new Intent(MainActivity.this,
                        SecondActivity.class);
                Category data = alCategories.get(position);
                Integer id = data.getId();
                i.putExtra("id", id.toString());
                startActivity(i);
            }
        });
    }
    protected void onResume() {
        super.onResume();
        lvCategories = (ListView) findViewById(R.id.listViewCategories);
        aa = new Adapter(this, R.layout.row, alCategories);
        lvCategories.setAdapter(aa);

        HttpRequest request = new HttpRequest
                ("http://10.0.2.2/C302_P06/getCategories.php");
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

                            int categoryId = jsonObj.getInt("category_id");
                            String categoryName = jsonObj.getString("name");
                            String description = jsonObj.getString("description");

                            String displayResults = "Category Id: " + categoryId + "\n\nCategory Name: "
                                    + categoryName + "\n\nDescription: " + description + "\n";
                            Category cat = new Category(categoryId,categoryName, description);
                            alCategories.add(cat);
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