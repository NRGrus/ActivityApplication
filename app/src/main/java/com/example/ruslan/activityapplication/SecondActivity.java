package com.example.ruslan.activityapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        TextView textView = new TextView(this);
//        textView.setTextSize(20);
//        textView.setPadding(16, 16, 16, 16);
//
//        Bundle arguments = getIntent().getExtras();
//        final Product product;
//        if (arguments != null) {
//            product = (Product) arguments.getParcelable(Product.class.getSimpleName());
//            textView.setText("Name: " + product.getName() + "\nCompany: " + product.getCompany() + "\nPrice: " + product.getPrice());
//        }
//        setContentView(textView);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        final Product product;
        if (extras != null) {
            TextView ageView = (TextView) findViewById(R.id.ageView);
            String age = extras.getString(MainActivity.AGE_KEY);
            ageView.setText("Возраст: " + age);
        }
    }

    public void onCancelClick(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void onButton1Click(View v) {
        sendMessage("Доступ разрешен");
    }
    public void onButton2Click(View v) {
        sendMessage("Доступ запрещен");
    }
    public void onButton3Click(View v) {
        sendMessage("Недопустимый возраст");
    }

    public void sendMessage(String message) {
        Intent intent = new Intent();
        intent.putExtra(MainActivity.ACCESS_MESSAGE, message);
        setResult(RESULT_OK, intent);
        finish();
    }
}
