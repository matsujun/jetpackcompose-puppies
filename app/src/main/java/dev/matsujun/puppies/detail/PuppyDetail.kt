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
package dev.matsujun.puppies.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.skydoves.landscapist.glide.GlideImage
import dev.matsujun.puppies.R
import dev.matsujun.puppies.data.Puppy
import dev.matsujun.puppies.data.puppies
import dev.matsujun.puppies.ui.theme.PuppiesTheme

@Composable
fun DetailScreen(navController: NavController, puppyId: Int) {
    val puppy = puppies.find { it.id == puppyId } ?: puppies[0]
    PuppyDetail(puppy)
}

@Composable
fun PuppyDetail(puppy: Puppy) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        GlideImage(
            imageModel = puppy.imageUrl ?: "",
            contentScale = ContentScale.FillWidth,
            placeHolder = ImageBitmap.imageResource(R.drawable.loading),
            error = ImageBitmap.imageResource(R.drawable.no_image_square),
        )
        Spacer(Modifier.width(16.dp))

        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = puppy.name,
                style = MaterialTheme.typography.h4
            )
            Spacer(Modifier.width(16.dp))

            Text(
                text = "Birthday: ${puppy.birthDayText()}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Age: ${puppy.age()}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Owner: ${puppy.ownerName}",
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Preview
@Composable
fun PuppyDetailPreview() {
    PuppiesTheme {
        Surface(color = MaterialTheme.colors.background) {
            PuppyDetail(puppies[0])
        }
    }
}
