package com.tikalk.mobileevent.mobileevent

interface BasePresenter {

    fun attach(view: BaseView)

    fun detach()

}