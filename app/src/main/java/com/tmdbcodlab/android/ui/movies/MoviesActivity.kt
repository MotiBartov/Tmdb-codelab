package com.tmdbcodlab.android.ui.movies

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.tmdbcodlab.android.MyApplication
import com.tmdbcodlab.android.R
import com.tmdbcodlab.android.io.Movie
import com.tmdbcodlab.android.ui.details.TmdbDetailsActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MoviesActivity : AppCompatActivity(),
        MoviesContract.View, MoviesAdapter.AdapterClickListener{



    companion object {
        val INTENT_EXTREA = "movie_id"
    }
    @Inject
    lateinit var presenter: MoviesContract.Presenter

    @Inject
    lateinit var adapter: MoviesAdapter


    override fun setLoadingIndicator(active: Boolean) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MyApplication).component.injectMovies(this)
        adapter.setAdapterListener(this)
        rvMovies.layoutManager = GridLayoutManager(this, 2)
        rvMovies.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
        presenter.loadMovies(true)
    }

    override fun showViewReady() {
        Toast.makeText(this, "View ready", Toast.LENGTH_LONG).show()
    }

    override fun showMovies(movies: List<Movie>) {
        adapter.updateMovies(movies)
    }

    override fun onItemClicked(id: Int?) {
        Timber.d("Movie: $id clicked")
        val intent = Intent(this, TmdbDetailsActivity::class.java)
        intent.putExtra(INTENT_EXTREA, id)
        startActivity(intent)
    }
}
