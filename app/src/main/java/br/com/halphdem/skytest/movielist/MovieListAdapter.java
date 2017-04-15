package br.com.halphdem.skytest.movielist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.halphdem.skytest.R;
import br.com.halphdem.skytest.movie.data.Movie;

/**
 * Created by fernando on 12/04/17.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> {

    private List<Movie> movies;

    private MovieListContract.Presenter presenter;

    private Context context;

    private ItemClickCallback itemClickCallback;

    public MovieListAdapter(List<Movie> movies, MovieListContract.Presenter presenter, Context context, ItemClickCallback itemClickCallback) {
        this.movies = movies;
        this.presenter = presenter;
        this.context = context;
        this.itemClickCallback = itemClickCallback;
    }

    @Override
    public MovieListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);

        MovieListViewHolder listaContatoViewHolder = new MovieListViewHolder(view);

        return listaContatoViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieListViewHolder holder, int position) {

        Movie movie = movies.get(position);
        final String id = movie.getId();

        holder.movieTitle.setText(movie.getTitle());
        presenter.loadImage(context, movie.getCoverUri(), holder.movieCover);
        holder.movieCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickCallback.onItemClick(id);
            }
        });


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieListViewHolder extends RecyclerView.ViewHolder {

        private TextView movieTitle;

        private ImageView movieCover;

        public MovieListViewHolder(View itemView) {
            super(itemView);

            movieTitle = (TextView) itemView.findViewById(R.id.movie_title);
            movieCover = (ImageView) itemView.findViewById(R.id.movie_cover);

        }
    }
}
