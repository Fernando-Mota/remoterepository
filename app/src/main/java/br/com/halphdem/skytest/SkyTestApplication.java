package br.com.halphdem.skytest;

import android.app.Application;

import br.com.halphdem.skytest.di.httpclient.DaggerHttpClientComponent;
import br.com.halphdem.skytest.di.httpclient.HttpClientComponent;
import br.com.halphdem.skytest.di.httpclient.HttpClientModule;
import br.com.halphdem.skytest.di.retrofit.DaggerRetrofitComponent;
import br.com.halphdem.skytest.di.retrofit.RetrofitComponent;
import br.com.halphdem.skytest.di.retrofit.RetrofitModule;

/**
 * Created by fernando on 30/04/17.
 */

public class SkyTestApplication extends Application {

    private static HttpClientComponent httpClientComponent;

    private static RetrofitComponent retrofitComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        httpClientComponent = DaggerHttpClientComponent.builder().httpClientModule(new HttpClientModule()).build();

        retrofitComponent = DaggerRetrofitComponent.builder().retrofitModule(new RetrofitModule()).httpClientComponent(httpClientComponent).build();
    }

    public static RetrofitComponent getRetrofitComponent() {
        return retrofitComponent;
    }
}
