package com.temporary.englishvocalist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class VocaListAdapter(private val vocaList : List<Voca>) : RecyclerView.Adapter<VocaViewHolder>() {
    override fun getItemCount(): Int {
        return vocaList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocaViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_voca, parent,false)
        return VocaViewHolder(inflatedView);
    }

    override fun onBindViewHolder(holder: VocaViewHolder, position: Int) {
        val voca = vocaList[position]
        holder.itemView.setOnClickListener {
            vocaClickListener.onClick(it, position)
        }
        holder.apply {
            bind(voca)
        }
    }

    interface OnVocaClickListener {
        fun onClick(v:View, position: Int)
    }
    private lateinit var vocaClickListener : OnVocaClickListener

    fun setVocaClickListener(vocaClickListener: OnVocaClickListener) {
        this.vocaClickListener = vocaClickListener
    }
}