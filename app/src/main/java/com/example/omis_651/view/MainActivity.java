package com.example.omis_651.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.activeandroid.ActiveAndroid;
import com.example.omis_651.R;
import com.example.omis_651.model.UserModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ActiveAndroid.initialize(this);
        final EditText pwd = (EditText) findViewById(R.id.etPWD);
        ((Button) findViewById(R.id.btnSignup)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignupActivity.class));
            }
        });

        ((Button) findViewById(R.id.btnLogin)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(pwd.getText().toString())) {
                    String userName = ((EditText) findViewById(R.id.etUN)).getText().toString();
                    if (!UserModel.checkUserAvailable(userName)) {
                        showMessage("User not available. Please signup!");
                    } else {
                        UserModel user = UserModel.getUserDetails(userName);
                        if (user.password.equals(pwd.getText().toString())) {
                            Intent i = new Intent(MainActivity.this, DiffcoursesActivity.class);
                            startActivity(i);
                        }
                    }

                } else {
                    showMessage("Please enter your credentials to get started");
                }
            }
        });

    }

    public void showMessage(String message) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(MainActivity.this);
        }
        builder.setTitle("Alert!")
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
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
