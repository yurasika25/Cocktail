package ua.cocktail.develop.cocktail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_drinks.view.*
import kotlinx.android.synthetic.main.item_header.view.*
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.network.model.DrinksModel
import ua.cocktail.develop.cocktail.network.model.HeaderModel
import java.util.*

const val TYPE_DRINK = 1
const val TYPE_HEADER = 2

class DrinksAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listItems: ArrayList<Any> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_DRINK) {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.item_drinks, parent, false)
            HeaderViewHolder(v)
        } else {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
            DrinkViewHolder(v)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TYPE_DRINK) {
            val itemList = listItems[position] as DrinksModel
            holder.itemView.drinkTitleTV.text = itemList.strDrink
            Glide
                .with(holder.itemView.context)
                .load(itemList.strDrinkThumb)
                .centerCrop()
                .into(holder.itemView.drinkPhotoIV)
        } else if (getItemViewType(position) == TYPE_HEADER) {
            val item = listItems[position] as HeaderModel
            holder.itemView.headerTV.text = item.title
        }
    }

    fun setData(drinks: List<Any>) {
        listItems.clear()
        listItems.addAll(drinks)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (listItems[position] is DrinksModel) {
            TYPE_DRINK
        } else
            TYPE_HEADER
    }

    class DrinkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemCount(): Int {
        return listItems.size
    }
}