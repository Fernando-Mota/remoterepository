package br.com.halphdem.skytest.movielist;

import android.content.Context;
import android.widget.ImageView;

import java.util.List;

import javax.inject.Inject;

import br.com.halphdem.skytest.movie.data.Movie;
import br.com.halphdem.skytest.movie.data.MovieRepository;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteListenersContract;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteRepository;
import retrofit2.Retrofit;

/**
 * Created by fernando on 13/04/17.
 */

public class MovieListPresenter implements MovieListContract.Presenter {

    private MovieRepository movieRepository;

    @Inject
    public MovieListPresenter(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void listMovies(MovieRemoteListenersContract.MovieFindAllListener listener) {
        movieRepository.findAll(listener);
    }

    @Override
    public void loadImage(Context context, String imageUri, ImageView destination) {
        movieRepository.loadRemoteImage(context, imageUri, destination);
    }
}
