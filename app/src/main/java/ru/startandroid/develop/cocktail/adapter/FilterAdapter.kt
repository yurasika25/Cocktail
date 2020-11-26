package ru.startandroid.develop.cocktail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_filters.view.*
import ru.startandroid.develop.cocktail.R
import java.util.*
import kotlin.collections.HashMap

class FilterAdapter(private var callback: CheckboxFilterCallback) :
    RecyclerView.Adapter<FilterAdapter.ViewHolder>() {

    private var listItems: ArrayList<String> = ArrayList()
    private var filterMap = HashMap<String, Boolean>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_filters, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemList = listItems[position]
        holder.itemView.filterTV.text = itemList
        holder.itemView.filterCB.isChecked = filterMap[itemList] == true
        holder.itemView.filterCB.setOnCheckedChangeListener { _, isChecked ->
            callback.onCheckboxFilterClicked(itemList, isChecked)
        }
    }

    fun addData(drinks: HashMap<String, Boolean>) {
        filterMap = drinks
        listItems = ArrayList<String>(drinks.keys)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemCount(): Int {
        return listItems.size
    }

}

interface CheckboxFilterCallback {
    fun onCheckboxFilterClicked(filter: String, isChecked: Boolean)
}