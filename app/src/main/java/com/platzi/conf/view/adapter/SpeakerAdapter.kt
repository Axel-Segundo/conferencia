package com.platzi.conf.view.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.platzi.conf.R
import com.platzi.conf.model.Conferences
import com.platzi.conf.model.Speaker
import javax.swing.text.View
import kotlin.collections.ArrayList

class SpeakerAdapter (val SpeakerListener: SpeakerListener) : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {
    var listSpeaker = ArrayList<List<Speaker>>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_speaker, parent, attachToRoot false))

    override fun getItemCount() = listSpeaker.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Speaker = listSpeaker[position]
        holder.tvSpeakerName.text=speaker.name
        holder.tvSpeakerWork.text=speaker.workplace

        Glide.with(holder.itemView.context)
            .load(Speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.tvSpeakerImage)

        holder.itemView.setOnClickListener { View:
            SpeakerListener.onSpeakerClicked(Speaker , position)
        }

    }

    fun updateData(data: List<Conferences>){
        listSpeaker.clear()
        listSpeaker.addAll(data)
        notifyDataSetChanged()

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSpeakerName = itemView.findViewById<TextView>(R.id.tvItemSpeakerName)
        val tvSpeakerWork = itemView.findViewById<TextView>(R.id.tvItemSpeakerWork)
        val tvSpeakerImage = itemView.findViewById<TextView>(R.id.tvItemSpeakerImage)
    }
}