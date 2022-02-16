package com.temporary.englishvocalist

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : Activity() {

    val vocaList : List<Voca> = listOf(
        Voca("english1", "korean1"),
        Voca("english2", "korean2"),
        Voca("english3", "korean3"),
        Voca("english4", "korean4"),

        ).shuffled()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val adapter = VocaListAdapter(vocaList)
        adapter.setVocaClickListener(object: VocaListAdapter.OnVocaClickListener {
            override fun onClick(v: View, position: Int) {
                val voca = vocaList[position]

                Toast.makeText(v.context, "Activity\n${voca.eng}\n${voca.kor}", Toast.LENGTH_SHORT).show()
                voca.eng = voca.eng + "1"
                adapter.notifyDataSetChanged()
            }
        })
        mRecyclerView.adapter = adapter
    }
}