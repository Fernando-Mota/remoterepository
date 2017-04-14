package br.com.halphdem.skytest.movie.data;

import android.content.Context;
import android.widget.ImageView;

import br.com.halphdem.skytest.movie.data.remote.MovieRemoteListenersContract;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteRepository;
import retrofit2.Retrofit;

/**
 * Created by fernando on 13/04/17.
 */

public class MovieRepository {

    private MovieRemoteRepository remoteRepository;

    public MovieRepository() {
        this.remoteRepository = new MovieRemoteRepository();
    }

    public void findAll(MovieRemoteListenersContract.MovieFindAllListener listener) {
        remoteRepository.findAll(listener);
    }

    public void findById(String id, MovieRemoteListenersContract.MovieFindByIdListener listener) {
        remoteRepository.findById(id, listener);
    }

    public void loadRemoteImage(Context context, String uri, ImageView destination) {
        remoteRepository.loadRemoteImage(context, uri, destination);
    }
}
