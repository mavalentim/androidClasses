package dk.itu.myshoppingv3kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class ShoppingActivity : AppCompatActivity() {
    // Model: Database of items
    //private lateinit var itemsDB: ItemsDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping)


        //this is a special object that is capable of filling frames in the content view I set
        val fm: FragmentManager = supportFragmentManager

        //var fragtrans : FragmentTransaction = fm.beginTransaction()

        //so we access the fragment via the class we defined for it
        //fragments are not hollow, they have internal functioning
        val searchFragment:Fragment = SearchFrag()

        val addingFragment: Fragment = addingfrag()

        //we also through the fragment manager create a transaction with the special method beginTransaction
        var fragtrans : FragmentTransaction = fm.beginTransaction()

        //we add the transaction that we want
        fragtrans.add(R.id.framefs, searchFragment)

        fragtrans.commit()

        val textViewtobechanged = findViewById<TextView>(R.id.currentscreen)
        textViewtobechanged.text = "Searching screen"

        //we observe the buttons to transition to another fragment
        val goTosearchButton = findViewById<Button>(R.id.tosearchbutton)
        val goToaddingButton = findViewById<Button>(R.id.toaddbutton)

        goToaddingButton.setOnClickListener{
            var fragtrans2 : FragmentTransaction = fm.beginTransaction()
            fragtrans2.replace(R.id.framefs,addingFragment).commit()
            //fragtrans.add(R.id.framefs,addingFragment).commit()

            val textViewtobechanged = findViewById<TextView>(R.id.currentscreen)
            textViewtobechanged.text = "Adding screen"
        }

        goTosearchButton.setOnClickListener{
            var fragtrans3 : FragmentTransaction = fm.beginTransaction()
            fragtrans3.replace(R.id.framefs, searchFragment).commit()

            val textViewtobechanged = findViewById<TextView>(R.id.currentscreen)
            textViewtobechanged.text = "Searching screen"
        }



    }
}