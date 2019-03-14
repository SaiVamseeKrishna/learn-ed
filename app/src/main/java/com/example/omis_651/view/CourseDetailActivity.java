package com.example.omis_651.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.omis_651.R;

/**
 * Created by vamse on 4/19/2018.
 */

public class CourseDetailActivity extends AppCompatActivity {
    ImageView iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_desc);
        TextView tv1 = (TextView) findViewById(R.id.textView4);
        TextView tv2 = (TextView)findViewById(R.id.textView6);
         iv= (ImageView) findViewById(R.id.imagef);
        Intent i = getIntent();
        tv1.setText(i.getStringExtra("COURSE"));
        tv2.setText(i.getStringExtra("PROF"));
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.setVisibility(View.GONE);
                VideoView videoview = (VideoView) findViewById(R.id.imageView);
                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sample);
                videoview.setVideoURI(uri);
                videoview.start();
            }
        });
    }
}
