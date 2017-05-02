package br.com.halphdem.skytest.di.movieoverview;

import br.com.halphdem.skytest.movie.data.MovieRepository;
import br.com.halphdem.skytest.movieoverview.MovieOverviewContract;
import br.com.halphdem.skytest.movieoverview.MovieOverviewPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by fernando on 01/05/17.
 */

@Module
public class MovieOverviewModule {

    @Provides
    public MovieOverviewContract.Presenter providesMovieOverviewPresenter(MovieRepository movieRepository) {
        return new MovieOverviewPresenter(movieRepository);
    }

}
