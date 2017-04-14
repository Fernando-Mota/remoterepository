package br.com.halphdem.skytest.movieoverview;

import android.content.Context;
import android.widget.ImageView;

import br.com.halphdem.skytest.movie.data.remote.MovieRemoteListenersContract;
import retrofit2.Retrofit;

/**
 * Created by fernando on 13/04/17.
 */

public interface MovieOverviewContract {

    public interface View {

        public void startPresenter();

    }

    public interface Presenter {

        public void start();

        public void findById(String id, MovieRemoteListenersContract.MovieFindByIdListener listener);

        public void loadImage(Context context, String imageUri, ImageView destinationImageView);

    }
}
