package com.tmdbcodlab.android.io

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by motibartov on 20/12/2017.
 */
data class ApiResponse(@SerializedName("page") @Expose var par: Int? = null,
                       @SerializedName("results") @Expose var results : List<Movie>? = null,
                       @SerializedName("total_results") @Expose var totalResults: Int? = null,
                       @SerializedName("total_pages") @Expose var totalPages: Int? = null){
}
