package com.tmdbcodlab.android.io

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by motibartov on 20/12/2017.
 */
@Entity(tableName = "movies")
data class Movie(@SerializedName("poster_path") @Expose var posterPath: String? = null,
                 @SerializedName("overview") @Expose var overview: String? = null,
                 @SerializedName("release_date") @Expose var releaseDate: String? = null,
                 @PrimaryKey(autoGenerate = false) @SerializedName("id") @Expose var id: Int? = null,
                 @SerializedName("original_title") @Expose var originalTitle: String? = null,
                 @SerializedName("original_language") @Expose var originalLanguage: String? = null,
                 @SerializedName("title") @Expose var title: String? = null,
                 @SerializedName("backdrop_path") @Expose var backdropPath: String? = null,
                 @SerializedName("popularity") @Expose var popularity: Double? = null,
                 @SerializedName("vote_count") @Expose var voteCount: Int? = null,
                 @SerializedName("video") @Expose var video: Boolean? = null,
                 @SerializedName("vote_average") @Expose var voteAverage: Double? = null)