package com.example.mvvmapicall.adapter

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mvvmapicall.UI.Fregment.BusinessFragment
import com.example.mvvmapicall.UI.Fregment.HealthFragment
import com.example.mvvmapicall.UI.Fregment.HomeFragment
import com.example.mvvmapicall.UI.Fregment.SportsFragment

class FregmentAdapter : FragmentPagerAdapter {
    constructor(fm: FragmentManager) : super(fm)

    var mContext: Context? = null
    var mTotalTabs = 0

    constructor(context: Context?, fragmentManager: FragmentManager?, totalTabs: Int) : super(
        fragmentManager!!
    ) {
        mContext = context
        mTotalTabs = totalTabs
    }

    override fun getItem(position: Int): Fragment {
        Log.d("asasas", position.toString() + "")
        return when (position) {
            0 -> HomeFragment()
            1 -> BusinessFragment()
            2 -> SportsFragment()
            3 -> HealthFragment()
            else ->  HomeFragment()
        }
    }

    override fun getCount(): Int {
        return mTotalTabs
    }
}