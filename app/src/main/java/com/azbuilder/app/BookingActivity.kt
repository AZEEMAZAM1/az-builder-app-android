package com.azbuilder.app

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.azbuilder.app.databinding.ActivityBookingBinding

class BookingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Book a Service"

        val services = arrayOf("Plumbing", "Tiling", "Electrical", "Painting", "Roofing", "Carpentry", "Plastering", "Extensions", "Landscaping", "General Repairs")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, services)
        binding.spinnerService.adapter = adapter

        val selectedService = intent.getStringExtra("selected_service")
        if (selectedService != null) {
            val index = services.indexOf(selectedService)
            if (index >= 0) binding.spinnerService.setSelection(index)
        }

        binding.btnSubmitBooking.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val phone = binding.etPhone.text.toString().trim()
            val address = binding.etAddress.text.toString().trim()
            val details = binding.etDetails.text.toString().trim()

            if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Booking submitted! We will contact you shortly.", Toast.LENGTH_LONG).show()
            finish()
        }

        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}
