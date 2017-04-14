package br.com.halphdem.skytest.movie.data.remote;

import java.util.List;

import br.com.halphdem.skytest.movie.data.Movie;

/**
 * Created by fernando on 13/04/17.
 */

public class MovieRemoteListenersContract {

    public interface MovieFindAllListener {
        public void onFindAll(List<Movie> movies);
        public void onFindAllError(Throwable throwable);
    }

    public interface MovieFindByIdListener {
        public void onFindById(Movie movie);
        public void onFindByIdError(Throwable throwable);
    }

}
