package br.com.halphdem.skytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.halphdem.skytest.movielist.MovieListFragment;

public class ViewContainer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_container);

        if(getSupportFragmentManager().findFragmentByTag("movie_list") == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.view_container, new MovieListFragment(), "movie_list")
                    .commit();
        }
    }
}
