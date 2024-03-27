package dk.itu.myshoppingv3kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class SearchFrag: Fragment() {

    private lateinit var itemsDB: ItemsDB //very similar to shopping activity, this is a late init

    override fun onCreate(savedInstanceState: Bundle?) { //initialization of the fragment things should run here
        super.onCreate(savedInstanceState)

        //initialize the items we have available
        itemsDB = ItemsDB.get()
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? { //THIS FUNCTION HAS TO RETURN A VIEW
        val searchView: View = inflater.inflate(R.layout.searchfrag, container, false) //THIS CREATES A VIEW OUT OF THE LAYOUT DEFINITION

        //search Button
        val searchButton: Button = searchView.findViewById(R.id.search_button_frag)

        //finding the place to put the answer
        val responseBox:TextView = searchView.findViewById(R.id.responseFromDB)

        searchButton.setOnClickListener{
            //user input CANNOT BE OUTSIDE, IT HAS TO TAKE THE NEWEST OF USER INPUT and that happens when right before they click on it
            val inputView:TextView =  searchView.findViewById(R.id.frag_input)
            val enteredText:String = inputView.text.toString()

            //responseBox filling
            val searchResponse:String? = itemsDB.whereDoesItGo(enteredText) //hardcoded

            if(searchResponse == null){
                responseBox.text = "No idea mate"
            }else if(searchResponse != null){
                responseBox.text = searchResponse
            }


        }

        return searchView
    }
}