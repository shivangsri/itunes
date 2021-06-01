package com.example.itunesearch.API;

import com.example.itunesearch.Model.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("search")
    Call<SearchResult> getSearchResults(
            @Query("term") String term
            ,@Query("entity") String str

    );
}
