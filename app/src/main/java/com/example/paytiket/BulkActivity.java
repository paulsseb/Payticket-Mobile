package com.example.paytiket;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.Html;

public class BulkActivity extends AppCompatActivity {
    Button btnaddChild, btnsubChild, btnaddAdult, btnsubAdult;
    EditText mChild, mAdult;
    private static int num = 1;
    private static int x, r, s, k, l, totVal;
    private static int z;
    Button Cpay;
    static Html Html;
    Object dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulk);
    }
    public void addChild(View v) {
        EditText mChild = (EditText) findViewById(R.id.idchild);
        x = Integer.parseInt(mChild.getText().toString());

        //int y = Integer.parseInt(mAdult.getText().toString());
        z = num + x;
        // EditText etSum = (EditText) findViewById(R.id.idsum);
        mChild.setText("" + z);
        // Toast.makeText(OtherActivity.this,+ z , Toast.LENGTH_LONG).show();
        //Integer intVal = Integer.parseInt(value1);


        //String value2 = mAdult.getText().toString();
        //adding children function

    }

    public void subChild(View view) {

//subtracting children function
        EditText mChild = (EditText) findViewById(R.id.idchild);
        x = Integer.parseInt(mChild.getText().toString());
        if (x==0){
            mChild.setEnabled(false);
        }else

            z = x - num;
        mChild.setText("" + z);

    }

    public void addAdult(View view) {
        //adding adult function
        EditText mAdult = (EditText) findViewById(R.id.idadult);
        x = Integer.parseInt(mAdult.getText().toString());

        //int y = Integer.parseInt(mAdult.getText().toString());
        z = num + x;
        // EditText etSum = (EditText) findViewById(R.id.idsum);
        mAdult.setText("" + z);
    }

    public void subAdult(View view) {
        //subtracting adult function
        EditText mAdult = (EditText) findViewById(R.id.idadult);
        x = Integer.parseInt(mAdult.getText().toString());
        if (x==0){
            mAdult.setEnabled(false);
        }else

            z = x - num;
        mAdult.setText("" + z);
    }

    public void confirmPay(View view) {
        EditText mAdult = (EditText) findViewById(R.id.idadult);
        EditText mChild = (EditText) findViewById(R.id.idchild);
        s = Integer.parseInt(mAdult.getText().toString());
        r = Integer.parseInt(mChild.getText().toString());
        k = r * 3000;
        l = s * 5000;


        totVal = k + l;

  /*  final CharSequence[] items = {"","","",""};
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Child:" + k)
                .setTitle("Child:" + k)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Confirm", null)
                .show();
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OtherActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });*/

        final AlertDialog.Builder builder = new AlertDialog.Builder(BulkActivity.this);

        CharSequence[] items = new CharSequence[]{Html.fromHtml("<b><big>Child\t:\t\t\t</big></b>" + k),
                Html.fromHtml("<b><big>Adult\t:\t\t\t</big></b>" + l),
                Html.fromHtml("<b><big>Total\t:\t\t\t<big><b>" + totVal)};

        builder.setTitle("Bulk Ticket");

        final AlertDialog.Builder dialog = builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        // Cpay.setText(k);

                        break;
                    case 1:
                        // Cpay.setText(k);
                        break;
                    case 2:
                        //  Cpay.setText(k);
                        break;


                }
            }
        });
        final AlertDialog.Builder dialog1 = new AlertDialog.Builder(BulkActivity.this);

        // builder.setNegativeButton("CANCEL", null );

        // builder.setPositiveButton("",null);
        //builder.setPositiveButton("Confirm", null);
        builder.setCancelable(true);
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(BulkActivity.this,"CANCEL", Toast.LENGTH_LONG).cancel();
            }
        });
        builder.setPositiveButton("PAY", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(BulkActivity.this,"Loading...", Toast.LENGTH_LONG).show();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void Clr(View view) {
        Intent intent = new Intent(BulkActivity.this,CaptureActivity.class);
        startActivity(intent);
    }
}
