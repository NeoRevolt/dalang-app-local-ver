package com.example.dalangapp.content.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.dalangapp.MainActivity
import com.example.dalangapp.R
import com.example.dalangapp.databinding.ActivityWayangDetailBinding

class WayangDetailActivity : AppCompatActivity() {


    // COMMENT A

    private lateinit var binding: ActivityWayangDetailBinding

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
        setWayangOffline()
    }

    private fun setWayangOffline() {
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
}