package com.example.omis_651.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.omis_651.adapter.CourseAdapter;
import com.example.omis_651.model.Courses;
import com.example.omis_651.R;
import com.example.omis_651.listener.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vamse on 4/19/2018.
 */

public class CourseListActivity extends AppCompatActivity {
    private List<Courses> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CourseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        setContentView(R.layout.homescreen);
        /*Toolbar myToolbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(myToolbar);*/
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new CourseAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent i = new Intent(CourseListActivity.this, CourseDetailActivity.class);
                Courses c = movieList.get(position);

                i.putExtra("COURSE", c.getTitle());
                i.putExtra("PROF", c.getGenre());
                startActivity(i);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        prepareCoursesData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sign_out: {
                // do your sign-out stuff
                startActivity(new Intent(this, MainActivity.class));
                break;
            }
            case R.id.action_rewardpoints: {
                // do your sign-out stuff
                startActivity(new Intent(this, RewardpointsActivity.class));
                break;
            }
            // case blocks for other MenuItems (if any)
        }
        return false;
    }

    private void prepareCoursesData() {
        Courses movie = new Courses("Mad Max: Fury Road", "Kishen Iyangar", "FREE");
        movieList.add(movie);

        movie = new Courses("Inside Out", "John Kearsing", "$10.99");
        movieList.add(movie);

        movie = new Courses("Star Wars: Episode VII - The Force Awakens", "Chang Liu", "FREE");
        movieList.add(movie);

        movie = new Courses("Shaun the Sheep", "Kishen Iyangar", "FREE");
        movieList.add(movie);

        movie = new Courses("The Martian", "John Kearsing", "$9.99");
        movieList.add(movie);

        movie = new Courses("Mission: Impossible Rogue Nation", "Chang Liu", "FREE");
        movieList.add(movie);

        movie = new Courses("Up", "Kishen Iyangar", "FREE");
        movieList.add(movie);

        movie = new Courses("Star Trek", "John Kearsing", "$12.99");
        movieList.add(movie);

        movie = new Courses("The LEGO Courses", "Kishen Iyangar", "FREE");
        movieList.add(movie);

        movie = new Courses("Iron Man", "John Kearsing", "$13.99");
        movieList.add(movie);

        movie = new Courses("Aliens", "Chang Liu", "$7.99");
        movieList.add(movie);

        movie = new Courses("Chicken Run", "John Kearsing", "FREE");
        movieList.add(movie);

        movie = new Courses("Back to the Future", "Kishen Iyangar", "FREE");
        movieList.add(movie);

        movie = new Courses("Raiders of the Lost Ark", "Chang Liu", "$7.99");
        movieList.add(movie);

        movie = new Courses("Goldfinger", "John Kearsing", "$8.99");
        movieList.add(movie);

        movie = new Courses("Guardians of the Galaxy", "Chang Liu", "FREE");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }



    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Alert!")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(CourseListActivity.this, MainActivity.class));
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
