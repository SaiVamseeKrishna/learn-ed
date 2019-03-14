package com.example.omis_651.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.omis_651.model.Courses;
import com.example.omis_651.R;

import java.util.List;

/**
 * Created by vamse on 4/19/2018.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.MyViewHolder> {

    private List<Courses> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public Button buynow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            buynow = (Button) view.findViewById(R.id.btnbuy);
        }
    }


    public CourseAdapter(List<Courses> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=null;
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Courses movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
        holder.buynow.setVisibility(View.GONE);
        if (!movie.getYear().equalsIgnoreCase("FREE")) {
            holder.buynow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}

