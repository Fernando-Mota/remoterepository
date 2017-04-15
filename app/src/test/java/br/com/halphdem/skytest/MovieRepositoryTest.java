package br.com.halphdem.skytest;

import android.content.Context;
import android.widget.ImageView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import br.com.halphdem.skytest.infra.RetrofitProvider;
import br.com.halphdem.skytest.movie.data.Movie;
import br.com.halphdem.skytest.movie.data.MovieRepository;
import br.com.halphdem.skytest.movie.data.remote.AbstractMovieRemoteRepository;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteListenersContract;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MovieRepositoryTest {

    @Mock
    MovieRemoteRepository movieRemoteRepository;

    @Mock
    MovieRemoteListenersContract.MovieFindAllListener findAllListener;

    @Mock
    MovieRemoteListenersContract.MovieFindByIdListener findByIdListener;

    @Mock
    ImageView destination;

    @Mock
    Context context;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testaChamadaFindAll() {
        MovieRepository movieRepository = new MovieRepository(movieRemoteRepository);

        movieRepository.findAll(findAllListener);

        List<Movie> movies = new ArrayList<>();
        verify(movieRemoteRepository, times(1)).findAll(findAllListener);
    }

    @Test
    public void testaChamadaFindById() {
        MovieRepository movieRepository = new MovieRepository(movieRemoteRepository);

        movieRepository.findById("123456", findByIdListener);

        List<Movie> movies = new ArrayList<>();
        verify(movieRemoteRepository, times(1)).findById("123456", findByIdListener);
    }

    @Test
    public void testaChamadaLoadRemoteImage() {
        MovieRepository movieRepository = new MovieRepository(movieRemoteRepository);

        String uri = "some.uri";

        movieRepository.loadRemoteImage(context, uri, destination);

        verify(movieRemoteRepository, times(1)).loadRemoteImage(context, uri, destination);
    }
}