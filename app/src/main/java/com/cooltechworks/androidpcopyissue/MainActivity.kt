package com.cooltechworks.androidpcopyissue

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private val BASE_HTML = "<HTML><HEAD></HEAD><body>%s</body></HTML>"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initEditText()
        initWebview()

    }

    fun initEditText() {

        edittext.isLongClickable = false
        edittext.setTextIsSelectable(false)

        edittext.customSelectionActionModeCallback = object : ActionMode.Callback {
            override fun onDestroyActionMode(p0: ActionMode?) {}

            override fun onCreateActionMode(p0: ActionMode?, p1: Menu?): Boolean {
                return false
            }

            override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
                return false
            }

            override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
                return false
            }
        }
    }


    fun initWebview() {

        val data = resources.getString(R.string.lorem_ipsum)


        webview.setOnLongClickListener { v -> true }

        webview.isHapticFeedbackEnabled = false
        webview.isFocusable = false
        webview.isFocusableInTouchMode = false

        val html = String.format(Locale.getDefault(), BASE_HTML, data)
        webview.loadDataWithBaseURL("file:///android_asset/", html, "text/html", "utf-8", null)
2    }
}
