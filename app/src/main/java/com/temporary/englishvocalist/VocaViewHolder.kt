package com.temporary.englishvocalist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_vocas.view.*

class VocaViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    var view : View = v

    fun bind(item: Voca) {
        view.mEng.text = item.eng
        view.mKor.text = item.kor
    }
}