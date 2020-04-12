package com.bikepnp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddBike extends AppCompatActivity {

    private Button mConfirmButton;
    private EditText mItemDetails;
    private EditText mName;
    private EditText mPhoneNumber;
    private EditText mPrice;
    private EditText mTitle;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_bike);


        //sets all of the edit texts to a variable
        mName = (EditText)findViewById(R.id.name);
        mPhoneNumber = (EditText)findViewById(R.id.phoneNumber);
        mTitle = (EditText)findViewById(R.id.title);
        mItemDetails = (EditText)findViewById(R.id.itemDetails);
        mPrice = (EditText)findViewById(R.id.price);


        //sets the button to confirm and works accordingly
        this.mConfirmButton = (Button)findViewById(R.id.confirm_button);
        this.mConfirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                AddBike.this.confirmed();
            }
        });
    }

    //Adds all the data to the server so they can put their bike up for rent
    public void confirmed() {
        //Puts all the data into a variable
        String name = mName.getText().toString();
        String phoneNumber = mPhoneNumber.getText().toString();
        String title = mTitle.getText().toString();
        String itemDetails = mItemDetails.getText().toString();
        Double price = Double.parseDouble(mPrice.getText().toString());


        //Add variables to server
        Intent resultIntent = new Intent();
        resultIntent.putExtra("name", name);
        resultIntent.putExtra("phone_number", phoneNumber);
        resultIntent.putExtra("title", title);
        resultIntent.putExtra("details", itemDetails);
        resultIntent.putExtra("item_price", price);


        //Ends the exit screen
        //finish();

    }
}
