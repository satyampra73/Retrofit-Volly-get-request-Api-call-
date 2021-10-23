package com.satyam.apicall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class getdata2 extends AppCompatActivity {
    Button button2;
    ListView lv_data2;
    String url = "https://thebudgetpantry.com/api/v2/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdata2);
        button2 = findViewById(R.id.button2);
        lv_data2 = findViewById(R.id.lv_data2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdata();

            }
        });

    }

    private void getdata() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).
                addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi2 api2 = retrofit.create(myApi2.class);
        Call<List<model2>> call = api2.getmodel2();
        call.enqueue(new Callback<List<model2>>() {
            @Override
            public void onResponse(Call<List<model2>> call, Response<List<model2>> response) {
                List<model2> modelList=response.body();
                List<String>list=new ArrayList<>();
                for (int i=0;i<modelList.size();i++){
                    String info="Name: "+modelList.get(i).name;
                    list.add(info);
                }
                ArrayAdapter arrayAdapter=new ArrayAdapter(getdata2.this, android.R.layout.simple_list_item_1,list);
                lv_data2.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<model2>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_SHORT).show();

            }
        });
    }
}