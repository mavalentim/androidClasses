package dk.itu.myshoppingv3kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AddingActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adding)
        //val itemsDB = ItemsDB.get()

        //get the views
        var inputForAddingItemName: TextView = findViewById(R.id.textEditforWhat)
        var inputForAddingItemPlace: TextView = findViewById(R.id.textEditforWhere)

        //the item name and place from
        var WhatText :String = inputForAddingItemName.text.toString()
        Log.d("pre1", WhatText)
        var WhereText:String = inputForAddingItemPlace.text.toString()

        //get the button that confirms it
        val ConfirmButton :Button = findViewById(R.id.addbutton)

        ConfirmButton.setOnClickListener{
            //itemsDB.addItem(WhatText, WhereText) this wont help at all
            Log.d("pre", WhatText)
            val intent = Intent(this, ShoppingActivity::class.java)
            intent.putExtra("newItem", WhatText)
            intent.putExtra("newPlace", WhereText)
            startActivity(intent)
        }

    }

}