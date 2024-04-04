package dk.itu.myshoppingv3kotlin

import android.graphics.Color
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoppingActivityViewModel: ViewModel() {

    //initialize the data in the view model to handle it here
    private val itemsDB: ItemsDB = ItemsDB.get()

    val uiState: MutableLiveData<ShoppingUiState> =
        MutableLiveData<ShoppingUiState>(ShoppingUiState(itemsDB.itemsMap, itemsDB.size()))


    //there needs to be a deleting functionality
    fun onDeleteItemClick(itemWhat: TextView) {
        val what = itemWhat.text.toString().trim { it <= ' ' }
        if (itemsDB.thisExists(what)) {
            itemsDB.removeItem(what)
            uiState.value = ShoppingUiState(itemsDB.itemsMap, itemsDB.size()) //changes the mutable live data's value
        }
    }

    //a way of searching for fields as well
    fun onFindItemClick(itemWhat: TextView, responseWhere: TextView) {
        val what = itemWhat.text.toString().trim()
        //itemWhat.setBackgroundColor(Color.parseColor("#FFFFFF"))
        if(itemsDB.getWhere(what) == null){
            responseWhere.text = "Ooof... Hard to tell!"
        }else{
            responseWhere.text = itemsDB.getWhere(what) //sets the text on the received textview
        }

    }

    //shoppingUiState is a data class
    data class ShoppingUiState(
        val theItems: ArrayList<Item>,
        val itemListSize: Int
    )


}