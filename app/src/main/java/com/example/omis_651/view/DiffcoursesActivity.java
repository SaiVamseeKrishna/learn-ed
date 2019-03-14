package com.example.omis_651.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.omis_651.R;

/**
 * Created by vamse on 5/1/2018.
 */

public class DiffcoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diffcourses);
        ((Button)findViewById(R.id.imageView4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DiffcoursesActivity.this,CourseListActivity.class);
                startActivity(i);
            }
        });

    }
}
