package br.com.halphdem.skytest.infra;

import br.com.halphdem.skytest.BuildConfig;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fernando on 02/05/17.
 */

public interface RetrofitProvider {

    OkHttpClient client = new OkHttpClient();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();
}
