package br.com.halphdem.skytest.movielist;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import br.com.halphdem.skytest.R;
import br.com.halphdem.skytest.movie.data.Movie;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteListenersContract;
import br.com.halphdem.skytest.movieoverview.MovieOverviewFragment;

/**
 * Created by fernando on 12/04/17.
 */

public class MovieListFragment extends Fragment implements MovieListContract.View, MovieRemoteListenersContract.MovieFindAllListener, ItemClickCallback {

    private MovieListContract.Presenter presenter;

    private RecyclerView movieList;

    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.context = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_list, container, false);

        startPresenter();

        movieList = (RecyclerView) view.findViewById(R.id.movie_list);

        return view;
    }

    @Override
    public void openMovieOverView(String id) {
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        Fragment newFragment = new MovieOverviewFragment();
        newFragment.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.frag_fade_in, R.anim.frag_fade_out, R.anim.frag_fade_in, R.anim.frag_fade_out);
        transaction.replace(R.id.view_container, newFragment);
        transaction.addToBackStack(getString(R.string.list_to_overview_fragment));
        transaction.commit();
    }


    @Override
    public void onStart() {
        super.onStart();
        presenter.listMovies(this);
    }

    @Override
    public void startPresenter() {
        presenter = new MovieListPresenter();
        presenter.start();
    }

    @Override
    public void onFindAll(List<Movie> movies) {
        movieList.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        movieList.setAdapter(new MovieListAdapter(movies, presenter, context, this));
    }

    @Override
    public void onFindAllError(Throwable throwable) {
        Toast.makeText(getContext(), getString(R.string.erro_lista_retorno_lista), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(String id) {
        openMovieOverView(id);
    }
}
