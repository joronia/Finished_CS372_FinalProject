package com.example.jose.collegepreptools;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Activity class for everything that is dealt with community service.
 */
public class Community_Service_extracurricular_activities extends ActionBarActivity {

    // Intitialize variable to zero.
    EditText event1 = null; //(EditText) findViewById(R.id.community);
    EditText hours1 = null;//(EditText) findViewById(R.id.dates);
    EditText hours2 = null;
    EditText description1 = null; //(EditText) findViewById(R.id.description);
    Spinner spinner = null; //(Spinner) findViewById(R.id.choices);

    /**
     * Creates all GUI functions in here
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community__service_extracurricular_activities);
        event1 = (EditText) findViewById(R.id.community);
        hours1 = (EditText) findViewById(R.id.dates);
        hours2 = (EditText) findViewById(R.id.hoursedit);
        description1 = (EditText) findViewById(R.id.description);
        spinner = (Spinner) findViewById(R.id.choices);

        // creates the image button to here a click from the user.
        ImageButton startButton = (ImageButton) findViewById(R.id.goback2);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startactivity2();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_community__service_extracurricular_activities, menu);
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
     * Method where I grab the text from each Textbox and write them to a file.
     *
     * @param v
     */
    public void writetofile(View v) {
        String FILENAME = "activities.txt";

        try {
            FileOutputStream fos = openFileOutput(FILENAME, MODE_PRIVATE + MODE_APPEND);
            OutputStreamWriter outputwriter = new OutputStreamWriter(fos);
            outputwriter.write("\n");
            outputwriter.write("Event Name: " + event1.getText().toString() + "\n");
            outputwriter.write("Event Type: " + spinner.getSelectedItem().toString() + "\n");
            outputwriter.write("Dates involved: " + hours1.getText().toString() + "\n");
            outputwriter.write("Number of hours: " + hours2.getText().toString() + "\n");
            outputwriter.write("Description of event: " + description1.getText().toString() + "\n");

            event1.setText("");
            hours1.setText("");
            hours2.setText("");
            description1.setText("");

            outputwriter.flush();
            outputwriter.close();
            File f = new File(FILENAME);
            boolean e = f.exists();
            long l = f.length();
            String n = f.getName();

            Toast

                    .makeText(this, "The contents are saved in the file.", Toast.LENGTH_LONG)

                    .show();

        } catch (Throwable t) {

            Toast

                    .makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG)

                    .show();

        }
    }

    /**
     * Method where it calls for the next page.
     */
    private void startactivity2() {
        Intent launchGame = new Intent(this, mainmenu.class);
        startActivity(launchGame);
    }

}


