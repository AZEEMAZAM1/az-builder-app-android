package com.azbuilder.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.azbuilder.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupServices()
        setupBottomButtons()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "AZ Builder"
        supportActionBar?.subtitle = "Professional Construction Services"
    }

    private fun setupServices() {
        val services = listOf(
            Service("Plumbing", "Pipe repairs, installations, leak fixing, bathroom fitting", "\uD83D\uDD27", "#2196F3"),
            Service("Tiling", "Floor tiles, wall tiles, mosaic, kitchen & bathroom tiling", "\uD83E\uDDF1", "#4CAF50"),
            Service("Electrical", "Wiring, socket installation, lighting, fuse box repair", "\u26A1", "#FF9800"),
            Service("Painting", "Interior & exterior painting, decorating, wallpapering", "\uD83C\uDFA8", "#9C27B0"),
            Service("Roofing", "Roof repair, replacement, guttering, chimney work", "\uD83C\uDFE0", "#795548"),
            Service("Carpentry", "Doors, windows, wardrobes, shelving, decking", "\uD83E\uDE9A", "#607D8B"),
            Service("Plastering", "Wall plastering, rendering, skimming, artex removal", "\uD83C\uDFD7", "#F44336"),
            Service("Extensions", "Home extensions, loft conversions, garage conversions", "\uD83C\uDFD8", "#3F51B5"),
            Service("Landscaping", "Garden design, paving, fencing, drainage", "\uD83C\uDF33", "#8BC34A"),
            Service("General Repairs", "Handyman services, maintenance, emergency repairs", "\uD83D\uDD28", "#FF5722")
        )

        val adapter = ServiceAdapter(services) { service ->
            val intent = Intent(this, ServiceDetailActivity::class.java)
            intent.putExtra("service_name", service.name)
            intent.putExtra("service_description", service.description)
            intent.putExtra("service_icon", service.icon)
            intent.putExtra("service_color", service.color)
            startActivity(intent)
        }

        binding.servicesRecyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.servicesRecyclerView.adapter = adapter
    }

    private fun setupBottomButtons() {
        binding.btnBookNow.setOnClickListener {
            startActivity(Intent(this, BookingActivity::class.java))
        }
        binding.btnAbout.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
    }
}
