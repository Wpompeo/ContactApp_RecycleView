package com.devspace.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

    }
}

val contacts = listOf(


    Contact(
        "Gabriel",
        "(51) 61 996479834",
        "Canoas - RS",
        R.drawable.sample1
    ),

    Contact(
        "Joaquin",
        "(51) 11 917479831",
        "São Paulo - SP",
        R.drawable.sample2
    ),

    Contact(
        "Maria",
        "(51) 51 937379833",
        "Esteio - RS",
        R.drawable.sample3
    ),

    Contact(
        "Regina",
        "(51) 31 947479434",
        "Patos de Minas",
        R.drawable.sample4
    ),

    Contact(
        "Simone",
        "(51) 32 987479834",
        "Contagem - MG",
        R.drawable.sample5
    ),

    Contact(
        "Isabel",
        "(51) 34 998489834",
        "Betim - MG",
        R.drawable.sample6
    ),
    Contact(
        "Joana",
        "(51) 47 911479811",
        "Florianópolis - SC",
        R.drawable.sample7
    ),
    Contact(
        "Vinicius",
        "(54) 21 922479824",
        "Rio de Janeiro - RJ",
        R.drawable.sample8
    ),
    Contact(
        "Anderson",
        "(51) 27 815479834",
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
        "João",
        "(31) 41 927472832",
        "Pouso Alegre - MG",
        R.drawable.sample13
    ),
    Contact(
        "Miguel",
        "(51) 51 987479834",
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