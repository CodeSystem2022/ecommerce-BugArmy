package com.chimy.ecommerceapp.fragments.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chimy.ecommerceapp.R
import com.chimy.ecommerceapp.adapters.BestProductAdapter
import com.chimy.ecommerceapp.databinding.FragmentBaseCategoryBinding
import com.chimy.ecommerceapp.util.showBottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseCategoryFragment : Fragment(R.layout.fragment_base_category) {
    private lateinit var binding: FragmentBaseCategoryBinding
    protected val offerAdapter: BestProductAdapter by lazy { BestProductAdapter() }
    protected val bestProductAdapter: BestProductAdapter by lazy { BestProductAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBaseCategoryBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupOfferRv()
        setupBestProductsRv()

        bestProductAdapter.onClick = {
            val b = Bundle().apply { putParcelable("product",it) }
            findNavController().navigate(R.id.action_homeFragment_to_productDetailsFragment,b)
        }

        offerAdapter.onClick = {
            val b = Bundle().apply { putParcelable("product",it) }
            findNavController().navigate(R.id.action_homeFragment_to_productDetailsFragment,b)
        }

        binding.rvOffer.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (!recyclerView.canScrollHorizontally(1)&& dx != 0){
                    onOpenPagingRequest()
                }
            }
        })

        binding.nestedScrollBaseCategory.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener{
                v,_,scrollV,_,_ ->
            if (v.getChildAt(0).bottom<=v.height + scrollV){
                onBestProductsPagingRequest()
            }
        })
    }


    fun showOfferLoading(){
        binding.offerProductProgressBar.visibility = View.VISIBLE
    }

    fun hideOfferLoading(){
        binding.offerProductProgressBar.visibility = View.GONE
    }

    fun showBestProductsLoading(){
        binding.bestProductProgressBar.visibility = View.VISIBLE
    }

    fun hideBestProductsLoading(){
        binding.bestProductProgressBar.visibility = View.GONE
    }

    open fun onOpenPagingRequest(){

    }

    open fun onBestProductsPagingRequest(){

    }

    private fun setupBestProductsRv() {
        binding.rvBestProducts.apply {
            layoutManager = GridLayoutManager(requireContext(),2, GridLayoutManager.VERTICAL,false)
            adapter = bestProductAdapter
        }
    }

    private fun setupOfferRv() {
        binding.rvBestProducts.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter = offerAdapter
        }
    }

    override fun onResume() {
        super.onResume()

        showBottomNavigationView()
    }

}
