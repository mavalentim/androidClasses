package dk.itu.myshoppingv3kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class fullListFrag:Fragment(){
    private lateinit var itemsDB: ItemsDB
    private lateinit var viewModel: ShoppingActivityViewModel

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
        //add all the functionality: now using viewmodel -> we inflate the layout, from the layout we get the place to be filled
        //but we connect to the viewmodel to fill it, its all through the viewmodel

        viewModel = ViewModelProvider(requireActivity())[ShoppingActivityViewModel::class.java]
        //instead of using this textView, we will use a recycler view, so first thing we put it in the layout and now we find it here
        //val text:TextView = searchView.findViewById(R.id.tobefilled)
        val recyclerView :RecyclerView = searchView.findViewById(R.id.listItems)

        //once we create the recycler view here we need a few things for every recycler view
        //we need a layout manager
        recyclerView.layoutManager = LinearLayoutManager(activity)

        //we need an itemAdapter, which on its own need an ItemHolder
        val mAdapter = ItemAdapter()
        recyclerView.adapter = mAdapter

        viewModel.uiState.observe(viewLifecycleOwner) { mAdapter.notifyDataSetChanged() }

        return searchView
    }

    private inner class ItemHolder(itemView: View, shoppingActivityViewModel: ShoppingActivityViewModel) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val mWhatTextView: TextView //the fields of this class are boxes to be filled, that get filled with the bind function call
        private val mWhereTextView: TextView
        private val itemNumber: TextView
        private val svm: ShoppingActivityViewModel

        init {
            mWhatTextView = itemView.findViewById(R.id.item_what)
            mWhereTextView = itemView.findViewById(R.id.item_where)
            itemNumber = itemView.findViewById(R.id.item_number)
            svm = shoppingActivityViewModel
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {

            val what =
            (v.findViewById<View>(R.id.item_what)// The what TextView
                    as TextView)
            svm.onDeleteItemClick(what)
        }

        fun bind(item: Item, position: Int) { //this function just fills in the located views which are the fields
            mWhatTextView.text = item.what
            mWhereTextView.text = item.where
            itemNumber.text = position.toString()
        }
    }

    private inner class ItemAdapter : RecyclerView.Adapter<ItemHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
            val layoutInflater = LayoutInflater.from(activity)
            val v = layoutInflater.inflate(R.layout.an_item, parent, false)
            return ItemHolder(v, viewModel)
        }

        override fun onBindViewHolder(holder: ItemHolder, position: Int) {
            val item = viewModel.uiState.value!!.theItems[position]
            holder.bind(item, position)
        }

        override fun getItemCount(): Int {
            return viewModel.uiState.value!!.itemListSize
        }
    }
    }