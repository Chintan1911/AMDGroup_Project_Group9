package com.example.jobfinder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
//this file was created by me(Abhishek)
class CandidateAdapter (options: FirebaseRecyclerOptions<Candidate>) :
    FirebaseRecyclerAdapter<Candidate, CandidateAdapter.CandidateHolder>(options) {

    class CandidateHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(
        inflater.inflate(R.layout.row_candidate, parent, false)
    ) {
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        val image: ImageView = itemView.findViewById(R.id.imgPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandidateHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CandidateHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CandidateHolder, position: Int, model: Candidate) {
        if (model.photoUrl.isNotEmpty()) {
            val storRef: StorageReference = FirebaseStorage.getInstance().getReferenceFromUrl(model.photoUrl)
            Glide.with(holder.image.context).load(storRef).into(holder.image)
        } else {
            // Handle the case where photoUrl is null or empty
            // For example, load a placeholder image or set a default image
            holder.image.setImageResource(R.drawable.logo)
        }

        holder.txtName.text = model.name
        holder.txtTitle.text = model.title
        // Set background based on position (odd/even)

        // Set background based on position (odd/even)
        if (position % 2 == 0) {
            // Even position
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.evenBackground
                )
            )
        } else {
            // Odd position
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.oddBackground
                )
            )
        }
        holder.itemView.setOnClickListener {
            // Handle item click if needed
        }
    }

}