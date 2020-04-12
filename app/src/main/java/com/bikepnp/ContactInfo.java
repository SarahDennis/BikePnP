package com.bikepnp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ContactInfo extends AppCompatActivity {

    private TextView mPhoneNumber;
    private TextView mEmail;
    private Button mBack;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_information);



        mPhoneNumber = (TextView)findViewById(R.id.phoneNumber);
        mEmail = (TextView)findViewById(R.id.email);


        mPhoneNumber.setText("123-456-7890");
        mEmail.setText("examplemail420@gmail.com");


        mBack = (Button)findViewById(R.id.back_button);
        mBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                finish();
            }
        });
    }


}