package br.com.halphdem.skytest.movie.data.remote;

import java.util.List;

import br.com.halphdem.skytest.BuildConfig;
import retrofit2.Call;
import retrofit2.http.*;
import retrofit2.http.Path;

/**
 * Created by fernando on 13/04/17.
 */

public interface AbstractMovieRemoteRepository {

    @GET(BuildConfig.MOVIE_CONTEXT)
    public Call<List<br.com.halphdem.skytest.movie.data.Movie>> findAll();

    @GET(BuildConfig.MOVIE_READ)
    Call<br.com.halphdem.skytest.movie.data.Movie> findById(@Path("id") String id);
}
