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

import br.com.halphdem.skytest.R;
import br.com.halphdem.skytest.movie.data.Movie;
import br.com.halphdem.skytest.movie.data.remote.MovieRemoteListenersContract;

/**
 * Created by fernando on 13/04/17.
 */

public class MovieOverviewFragment extends Fragment implements MovieRemoteListenersContract.MovieFindByIdListener, MovieOverviewContract.View {

    private MovieOverviewPresenter presenter;

    private Movie movie;

    private ImageView imagemTopo;

    private ImageView imagemBody;

    private TextView tituloOverview;

    private TextView overviewText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_overview, container, false);

        startPresenter();

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
            Toast.makeText(getContext(), "Este filme ainda não possui uma sinopse!", Toast.LENGTH_SHORT).show();
            return;
        }

        overviewText.setText("Duração: " + movie.getDuration() + "\n\n" + "Sinopse: " + movie.getOverview());
        tituloOverview.setText(movie.getTitle() + " - " + movie.getReleaseYear());

        imagemBody.setAlpha(0.4F);
        presenter.loadImage(getContext(), movie.getBackdropsUris().get(1), imagemBody);
        presenter.loadImage(getContext(), movie.getBackdropsUris().get(0), imagemTopo);

    }

    @Override
    public void onFindByIdError(Throwable throwable) {
        Toast.makeText(getContext(), "Erro ao carregar dados do filme!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void startPresenter() {
        presenter = new MovieOverviewPresenter();
        presenter.start();
    }
}
