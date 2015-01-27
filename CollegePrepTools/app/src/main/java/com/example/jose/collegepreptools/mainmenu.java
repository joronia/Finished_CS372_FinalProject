package com.example.jose.collegepreptools;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Whole separate class for the main menu.
 */
public class mainmenu extends ActionBarActivity {
    /**
     * Creates everything in here to be usable in my project.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        ImageButton gpa = (ImageButton) findViewById(R.id.gpapage1);
        gpa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                gotogpa();
            }
        });

        ImageButton community = (ImageButton) findViewById(R.id.communitypage1);
        community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotocommunity();
            }
        });

        ImageButton seecommunity = (ImageButton) findViewById(R.id.seecommevent);
        seecommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoseecomm();
            }
        });

        ImageButton addscores = (ImageButton) findViewById(R.id.addscores);
        addscores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoaddscores();
            }
        });

        ImageButton seescores = (ImageButton) findViewById(R.id.seescores);
        seescores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoseescores();
            }
        });

        ImageButton seecollege = (ImageButton) findViewById(R.id.college);
        seecollege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoseecollege();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mainmenu, menu);
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
     * Tells the button that it needs to launch a certain class the same goes for all the methods after this first one.
     */
    private void gotogpa() {
        Intent launchactivities = new Intent(this, MainActivity.class);
        startActivity(launchactivities);
    }

    private void gotocommunity() {
        Intent show = new Intent(this, Community_Service_extracurricular_activities.class);
        startActivity(show);
    }

    private void gotoseecomm() {
        Intent showevent = new Intent(this, Viewevents.class);
        startActivity(showevent);
    }

    private void gotoaddscores() {
        Intent addscores = new Intent(this, standard_test.class);
        startActivity(addscores);
    }

    private void gotoseescores() {
        Intent seescores = new Intent(this, seetest.class);
        startActivity(seescores);
    }

    private void gotoseecollege() {
        Intent college = new Intent(this, collegeinfo.class);
        startActivity(college);
    }
}
