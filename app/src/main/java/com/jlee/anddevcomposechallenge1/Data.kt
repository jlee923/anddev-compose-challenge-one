/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jlee.anddevcomposechallenge1

import androidx.annotation.DrawableRes

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
