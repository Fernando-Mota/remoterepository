package br.com.halphdem.skytest.di.httpclient;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * Created by fernando on 30/04/17.
 */
@Component(modules = HttpClientModule.class)
public interface HttpClientComponent {

    OkHttpClient getOkHttpClient();

}
