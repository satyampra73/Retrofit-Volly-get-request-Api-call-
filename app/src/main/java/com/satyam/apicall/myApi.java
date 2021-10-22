package com.satyam.apicall;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface myApi {
    @GET("payment-types")
    Call<List<model>> getModel();
}
