package com.choirunnisa.mypsilat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.content.view.*

class ContentTeknikAdapter(private val contentItem: List<ContentItem>) :
    RecyclerView.Adapter<ContentTeknikAdapter.ContentItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentItemViewHolder {
        return ContentItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.content,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ContentItemViewHolder, position: Int) {
        holder.bind(contentItem[position])
    }

    override fun getItemCount(): Int {
        return contentItem.size
    }


    inner class ContentItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageContent = view.imageContent
        private val txtnumberArrange = view.numberArrange
        private val imageContent2 = view.imageContent2
        private val txtcontentDescription = view.contentDescriptions

        fun bind(contentItem: ContentItem) {
            imageContent.setImageResource(contentItem.imageContent)

            if (contentItem.imageContent2 == null) {
                imageContent2.visibility = View.GONE
            }  else imageContent2.setImageResource(contentItem.imageContent2)

            txtnumberArrange.text = contentItem.numberArrange
            txtcontentDescription.text = contentItem.description
        }
    }
}