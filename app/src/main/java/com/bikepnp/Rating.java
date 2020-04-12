package com.bikepnp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class Rating extends AppCompatActivity {

    private Button mSubmit;
    private RatingBar mRateUser;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_layout);


        //Sets up the rating bar and submit button
        mRateUser = (RatingBar) findViewById(R.id.ratingBar);


        mSubmit = (Button)findViewById(R.id.submit_button);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                rateUser();
            }
        });

    }



    //*********************************************************************
    //Other Functions
    //*********************************************************************

    //Saves the rating and finishes the program
    public void rateUser() {
        int rating = mRateUser.getNumStars();


        //Add to the number of reviews the person currently has and make the new average


        finish();
    }

}
