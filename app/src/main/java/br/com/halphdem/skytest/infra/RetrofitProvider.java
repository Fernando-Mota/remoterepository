package br.com.halphdem.skytest.infra;

import br.com.halphdem.skytest.AppRemoteContext;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fernando on 14/04/17.
 */

public interface RetrofitProvider {

    public static final OkHttpClient client = new OkHttpClient();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(AppRemoteContext.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();

}
