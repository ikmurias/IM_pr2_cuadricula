package com.example.im_pr2_cuadricula

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val numCursos: Int,
    @DrawableRes val imageResouceID: Int
)
