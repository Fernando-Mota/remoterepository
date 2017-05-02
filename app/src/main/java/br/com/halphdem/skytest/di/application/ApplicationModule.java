package br.com.halphdem.skytest.di.application;

import br.com.halphdem.skytest.SkyTestApplication;
import dagger.Module;
import dagger.Provides;

/**
 * Created by fernando on 30/04/17.
 */


@Module
public class ApplicationModule {

    public final SkyTestApplication application;

    public ApplicationModule(SkyTestApplication application) {
        this.application = application;
    }

    @Provides
    public SkyTestApplication getApplication() {
        return this.application;
    }
}
