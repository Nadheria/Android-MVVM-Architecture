package com.example.mvvmapicall.UI

import android.os.Bundle
import com.app.bonusbuddy.base.BaseActivity
import com.example.mvvmapicall.adapter.FregmentAdapter
import com.example.mvvmapicall.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.GRAVITY_FILL
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener

class MainActivity :  BaseActivity<ActivityMainBinding>() {


    override fun createBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding.tablayout.addTab(binding.tablayout.newTab().setText("Home"))
        binding.tablayout.addTab(binding.tablayout.newTab().setText("business"))
        binding.tablayout.addTab(binding.tablayout.newTab().setText("Sports"))
        binding.tablayout.addTab(binding.tablayout.newTab().setText("Health"))
        binding.tablayout.tabGravity = GRAVITY_FILL


        val adapter = FregmentAdapter(this, supportFragmentManager, binding.tablayout.tabCount)
        binding.viewPager.setAdapter(adapter)
        binding.viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(binding.tablayout))

        binding.tablayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewPager.setCurrentItem(tab.position)
                //                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3)
//                {
//                    adapter.notifyDataSetChanged();
//                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })


    }

}