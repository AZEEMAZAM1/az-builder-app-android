package com.azbuilder.app

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ServiceAdapter(
    private val services: List<Service>,
    private val onItemClick: (Service) -> Unit
) : RecyclerView.Adapter<ServiceAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView: CardView = view.findViewById(R.id.serviceCard)
        val iconText: TextView = view.findViewById(R.id.serviceIcon)
        val nameText: TextView = view.findViewById(R.id.serviceName)
        val descText: TextView = view.findViewById(R.id.serviceDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_service, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val service = services[position]
        holder.iconText.text = service.icon
        holder.nameText.text = service.name
        holder.descText.text = service.description
        holder.cardView.setCardBackgroundColor(Color.parseColor(service.color))
        holder.cardView.setOnClickListener { onItemClick(service) }
    }

    override fun getItemCount() = services.size
}
