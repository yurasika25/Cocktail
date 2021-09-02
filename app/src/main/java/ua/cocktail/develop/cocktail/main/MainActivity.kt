package ua.cocktail.develop.cocktail.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.mainfragment.MainFragment

class MainActivity : AppCompatActivity(), MainView {

    private var presenter: MainPresenter? = null

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        presenter?.enterWithView(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter()
    }

    override fun goToMainFragment() {
        val fragment: Fragment = MainFragment.newInstance()
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.mainContainer, fragment)
        ft.commit()
    }

}



