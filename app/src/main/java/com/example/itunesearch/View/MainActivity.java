package com.example.itunesearch.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.itunesearch.API.ApiClient;
import com.example.itunesearch.util.Adapter;
import com.example.itunesearch.Model.ResultModel;
import com.example.itunesearch.Model.SearchResult;
import com.example.itunesearch.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    EditText editText;
    Button search;

    //entity
    String str = "musicVideo";


    List<ResultModel> resultModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.etQuery);
        search = findViewById(R.id.btnSearch);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //If search button is clicked then this function is called
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Passing data from edittext to retriveJSON method
                retriveJSON(editText.getText().toString(), str);

            }
        });
    }

    private void retriveJSON(String term, String str) {

        Call<SearchResult> call = ApiClient.getInstance().getApi().getSearchResults(term, str);
        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                if (response.isSuccessful() && response.body().getResultModels() != null) {
                    resultModels.clear();
                    resultModels = response.body().getResultModels();


                    adapter = new Adapter(MainActivity.this, resultModels);
                    recyclerView.setAdapter(adapter);


                } else {
                    Toast.makeText(MainActivity.this, "no", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                Log.d("shiva", "error: ");

            }
        });

    }
}