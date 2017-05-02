package br.com.halphdem.skytest.movieoverview;

import android.content.Context;
import android.widget.ImageView;

import javax.inject.Inject;

import br.com.halphdem.skytest.movie.data.MovieRepository;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteListenersContract;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteRepository;
import retrofit2.Retrofit;

/**
 * Created by fernando on 13/04/17.
 */

public class MovieOverviewPresenter implements MovieOverviewContract.Presenter {


    private MovieRepository repository;

    @Inject
    public MovieOverviewPresenter(MovieRepository movieRepository) {
        this.repository = movieRepository;
    }

    @Override
    public void findById(String id, MovieRemoteListenersContract.MovieFindByIdListener listener) {
        repository.findById(id, listener);
    }

    @Override
    public void loadImage(Context context, String imageUri, ImageView destinationImageView) {
        repository.loadRemoteImage(context, imageUri, destinationImageView);
    }
}
