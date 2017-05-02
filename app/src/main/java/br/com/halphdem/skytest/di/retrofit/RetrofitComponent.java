package br.com.halphdem.skytest.di.retrofit;

import javax.inject.Singleton;

import br.com.halphdem.skytest.di.httpclient.HttpClientComponent;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by fernando on 30/04/17.
 */
@Component(modules = RetrofitModule.class, dependencies = HttpClientComponent.class)
public interface RetrofitComponent {

    Retrofit getRetrofit();

}
