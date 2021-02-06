package com.kei.recipeapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe (
    var name: String,
    var description: String,
    var Ingredients: String,
    var steps: String,
    var rating: Int,
    var photo: String

): Parcelable