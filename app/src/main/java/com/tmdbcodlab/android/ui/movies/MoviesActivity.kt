package com.tmdbcodlab.android.ui.movies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.tmdbcodlab.android.MyApplication
import com.tmdbcodlab.android.R
import com.tmdbcodlab.android.io.Movie
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MoviesActivity : AppCompatActivity(), MoviesContract.View{


    companion object {
        val TAG = "TAG_MoviesActivity"
    }
    @Inject
    lateinit var presenter: MoviesContract.Presenter

    @Inject
    lateinit var adapter: MoviesAdapter


    override fun setLoadingIndicator(active: Boolean) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate:")
        setContentView(R.layout.activity_main)
        (application as MyApplication).component.injectMovies(this)
        rvMovies.layoutManager = LinearLayoutManager(this)
        rvMovies.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
        presenter.loadMovies(true)
    }

    override fun showViewReady() {
        Toast.makeText(this, "View ready", Toast.LENGTH_LONG).show()
    }

    override fun showMovies(movies: List<Movie>) {
        adapter.updateMovies(movies)
    }
}
