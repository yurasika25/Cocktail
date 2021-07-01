package ua.cocktail.develop.cocktail.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_test.*
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.adapter.CocktailAdapter
import ua.cocktail.develop.cocktail.network.model.CocktailModel

class TestFragment : Fragment(), TestFragmentView {

    var adapter = CocktailAdapter()
    var index = 0
    var listCocktail =
        arrayListOf(
            R.drawable.ic_camera,
            R.drawable.em,
            R.drawable.ic_bonus_menu,
            R.drawable.ic_apple
        )

    private var fragmentPresenter: TestFragmentPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    private fun initFun() {
        rc_view.layoutManager = GridLayoutManager(requireActivity(), 3)
        rc_view.adapter = adapter
        id_btn_button_rv.setOnClickListener {
            if (index > 3) index = 0
            val result = CocktailModel(listCocktail[index], "Test$index")
            adapter.addItems(result)
            index++
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentPresenter = TestFragmentPresenter()
        initFun()
        val tBar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarTest)
        tBar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun onPause() {
        super.onPause()
        fragmentPresenter?.exitFromView()
    }

    override fun onResume() {
        super.onResume()
        fragmentPresenter?.enterWithView(this)
    }
}

