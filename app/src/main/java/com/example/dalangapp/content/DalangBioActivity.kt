package com.example.dalangapp.content

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dalangapp.MainActivity
import com.example.dalangapp.R
import com.example.dalangapp.adapter.DalangAdapter
import com.example.dalangapp.content.detail.DetailActivity
import com.example.dalangapp.databinding.ActivityDalangBioBinding
import com.example.dalangapp.retrofit.ApiConfig
import com.example.dalangapp.retrofit.responses.DalangResponse
import com.example.dalangapp.retrofit.responses.DataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DalangBioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDalangBioBinding
    private lateinit var adapter: DalangAdapter

    private lateinit var sharedPreferences: SharedPreferences
    private val listDalangItem = ArrayList<DataItem>()

    private var SHARED_PREF_NAME = "mypref"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDalangBioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE)

        listDalangItem.addAll(listDalangOffline)
//        setDalang()
        initRv()


        binding.btnBackToHome.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

    }

    private val listDalangOffline: ArrayList<DataItem>
        get() {
            val dalangId = resources.getIntArray(R.array.data_dalang_id)
            val dalangName = resources.getStringArray(R.array.data_dalang_name)
            val dalangBio = resources.getStringArray(R.array.data_dalang_description)
            val dalangImage = resources.obtainTypedArray(R.array.data_dalang_image)
            val dalangBorn = resources.getStringArray(R.array.data_dalang_born)
            val dataDalangOffline = ArrayList<DataItem>()
            for (i in dalangId.indices) {
                val dalang = DataItem(
                    dalangImage.getResourceId(i, -1),
                    "null",
                    dalangBorn[i],
                    dalangName[i],
                    dalangId[i],
                    dalangBio[i],
                    "null",
                    dalangImage.getResourceId(i, -1),
                    "null"
                )
                dataDalangOffline.add(dalang)
            }
            return dataDalangOffline
        }

    private fun initRv() {
        adapter = DalangAdapter()
        adapter.setList(listDalangItem)
        binding.apply {
            rvDalang.layoutManager = LinearLayoutManager(this@DalangBioActivity)
            rvDalang.setHasFixedSize(true)
            rvDalang.adapter = adapter

            adapter.setOnItemClickCallback(object : DalangAdapter.OnItemClickCallback {
                override fun onItemClicked(data: DataItem) {
                    Intent(this@DalangBioActivity, DetailActivity::class.java).also {
                        it.putExtra(DetailActivity.EXTRA_PHOTO, data.image)
                        it.putExtra(DetailActivity.EXTRA_NAME, data.name)
                        it.putExtra(DetailActivity.EXTRA_DESK, data.biography)
                        it.putExtra(
                            DetailActivity.EXTRA_DESK1,
                            "Asal/Tempat Lahir : " + data.origin
                        )
                        startActivity(it)
                    }
                }
            })
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}