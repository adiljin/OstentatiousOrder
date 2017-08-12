package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

import static android.R.attr.id;

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

        CheckBox whippedCreamBox = (CheckBox) findViewById(R.id.whippedCreamBox);
        boolean doLikeCream = whippedCreamBox.isChecked();
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        String order = NumberFormat.getCurrencyInstance().format(number) + "\nQuantity: "+ quantity
                + "\nAdd whipped cream? " + doLikeCream
                + "\nThank you";
        priceTextView.setText(order);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}
