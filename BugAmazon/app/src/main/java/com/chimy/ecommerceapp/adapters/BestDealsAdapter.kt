package com.chimy.ecommerceapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chimy.ecommerceapp.data.Product
import com.chimy.ecommerceapp.databinding.BestDealsRvItemBinding

class BestDealsAdapter {
    class bestDealsAdapter: RecyclerView.Adapter<bestDealsAdapter.BestDealsViewHolder>() {

        inner class BestDealsViewHolder(private val binding: BestDealsRvItemBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(product: Product) {
                binding.apply {
                    Glide.with(itemView).load(product.images[0]).into(imgBestDeal)
                    product.offerPercentage?.let {
                        val remainingPricePercentage = 1 - it
                        val priceAfterOffer = remainingPricePercentage * product.price
                        tvNewPrice.text = "$ ${String.format("%.2f",priceAfterOffer)}"
                    }
                    tvOldPrice.text = "$ ${product.price}"
                    tvDealProductName.text = product.name
                }
            }
        }

        fun bind(product: Product) {
        }

        private val diffCallback = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }
        }

        val differ = AsyncListDiffer(this, diffCallback)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestDealsViewHolder {
            return BestDealsViewHolder(
                BestDealsRvItemBinding.inflate(
                    LayoutInflater.from(parent.context)
                )
            )
        }

        override fun onBindViewHolder(holder: BestDealsViewHolder, position: Int) {
            val product = differ.currentList[position]
            holder.bind(product)

            holder.itemView.setOnClickListener{
                onClick?.invoke(product)
            }
        }

        override fun getItemCount(): Int {
            return differ.currentList.size
        }

        var onClick: ((Product) -> Unit)? = null

    }

}