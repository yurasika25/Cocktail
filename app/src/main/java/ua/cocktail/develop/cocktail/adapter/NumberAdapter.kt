package ua.cocktail.develop.cocktail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_number.view.*
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.network.model.NumbersModel
import java.util.ArrayList

class NumberAdapter : RecyclerView.Adapter<NumberAdapter.ViewHolder>() {

    private var listItems: ArrayList<NumbersModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_number, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemList = listItems[position]

        holder.itemView.numbers_title.text = itemList.id
        holder.itemView.text_title.text = itemList.title
    }

    fun addNewData(listItems: List<NumbersModel>) {
        this.listItems.addAll(listItems)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
