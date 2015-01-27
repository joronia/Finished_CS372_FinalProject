package com.example.jose.collegepreptools;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class seetest extends ActionBarActivity {
    TextView test12 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seetest);
        test12 = (TextView) findViewById(R.id.seetests);
        test12.setMovementMethod(new ScrollingMovementMethod());
        ImageButton startButton = (ImageButton) findViewById(R.id.goback5);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startactivity();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_seetest, menu);
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
     * reads from file created earlier and sets the read lines to a arrayList and then adds them to the TextView.
     *
     * @param v
     */
    public void seetests(View v) {
        String ffile = "";
        try {
            File F = new File("tests.txt");
            FileInputStream get = openFileInput(F.getName());
            ArrayList<String> sentence = new ArrayList();
            byte[] getbytes = new byte[1024];
            int cb = get.read(getbytes, 0, 1024);

            while (cb != -1) {
                ffile += new String(getbytes, 0, cb);
                sentence.add(ffile);
                cb = get.read(getbytes, 0, 1024);
            }
            get.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            test12.setText(ffile);
        }
    }

    /**
     * Goes back to the main menu.
     */
    private void startactivity() {
        Intent launchactivities = new Intent(this, mainmenu.class);
        startActivity(launchactivities);
    }
}
