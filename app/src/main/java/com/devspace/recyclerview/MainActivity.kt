package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)
        //muda orientação tela
        ivGrid.setOnClickListener{
            rvList.layoutManager = GridLayoutManager(this, 2)
        }
        //volta para orientação padrao
        ivList.setOnClickListener{
            rvList.layoutManager = LinearLayoutManager(this)
        }
        //acesso proxima tela
        adapter.setOnClickListener { contact ->
            val intent = Intent (this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("city", contact.city)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)

        }
    }


}

val contacts = listOf(

    Contact(
        "Fernanda",
        "(55) 61 996479834",
        "Canoas - RS",
        R.drawable.sample1
    ),
    Contact(
        "Joaquin",
        "(55) 11 917479831",
        "São Paulo - SP",
        R.drawable.sample2
    ),
    Contact(
        "Maria",
        "(55) 51 937379833",
        "Esteio - RS",
        R.drawable.sample3
    ),
    Contact(
        "Regina",
        "(55) 31 947479434",
        "Patos de Minas - MG",
        R.drawable.sample4
    ),
    Contact(
        "Simone",
        "(55) 32 987479834",
        "Contagem - MG",
        R.drawable.sample5
    ),
    Contact(
        "Isabel",
        "(55) 34 998489834",
        "Betim - MG",
        R.drawable.sample6
    ),
    Contact(
        "Joana",
        "(55) 47 911479811",
        "Florianópolis - SC",
        R.drawable.sample7
    ),
    Contact(
        "Vinicius",
        "(55) 21 922479824",
        "Rio de Janeiro - RJ",
        R.drawable.sample8
    ),
    Contact(
        "Anderson",
        "(55) 27 815479834",
        "Vitória - ES",
        R.drawable.sample9
    ),
    Contact(
        "Gustavo",
        "(55) 71 987479834",
        "BAHIA - BA",
        R.drawable.sample10
    ),
    Contact(
        "Verônica",
        "(55) 65 933479334",
        "Mato Grosso - MT",
        R.drawable.sample11
    ),
    Contact(
        "Caleb",
        "(55) 62 955475834",
        "Goiana - GO",
        R.drawable.sample12
    ),
    Contact(
        "Joana",
        "(55) 41 927472832",
        "Pouso Alegre - MG",
        R.drawable.sample13
    ),
    Contact(
        "Miguel",
        "(55) 51 987479834",
        "Porto Alegre - RS",
        R.drawable.sample14
    ),
    Contact(
        "Patricia",
        "(55) 51 968476834",
        "Gravataí - RS",
        R.drawable.sample15
    ),
    Contact(
        "Paola",
        "(55) 32 987479834",
        "Fortaleza - CE",
        R.drawable.sample16
    ),
)