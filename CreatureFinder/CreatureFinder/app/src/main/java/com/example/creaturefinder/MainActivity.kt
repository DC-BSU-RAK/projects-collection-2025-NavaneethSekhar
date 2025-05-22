package com.example.creaturefinder

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerContinent: Spinner
    private lateinit var spinnerRegion: Spinner
    private lateinit var btnFindCreatures: Button
    private lateinit var textCreatures: TextView

    private val data = mapOf(
        "Africa" to mapOf(
            "Savanna" to listOf("Lion", "Elephant", "Giraffe"),
            "Rainforest" to listOf("Gorilla", "Okapi", "Leopard")
        ),
        "Asia" to mapOf(
            "Desert" to listOf("Camel", "Sand Cat"),
            "Jungle" to listOf("Tiger", "Orangutan", "Python")
        ),
        "North America" to mapOf(
            "Mountains" to listOf("Mountain Lion", "Bighorn Sheep"),
            "Forest" to listOf("Bear", "Raccoon", "Deer")
        ),
        "South America" to mapOf(
            "Rainforest" to listOf("Jaguar", "Sloth", "Macaw"),
            "Andes" to listOf("Llama", "Spectacled Bear")
        ),
        "Europe" to mapOf(
            "Forest" to listOf("Red Fox", "Eurasian Lynx", "Brown Bear"),
            "Alps" to listOf("Chamois", "Ibex", "Marmot")
        ),
        "Australia" to mapOf(
            "Outback" to listOf("Kangaroo", "Emu", "Dingo"),
            "Coastal" to listOf("Koala", "Platypus", "Cassowary")
        ),
        "Antarctica" to mapOf(
            "Ice Shelf" to listOf("Penguin", "Seal", "Krill")
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CreatureFinder) // Apply the custom theme
        setContentView(R.layout.activity_main)

        spinnerContinent = findViewById(R.id.spinnerContinent)
        spinnerRegion = findViewById(R.id.spinnerRegion)
        btnFindCreatures = findViewById(R.id.btnFindCreatures)
        textCreatures = findViewById(R.id.textCreatures)

        val continents = data.keys.toList()
        spinnerContinent.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, continents)

        spinnerContinent.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                val selectedContinent = continents[position]
                val regions = data[selectedContinent]?.keys?.toList() ?: emptyList()
                spinnerRegion.adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, regions)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        btnFindCreatures.setOnClickListener {
            val continent = spinnerContinent.selectedItem?.toString()
            val region = spinnerRegion.selectedItem?.toString()

            val creatures = data[continent]?.get(region)

            if (creatures != null) {
                textCreatures.text = "Creatures in $region ($continent):\n\n${creatures.joinToString("\n")}"
            } else {
                textCreatures.text = "No data available for that selection."
            }
        }

        // 🎉 Welcome popup message
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Welcome to Creature Finder!")
        builder.setMessage("Here you can choose a continent and a region to discover what creatures live there.")
        builder.setPositiveButton("Got it!") { dialog, _ -> dialog.dismiss() }
        builder.setCancelable(false)
        builder.show()
    }
}
