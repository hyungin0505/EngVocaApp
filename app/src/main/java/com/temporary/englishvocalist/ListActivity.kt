package com.temporary.englishvocalist

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_list.*
import java.util.*

class ListActivity : Activity() {

    val TAG = "ListActivity"
    var db: AppDatabase? = null
    var vocaList = mutableListOf<Voca>(
        Voca("english1", "korean1"),
        Voca("english2", "korean2"),
        Voca("english3", "korean3"),
        Voca("english4", "korean4"),
        Voca("english5", "korean5"),
        Voca("english6", "korean6"),
        Voca("english7", "korean7"),
        Voca("english8", "korean8"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        db = AppDatabase.getInstance(this)

        val savedVoca = db!!.VocaDao().getAll()
        if (savedVoca.isNotEmpty()) {
            vocaList.addAll(savedVoca)
        }

        val adapter = VocaListAdapter(vocaList)
        adapter.setItemClickListener(object : VocaListAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {

                val voca = vocaList[position]

                db?.VocaDao()?.delete(voca = voca)
                vocaList.removeAt(position)
                adapter.notifyDataSetChanged()

                Log.d(TAG, "remove item($position). name:${voca.eng}")
            }
        })
        mRecyclerView.adapter = adapter

        mPlusButton.setOnClickListener {
            val random = Random()
            val numA = random.nextInt(1000)
            val numB = random.nextInt(10000)
            val numC = random.nextInt(10000)
            val rndNumber = String.format("%03d-%04d-%04d", numA, numB, numC)

            val voca = Voca(0, "New $numA", rndNumber) //Contacts 생성
            db?.VocaDao()?.insertAll(voca) //DB에 추가
            vocaList.add(voca) //리스트 추가

            adapter.notifyDataSetChanged() //리스트뷰 갱신
        }
    }
}

























