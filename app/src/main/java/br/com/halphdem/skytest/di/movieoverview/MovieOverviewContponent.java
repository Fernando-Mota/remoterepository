package br.com.halphdem.skytest.di.movieoverview;

import br.com.halphdem.skytest.di.movierepository.MovieRepositoryComponent;
import br.com.halphdem.skytest.movieoverview.MovieOverviewContract;
import br.com.halphdem.skytest.movieoverview.MovieOverviewFragment;
import dagger.Component;

/**
 * Created by fernando on 01/05/17.
 */

@Component(modules = MovieOverviewModule.class, dependencies = MovieRepositoryComponent.class)
public interface MovieOverviewContponent {

    MovieOverviewContract.Presenter getPresenter();

    void inject(MovieOverviewFragment view);

}


