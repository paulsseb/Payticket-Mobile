package com.example.paytiket;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    String ip="192.168.43.55";
    String port="1433";
    String classes="net.sourceforge.jtds.jdbc.Driver";
    String username="Paytiket";
    String password="pass";
    String DB="paytiket";
    @SuppressLint("NewApi")
    public Connection CONN(){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll()
                .build();
        StrictMode.setThreadPolicy(policy);

        Connection conn = null;
        String ConnUrl;
        try {
            //Class.forName(classes).newInstance();
            Class.forName(classes);
            ConnUrl = "jdbc:jtds:sqlserver://" + ip + ":"+port+";" + "databaseName=" + DB +  ";username=Paytiket;password=" + password +";" ;
            conn = DriverManager.getConnection(ConnUrl);
       } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
return conn ;
    }


}
