package com.example.jose.collegepreptools;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Class to set the scores from SAT/ACT
 */
public class standard_test extends ActionBarActivity {
    // Initialize variables to zero.
    EditText location2 = null;
    EditText date2 = null;
    EditText english2 = null;
    EditText math2 = null;
    EditText writing2 = null;
    EditText science2 = null;
    EditText reading2 = null;
    Spinner standard2 = null;

    /**
     * Creates the objects from activity.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_test);
        location2 = (EditText) findViewById(R.id.insertlocation);
        date2 = (EditText) findViewById(R.id.editdates);
        english2 = (EditText) findViewById(R.id.editcreading);
        math2 = (EditText) findViewById(R.id.editmath);
        writing2 = (EditText) findViewById(R.id.editwriting);
        science2 = (EditText) findViewById(R.id.editscience);
        reading2 = (EditText) findViewById(R.id.editreading1);
        standard2 = (Spinner) findViewById(R.id.standard);

        ImageButton startButton = (ImageButton) findViewById(R.id.goback4);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startactivity();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_standard_test, menu);
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
     * Writes to file all the information I asked the user into a txt file.
     *
     * @param v
     */
    public void writetest(View v) {
        String y = "tests.txt";

        try {
            FileOutputStream fos1 = openFileOutput(y, MODE_PRIVATE + MODE_APPEND);
            OutputStreamWriter wrtr = new OutputStreamWriter(fos1);
            wrtr.write("\n");
            wrtr.write("Location: " + location2.getText().toString() + "\n");
            wrtr.write("Test Type: " + standard2.getSelectedItem().toString() + "\n");
            wrtr.write("Date: " + date2.getText().toString() + "\n");
            wrtr.write("Critical English: " + english2.getText().toString() + "\n");
            wrtr.write("Math: " + math2.getText().toString() + "\n");
            wrtr.write("Writing: " + writing2.getText().toString() + "\n");
            wrtr.write("Science: " + science2.getText().toString() + "\n");
            wrtr.write("Reading: " + reading2.getText().toString() + "\n");
            location2.setText("");
            date2.setText("");
            english2.setText("");
            math2.setText("");
            writing2.setText("");
            science2.setText("");
            reading2.setText("");

            wrtr.flush();
            wrtr.close();

            Toast

                    .makeText(this, "The contents are saved in the file.", Toast.LENGTH_LONG)

                    .show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable t) {
            Toast

                    .makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG)

                    .show();
        }


    }

    /**
     * Goes back to the main menu of the application.
     */
    private void startactivity() {
        Intent launchactivities = new Intent(this, mainmenu.class);
        startActivity(launchactivities);
    }
}
