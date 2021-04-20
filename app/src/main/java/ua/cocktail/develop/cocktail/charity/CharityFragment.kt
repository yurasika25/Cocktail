package ua.cocktail.develop.cocktail.charity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import ua.cocktail.develop.cocktail.R
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_charity.*
import kotlinx.android.synthetic.main.fragmet_support.*
import ua.cocktail.develop.cocktail.adapter.ViewPagerAdapter
import ua.cocktail.develop.cocktail.help.HelpFragment
import ua.cocktail.develop.cocktail.mainfragment.MainFragment
import ua.cocktail.develop.cocktail.rules.RulesFragment


class CharityFragment : Fragment(), CharityFragmentView {

    private var fragmentPresenter: CharityFragmentPresenter? = null

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


        val toolbarCharity = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarCharity)
            toolbarCharity.setNavigationOnClickListener { requireActivity().onBackPressed()}

        val actionBar: ActionBar? = (activity as AppCompatActivity?)!!.supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val viewPager = view.findViewById<View>(R.id.viewpager) as ViewPager
        setupViewPager(viewPager)
        val tabLayout = view.findViewById<View>(R.id.tablayout) as TabLayout
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