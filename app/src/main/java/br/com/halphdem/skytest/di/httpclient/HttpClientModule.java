package br.com.halphdem.skytest.di.httpclient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by fernando on 30/04/17.
 */

@Module
public class HttpClientModule {

    @Provides
    public OkHttpClient providesOkHttpClient() {
        return new OkHttpClient();
    }
}
