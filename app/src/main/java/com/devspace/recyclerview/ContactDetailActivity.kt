package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class ContactDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_detail)

        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvPhone = findViewById<TextView>(R.id.tv_phone)
        val tvCity = findViewById<TextView>(R.id.tv_city)
        val image = findViewById<ImageView>(R.id.image)
        val tvShare = findViewById<TextView>(R.id.tv_share_contact)
        val tvSend = findViewById<TextView>(R.id.tv_send_message)
        val tvBlock = findViewById<TextView>(R.id.tv_block_contact)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val city = intent.getStringExtra("city")
        val icon = intent.getIntExtra("icon", R.drawable.sample1)

        tvName.text = name
        tvPhone.text = phone
        tvCity.text = city
        image.setImageResource(icon)

        tvShare.setOnClickListener{
            //Intent implicita
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "$name $phone $city")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

        tvSend.setOnClickListener{
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_EMAIL, "$name $phone $city")
                type = "text/plan"
            }
            val messageIntent = Intent.createChooser(sendIntent, null)
            startActivity(messageIntent)
        }

        tvBlock.setOnClickListener{
            val blockIntent: Intent = Intent().apply {
                action = Intent.ACTION_PROFILE_REMOVED
                putExtra(Intent.ACTION_PROFILE_INACCESSIBLE, "$name $phone $city")
                type = "text/plain"
            }
            val removeContact = Intent.createChooser(blockIntent, null)
            startActivity(removeContact)
        }


    }
}
