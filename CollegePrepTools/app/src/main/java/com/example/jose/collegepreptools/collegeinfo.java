package com.example.jose.collegepreptools;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Class for all code that deals with the collegeinfo part of the app.
 */
public class collegeinfo extends ActionBarActivity {
    // Initializing GUI variables to be zero.
    EditText findtext = null;
    WebView myWebView = null;

    /**
     * This is where the activity creates all of the objects used in the interface with the object id.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collegeinfo);
        findtext = (EditText) findViewById(R.id.searchbox1);
        //WebView
        myWebView = (WebView) findViewById(R.id.collegeall);
        myWebView.loadUrl("http://www.utexas.edu/world/univ/state/");


        ImageButton goback6 = (ImageButton) findViewById(R.id.goback6);
        goback6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gobacktomenu();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_collegeinfo, menu);
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
     * An Intent to go back to the main menu of the application.
     */
    public void gobacktomenu() {
        Intent menu = new Intent(this, mainmenu.class);
        startActivity(menu);
    }

    /**
     * This is to find the word the user wants to find in the webpage and highlights all of them. View v is
     * used so the button can read the code.
     *
     * @param v
     */
    public void find(View v) {
        myWebView.findAll(findtext.getText().toString());
        myWebView.findAllAsync(findtext.getText().toString());
    }

    /**
     * This method is so from the highlighted text you can go to the next highlighted word.
     *
     * @param v
     */
    public void nextword(View v) {
        myWebView.findNext(true);
    }


}
