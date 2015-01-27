package com.example.jose.collegepreptools;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Class to view all of my events created.
 */
public class Viewevents extends ActionBarActivity {
    TextView events1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewevents);
        events1 = (TextView) findViewById(R.id.displayevents1);
        events1.setMovementMethod(new ScrollingMovementMethod());

        ImageButton startButton = (ImageButton) findViewById(R.id.goback3);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startactivity();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_viewevents, menu);
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

    /**
     * Reads from the file all of the data from the SAT/ACT and puts them to a String of Arrays. Finally it sits those up with
     * a TextView with the information from the file.
     *
     * @param v
     */
    public void readfromtxt(View v) {
        // String fileTo = "activities.txt";
        String collected = " ";
        // FileInputStream fis = null;
        //  ArrayList<String> lines = new ArrayList();
        try {

            //String collected = " ";
            //FileInputStream fis = new FileInputStream("activities.txt");
            File f = new File("activities.txt");
            boolean e = f.exists();
            long l = f.length();
            String n = f.getName();
            FileInputStream fis = openFileInput(f.getName());
            ArrayList<String> lines = new ArrayList();
            //fis = openFileInput("activities.txt");
            // int a = fis.available();
            //byte[] dataArray = new byte[a];
            byte[] readbytes = new byte[1024];
            int cb = fis.read(readbytes, 0, 1024);
            collected = "";
            while (cb != -1) {

                collected += new String(readbytes, 0, cb);
                lines.add(collected);
                cb = fis.read(readbytes, 0, 1024);

            }

            fis.close();


        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {

            events1.setText(collected);
        }


    }

    /**
     * Launches to the main menu again.
     */
    private void startactivity() {
        Intent launchactivities = new Intent(this, mainmenu.class);
        startActivity(launchactivities);
    }
}
