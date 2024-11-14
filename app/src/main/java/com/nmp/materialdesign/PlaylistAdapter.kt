package com.nmp.materialdesign

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nmp.materialdesign.databinding.CardPlaylistBinding
import com.squareup.picasso.Picasso

class PlaylistAdapter(val playlists:ArrayList<Playlist>) :
    RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {
        class PlaylistViewHolder(val binding: CardPlaylistBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val binding = CardPlaylistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PlaylistViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return playlists.size
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val url = playlists[position].image_url
        val builder = Picasso.Builder(holder.itemView.context)
        builder.listener { picasso, uri, exception -> exception.printStackTrace() }
        Picasso.get().load(url).into(holder.binding.imgPlaylist)

        with(holder.binding) {
            txtTitle.text = playlists[position].title
            txtSubtitle.text = playlists[position].subtitle
            txtDescription.text = playlists[position].description
            btnLikes.text = playlists[position].num_likes.toString()
        }

    }
}