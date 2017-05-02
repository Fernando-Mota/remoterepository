package br.com.halphdem.skytest.di.movielist;

import br.com.halphdem.skytest.movie.data.MovieRepository;
import br.com.halphdem.skytest.movielist.MovieListContract;
import br.com.halphdem.skytest.movielist.MovieListPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by fernando on 30/04/17.
 */

@Module
public class MovieListModule {

    @Provides
    public MovieListContract.Presenter providesMovieListPresenter(MovieRepository movieRepository) {
        return new MovieListPresenter(movieRepository);
    }

}
