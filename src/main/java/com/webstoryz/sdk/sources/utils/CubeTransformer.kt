package com.webstoryz.sdk.sources.utils

import android.view.View
import androidx.viewpager.widget.ViewPager

class CubeTransformer : ViewPager.PageTransformer {
    override fun transformPage(view: View, position: Float) {
        val deltaY = 0.5F

        view.pivotX = if (position < 0F) view.width.toFloat() else 0F
        view.pivotY = view.height * deltaY
        view.rotationY = 45F * position
    }
}