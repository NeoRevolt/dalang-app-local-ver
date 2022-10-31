package com.example.dalangapp.content.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.dalangapp.MainActivity
import com.example.dalangapp.R
import com.example.dalangapp.databinding.ActivityWayangDetailBinding
import com.example.dalangapp.retrofit.responses.WayangData

class WayangDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWayangDetailBinding
    val listWayangItems = ArrayList<WayangData>()

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWayangDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnBackToHome.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

//        listWayangItems.addAll(listWayangOffline)
        setWayangOffline()
    }

    private val listWayangOffline: ArrayList<WayangData>
        get() {
            val wayangId = resources.getIntArray(R.array.data_wayang_id)
            val wayangName = resources.getStringArray(R.array.data_wayang_name)
            val wayangImage = resources.getStringArray(R.array.data_wayang_image)
            val wayangDesk = resources.getStringArray(R.array.data_wayang_description)
            val wayangOrigin = resources.getStringArray(R.array.data_wayang_origin)
            val wayangSource = resources.getStringArray(R.array.data_wayang_source)
            val listWayang = ArrayList<WayangData>()
            for (i in wayangId.indices) {
                val wayang = WayangData(
                    wayangImage[i],
                    "null",
                    wayangOrigin[i],
                    wayangName[i],
                    wayangDesk[i],
                    wayangId[i],
                    wayangSource[i],
                    "null",
                    "null"
                )
                listWayang.add(wayang)
            }
            return listWayang
        }

    private fun setWayangOffline() {
        val wayangId = resources.getIntArray(R.array.data_wayang_id)
        val wayangName = resources.getStringArray(R.array.data_wayang_name)
        val wayangImage = resources.obtainTypedArray(R.array.data_wayang_image)
        val wayangDesk = resources.getStringArray(R.array.data_wayang_description)
        val wayangOrigin = resources.getStringArray(R.array.data_wayang_origin)
        val wayangSource = resources.getStringArray(R.array.data_wayang_source)

        val id = intent.getIntExtra(EXTRA_ID, 1) - 1
        setData(
            wayangName[id],
            wayangDesk[id],
            wayangOrigin[id],
            wayangSource[id],
            wayangImage.getResourceId(id, -1)
        )
    }

    private fun setData(
        name: String,
        description: String,
        origin: String,
        source: String,
        url: Int
    ) {
        Glide.with(this)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .fitCenter()
            .into(binding.ivDetail)
        binding.ivDetail.setImageResource(url)
        binding.tvJudulDetail.text = name
        binding.tvDeskripsiDetail.text = description
        binding.tvOtherInfoDesc1.text = "Asal : $origin"
        binding.tvOtherInfoDesc2.text = "Sumber : $source"
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}