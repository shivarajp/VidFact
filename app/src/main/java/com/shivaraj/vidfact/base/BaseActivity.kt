package com.shivaraj.vidfact.base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.shivaraj.vidfact.R

abstract class BaseActivity<P : Presenter<*>> : AppCompatActivity() {

    lateinit var presenter: P

    protected abstract val layout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    protected abstract fun initView()

    protected abstract fun inject()

}
