package com.varma.hemanshu.coffeehouse;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantityCap = 0;
    int quantityMocha = 0;
    int quantityFrappe = 0;
    int quantityEspresso = 0;
    String summaryString;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when increment button is clicked.
     */
    public void increment(View view) {
        Button incButtonCappuccino = findViewById(R.id.IncButtonViewCappuccino);
        Button incButtonMocha = findViewById(R.id.IncButtonViewMocha);
        Button incButtonFrappe = findViewById(R.id.IncButtonViewFrappe);
        Button incButtonEspresso = findViewById(R.id.IncButtonViewEspresso);
        switch (view.getId()) {
            case R.id.IncButtonViewCappuccino:
                if (quantityCap == 100) {
                    incButtonCappuccino.setEnabled(false);
                    Toast.makeText(this, getString(R.string.max_quantity), Toast.LENGTH_SHORT).show();
                } else {
                    quantityCap += 1;
                }
                incButtonCappuccino.setEnabled(true);
                displayQuantityCap(quantityCap);
                break;
            case R.id.IncButtonViewMocha:
                if (quantityMocha == 100) {
                    incButtonMocha.setEnabled(false);
                    Toast.makeText(this, getString(R.string.max_quantity), Toast.LENGTH_SHORT).show();
                } else {
                    quantityMocha += 1;
                }
                incButtonMocha.setEnabled(true);
                displayQuantityMocha(quantityMocha);
                break;
            case R.id.IncButtonViewFrappe:
                if (quantityFrappe == 100) {
                    incButtonFrappe.setEnabled(false);
                    Toast.makeText(this, getString(R.string.max_quantity), Toast.LENGTH_SHORT).show();
                } else {
                    quantityFrappe += 1;
                }
                incButtonFrappe.setEnabled(true);
                displayQuantityFrappe(quantityFrappe);
                break;
            case R.id.IncButtonViewEspresso:
                if (quantityEspresso == 100) {
                    incButtonEspresso.setEnabled(false);
                    Toast.makeText(this, getString(R.string.max_quantity), Toast.LENGTH_SHORT).show();
                } else {
                    quantityEspresso += 1;
                }
                incButtonEspresso.setEnabled(true);
                displayQuantityEspresso(quantityEspresso);
                break;
        }

    }

    /**
     * This method is called when decrement button is clicked.
     */
    public void decrement(View view) {
        Button decButtonCappuccino = findViewById(R.id.decButtonViewCappuccino);
        Button decButtonMocha = findViewById(R.id.decButtonViewMocha);
        Button decButtonFrappe = findViewById(R.id.decButtonViewFrappe);
        Button decButtonEspresso = findViewById(R.id.decButtonViewEspresso);
        switch (view.getId()) {
            case R.id.decButtonViewCappuccino:
                if (quantityCap == 0) {
                    decButtonCappuccino.setEnabled(false);
                    Toast.makeText(this, getString(R.string.min_quantity), Toast.LENGTH_SHORT).show();
                } else {
                    quantityCap -= 1;
                }
                decButtonCappuccino.setEnabled(true);
                displayQuantityCap(quantityCap);
                break;
            case R.id.decButtonViewMocha:
                if (quantityMocha == 0) {
                    decButtonMocha.setEnabled(false);
                    Toast.makeText(this, getString(R.string.min_quantity), Toast.LENGTH_SHORT).show();
                } else {
                    quantityMocha -= 1;
                }
                decButtonMocha.setEnabled(true);
                displayQuantityMocha(quantityMocha);
                break;
            case R.id.decButtonViewFrappe:
                if (quantityFrappe == 0) {
                    decButtonFrappe.setEnabled(false);
                    Toast.makeText(this, getString(R.string.min_quantity), Toast.LENGTH_SHORT).show();
                } else {
                    quantityFrappe -= 1;
                }
                decButtonFrappe.setEnabled(true);
                displayQuantityFrappe(quantityFrappe);
                break;
            case R.id.decButtonViewEspresso:
                if (quantityEspresso == 0) {
                    decButtonEspresso.setEnabled(false);
                    Toast.makeText(this, getString(R.string.min_quantity), Toast.LENGTH_SHORT).show();
                } else {
                    quantityEspresso -= 1;
                }
                decButtonEspresso.setEnabled(true);
                displayQuantityEspresso(quantityEspresso);
                break;
        }
    }

    /**
     * This method displays the given quantity value of CAPPUCCINO on screen.
     */
    private void displayQuantityCap(int number) {
        TextView quantityTextViewCap = findViewById(R.id.quantity_text_view_cap);
        quantityTextViewCap.setText("" + number);

    }

    /**
     * This method displays the given quantity value of CAFFE MOCHA on screen.
     */
    private void displayQuantityMocha(int number) {
        TextView quantityTextViewMocha = findViewById(R.id.quantity_text_view_mocha);
        quantityTextViewMocha.setText("" + number);

    }

    /**
     * This method displays the given quantity value of FRAPPE on screen.
     */
    private void displayQuantityFrappe(int number) {
        TextView quantityTextViewFrappe = findViewById(R.id.quantity_text_view_frappe);
        quantityTextViewFrappe.setText("" + number);

    }

    /**
     * This method displays the given quantity value of ESPRESSO on screen.
     */
    private void displayQuantityEspresso(int number) {
        TextView quantityTextViewEspresso = findViewById(R.id.quantity_text_view_espresso);
        quantityTextViewEspresso.setText("" + number);

    }

    /**
     * This method is called when VIEW SUMMARY Button is clicked.
     */
    public void viewSummary(View view) {
        int finalPrice;
        // Checks for HotCoffee Extra's cappuccino
        CheckBox addHotCoffeeCap = findViewById(R.id.HotCoffeeCap);
        boolean hasHotCoffeeCap = addHotCoffeeCap.isChecked();
        //Checks for Brewed Coffee Extra's for Cappuccino
        CheckBox addBrewedCoffeeCap = findViewById(R.id.BrewedCap);
        boolean hasBrewedCoffeeCap = addBrewedCoffeeCap.isChecked();

        // Checks for HotCoffee Extra's Mocha
        CheckBox addHotCoffeeMocha = findViewById(R.id.HotCoffeeMocha);
        boolean hasHotCoffeeMocha = addHotCoffeeMocha.isChecked();
        //Checks for Brewed Coffee Extra's for Mocha
        CheckBox addBrewedCoffeeMocha = findViewById(R.id.BrewedMocha);
        boolean hasBrewedCoffeeMocha = addBrewedCoffeeMocha.isChecked();

        // Checks for HotCoffee Extra's Frappe
        CheckBox addHotCoffeeFrappe = findViewById(R.id.HotCoffeeFrappe);
        boolean hasHotCoffeeFrappe = addHotCoffeeFrappe.isChecked();
        //Checks for Brewed Coffee Extra's for frappe
        CheckBox addBrewedCoffeeFrappe = findViewById(R.id.BrewedFrappe);
        boolean hasBrewedCoffeeFrappe = addBrewedCoffeeFrappe.isChecked();

        // Checks for HotCoffee Extra's Espresso
        CheckBox addHotCoffeeEspresso = findViewById(R.id.HotCoffeeEspresso);
        boolean hasHotCoffeeEspresso = addHotCoffeeEspresso.isChecked();
        //Checks for Brewed Coffee Extra's for Espresso
        CheckBox addBrewedCoffeeEspresso = findViewById(R.id.BrewedEspresso);
        boolean hasBrewedCoffeeEspresso = addBrewedCoffeeEspresso.isChecked();

        int priceCap = calculatePriceCap(hasHotCoffeeCap, hasBrewedCoffeeCap);
        int priceMocha = calculatePriceMocha(hasHotCoffeeMocha, hasBrewedCoffeeMocha);
        int priceFrappe = calculatePriceFrappe(hasHotCoffeeFrappe, hasBrewedCoffeeFrappe);
        int priceEspresso = calculatePriceEspresso(hasHotCoffeeEspresso, hasBrewedCoffeeEspresso);
        finalPrice = priceCap + priceMocha + priceFrappe + priceEspresso;

        //Intent for getting name from UserActivity.
        Intent i = getIntent();
        name = i.getStringExtra("Name");
        String phone_no = i.getStringExtra("Phone_No");
        summaryString = createSummary(name, phone_no, hasHotCoffeeCap, hasBrewedCoffeeCap, priceCap, hasHotCoffeeMocha, hasBrewedCoffeeMocha, priceMocha, hasHotCoffeeFrappe, hasBrewedCoffeeFrappe, priceFrappe, hasHotCoffeeEspresso, hasBrewedCoffeeEspresso, priceEspresso, finalPrice);
        displayMessage();


    }

    /**
     * This method displays the Summary in an DialogBox.
     */
    private void displayMessage() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle(R.string.title);
        alertDialog.setMessage(summaryString);
        alertDialog.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }

    /**
     * Calculates the price received from SubmitOrder method
     *
     * @param isHotCoffee    is used to check whether customer needs Hot Coffee
     * @param isBrewedCoffee is used to check whether customer needs Brewed Coffee
     * @return price of Cappuccino
     */
    private int calculatePriceCap(boolean isHotCoffee, boolean isBrewedCoffee) {
        int price = 50;
        if (isHotCoffee) {
            price += 5;
        }
        if (isBrewedCoffee) {
            price += 7;
        }
        return quantityCap * price;
    }

    /**
     * Calculates the price received from SubmitOrder method
     *
     * @param isHotCoffee    is used to check whether customer needs Hot Coffee
     * @param isBrewedCoffee is used to check whether customer needs Brewed Coffee
     * @return price of Caffe Mocha
     */
    private int calculatePriceMocha(boolean isHotCoffee, boolean isBrewedCoffee) {
        int price = 70;
        if (isHotCoffee) {
            price += 5;
        }
        if (isBrewedCoffee) {
            price += 7;
        }
        return quantityMocha * price;
    }

    /**
     * Calculates the price received from SubmitOrder method
     *
     * @param isHotCoffee    is used to check whether customer needs Hot Coffee
     * @param isBrewedCoffee is used to check whether customer needs Brewed Coffee
     * @return price of Frappe Coffee
     */
    private int calculatePriceFrappe(boolean isHotCoffee, boolean isBrewedCoffee) {
        int price = 75;
        if (isHotCoffee) {
            price += 5;
        }
        if (isBrewedCoffee) {
            price += 7;
        }
        return quantityFrappe * price;
    }

    /**
     * Calculates the price received from SubmitOrder method
     *
     * @param isHotCoffee    is used to check whether customer needs Hot Coffee
     * @param isBrewedCoffee is used to check whether customer needs Brewed Coffee
     * @return price of Espresso
     */
    private int calculatePriceEspresso(boolean isHotCoffee, boolean isBrewedCoffee) {
        int price = 90;
        if (isHotCoffee) {
            price += 5;
        }
        if (isBrewedCoffee) {
            price += 7;
        }
        return quantityEspresso * price;
    }

    /**
     * This method creates an Summary of Total order by User.
     */
    private String createSummary(String name, String phone, boolean hasHotCoffeeCap, boolean hasBrewedCoffeeCap, int pCap, boolean hasHotCoffeeMocha, boolean hasBrewedCoffeeMocha, int pMocha, boolean hasHotCoffeeFrappe, boolean hasBrewedCoffeeFrappe, int pFrappe, boolean hasHotCoffeeEspresso, boolean hasBrewedCoffeeEspresso, int pEspresso, int price) {

        String summary = getString(R.string.name_summary) + name + "\n" + getString(R.string.phone_no_summary) + phone + "\n" + getString(R.string.view_line);
        //Cappuccino
        summary += "\n" + getString(R.string.cappuccino);
        summary += "\n" + getString(R.string.hot_coffee_summary) + hasHotCoffeeCap + "\n" + getString(R.string.brewed_coffee_summary) + hasBrewedCoffeeCap;
        summary += "\n" + getString(R.string.quantity_summary) + quantityCap + "\n" + getString(R.string.price) + pCap;
        summary += "\n" + getString(R.string.view_line);
        //Mocha
        summary += "\n" + getString(R.string.caffe_mocha);
        summary += "\n" + getString(R.string.hot_coffee_summary) + hasHotCoffeeMocha + "\n" + getString(R.string.brewed_coffee_summary) + hasBrewedCoffeeMocha;
        summary += "\n" + getString(R.string.quantity_summary) + quantityMocha + "\n" + getString(R.string.price) + pMocha;
        summary += "\n" + getString(R.string.view_line);
        //Frappe
        summary += "\n" + getString(R.string.frappe);
        summary += "\n" + getString(R.string.hot_coffee_summary) + hasHotCoffeeFrappe + "\n" + getString(R.string.brewed_coffee_summary) + hasBrewedCoffeeFrappe;
        summary += "\n" + getString(R.string.quantity_summary) + quantityFrappe + "\n" + getString(R.string.price) + pFrappe;
        summary += "\n" + getString(R.string.view_line);
        //Espresso
        summary += "\n" + getString(R.string.espresso);
        summary += "\n" + getString(R.string.hot_coffee_summary) + hasHotCoffeeEspresso + "\n" + getString(R.string.brewed_coffee_summary) + hasBrewedCoffeeEspresso;
        summary += "\n" + getString(R.string.quantity_summary) + quantityEspresso + "\n" + getString(R.string.price) + pEspresso;
        summary += "\n" + getString(R.string.view_line);
        //Total Price
        summary += "\n" + getString(R.string.total_price) + price + "\n" + getString(R.string.view_line);
        return summary;
    }

    /**
     * This method is invoked when CONFIRM ORDER is clicked.
     * It also passes the Summary to Mail using Intent.
     */
    public void mailOrder(View view) {
        String subject = getString(R.string.order_subject) + name;
        Toast.makeText(MainActivity.this, R.string.thank_you, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, summaryString);
        startActivity(intent);
    }
}


