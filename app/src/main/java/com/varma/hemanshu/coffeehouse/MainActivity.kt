package com.varma.hemanshu.coffeehouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.TextView
import android.widget.CheckBox
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private var quantityCap = 0
    private var quantityMocha = 0
    private var quantityFrappe = 0
    private var quantityEspresso = 0
    var summaryString: String? = null
    var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * This method is called when increment button is clicked.
     */
    fun increment(view: View) {
        val incButtonCappuccino = findViewById<Button>(R.id.IncButtonViewCappuccino)
        val incButtonMocha = findViewById<Button>(R.id.IncButtonViewMocha)
        val incButtonFrappe = findViewById<Button>(R.id.IncButtonViewFrappe)
        val incButtonEspresso = findViewById<Button>(R.id.IncButtonViewEspresso)
        when (view.id) {
            R.id.IncButtonViewCappuccino -> {
                if (quantityCap == 100) {
                    incButtonCappuccino.isEnabled = false
                    Toast.makeText(this, getString(R.string.max_quantity), Toast.LENGTH_SHORT).show()
                } else {
                    quantityCap += 1
                }
                incButtonCappuccino.isEnabled = true
                displayQuantityCap(quantityCap)
            }
            R.id.IncButtonViewMocha -> {
                if (quantityMocha == 100) {
                    incButtonMocha.isEnabled = false
                    Toast.makeText(this, getString(R.string.max_quantity), Toast.LENGTH_SHORT).show()
                } else {
                    quantityMocha += 1
                }
                incButtonMocha.isEnabled = true
                displayQuantityMocha(quantityMocha)
            }
            R.id.IncButtonViewFrappe -> {
                if (quantityFrappe == 100) {
                    incButtonFrappe.isEnabled = false
                    Toast.makeText(this, getString(R.string.max_quantity), Toast.LENGTH_SHORT).show()
                } else {
                    quantityFrappe += 1
                }
                incButtonFrappe.isEnabled = true
                displayQuantityFrappe(quantityFrappe)
            }
            R.id.IncButtonViewEspresso -> {
                if (quantityEspresso == 100) {
                    incButtonEspresso.isEnabled = false
                    Toast.makeText(this, getString(R.string.max_quantity), Toast.LENGTH_SHORT).show()
                } else {
                    quantityEspresso += 1
                }
                incButtonEspresso.isEnabled = true
                displayQuantityEspresso(quantityEspresso)
            }
        }
    }

    /**
     * This method is called when decrement button is clicked.
     */
    fun decrement(view: View) {
        val decButtonCappuccino = findViewById<Button>(R.id.decButtonViewCappuccino)
        val decButtonMocha = findViewById<Button>(R.id.decButtonViewMocha)
        val decButtonFrappe = findViewById<Button>(R.id.decButtonViewFrappe)
        val decButtonEspresso = findViewById<Button>(R.id.decButtonViewEspresso)
        when (view.id) {
            R.id.decButtonViewCappuccino -> {
                if (quantityCap == 0) {
                    decButtonCappuccino.isEnabled = false
                    Toast.makeText(this, getString(R.string.min_quantity), Toast.LENGTH_SHORT).show()
                } else {
                    quantityCap -= 1
                }
                decButtonCappuccino.isEnabled = true
                displayQuantityCap(quantityCap)
            }
            R.id.decButtonViewMocha -> {
                if (quantityMocha == 0) {
                    decButtonMocha.isEnabled = false
                    Toast.makeText(this, getString(R.string.min_quantity), Toast.LENGTH_SHORT).show()
                } else {
                    quantityMocha -= 1
                }
                decButtonMocha.isEnabled = true
                displayQuantityMocha(quantityMocha)
            }
            R.id.decButtonViewFrappe -> {
                if (quantityFrappe == 0) {
                    decButtonFrappe.isEnabled = false
                    Toast.makeText(this, getString(R.string.min_quantity), Toast.LENGTH_SHORT).show()
                } else {
                    quantityFrappe -= 1
                }
                decButtonFrappe.isEnabled = true
                displayQuantityFrappe(quantityFrappe)
            }
            R.id.decButtonViewEspresso -> {
                if (quantityEspresso == 0) {
                    decButtonEspresso.isEnabled = false
                    Toast.makeText(this, getString(R.string.min_quantity), Toast.LENGTH_SHORT).show()
                } else {
                    quantityEspresso -= 1
                }
                decButtonEspresso.isEnabled = true
                displayQuantityEspresso(quantityEspresso)
            }
        }
    }

    /**
     * This method displays the given quantity value of CAPPUCCINO on screen.
     */
    private fun displayQuantityCap(number: Int) {
        val quantityTextViewCap = findViewById<TextView>(R.id.quantity_text_view_cap)
        quantityTextViewCap.text = "$number"
    }

    /**
     * This method displays the given quantity value of CAFFE MOCHA on screen.
     */
    private fun displayQuantityMocha(number: Int) {
        val quantityTextViewMocha = findViewById<TextView>(R.id.quantity_text_view_mocha)
        quantityTextViewMocha.text = "$number"
    }

    /**
     * This method displays the given quantity value of FRAPPE on screen.
     */
    private fun displayQuantityFrappe(number: Int) {
        val quantityTextViewFrappe = findViewById<TextView>(R.id.quantity_text_view_frappe)
        quantityTextViewFrappe.text = "$number"
    }

    /**
     * This method displays the given quantity value of ESPRESSO on screen.
     */
    private fun displayQuantityEspresso(number: Int) {
        val quantityTextViewEspresso = findViewById<TextView>(R.id.quantity_text_view_espresso)
        quantityTextViewEspresso.text = "$number"
    }

    /**
     * This method is called when VIEW SUMMARY Button is clicked.
     */
    fun viewSummary(view: View?) {
        val finalPrice: Int
        // Checks for HotCoffee Extra's cappuccino
        val addHotCoffeeCap = findViewById<CheckBox>(R.id.HotCoffeeCap)
        val hasHotCoffeeCap = addHotCoffeeCap.isChecked
        //Checks for Brewed Coffee Extra's for Cappuccino
        val addBrewedCoffeeCap = findViewById<CheckBox>(R.id.BrewedCap)
        val hasBrewedCoffeeCap = addBrewedCoffeeCap.isChecked

        // Checks for HotCoffee Extra's Mocha
        val addHotCoffeeMocha = findViewById<CheckBox>(R.id.HotCoffeeMocha)
        val hasHotCoffeeMocha = addHotCoffeeMocha.isChecked
        //Checks for Brewed Coffee Extra's for Mocha
        val addBrewedCoffeeMocha = findViewById<CheckBox>(R.id.BrewedMocha)
        val hasBrewedCoffeeMocha = addBrewedCoffeeMocha.isChecked

        // Checks for HotCoffee Extra's Frappe
        val addHotCoffeeFrappe = findViewById<CheckBox>(R.id.HotCoffeeFrappe)
        val hasHotCoffeeFrappe = addHotCoffeeFrappe.isChecked
        //Checks for Brewed Coffee Extra's for frappe
        val addBrewedCoffeeFrappe = findViewById<CheckBox>(R.id.BrewedFrappe)
        val hasBrewedCoffeeFrappe = addBrewedCoffeeFrappe.isChecked

        // Checks for HotCoffee Extra's Espresso
        val addHotCoffeeEspresso = findViewById<CheckBox>(R.id.HotCoffeeEspresso)
        val hasHotCoffeeEspresso = addHotCoffeeEspresso.isChecked
        //Checks for Brewed Coffee Extra's for Espresso
        val addBrewedCoffeeEspresso = findViewById<CheckBox>(R.id.BrewedEspresso)
        val hasBrewedCoffeeEspresso = addBrewedCoffeeEspresso.isChecked
        val priceCap = calculatePriceCap(hasHotCoffeeCap, hasBrewedCoffeeCap)
        val priceMocha = calculatePriceMocha(hasHotCoffeeMocha, hasBrewedCoffeeMocha)
        val priceFrappe = calculatePriceFrappe(hasHotCoffeeFrappe, hasBrewedCoffeeFrappe)
        val priceEspresso = calculatePriceEspresso(hasHotCoffeeEspresso, hasBrewedCoffeeEspresso)
        finalPrice = priceCap + priceMocha + priceFrappe + priceEspresso

        //Intent for getting name from UserActivity.
        val i = intent
        name = i.getStringExtra("NAME")
        val phoneNo = i.getStringExtra("PHONE_NO")
        summaryString = createSummary(name, phoneNo, hasHotCoffeeCap, hasBrewedCoffeeCap, priceCap, hasHotCoffeeMocha, hasBrewedCoffeeMocha, priceMocha, hasHotCoffeeFrappe, hasBrewedCoffeeFrappe, priceFrappe, hasHotCoffeeEspresso, hasBrewedCoffeeEspresso, priceEspresso, finalPrice)
        displayMessage()
    }

    /**
     * This method displays the Summary in an DialogBox.
     */
    private fun displayMessage() {
        val alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle(R.string.title)
        alertDialog.setMessage(summaryString)
        alertDialog.setPositiveButton(R.string.okay) { _, _ -> }
        alertDialog.show()
    }

    /**
     * Calculates the price received from SubmitOrder method
     *
     * @param isHotCoffee    is used to check whether customer needs Hot Coffee
     * @param isBrewedCoffee is used to check whether customer needs Brewed Coffee
     * @return price of Cappuccino
     */
    private fun calculatePriceCap(isHotCoffee: Boolean, isBrewedCoffee: Boolean): Int {
        var price = 50
        if (isHotCoffee) {
            price += 5
        }
        if (isBrewedCoffee) {
            price += 7
        }
        return quantityCap * price
    }

    /**
     * Calculates the price received from SubmitOrder method
     *
     * @param isHotCoffee    is used to check whether customer needs Hot Coffee
     * @param isBrewedCoffee is used to check whether customer needs Brewed Coffee
     * @return price of Caffe Mocha
     */
    private fun calculatePriceMocha(isHotCoffee: Boolean, isBrewedCoffee: Boolean): Int {
        var price = 70
        if (isHotCoffee) {
            price += 5
        }
        if (isBrewedCoffee) {
            price += 7
        }
        return quantityMocha * price
    }

    /**
     * Calculates the price received from SubmitOrder method
     *
     * @param isHotCoffee    is used to check whether customer needs Hot Coffee
     * @param isBrewedCoffee is used to check whether customer needs Brewed Coffee
     * @return price of Frappe Coffee
     */
    private fun calculatePriceFrappe(isHotCoffee: Boolean, isBrewedCoffee: Boolean): Int {
        var price = 75
        if (isHotCoffee) {
            price += 5
        }
        if (isBrewedCoffee) {
            price += 7
        }
        return quantityFrappe * price
    }

    /**
     * Calculates the price received from SubmitOrder method
     *
     * @param isHotCoffee    is used to check whether customer needs Hot Coffee
     * @param isBrewedCoffee is used to check whether customer needs Brewed Coffee
     * @return price of Espresso
     */
    private fun calculatePriceEspresso(isHotCoffee: Boolean, isBrewedCoffee: Boolean): Int {
        var price = 90
        if (isHotCoffee) {
            price += 5
        }
        if (isBrewedCoffee) {
            price += 7
        }
        return quantityEspresso * price
    }

    /**
     * This method creates an Summary of Total order by User.
     */
    private fun createSummary(name: String?, phone: String?, hasHotCoffeeCap: Boolean, hasBrewedCoffeeCap: Boolean, pCap: Int, hasHotCoffeeMocha: Boolean, hasBrewedCoffeeMocha: Boolean, pMocha: Int, hasHotCoffeeFrappe: Boolean, hasBrewedCoffeeFrappe: Boolean, pFrappe: Int, hasHotCoffeeEspresso: Boolean, hasBrewedCoffeeEspresso: Boolean, pEspresso: Int, price: Int): String {
        var summary = """
             ${getString(R.string.name_summary)}$name
             ${getString(R.string.phone_no_summary)}$phone
             ${getString(R.string.view_line)}
             """.trimIndent()
        //Cappuccino
        summary += """
             
             ${getString(R.string.cappuccino)}
             """.trimIndent()
        summary += """
             
             ${getString(R.string.hot_coffee_summary)}$hasHotCoffeeCap
             ${getString(R.string.brewed_coffee_summary)}$hasBrewedCoffeeCap
             """.trimIndent()
        summary += """
             
             ${getString(R.string.quantity_summary)}$quantityCap
             ${getString(R.string.price)}$pCap
             """.trimIndent()
        summary += """
             
             ${getString(R.string.view_line)}
             """.trimIndent()
        //Mocha
        summary += """
             
             ${getString(R.string.caffe_mocha)}
             """.trimIndent()
        summary += """
             
             ${getString(R.string.hot_coffee_summary)}$hasHotCoffeeMocha
             ${getString(R.string.brewed_coffee_summary)}$hasBrewedCoffeeMocha
             """.trimIndent()
        summary += """
             
             ${getString(R.string.quantity_summary)}$quantityMocha
             ${getString(R.string.price)}$pMocha
             """.trimIndent()
        summary += """
             
             ${getString(R.string.view_line)}
             """.trimIndent()
        //Frappe
        summary += """
             
             ${getString(R.string.frappe)}
             """.trimIndent()
        summary += """
             
             ${getString(R.string.hot_coffee_summary)}$hasHotCoffeeFrappe
             ${getString(R.string.brewed_coffee_summary)}$hasBrewedCoffeeFrappe
             """.trimIndent()
        summary += """
             
             ${getString(R.string.quantity_summary)}$quantityFrappe
             ${getString(R.string.price)}$pFrappe
             """.trimIndent()
        summary += """
             
             ${getString(R.string.view_line)}
             """.trimIndent()
        //Espresso
        summary += """
             
             ${getString(R.string.espresso)}
             """.trimIndent()
        summary += """
             
             ${getString(R.string.hot_coffee_summary)}$hasHotCoffeeEspresso
             ${getString(R.string.brewed_coffee_summary)}$hasBrewedCoffeeEspresso
             """.trimIndent()
        summary += """
             
             ${getString(R.string.quantity_summary)}$quantityEspresso
             ${getString(R.string.price)}$pEspresso
             """.trimIndent()
        summary += """
             
             ${getString(R.string.view_line)}
             """.trimIndent()
        //Total Price
        summary += """
             
             ${getString(R.string.total_price)}$price
             ${getString(R.string.view_line)}
             """.trimIndent()
        return summary
    }

    /**
     * This method is invoked when CONFIRM ORDER is clicked.
     * It also passes the Summary to Mail using Intent.
     */
    fun mailOrder(view: View?) {
        val subject = getString(R.string.order_subject) + name
        Toast.makeText(this@MainActivity, R.string.thank_you, Toast.LENGTH_LONG).show()
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, summaryString)
        startActivity(intent)
    }
}