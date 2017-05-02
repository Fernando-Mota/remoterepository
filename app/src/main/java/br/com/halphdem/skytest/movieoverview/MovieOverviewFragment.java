package br.com.halphdem.skytest.movieoverview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import br.com.halphdem.skytest.R;
import br.com.halphdem.skytest.ViewContainer;
import br.com.halphdem.skytest.di.movieoverview.DaggerMovieOverviewContponent;
import br.com.halphdem.skytest.di.movieoverview.MovieOverviewModule;
import br.com.halphdem.skytest.movie.data.Movie;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteListenersContract;

/**
 * Created by fernando on 13/04/17.
 */

public class MovieOverviewFragment extends Fragment implements MovieRemoteListenersContract.MovieFindByIdListener, MovieOverviewContract.View {

    @Inject
    MovieOverviewContract.Presenter presenter;

    private Movie movie;

    private ImageView imagemTopo;

    private ImageView imagemBody;

    private TextView tituloOverview;

    private TextView overviewText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_overview, container, false);

        DaggerMovieOverviewContponent.builder().movieOverviewModule(new MovieOverviewModule())
                .movieRepositoryComponent(ViewContainer.getMovieRepositoryComponent()).build().inject(this);

        imagemTopo = (ImageView) view.findViewById(R.id.imagem_topo);
        imagemBody = (ImageView) view.findViewById(R.id.imagem_body);
        tituloOverview = (TextView) view.findViewById(R.id.movie_overview_title);
        overviewText = (TextView) view.findViewById(R.id.movie_overview);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        presenter.findById(bundle.getString("id"), this);
    }

    @Override
    public void onFindById(Movie movie) {
        this.movie = movie;

        if (movie == null) {
            Toast.makeText(getContext(), getString(R.string.erro_overview_sem_sinopse), Toast.LENGTH_SHORT).show();
            return;
        }

        overviewText.setText(String.format(getString(R.string.texto_overview), movie.getDuration(), movie.getOverview()));
        tituloOverview.setText(String.format(getString(R.string.titulo_no_overview), movie.getTitle(), movie.getReleaseYear()));

        imagemBody.setAlpha(0.4F);

        presenter.loadImage(getContext(), movie.getBackdropsUris().get(1), imagemBody);
        presenter.loadImage(getContext(), movie.getBackdropsUris().get(0), imagemTopo);

    }

    @Override
    public void onFindByIdError(Throwable throwable) {
        Toast.makeText(getContext(), getString(R.string.erro_overview_carregar_filme), Toast.LENGTH_LONG).show();
    }
}
