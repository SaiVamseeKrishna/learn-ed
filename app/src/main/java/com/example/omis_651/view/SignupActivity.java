package com.example.omis_651.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.omis_651.R;
import com.example.omis_651.model.UserModel;

/**
 * Created by vamse on 4/19/2018.
 */

public class SignupActivity extends AppCompatActivity {

    public String userName, userPwd, userConfPwd, userDept;
    public boolean pwdMatches;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        ((TextView) findViewById(R.id.errorText)).setVisibility(View.GONE);

        ((Button) findViewById(R.id.btnLogin)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = ((EditText) findViewById(R.id.editText)).getText().toString();
                userPwd = ((EditText) findViewById(R.id.editText3)).getText().toString();
                userConfPwd = ((EditText) findViewById(R.id.editText4)).getText().toString();
                userDept = ((EditText) findViewById(R.id.etdept)).getText().toString();
                pwdMatches = true;
                if (!userPwd.equals(userConfPwd) && !userPwd.isEmpty()) {
                    ((TextView) findViewById(R.id.errorText)).setVisibility(View.VISIBLE);
                    pwdMatches = false;
                }

                if (!userName.isEmpty() && pwdMatches) {
                    UserModel user = new UserModel();
                    user.userName = userName;
                    user.password = userPwd;
                    user.department = userDept;
                    user.save();
                    ((Button) findViewById(R.id.btnLogin)).setClickable(true);
                    Intent i = new Intent(SignupActivity.this, CourseListActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
