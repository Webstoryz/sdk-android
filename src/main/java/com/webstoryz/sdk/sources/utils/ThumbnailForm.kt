package com.webstoryz.sdk.sources.utils

import android.graphics.Color
import java.lang.Exception

enum class ThumbnailForm {
    square,
    circle,
    rectangle,
    polygon;

    private var _angles: Int = 0;

    var angles: Int
        get() {
            return when (this) {
                polygon -> {
                    this._angles
                }
                else -> 0
            }
        }
        set(value) {
            when (this) {
                polygon -> _angles = value

                else -> throw Exception("Cannot set angles of defined construction")
            }
        }

    val captionColor: Int
        get() {
            return when (this) {
                polygon, circle -> Color.BLACK
                else -> Color.WHITE
            }
        }

    val captionInside: Boolean
        get() {
            return when (this) {
                polygon, circle -> false
                else -> true
            }
        }

    companion object {
        fun getThumbForm(form:String): ThumbnailForm {
            val definedForm =  when (form) {
                "circle" -> circle
                "polygon" -> polygon
                "rectangle" -> rectangle
                "square" -> square
                else -> circle
            }
            if (definedForm == polygon) {
                definedForm.angles = 12
            }
            return definedForm
        }
    }
}



