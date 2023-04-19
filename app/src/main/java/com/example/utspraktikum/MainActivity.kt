package com.example.utspraktikum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var courseList = ArrayList<MainData>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        courseList.addAll(getDataMahasiswa())
        recyclerView = findViewById<RecyclerView>(R.id.idRV)
        recyclerView.layoutManager = LinearLayoutManager(this)

//        recyclerView.layoutManager = GridLayoutManager(this, 2)
//        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MainAdaptor(courseList)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_list -> {
            // do something when the first option is selected
            if (recyclerView.layoutManager is GridLayoutManager) {
                recyclerView.layoutManager = LinearLayoutManager(this)
            }
            true
        }
            R.id.action_grid -> {
            // do something when the second option is selected
            recyclerView.layoutManager = GridLayoutManager(this, 2)
            true
        }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getDataMahasiswa(): ArrayList<MainData> {

        val datanama = resources.getStringArray(R.array.itemNama)
        val dataNim = resources.getStringArray(R.array.itemNim)
        val dataUsia = resources.getStringArray(R.array.itemUsia)
        val dataImg = resources.getStringArray(R.array.itemImg)
        val listData = ArrayList<MainData>()

        for (i in 0 until datanama.size) {
            val imageResId = resources.getIdentifier(dataImg[i].toLowerCase(), "drawable",  packageName)
            listData.add(MainData(datanama[i], dataNim[i], dataUsia[i], imageResId))
        }

        return listData

    }
}