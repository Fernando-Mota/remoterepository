package br.com.halphdem.skytest.movielist;

import android.content.Context;
import android.widget.ImageView;

import java.util.List;

import br.com.halphdem.skytest.movie.data.Movie;
import br.com.halphdem.skytest.movie.data.MovieRepository;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteListenersContract;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteRepository;
import retrofit2.Retrofit;

/**
 * Created by fernando on 13/04/17.
 */

public class MovieListPresenter implements MovieListContract.Presenter {

    private MovieRepository repository;

    public MovieListPresenter() {
    }

    public MovieListPresenter(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public void start() {
        repository = new MovieRepository(new MovieRemoteRepository());
    }

    @Override
    public void listMovies(MovieRemoteListenersContract.MovieFindAllListener listener) {
        repository.findAll(listener);
    }

    @Override
    public void loadImage(Context context, String imageUri, ImageView destination) {
        repository.loadRemoteImage(context, imageUri, destination);
    }
}
