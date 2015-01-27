package com.example.jose.collegepreptools;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * Class for the GPA Calculator.
 */
public class MainActivity extends ActionBarActivity {
    //  private int _a, _aminus, _bplus, _b, _bminus, _cplus, _c, _cminus, _dplus, _d, _dminus, _f;
    EditText a11 = null; //(EditText) findViewById(R.id.a);
    EditText a22 = null; //(EditText) findViewById(R.id.aminus);
    EditText b11 = null; //(EditText) findViewById(R.id.bplus);
    EditText b22 = null; //(EditText) findViewById(R.id.b);
    EditText b33 = null; //(EditText) findViewById(R.id.bminus);
    EditText c11 = null; //(EditText) findViewById(R.id.cplus);
    EditText c22 = null; //(EditText) findViewById(R.id.c);
    EditText c33 = null; //(EditText) findViewById(R.id.cminus);
    EditText d11 = null; //(EditText) findViewById(R.id.dplus);
    EditText d22 = null; // (EditText) findViewById(R.id.d);
    EditText d33 = null; //(EditText) findViewById(R.id.dminus);
    EditText f11 = null; //(EditText) findViewById(R.id.f);
    TextView show = null; //(TextView) findViewById(R.id.showresults);

    /**
     * Method to create all objects from user interface.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a11 = (EditText) findViewById(R.id.a);
        a22 = (EditText) findViewById(R.id.aminus);
        b11 = (EditText) findViewById(R.id.bplus);
        b22 = (EditText) findViewById(R.id.b);
        b33 = (EditText) findViewById(R.id.bminus);
        c11 = (EditText) findViewById(R.id.cplus);
        c22 = (EditText) findViewById(R.id.c);
        c33 = (EditText) findViewById(R.id.cminus);
        d11 = (EditText) findViewById(R.id.dplus);
        d22 = (EditText) findViewById(R.id.d);
        d33 = (EditText) findViewById(R.id.dminus);
        f11 = (EditText) findViewById(R.id.f);
        show = (TextView) findViewById(R.id.showresults);

        ImageButton startButton = (ImageButton) findViewById(R.id.goback1);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startactivity();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // public MainActivity(int a, int aminus, int bplus, int b, int bminus, int cplus, int c, int cminus, int dplus, int d, int dminus, int f) {
    //  seta(a);
    //setaminus(aminus);
    //setbplus(bplus);
    //setb(b);
    //setbminus(bminus);
    //setcplus(cplus);
    //setcminus(cminus);
    //setc(c);
    //setdplus(dplus);
    //setdminus(dminus);
    //setd(d);
    //setf(f);
    // }


    //public void seta(int a) {
    //_a = a;
    // }

    // public void setaminus(int aminus) {
    // _aminus = aminus;
    // }

    //public void setbplus(int bplus) {
    //_bplus = bplus;
    // }

    // public void setb(int b) {
    // _b = b;
    // }

    // public void setbminus(int bminus) {
    // _bminus = bminus;
    // }

    //  public void setcplus(int cplus) {
    // _cplus = cplus;
    // }

    // public void setc(int c) {
    //  _c = c;
    // }

    // public void setcminus(int cminus) {
    // _cminus = cminus;
    // }

    // public void setdplus(int dplus) {
    //  _dplus = dplus;
    // }

    // public void setdminus(int dminus) {
    //  _dminus = dminus;
    // }

    // public void setd(int d) {
    //   _d = d;
    //}
    // public void setf(int f) {
    // _f = f;
    // }

    // public void gpa() {
    // int a1 = Integer.parseInt(String.valueOf(a11.getText()));
    //seta(a1);
    // int a2 = Integer.parseInt(String.valueOf(a22.getText()));
    // setaminus(a2);
    //  int b1 = Integer.parseInt(String.valueOf(b11.getText()));
    // setbplus(b1);
    //  int b2 = Integer.parseInt(String.valueOf(b22.getText()));
    //  setb(b2);
    //  int b3 = Integer.parseInt(String.valueOf(b33.getText()));
    //  setbminus(b3);
    //  int c1 = Integer.parseInt(String.valueOf(c11.getText()));
    //  setcplus(c1);
    //  int c2 = Integer.parseInt(String.valueOf(c22.getText()));
    //  setc(c2);
    // int c3 = Integer.parseInt(String.valueOf(c33.getText()));
    // setcminus(c3);
    // int d1 = Integer.parseInt(String.valueOf(d11.getText()));
    //  setdplus(d1);
    //  int d2 = Integer.parseInt(String.valueOf(d22.getText()));
    //  setd(d2);
    //  int d3 = Integer.parseInt(String.valueOf(d33.getText()));
    //  setdminus(d3);
    //  int f1 = Integer.parseInt(String.valueOf(f11.getText()));
    //  setf(f1);
    // }

    /**
     * This is where I setup my math and texts to calculate users GPA.
     *
     * @param v
     */
    public void calculategpa(View v) {

        double a1 = Double.parseDouble(String.valueOf(a11.getText()));
        double a2 = Double.parseDouble(String.valueOf(a22.getText()));
        double b1 = Double.parseDouble(String.valueOf(b11.getText()));
        double b2 = Double.parseDouble(String.valueOf(b22.getText()));
        double b3 = Double.parseDouble(String.valueOf(b33.getText()));
        double c1 = Double.parseDouble(String.valueOf(c11.getText()));
        double c2 = Double.parseDouble(String.valueOf(c22.getText()));
        double c3 = Double.parseDouble(String.valueOf(c33.getText()));
        double d1 = Double.parseDouble(String.valueOf(d11.getText()));
        double d2 = Double.parseDouble(String.valueOf(d22.getText()));
        double d3 = Double.parseDouble(String.valueOf(d33.getText()));
        double f1 = Double.parseDouble(String.valueOf(f11.getText()));


        Double Totalgrade = 0.00;
        Double numberofclass;
        Double GPA = 0.0;

        numberofclass = a1 + a2 + b1 + b2 + b3 + c1 + c2 + c3 + d1 + d2 + d3 + f1;
        Double aamount = a1 * 4.0;
        Double Aminusamount = a2 * 3.7;
        Double bplusamount = b1 * 3.3;
        Double bamount = b2 * 3.0;
        Double bminusamount = b3 * 2.7;
        Double cplusamount = c1 * 2.3;
        Double camount = c2 * 2.0;
        Double cminusamount = c3 * 1.7;
        Double dplusamount = d1 * 1.3;
        Double damount = d2 * 1.0;
        Double dminusamount = d3 * 0.7;
        Double famount = f1 * 0.0;

        Totalgrade = aamount + Aminusamount + bplusamount + bamount + bminusamount + cplusamount + camount + cminusamount + dplusamount + damount + dminusamount + famount;

        if (Totalgrade == 0 && numberofclass == 0) {
            Toast.makeText(this, "You need to add at least one number", Toast.LENGTH_LONG).show();

        }


        GPA = Totalgrade / numberofclass;

        show.setText("GPA: " + String.format("%.3f", GPA));

    }

    /**
     * Launches the next page on a click.
     */
    private void startactivity() {
        Intent launchactivities = new Intent(this, mainmenu.class);
        startActivity(launchactivities);
    }

}

