package ua.cocktail.develop.cocktail.charity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import ua.cocktail.develop.cocktail.R
import androidx.appcompat.app.AppCompatActivity
import ua.cocktail.develop.cocktail.adapter.ViewPagerAdapter

class CharityFragment(val name : String) : Fragment(), CharityFragmentView {


    private var fragmentPresenter: CharityFragmentPresenter? = null

    fun onAddAll() : String{
        return name

    }

    override fun onPause() {
        super.onPause()
        fragmentPresenter?.exitFromView()
    }

    override fun onResume() {
        super.onResume()
        fragmentPresenter?.enterWithView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_charity, container, false)

        fragmentPresenter = CharityFragmentPresenter()


        val toolbarCharity =
            view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarCharity)
        toolbarCharity.setNavigationOnClickListener { requireActivity().onBackPressed() }

        val actionBar: ActionBar? = (activity as AppCompatActivity?)!!.supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val viewPager = view.findViewById<View>(R.id.viewpager) as ViewPager
        setupViewPager(viewPager)
        val tabLayout = view.findViewById<View>(R.id.tabLayout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)

        return view
    }

    private fun setupViewPager(viewPager: ViewPager?) {
        val adapter = ViewPagerAdapter(activity?.supportFragmentManager)
        adapter.addFragment(HelpFragmentOne(), "Список кампаній")
        adapter.addFragment(HelpFragmentTwo(), "Моя допомога")
        viewPager!!.adapter = adapter
    }

    override fun navigateToHelp() {
        TODO("Not yet implemented")
    }
}