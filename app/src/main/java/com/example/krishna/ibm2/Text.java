package com.example.krishna.ibm2;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;

import java.util.Objects;


public class Text extends Fragment implements View.OnClickListener {

    final NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
            "2018-03-16",
            "b03fb92a-e8f2-437b-a48f-04c4c7fa1176",
            "YSyFleB2APjV"
    );

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        service.setEndPoint("https://gateway.watsonplatform.net/natural-language-understanding/api");
//        setContentView(R.layout.activity_text4);
//        LayoutInflater inflater = getLayoutInflater();
//        LinearLayout container = (LinearLayout) findViewById(R.id.haha);
//        setContentView(inflater.inflate(R.layout.activity_front__screen, container));

//        fm.beginTransaction().replace(R.id., new ).commit();
//        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.); //Remember this is the FrameLayout area within your activity_main.xml
//        getLayoutInflater().inflate(R.layout.the_layout_you_want_to_load, contentFrameLayout);
        Button text = (Button) getView().findViewById(R.id.analyze);
        text.setOnClickListener(this);



}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_text4, container, false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.analyze:
                final TextView textView;
                final EditText editText;
                Button button;
                String sentiment;

                //initialize UI parameters
                textView = (TextView) getView().findViewById(R.id.textView);
                editText = (EditText) getView().findViewById(R.id.editText);
                button = (Button) getView().findViewById(R.id.analyze);

                        String text = //editText.getText().toString();

                        "IBM is an American multinational technology " +
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
                                showPopup();
                            }

                    });
      textView.setText(text);
        }
        }

//       Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
//                .replace(R.id.content_frame, fragment)
//                .addToBackStack(null)
//                .commit();

    private PopupWindow pw;
    private void showPopup() {
/*        try {
// We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) PopUpDemo.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popup,
                    (ViewGroup) findViewById(R.id.popup_1));
            pw = new PopupWindow(layout, 300, 370, true);
            pw.showAtLocation(layout, Gravity.CENTER, 0, 0);
            Close = (Button) layout.findViewById(R.id.close_popup);
            Close.setOnClickListener(cancel_button);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private View.OnClickListener cancel_button = new View.OnClickListener() {
        public void onClick(View v) {
            pw.dismiss();
        }
*/    };


 }