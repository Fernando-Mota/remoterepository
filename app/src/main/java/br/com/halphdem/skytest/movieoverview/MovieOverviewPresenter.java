package br.com.halphdem.skytest.movieoverview;

import android.content.Context;
import android.widget.ImageView;

import br.com.halphdem.skytest.movie.data.MovieRepository;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteListenersContract;
import retrofit2.Retrofit;

/**
 * Created by fernando on 13/04/17.
 */

public class MovieOverviewPresenter implements MovieOverviewContract.Presenter {

    private MovieRepository repository;

    @Override
    public void start() {
        repository = new MovieRepository();
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
