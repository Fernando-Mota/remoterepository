package br.com.halphdem.skytest.movielist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.List;

import br.com.halphdem.skytest.BaseView;
import br.com.halphdem.skytest.movie.data.Movie;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteListenersContract;
import retrofit2.Retrofit;

/**
 * Created by fernando on 12/04/17.
 */

public interface MovieListContract {

    public interface View extends BaseView {

        public void initializeList();

        public void openMovieOverView(String id);

    }

    public interface Presenter {

        public void start();

        public void listMovies(MovieRemoteListenersContract.MovieFindAllListener listener);

        public void loadImage(Context context, String imageUri, ImageView destinationImageView);

    }

}
