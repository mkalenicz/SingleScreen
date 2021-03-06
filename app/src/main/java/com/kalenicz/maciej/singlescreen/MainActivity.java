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

    public void setCompanyDetails() {
        TextView businessName = findViewById(R.id.business_name);
        TextView phoneNumber = findViewById(R.id.phone_number);
        TextView email = findViewById(R.id.email);
        TextView openingHours = findViewById(R.id.hours_of_operation);
        TextView description = findViewById(R.id.description);
        TextView adress = findViewById(R.id.adress);
        adress.setText(R.string.adress);
        businessName.setText(R.string.business_name);
        phoneNumber.setText(R.string.phone_number);
        email.setText(R.string.email);
        openingHours.setText(R.string.opening_hours);
        description.setText(R.string.description);

    }

    public void dialPhoneNumber(View view) {
        TextView phoneNumber = findViewById(R.id.phone_number);
        String number = phoneNumber.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void composeEmail(View view) {
        TextView email = findViewById(R.id.email);
        String[] emails = {email.getText().toString()};
        String subject = "Book Wroclove Apartment";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, emails);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showMap(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.geolocation)));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
