package br.com.halphdem.skytest.di.application;

import br.com.halphdem.skytest.SkyTestApplication;
import dagger.Component;

/**
 * Created by fernando on 30/04/17.
 */

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    SkyTestApplication getApplication();

    void inject(SkyTestApplication skyTestApplication);

}
