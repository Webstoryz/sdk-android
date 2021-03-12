package com.webstoryz.sdk.sources.views

import android.graphics.BitmapFactory
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.webstoryz.sdk.sources.R
import com.webstoryz.sdk.sources.models.StoryModel
import java.net.URL
import kotlin.concurrent.thread


class ThumbnailRecyclerViewAdapter(
    private val values: List<StoryModel>, private val onClickListener: View.OnClickListener
) : RecyclerView.Adapter<ThumbnailRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_thumbnail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.thumbnailTitle.visibility = View.INVISIBLE
        holder.imageView.visibility = View.INVISIBLE
        thread {
            holder.thumbnailTitle.text = item.title
            val url = URL(item.thumbUrl)
            val bitmap = BitmapFactory.decodeStream(url.openStream())
            holder.imageView.setImageBitmap(bitmap)
            holder.thumbnailTitle.visibility = View.VISIBLE
            holder.imageView.visibility = View.VISIBLE

            holder.imageView.setOnClickListener(onClickListener)

            holder.thumbnailTitle.setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val thumbnailTitle: TextView = view.findViewById(R.id.thumbnailTitle)
        val imageView: ImageView = view.findViewById(R.id.thumbnail)

        override fun toString(): String {
            return super.toString() + " '" + thumbnailTitle.text + "'"
        }
    }
}