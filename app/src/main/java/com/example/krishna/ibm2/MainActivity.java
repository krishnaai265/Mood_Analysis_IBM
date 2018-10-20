package com.example.krishna.ibm2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;

import okhttp3.OkHttpClient;
/*import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;

import java.util.HashMap;
import java.util.Map;
*/

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    OkHttpClient client = new OkHttpClient();
    TextView textView;
    EditText editText;
    Button button;
    String sentiment;

    /*        private class AskWatsonTask extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... textsToAnalyse) {

                System.out.println(editText.getText());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("what is happening inside a thread – we are running Watson AlchemyAPI");
                    }
                });
                sentiment = "Test sentiment";
                AlchemyLanguage service = new AlchemyLanguage();

                service.setApiKey("");

                Map<String, Object> params = new HashMap <String, Object>();
                params.put(AlchemyLanguage.TEXT, editText.getText());
                DocumentSentiment sentiment = service.getSentiment(params).execute();
                System.out.println(sentiment);

//passing the result to be displayed at UI in the main tread
                return sentiment.getSentiment().getType().name();
            }
                //setting the value of UI outside of the thread
                @Override
                protected void onPostExecute(String result) {
                    textView.setText("The message’s sentiment is: " + result);
                }

            }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        System.out.println("I am here");
        //initialize UI parameters
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

/*        //fire action when button is pressed
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Logging to the console that the button pressed for the text : " + editText.getText());
                textView.setText("Displaying at UI the sentiment to be checked for : " + editText.getText());

                AskWatsonTask task = new AskWatsonTask();
                task.execute(new String[]{});
            }

        });
*/ /*      NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
                "2018-03-16",
                "b03fb92a-e8f2-437b-a48f-04c4c7fa1176",
                "YSyFleB2APjV"
        );
         //   service.setEndPoint("https://gateway-fra.watsonplatform.net/natural-language-understanding/api");
        service.setEndPoint("https://gateway.watsonplatform.net/natural-language-understanding/api");
        String text = "IBM is an American multinational technology " +
                "company headquartered in Armonk, New York, " +
                "United States, with operations in over 170 countries.";

        EntitiesOptions entitiesOptions = new EntitiesOptions.Builder()
                .emotion(true)
                .sentiment(true)
                .limit(2)
                .build();

        KeywordsOptions keywordsOptions = new KeywordsOptions.Builder()
                .emotion(true)
                .sentiment(true)
                .limit(2)
                .build();

        Features features = new Features.Builder()
                .entities(entitiesOptions)
                .keywords(keywordsOptions)
                .build();

        AnalyzeOptions parameters = new AnalyzeOptions.Builder()
                .text(text)
                .features(features)
                .build();

        AnalysisResults response = service
                .analyze(parameters)
                .execute();
        System.out.println(response);
*/ /*
        ServiceCall call = service.analyze(parameters);
        call.enqueue(new ServiceCallback<AnalysisResults>() {
            @Override public void onResponse(AnalysisResults response) {
                System.out.println(response);
                textView.setText((CharSequence) response);
                System.out.println("I am here");
                Log.d("Cllg","I am here");
                String s = String.valueOf((CharSequence) response);
                Log.d("Cllg", s);
            }
            @Override public void onFailure(Exception e) {

            }
        });
*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (savedInstanceState == null) {
            Fragment newFragment = new HomeFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.content_frame, newFragment);
            ft.addToBackStack(null);
            ft.commit();
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
      //      startActivity(new Intent(this, Item1fddcddActivity.class));
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
