package com.example.krishna.ibm2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Objects;


public class HomeFragment extends Fragment implements View.OnClickListener {
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayout text = (LinearLayout) getView().findViewById(R.id.text);
        LinearLayout email = (LinearLayout) getView().findViewById(R.id.email);
        LinearLayout url = (LinearLayout) getView().findViewById(R.id.url);
        LinearLayout status = (LinearLayout) getView().findViewById(R.id.status);
        LinearLayout blog = (LinearLayout) getView().findViewById(R.id.blog);
        LinearLayout article = (LinearLayout) getView().findViewById(R.id.article);
        LinearLayout code = (LinearLayout) getView().findViewById(R.id.code);

        text.setOnClickListener(this);
        email.setOnClickListener(this);
        url.setOnClickListener(this);
        status.setOnClickListener(this);
        blog.setOnClickListener(this);
        article.setOnClickListener(this);
        code.setOnClickListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.home, container, false);

    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.text:
                fragment = new Text();
                break;
            case R.id.email:
//                fragment = new ExamScheduleFragment();
                break;
            case R.id.url:
//                fragment = new ResultFragment();
                break;
            case R.id.status:
//                fragment = new AttendenceFragment();
                break;
            case R.id.blog:
//                fragment = new AttendenceFragment();
                break;
            case R.id.article:
//                fragment = new AttendenceFragment();
                break;
            case R.id.code:
//                fragment = new AttendenceFragment();
                break;
        }
        Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment)
                .addToBackStack(null)
                .commit();
    }
/*    public void image_click(View view) {
    Fragment fragment = null;
        if (view.getId() == R.id.text) {
            // button1 action
            fragment = new Text();
 //           Intent homeIntent = new Intent(HomeFragment.this, Text.class);
 //           startActivity(homeIntent);
  //          finish();
        } else if (view.getId() == R.id.email) {
            //button2 action

        } else if (view.getId() == R.id.url) {
            //button3 action
        } else if (view.getId() == R.id.status) {
            //button2 action
        } else if (view.getId() == R.id.blog) {
            //button3 action
        } else if (view.getId() == R.id.article) {
            //button2 action
        } else if (view.getId() == R.id.code) {
            //button3 action
        }
            Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
            .replace(R.id.content_frame, fragment)
            .addToBackStack(null)
            .commit();
    }
*/}
