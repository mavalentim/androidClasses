package dk.itu.myshoppingv3kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class SearchFrag: Fragment() {

    private lateinit var itemsDB: ItemsDB //very similar to shopping activity, this is a late init

    override fun onCreate(savedInstanceState: Bundle?) { //initialization of the fragment things should run here
        super.onCreate(savedInstanceState)

        //initialize the items we have available
        itemsDB = ItemsDB.get()
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? { //THIS FUNCTION HAS TO RETURN A VIEW
        val searchView: View = inflater.inflate(R.layout.searchfrag, container, false) //THIS CREATES A VIEW OUT OF THE LAYOUT DEFINITION

        //viewModel
        val viewModel = ViewModelProvider(requireActivity())[ShoppingActivityViewModel::class.java]

        //search Button
        val searchButton: Button = searchView.findViewById(R.id.search_button_frag)

        //finding the place to put the answer
        val responseBox:TextView = searchView.findViewById(R.id.responseFromDB)

        searchButton.setOnClickListener{
            //Finding the view where the user inputs stuff (its inside so that its the most up to date)
            val inputView:TextView =  searchView.findViewById(R.id.frag_input)

            //responseBox filling -- this will be done with the viewmodel now, the viewmodel will provide the functions!
            viewModel.onFindItemClick(inputView, responseBox)
            //OLD WAY OF DOING IT
            /*
            val searchResponse:String? = itemsDB.whereDoesItGo(enteredText) //hardcoded

            if(searchResponse == null){
                responseBox.text = "No idea mate"
            }else if(searchResponse != null){
                responseBox.text = searchResponse
            }
             */


        }

        val deleteButton :Button = searchView.findViewById(R.id.delete_button_frag)

        deleteButton.setOnClickListener{
            val inputView:TextView =  searchView.findViewById(R.id.frag_input)
            viewModel.onDeleteItemClick(inputView)
        }

        return searchView
    }
}