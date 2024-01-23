package com.example.mvvmapicall.Base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.mvvmapicall.network.models.NewsModel


abstract class BaseAdapter<T, VB : ViewBinding>(
    val itemClickListener: OnItemClickListener,
    private val context: Context,
    private val items: List<T>,
) : RecyclerView.Adapter<BaseViewHolder<T, VB>>() {

    abstract fun createBinding(inflater: LayoutInflater, parent: ViewGroup): VB

    abstract fun createViewHolder(binding: VB): BaseViewHolder<T, VB>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T, VB> {

        val inflater = LayoutInflater.from(context)
        val binding = createBinding(inflater, parent)
        return createViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T, VB>, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size


}

abstract class BaseViewHolder<T, VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: T)
}

interface OnItemClickListener {
    fun onItemClick(item:  NewsModel.Article)
}