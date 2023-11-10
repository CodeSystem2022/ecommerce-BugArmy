package com.chimy.ecommerceapp.fragments.shopping


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import com.chimy.ecommerceapp.R
import com.chimy.ecommerceapp.adapters.HomeViewpagerAdapter
import com.chimy.ecommerceapp.databinding.FragmentHomeBinding
import com.chimy.ecommerceapp.fragments.categories.AccessoryFragment
import com.chimy.ecommerceapp.fragments.categories.ChairFragment
import com.chimy.ecommerceapp.fragments.categories.CupboardFragment
import com.chimy.ecommerceapp.fragments.categories.FornitureFragment
import com.chimy.ecommerceapp.fragments.categories.MainCategoryFragment
import com.chimy.ecommerceapp.fragments.categories.TableFragment
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment: Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf<Fragment>(
            MainCategoryFragment(),
            ChairFragment(),
            CupboardFragment(),
            TableFragment(),
            AccessoryFragment(),
            FornitureFragment()
        )

        binding.viewPagerHome.isUserInputEnabled = false

        val viewpager2Adapter = HomeViewpagerAdapter(categoriesFragments,childFragmentManager,lifecycle)
        binding.viewPagerHome.adapter = viewpager2Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPagerHome){ tab, position ->
            when (position){
                0 -> tab.text = "Main"
                1 -> tab.text = "Chair"
                2 -> tab.text = "Cupboard"
                3 -> tab.text = "Table"
                4 -> tab.text = "Accessory"
                5 -> tab.text = "Forniture"
            }
        }.attach()
    }

}