package com.example.fragments;

import android.net.Uri;
import android.nfc.Tag;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements BlueFragment.OnFragmentInteractionListener,
                                PinkFragment.OnFragmentInteractionListener{

    FragmentManager fragmentManager;
    BlueFragment blueFragment;
    PinkFragment pinkFragment;
    PinkFragment pinkFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        blueFragment = BlueFragment.newInstance("","");
        pinkFragment = PinkFragment.newInstance("","");
        pinkFragmentTwo = PinkFragment.newInstance("","");

        fragmentManager.beginTransaction().add(R.id.frmPlaceHolderOne, blueFragment)
                .addToBackStack("BLUE").commit();
        fragmentManager.beginTransaction().add(R.id.frmPlaceHolderTwo, pinkFragment)
                .addToBackStack("PINK").commit();
        fragmentManager.beginTransaction().add(R.id.frmPlaceHolderThree, pinkFragmentTwo)
                .addToBackStack("PINK_TWO").commit();
    }

    @Override
    public void sendNudesToActivity(String string) {
        Log.d("TAG", "sendNudesToActivity: " + string);
        pinkFragment.setSSNNumber(string);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onClick(View view) {
        //fragmentManager.popBackStack();
        //fragmentManager.popBackStack("PINK", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentManager.beginTransaction().remove(blueFragment).commit();
    }
}
