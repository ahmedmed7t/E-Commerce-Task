package com.example.e_commercetask.app

import android.app.Activity
import android.view.View
import android.widget.EditText
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.example.e_commercetask.R
import com.google.android.material.snackbar.Snackbar

// View extensions
fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

// EditText extensions

fun EditText.hideError(){
    this.background = ContextCompat.getDrawable(context, R.drawable.edit_text_background)
}

fun EditText.showError(){
    this.background = ContextCompat.getDrawable(context, R.drawable.error_edit_text_background)
}

// Activity extensions
fun Activity.showErrorToast(text: String) {
    val parent: View = findViewById(android.R.id.content)
    val snackBar: Snackbar = Snackbar.make(parent, text, Snackbar.LENGTH_LONG)
    snackBar.view.background = AppCompatResources.getDrawable(this, R.drawable.error_toast_background)
    snackBar.show()
}

// String extensions
fun String.toOriginalImage(): String {
    return "https://image.tmdb.org/t/p/original$this"
}

fun String.toW500Image(): String {
    return "https://image.tmdb.org/t/p/w500$this"
}