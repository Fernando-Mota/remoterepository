package br.com.halphdem.skytest.di.retrofit;

import javax.inject.Singleton;

import br.com.halphdem.skytest.BuildConfig;
import br.com.halphdem.skytest.SkyTestApplication;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fernando on 30/04/17.
 */

@Module
public class RetrofitModule {

    @Provides
    public Retrofit getRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}
