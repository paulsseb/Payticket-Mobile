package com.example.paytiket;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CaptureActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);

        Button BtnChild, BtnAdult, BtnOthers;
        BtnChild = (Button) findViewById(R.id.btnChild);
        BtnAdult = (Button) findViewById(R.id.btnAdult);
        BtnOthers = (Button) findViewById(R.id.btnOther);
        BtnOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CaptureActivity.this, BulkActivity.class);
                startActivity(intent);
            }
        });
    }
        public void showChild(View view) {

            final AlertDialog.Builder builder = new AlertDialog.Builder(CaptureActivity.this);
            builder.setTitle("Ticekt: 1 Child");
            builder.setMessage("Amount: 3000");
            final AlertDialog.Builder dialog1 = new AlertDialog.Builder(CaptureActivity.this);
            builder.setCancelable(true);
            builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(CaptureActivity.this, "CANCEL", Toast.LENGTH_LONG).cancel();
                }
            });
            builder.setPositiveButton("Pay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {



                   Toast.makeText(CaptureActivity.this,"Loading...", Toast.LENGTH_LONG).show();


                }
            });


            AlertDialog alert = builder.create();
       alert.show();

        }



    public void showAdult(View view) {

            final AlertDialog.Builder builder = new AlertDialog.Builder(CaptureActivity.this);
            builder.setTitle("Ticekt: 1 Adult");
            builder.setMessage("Amount: 5000");


            final AlertDialog.Builder dialog1 = new AlertDialog.Builder(CaptureActivity.this);
            builder.setCancelable(true);
            builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(CaptureActivity.this, "CANCEL", Toast.LENGTH_LONG).cancel();
                }
            });
            builder.setPositiveButton("pay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(CaptureActivity.this, "Loading...", Toast.LENGTH_LONG).show();

                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }


        public void mult(View view) {
            Intent intent = new Intent(CaptureActivity.this, BulkActivity.class);
            startActivity(intent);
        }

        public void main(View view) {
            //Intent intent = new Intent(CaptureActivity.this, MainActivity.class);
           // startActivity(intent);

            Intent intent = new Intent(CaptureActivity.this, SubmitActivity.class);
             startActivity(intent);
        }
}
