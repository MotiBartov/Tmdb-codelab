package com.tikalk.mobileevent.mobileevent

interface BasePresenter {

    fun subscribe(view: BaseView)

    fun unsubscribe()

}