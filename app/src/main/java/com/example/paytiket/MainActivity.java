package com.example.paytiket;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.security.Permission;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;


public class MainActivity extends AppCompatActivity {


    private ImageView imageView,imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);

        imageView = (ImageView) findViewById(R.id.ivtiket) ;
        imageView2 =(ImageView) findViewById(R.id.ivbalance) ;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Balance();
            }
        });

    }


    private void Register() {
        Intent intent = new Intent(MainActivity.this,CaptureActivity.class);
        startActivity(intent);
    }

    private  void Balance(){
        Intent intent = new Intent(MainActivity.this,BalanceActivity.class);
       startActivity(intent);
    }
}