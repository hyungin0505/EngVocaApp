package com.temporary.englishvocalist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_voca.view.*

class VocaViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    var view : View = v

    fun bind(voca: Voca) {
        view.mEng.text = voca.eng
        view.mKor.text = voca.kor
    }
}