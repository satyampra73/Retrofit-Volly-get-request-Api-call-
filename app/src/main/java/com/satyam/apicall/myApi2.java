package com.satyam.apicall;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface myApi2 {
    @GET("payment-types")
    Call<List<model2>> getmodel2();
}
