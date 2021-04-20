package ua.cocktail.develop.cocktail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import java.util.ArrayList

import androidx.fragment.app.FragmentStatePagerAdapter


class ViewPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm!!) {
    private val mFragmentList: MutableList<Fragment> = ArrayList<Fragment>()
    private val mFragmentTitleList: MutableList<String> = ArrayList()
    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mFragmentTitleList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }
}