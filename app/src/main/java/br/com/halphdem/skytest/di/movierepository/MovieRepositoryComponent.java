package br.com.halphdem.skytest.di.movierepository;

import br.com.halphdem.skytest.di.retrofit.RetrofitComponent;
import br.com.halphdem.skytest.movie.data.Movie;
import br.com.halphdem.skytest.movie.data.MovieRepository;
import br.com.halphdem.skytest.movie.data.remote.AbstractMovieRemoteRepository;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteRepository;
import dagger.Component;

/**
 * Created by fernando on 30/04/17.
 */

@Component(modules = MovieRepositoryModule.class, dependencies = RetrofitComponent.class)
public interface MovieRepositoryComponent {

    AbstractMovieRemoteRepository getAbstractMovieRemoteRepository();

    MovieRemoteRepository getMovieRemoteRepository();

    MovieRepository getMovieRepository();

}
