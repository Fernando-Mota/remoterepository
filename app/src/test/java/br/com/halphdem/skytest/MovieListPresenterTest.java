package br.com.halphdem.skytest;

import android.content.Context;
import android.widget.ImageView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.halphdem.skytest.movie.data.MovieRepository;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteListenersContract;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteRepository;
import br.com.halphdem.skytest.movielist.MovieListContract;
import br.com.halphdem.skytest.movielist.MovieListPresenter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by fernando on 15/04/17.
 */

public class MovieListPresenterTest {

    @Mock
    MovieRepository movieRepository;

    @Mock
    MovieRemoteListenersContract.MovieFindAllListener listener;

    @Mock
    Context context;

    @Mock
    ImageView destination;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testaChamadaFindAll() {
        MovieListContract.Presenter presenter = new MovieListPresenter(movieRepository);

        presenter.listMovies(listener);

        verify(movieRepository, times(1)).findAll(listener);
    }

    @Test
    public void testaChamadaLoadImage() {
        MovieListContract.Presenter presenter = new MovieListPresenter(movieRepository);

        String uri = "some.uri";

        presenter.loadImage(context, uri, destination);

        verify(movieRepository, times(1)).loadRemoteImage(context, uri, destination);
    }
}
