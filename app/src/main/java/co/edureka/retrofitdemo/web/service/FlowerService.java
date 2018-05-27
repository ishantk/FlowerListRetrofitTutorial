package co.edureka.retrofitdemo.web.service;


import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import co.edureka.retrofitdemo.model.FlowersCollection;

public interface FlowerService {
    @GET("/coGUFiJJmG")
    void getFlowerList(@Query("indent") String indent, Callback<FlowersCollection> callback);
}
