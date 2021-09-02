package ua.cocktail.develop.cocktail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.drinks_item_test.view.*
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.network.model.CocktailModel

class CocktailAdapter : RecyclerView.Adapter<CocktailAdapter.CocktailHolder>() {

    private val listCocktail = ArrayList<CocktailModel>()

    class CocktailHolder(item: View) : RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.drinks_item_test, parent, false)
        return CocktailHolder(view)
    }

    override fun onBindViewHolder(holder: CocktailHolder, position: Int) {
        val result = listCocktail[position]
        holder.itemView.id_image_tv_cocktail.setImageResource(result.imageTVid)
        holder.itemView.id_tv_text_cocktail.text = result.titleTVid
    }

    override fun getItemCount(): Int {
        return listCocktail.size
    }

    fun addItems(cocktail: CocktailModel) {
        listCocktail.add(cocktail)
        notifyDataSetChanged()
    }
}