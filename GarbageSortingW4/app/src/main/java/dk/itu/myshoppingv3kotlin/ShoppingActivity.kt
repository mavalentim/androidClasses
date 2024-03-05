package dk.itu.myshoppingv3kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class ShoppingActivity : AppCompatActivity() {
    // Model: Database of items
    private lateinit var itemsDB: ItemsDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping)

        //getting the items
        itemsDB = ItemsDB.get() //this works as a constructor it seems

        val intent = intent

        // Get the data from the Intent extras using the same key you used in the sending activity
        val newdata:String? = intent.getStringExtra("newItem")
        val newplace:String? = intent.getStringExtra("newPlace")

        if(newdata!=null && newplace!=null){
            itemsDB.addItem(newdata, newplace)
            Log.d("newData", newdata)
        }

        //Input text field
        val inputTextField: TextView = findViewById(R.id.what_text)

        //Response from the system


        val listItems: Button = findViewById(R.id.list) //
        listItems.setOnClickListener {
            //what was written
            val inputFromUser :String = inputTextField.text.toString()

            //here get the response from the database
            val responseFromDB:String? = itemsDB.whereDoesItGo(inputFromUser)

            //fill in the response box
            //if(response)
            val responseBox :TextView = findViewById(R.id.textResponse)
            responseBox.text = "You should throw the $inputFromUser in the $responseFromDB"
        }

        val addItem: Button = findViewById(R.id.add_button)
        addItem.setOnClickListener {
            Log.d("ButtonClickListener", "Button clicked!")
            //val myIntent = intent(this, AddingActivity::class.java)
            val intent = Intent(this, AddingActivity::class.java)
            startActivity(intent)
        }
    }
}