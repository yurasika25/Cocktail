package ru.startandroid.develop.cocktail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_drinks.view.*
import ru.startandroid.develop.cocktail.R
import ru.startandroid.develop.cocktail.network.model.DrinksModel
import java.util.ArrayList

class DrinksAdapter :
    RecyclerView.Adapter<DrinksAdapter.ViewHolder>() {

    private var listItems: ArrayList<DrinksModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_drinks, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemList = listItems[position]
        holder.itemView.drinkTitleTV.text = itemList.strDrink
        Glide
            .with(holder.itemView.context)
            .load(itemList.strDrinkThumb)
            .centerCrop()
            .into(holder.itemView.drinkPhotoIV)
    }

    fun addData(drinks: List<DrinksModel>) {
        listItems.addAll(drinks)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemCount(): Int {
        return listItems.size


    }

}