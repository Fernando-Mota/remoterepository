package br.com.halphdem.skytest.movielist;

import android.content.Context;
import android.widget.ImageView;

import br.com.halphdem.skytest.infra.BasePresenter;
import br.com.halphdem.skytest.infra.BaseView;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteListenersContract;

/**
 * Created by fernando on 12/04/17.
 */

public interface MovieListContract {

    public interface View extends BaseView {

        public void openMovieOverView(String id);

    }

    public interface Presenter extends BasePresenter {

        public void listMovies(MovieRemoteListenersContract.MovieFindAllListener listener);

        public void loadImage(Context context, String imageUri, ImageView destinationImageView);

    }

}
