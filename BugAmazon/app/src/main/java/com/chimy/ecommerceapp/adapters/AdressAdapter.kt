package com.chimy.ecommerceapp.adapters


import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.chimy.ecommerceapp.R
import com.chimy.ecommerceapp.data.Adress
import com.chimy.ecommerceapp.databinding.AddressRvItemBinding

class AdressAdapter : RecyclerView.Adapter<AdressAdapter.AddresViewHolder>() {

    inner class AddresViewHolder(val binding: AddressRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(address: Adress, isSelected:Boolean ) {
            binding.apply {
                buttonAddress.text = address.adressTitle
                if (isSelected){
                    buttonAddress.background = ColorDrawable(itemView.context.resources.getColor(R.color.g_blue))
                }else {
                    buttonAddress.background = ColorDrawable(itemView.context.resources.getColor(R.color.g_white))
                }
            }
        }

    }

    private val diffUtil = object : DiffUtil.ItemCallback<Adress>() {
        override fun areItemsTheSame(oldItem: Adress, newItem: Adress): Boolean {
            return oldItem.adressTitle == newItem.adressTitle && oldItem.fullName == newItem.fullName
        }

        override fun areContentsTheSame(oldItem: Adress, newItem: Adress): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddresViewHolder {
        return AddresViewHolder(
            AddressRvItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }
    var selectedAddress = -1

    override fun onBindViewHolder(holder: AddresViewHolder, position: Int) {
        val address = differ.currentList[position]
        holder.bind(address, selectedAddress == position)

        holder.binding.buttonAddress.setOnClickListener{
            if (selectedAddress >= 0 )
                notifyItemChanged(selectedAddress)
            selectedAddress = holder.adapterPosition
            notifyItemChanged(selectedAddress)
            onClick?.invoke(address)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    var onClick: ((Adress) -> Unit)? = null


}





