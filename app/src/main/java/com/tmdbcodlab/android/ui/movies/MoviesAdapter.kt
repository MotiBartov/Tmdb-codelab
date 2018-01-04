package com.tmdbcodlab.android.ui.movies

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.tmdbcodlab.android.R
import com.tmdbcodlab.android.api.ApiModule
import com.tmdbcodlab.android.api.ApiModule.Companion.IMAGES_URL
import com.tmdbcodlab.android.io.Movie
import kotlinx.android.synthetic.main.movie_list_item.view.*
import timber.log.Timber
import java.net.URI

/**
 * Created by motibartov on 24/12/2017.
 */
class MoviesAdapter() : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    var movies = ArrayList<Movie>()

    var adapterClickListener: AdapterClickListener? = null


    fun setAdapterListener(listener: AdapterClickListener){
        adapterClickListener = listener
    }

    override fun onBindViewHolder(holder: MoviesViewHolder?, position: Int) {
        holder?.bind(movies[position].posterPath)
        holder?.view?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                adapterClickListener?.onItemClicked(movies[position].id)
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(movies.isEmpty()){
            return 0
        }else{
            return movies.size
        }
    }

    fun updateMovies(movies : List<Movie>){
        if(!this.movies.isEmpty()){
            this.movies.clear()
        }
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    class MoviesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(imageUrl: String?){
            Glide.with(view.context).load(IMAGES_URL + imageUrl).into(view.ivMovieImage)
        }
    }

    interface AdapterClickListener{
        fun onItemClicked(id: Int?)
    }
}