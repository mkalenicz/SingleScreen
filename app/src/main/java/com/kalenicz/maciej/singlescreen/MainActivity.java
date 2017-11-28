package com.kalenicz.maciej.singlescreen;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setCompanyDetails();
    }

    private void setCompanyDetails(){
        TextView businessName = (TextView) findViewById(R.id.business_name);
        businessName.setText("Wroclove Apartment");
        TextView phoneNumber = (TextView) findViewById(R.id.phone_number);
        phoneNumber.setText("+48602393632");

    }

    public void dialPhoneNumber(View view) {
        TextView phoneNumber = (TextView) findViewById(R.id.phone_number);
       String number = phoneNumber.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
