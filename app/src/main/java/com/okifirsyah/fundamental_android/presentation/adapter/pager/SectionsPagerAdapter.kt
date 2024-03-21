package com.okifirsyah.fundamental_android.presentation.adapter.pager

import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.okifirsyah.fundamental_android.R
import com.okifirsyah.fundamental_android.presentation.view.HomeFragment
import com.okifirsyah.fundamental_android.presentation.view.ProfileFragment

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    private val views = arrayOf(HomeFragment(), ProfileFragment())
    private val act = activity
    override fun getItemCount(): Int {
        return views.size
    }

    override fun createFragment(position: Int): Fragment {
//        var fragment: Fragment? = null
//        when (position) {
//            0 ->  {
//                fragment = HomeFragment.newInstance(position + 10)
//            }
//            1 -> fragment = views[1]
//        }
//
//
//        return fragment as Fragment
        val fragment = HomeFragment.newInstance(position + 1)
        act.supportActionBar?.title = act.resources.getString(TAB_TITLES[position])
        return fragment
    }

    companion object {
        @StringRes
        val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }

}