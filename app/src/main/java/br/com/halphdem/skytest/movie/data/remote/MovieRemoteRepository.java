package br.com.halphdem.skytest.movie.data.remote;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.halphdem.skytest.infra.RetrofitProvider;
import br.com.halphdem.skytest.movie.data.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fernando on 13/04/17.
 */

public class MovieRemoteRepository {

    private AbstractMovieRemoteRepository remoteRepository;

    public MovieRemoteRepository() {
        remoteRepository = RetrofitProvider.retrofit.create(AbstractMovieRemoteRepository.class);
    }

    public void findAll(final MovieRemoteListenersContract.MovieFindAllListener listener) {
        remoteRepository.findAll().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                listener.onFindAll(response.body());
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                listener.onFindAllError(t);
            }
        });
    }

    public void findById(String id, final MovieRemoteListenersContract.MovieFindByIdListener listener) {
        remoteRepository.findById(id).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                listener.onFindById(response.body());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                listener.onFindByIdError(t);
            }
        });

    }

    public void loadRemoteImage(Context context, String uri, ImageView destination) {
        Picasso.with(context).load(uri).fit().centerCrop().into(destination);
    }
}
