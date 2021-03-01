package com.jlee.anddevcomposechallenge1

import androidx.annotation.DrawableRes
import com.jlee.anddevcomposechallenge1.R

data class PuppyDetail(
    val name: String,
    @DrawableRes val resId: Int,
    val age: String,
    val gender: String,
    val personality: String,
)

val PUPPY_LIST = listOf(
    PuppyDetail(
        "Fluffy",
        R.drawable.dog2,
        "5 months",
        "Male",
        "Rambunctious"
    ),
    PuppyDetail(
        "Sierra",
        R.drawable.dog1,
        "6 months",
        "Female",
        "Shy"
    ),
    PuppyDetail(
        "Clifford",
        R.drawable.dog3,
        "8 months",
        "Male",
        "Playful"
    ),
    PuppyDetail(
        "Airbud",
        R.drawable.dog4,
        "3 months",
        "Male",
        "Mellow"
    ),
    PuppyDetail(
        "Fido",
        R.drawable.dog5,
        "4 months",
        "Male",
        "Cuddly"
    ),
    PuppyDetail(
        "Theodore",
        R.drawable.dog6,
        "11 months",
        "Male",
        "Sensitive"
    ),
    PuppyDetail(
        "Margaret",
        R.drawable.dog7,
        "9 months",
        "Female",
        "Curious"
    ),
)
