package com.example.krishna.ibm2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
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


public class Text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text4);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

    final TextView textView;
    final EditText editText;
    Button button;
    String sentiment;

    //initialize UI parameters
    textView = (TextView) findViewById(R.id.textView);
    editText = (EditText) findViewById(R.id.editText);
    button = (Button) findViewById(R.id.button);

      final NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
                "2018-03-16",
                "b03fb92a-e8f2-437b-a48f-04c4c7fa1176",
                "YSyFleB2APjV"
        );
         //   service.setEndPoint("https://gateway-fra.watsonplatform.net/natural-language-understanding/api");
        service.setEndPoint("https://gateway.watsonplatform.net/natural-language-understanding/api");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = editText.getText().toString();

                //"IBM is an American multinational technology " +
                //"company headquartered in Armonk, New York, " +
                //"United States, with operations in over 170 countries.";

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
            }

        });

}
 }