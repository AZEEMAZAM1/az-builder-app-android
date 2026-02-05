package com.azbuilder.app

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.azbuilder.app.databinding.ActivityServiceDetailBinding

class ServiceDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityServiceDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("service_name") ?: "Service"
        val description = intent.getStringExtra("service_description") ?: ""
        val icon = intent.getStringExtra("service_icon") ?: ""
        val color = intent.getStringExtra("service_color") ?: "#2196F3"

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = name

        binding.serviceIcon.text = icon
        binding.serviceName.text = name
        binding.serviceDescription.text = description
        binding.headerCard.setCardBackgroundColor(Color.parseColor(color))

        binding.serviceFeatures.text = getFeatures(name)

        binding.btnBookService.setOnClickListener {
            val intent = Intent(this, BookingActivity::class.java)
            intent.putExtra("selected_service", name)
            startActivity(intent)
        }

        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun getFeatures(serviceName: String): String {
        return when (serviceName) {
            "Plumbing" -> "- Emergency leak repairs\n- Bathroom installation\n- Boiler servicing\n- Pipe replacement\n- Drain unblocking\n- Radiator fitting\n- Water tank installation"
            "Tiling" -> "- Kitchen backsplash\n- Bathroom floor & wall tiling\n- Mosaic patterns\n- Underfloor heating compatible\n- Waterproof tiling\n- Tile repair & replacement\n- Natural stone tiling"
            "Electrical" -> "- Full house rewiring\n- Socket & switch installation\n- LED lighting setup\n- Fuse box upgrades\n- Safety inspections\n- Smart home wiring\n- Outdoor lighting"
            "Painting" -> "- Interior painting\n- Exterior painting\n- Wallpaper hanging\n- Feature walls\n- Ceiling painting\n- Wood staining\n- Spray painting"
            "Roofing" -> "- Flat roof repair\n- Pitched roof work\n- Gutter cleaning & repair\n- Chimney repointing\n- Roof insulation\n- Skylight installation\n- Emergency repairs"
            "Carpentry" -> "- Bespoke wardrobes\n- Kitchen fitting\n- Door hanging\n- Staircase construction\n- Decking installation\n- Shelving & storage\n- Window frames"
            "Plastering" -> "- Skim coating\n- Dry lining\n- Rendering\n- Artex removal\n- Coving installation\n- Ceiling repair\n- Damp proofing plaster"
            "Extensions" -> "- Single storey extensions\n- Double storey extensions\n- Loft conversions\n- Garage conversions\n- Basement conversions\n- Orangeries\n- Planning permission help"
            "Landscaping" -> "- Garden design\n- Block paving\n- Fencing & gates\n- Artificial grass\n- Decking\n- Drainage solutions\n- Retaining walls"
            else -> "- Professional service\n- Free quotation\n- Fully insured\n- Experienced team\n- Quality materials\n- Competitive pricing\n- Customer satisfaction guaranteed"
        }
    }
}
