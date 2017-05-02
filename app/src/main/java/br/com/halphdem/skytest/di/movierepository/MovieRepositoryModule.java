package br.com.halphdem.skytest.di.movierepository;

import br.com.halphdem.skytest.movie.data.MovieRepository;
import br.com.halphdem.skytest.movie.data.remote.AbstractMovieRemoteRepository;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteRepository;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by fernando on 30/04/17.
 */

@Module
public class MovieRepositoryModule {

    @Provides
    public AbstractMovieRemoteRepository providesAbstractMovieRemoteRepository(Retrofit retrofit) {
        return retrofit.create(AbstractMovieRemoteRepository.class);
    }

    @Provides
    public MovieRemoteRepository providesMovieRemoteRepository(AbstractMovieRemoteRepository abstractMovieRemoteRepository) {
        return new MovieRemoteRepository(abstractMovieRemoteRepository);
    }

    @Provides
    public MovieRepository providesMovieRepository(MovieRemoteRepository remoteRepository) {
        return new MovieRepository(remoteRepository);
    }

}
