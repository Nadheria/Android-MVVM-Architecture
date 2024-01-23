package com.example.mvvmapicall.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapicall.R
import com.example.mvvmapicall.UI.MainActivity
import com.example.mvvmapicall.network.models.NewsModel
import com.squareup.picasso.Picasso


class Adapter(private val mContext: Context, mData: ArrayList<NewsModel.Article>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    private val modal: NewsModel.Article? = null
    private val mData: ArrayList<NewsModel.Article>
    private val webView: WebView? = null

    init {
        this.mData = mData
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adapter.ViewHolder {
        val v: View
        val inflater = LayoutInflater.from(mContext)
        v = inflater.inflate(R.layout.categories, null, false)
        return Adapter.ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.title.setText(mData[position].title)
        holder.description.setText(mData[position].description)
        val nmodal: NewsModel.Article = mData[position]
        Picasso.get().load(nmodal.url).into(holder.urlToImage)
        holder.cardView.setOnClickListener(View.OnClickListener {
            val intent = Intent(mContext, MainActivity::class.java)
            intent.putExtra("url", mData[position].url)
            mContext.startActivities(arrayOf(intent))
        })
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var description: TextView
        var url: TextView? = null
        var content: TextView? = null
        var urlToImage: ImageView
        var cardView: CardView

        init {
            title = itemView.findViewById<TextView>(R.id.heading)
            description = itemView.findViewById<TextView>(R.id.subtitle)
            cardView = itemView.findViewById<CardView>(R.id.news_card)
            urlToImage = itemView.findViewById<ImageView>(R.id.news_poster)
        }
    }
}
