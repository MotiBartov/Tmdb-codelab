package com.tmdbcodlab.android.ui

import android.support.v7.app.AppCompatActivity
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    val nums = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9 ,10)
    val bignums = listOf(100, 200, 300, 400, 500, 600)

    val l2 : List<Int> = emptyArray<Int>().toList()

    val f = Flowable.just(bignums)
    val f1 = Flowable.just(nums)
            .flatMap { it -> Flowable.fromIterable(it) }.filter { it -> it>10 }
            .toList()
            .toFlowable().filter { l -> !l.isEmpty() }
            .switchIfEmpty(f)

    override fun onResume() {
        super.onResume()

        f1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{i -> Timber.d("f1 onNext: $i")}



    }
}
