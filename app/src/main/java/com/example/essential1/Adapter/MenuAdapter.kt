package com.example.essential.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.essential1.Data.MenuItemData
import com.example.essential1.databinding.ActivityMainBinding

class MenuAdapter(var conext:Context):
    RecyclerView.Adapter<MenuAdapter.VH>(){

    inner class VH(var binding: ActivityMainBinding):RecyclerView.ViewHolder(binding.root)

    private var onclicklistener:OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        var binding = ActivityMainBinding.inflate(LayoutInflater.from(conext),parent,false)
        return VH(binding)
    }

    private val differCallback = object : DiffUtil.ItemCallback<MenuItemData>(){
        override fun areItemsTheSame(oldItem: MenuItemData, newItem: MenuItemData): Boolean {
            return  oldItem.text == newItem.text
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: MenuItemData, newItem: MenuItemData): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

    }
    fun onclicklistener(){
        this.onclicklistener = onclicklistener
    }
}