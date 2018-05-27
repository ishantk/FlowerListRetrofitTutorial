package co.edureka.retrofitdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import co.edureka.retrofitdemo.R;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import co.edureka.retrofitdemo.adapter.FlowersAdapter;
import co.edureka.retrofitdemo.model.FlowersCollection;
import co.edureka.retrofitdemo.web.adapter.FlowerWebAdapter;
import co.edureka.retrofitdemo.web.service.FlowerService;


public class MainActivity extends AppCompatActivity {

    private ListView flowersList;
    private FlowersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flowersList = (ListView) findViewById(R.id.flowersList);

        FlowerService flowerService = new FlowerWebAdapter().getFlowerService();
        flowerService.getFlowerList("2", new Callback<FlowersCollection>() {
            @Override
            public void success(FlowersCollection flowersCollection, Response response) {
                adapter = new FlowersAdapter(MainActivity.this, flowersCollection.flowers);
                flowersList.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }
}
