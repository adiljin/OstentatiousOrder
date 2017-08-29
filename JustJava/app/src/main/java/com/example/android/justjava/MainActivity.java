package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

import static android.R.attr.id;
import static android.content.Intent.EXTRA_EMAIL;
import static com.example.android.justjava.R.id.whippedCreamBox;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */

    int quantity = 2;
    int price = 3;
    int priceCream = 5;
    int priceChocolate = 7;

    public void increment(View view)
    {
        if(quantity>=1)
        {
            quantity++;
        }
        display(quantity);
    }

    public void decrement(View view)
    {
        if(quantity>1)
        {
            quantity--;
        }
        display(quantity);
    }

    public void submitOrder(View view) {

        displayPrice(quantity*price);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {

        EditText editUserName = (EditText) findViewById(R.id.userName);
        CheckBox whippedCreamBox = (CheckBox) findViewById(R.id.whippedCreamBox);
        CheckBox chocolateBox = (CheckBox) findViewById(R.id.chocolateBox);
        String userName = String.valueOf(editUserName.getText());
        boolean doLikeCream = whippedCreamBox.isChecked();
        boolean doLikeChocolate = chocolateBox.isChecked();
        int price = number;
        if(doLikeCream)
        {
            price+=priceCream;
        }
        if (doLikeChocolate)
        {
            price+=priceChocolate;
        }

        //TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        String order = "Price is: $" + price
                + "\nQuantity: "+ quantity
                + "\nAdd whipped cream? $" + priceCream + " " + doLikeCream
                + "\nAdd chocolate? $" + priceChocolate + " " + doLikeChocolate;
        //priceTextView.setText(order);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_TEXT, order);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"JustJava@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order " + userName);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}
