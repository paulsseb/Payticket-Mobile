package com.example.paytiket;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SubmitActivity extends AppCompatActivity {
  Connection connect;
  String ConnectionResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
    }
    public void submitData(View view) {
    }
    public void LoadData(View view){
        TextView tx1= (TextView)findViewById(R.id.tvResult1);
        TextView tx2= (TextView)findViewById(R.id.tvResult2);
        TextView tx3 = (TextView) findViewById(R.id.textview);
        try {
            ConnectionHelper con = new ConnectionHelper();
            connect = con.CONN();
            //tx3.setText("SUCCESS");
            if (connect != null) {

                String sql_query = "select * from cash";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(sql_query);
                while (rs.next())
                {
                    tx3.setText("SUCCESS");
                tx1.setText(rs.getString(1));
               // tx2.setText(rs.getString(2));
            }
        }
            else{
                ConnectionResult ="Check connection";
            }


        }
        /*catch (Exception e) {
            Log.e("error",e.getMessage());

        }*/
        catch(SQLException e){
            Log.e("error",e.getMessage());

        }
    }
}