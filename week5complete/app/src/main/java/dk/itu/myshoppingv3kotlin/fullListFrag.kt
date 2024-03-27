package dk.itu.myshoppingv3kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class fullListFrag:Fragment(){
    private lateinit var itemsDB: ItemsDB

    override fun onCreate(savedInstanceState: Bundle?) { //initialization of the fragment things should run here
        super.onCreate(savedInstanceState)

        //initialize the items we have available
        itemsDB = ItemsDB.get()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View { //THIS FUNCTION HAS TO RETURN A VIEW
        val searchView: View = inflater.inflate(
            R.layout.full_list,
            container,
            false
        )
        //add all the functionality
        val text:TextView = searchView.findViewById(R.id.tobefilled)
        text.text = itemsDB.listItems()

        return searchView
    }
    }