package com.shivaraj.vidfact.base

import io.reactivex.disposables.CompositeDisposable

/**
 * Base class that implements Presenter and implement onAttach & detach methods.
 * It keeps a reference, get it by calling getView().
 */
open class BasePresenter<T : BaseView> : Presenter<T> {

    var view: T? = null
        private set

    val compositeDesposable = CompositeDisposable()

    private val isViewAttached: Boolean
        get() = view != null

    override fun onAttachView(mvpView: T) {
        view = mvpView
    }

    override fun onDetachView() {
        view = null
        if (!compositeDesposable.isDisposed) {
            compositeDesposable.clear()
        }
    }

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }

    private class MvpViewNotAttachedException internal constructor() : RuntimeException("Attach view")

}