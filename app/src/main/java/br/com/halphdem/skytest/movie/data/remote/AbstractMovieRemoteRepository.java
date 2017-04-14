package br.com.halphdem.skytest.movie.data.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;
import retrofit2.http.Path;

/**
 * Created by fernando on 13/04/17.
 */

public interface AbstractMovieRemoteRepository {

    @GET(MovieRemoteContext.CONTEXT)
    public Call<List<br.com.halphdem.skytest.movie.data.Movie>> findAll();

    @GET(MovieRemoteContext.READ)
    Call<br.com.halphdem.skytest.movie.data.Movie> findById(@Path("id") String id);
}
