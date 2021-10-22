package com.satyam.apicall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ListView lv_data;
    String url = "https://thebudgetpantry.com/api/v2/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        lv_data=findViewById(R.id.lv_data);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdata();
            }
        });

    }

    private void getdata() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi api = retrofit.create(myApi.class);
        Call<List<model>> call = api.getModel();
        call.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                List<model> data = response.body();
                List<String>list=new ArrayList<>();
                for (int i=0;i<data.size();i++){
                    String info="name: "+data.get(i).name+"\n"+"payment type: "+data.get(i).payment_type+"\n"+"payment type key: "+data.get(i).payment_type_key+"\n"+"title: "+data.get(i).title;
                    list.add(info);
                }
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list);
                lv_data.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"something ent wrong",Toast.LENGTH_SHORT).show();

            }
        });

    }

}