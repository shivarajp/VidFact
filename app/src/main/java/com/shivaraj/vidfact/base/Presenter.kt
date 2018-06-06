package com.shivaraj.vidfact.base

/**
 * Created by H237872 on 6/6/2018.
 */
interface Presenter<in V : BaseView> {
    fun onAttachView(mvpView: V)
    fun onDetachView()
}