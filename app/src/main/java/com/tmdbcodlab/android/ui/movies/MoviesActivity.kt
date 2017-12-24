package com.tmdbcodlab.android.ui.movies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tmdbcodlab.android.MyApplication
import com.tmdbcodlab.android.R
import javax.inject.Inject

class MoviesActivity : AppCompatActivity(), MoviesContract.View{

    companion object {
        val TAG = "TAG_MoviesActivity"
    }
    @Inject
    lateinit var presenter: MoviesContract.Presenter

    override fun setLoadingIndicator(active: Boolean) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate:")
        setContentView(R.layout.activity_main)
        (application as MyApplication).component.injectMovies(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
        presenter.loadMovies(true)
    }

    override fun showViewReady() {
        Toast.makeText(this, "View ready", Toast.LENGTH_LONG).show()
    }
}
