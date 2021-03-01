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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.jlee.anddevcomposechallenge1.ui.theme.MyTheme
import com.jlee.anddevcomposechallenge1.ui.theme.shapes

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "puppyList") {
        composable("puppyList") { PuppyListHome(navController) }
        composable(
            "puppyDetail/{puppyId}",
            arguments = listOf(navArgument("puppyId") { type = NavType.IntType })
        ) { backStackEntry ->
            PuppyDetailHome(navController, backStackEntry.arguments?.getInt("puppyId"))
        }
    }
}

@Composable
fun PuppyListHome(navController: NavController) {
    Surface(
        color = MaterialTheme.colors.background,
    ) {
        PuppyList(navController, PUPPY_LIST)
    }
}

@Composable
fun PuppyList(navController: NavController, puppyList: List<PuppyDetail>) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 0.dp)
    ) {
        Text(
            text = "Pup-Me-Up",
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Do you need a pup-me-up? Check out these adorable puppies up for adoption!",
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            itemsIndexed(puppyList) { index, detail ->
                PuppyContent(navController, puppyDetail = detail, index)
            }
        }
    }
}

@Composable
fun PuppyContent(navController: NavController, puppyDetail: PuppyDetail, puppyId: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingValues(horizontal = 16.dp, vertical = 4.dp))
            .background(
                color = Color(0xFFFFFFFF),
                shape = shapes.medium
            )
            .clickable { navController.navigate("puppyDetail/$puppyId") }
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = puppyDetail.resId),
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = puppyDetail.name,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun PuppyDetailHome(navController: NavController, puppyDetailId: Int?) {
    if (puppyDetailId == null) {
        navController.navigateUp()
        return
    } else {
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier
                .padding(PaddingValues(horizontal = 16.dp, vertical = 16.dp))
        ) {
            PuppyDetailView(PUPPY_LIST[puppyDetailId])
        }
    }
}

@Composable
fun PuppyDetailView(puppyDetail: PuppyDetail) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(PaddingValues(horizontal = 16.dp, vertical = 16.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(.5f))
        Text(
            text = puppyDetail.name,
            style = MaterialTheme.typography.h2,
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = puppyDetail.resId),
            contentDescription = null,
            modifier = Modifier
                .height(350.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 0.dp)
                .background(color = Color(0xFFFFFFFF), shape = shapes.medium)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Gender: ${puppyDetail.gender}",
            style = MaterialTheme.typography.body1,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Age: ${puppyDetail.age}",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Personality: ${puppyDetail.personality}",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
