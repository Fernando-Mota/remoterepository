package br.com.halphdem.skytest.movieoverview;

import android.content.Context;
import android.widget.ImageView;

import br.com.halphdem.skytest.infra.BasePresenter;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteListenersContract;

/**
 * Created by fernando on 13/04/17.
 */

public interface MovieOverviewContract {

    public interface View {

        public void startPresenter();

    }

    public interface Presenter extends BasePresenter {

        public void findById(String id, MovieRemoteListenersContract.MovieFindByIdListener listener);

        public void loadImage(Context context, String imageUri, ImageView destinationImageView);

    }
}
