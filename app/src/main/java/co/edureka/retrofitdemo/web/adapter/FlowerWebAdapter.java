package co.edureka.retrofitdemo.web.adapter;

import retrofit.RestAdapter;
import co.edureka.retrofitdemo.web.service.FlowerService;

public class FlowerWebAdapter {

    public FlowerService getFlowerService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://www.json-generator.com/api/json/get")
                .build();
        return restAdapter.create(FlowerService.class);
    }
}