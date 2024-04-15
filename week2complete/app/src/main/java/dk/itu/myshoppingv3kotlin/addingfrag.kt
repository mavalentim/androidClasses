package dk.itu.myshoppingv3kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class addingfrag: Fragment() {
    //this is a field of the fragment, but one that will be filled when we run onCreate
    private lateinit var itemsDB: ItemsDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initialize the items we have available
        itemsDB = ItemsDB.get()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val addinView: View = inflater.inflate(R.layout.addingfrag, container, false)

        //adding behaviour

        val addingButton = addinView.findViewById<Button>(R.id.addingbutton)

        addingButton.setOnClickListener{
            val enteredThing = addinView.findViewById<TextView>(R.id.addthing).text.toString()
            val enteredLocation = addinView.findViewById<TextView>(R.id.addwhere).text.toString()

            itemsDB.addItem(enteredThing, enteredLocation)

        }






        return addinView
    }

}