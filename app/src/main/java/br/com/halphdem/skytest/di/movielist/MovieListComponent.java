package br.com.halphdem.skytest.di.movielist;

import br.com.halphdem.skytest.di.movierepository.MovieRepositoryComponent;
import br.com.halphdem.skytest.movielist.MovieListContract;
import br.com.halphdem.skytest.movielist.MovieListFragment;
import dagger.Component;

/**
 * Created by fernando on 01/05/17.
 */
@Component(modules = MovieListModule.class, dependencies = MovieRepositoryComponent.class)
public interface MovieListComponent {

    MovieListContract.Presenter getPresenter();

    void inject(MovieListFragment view);
}
