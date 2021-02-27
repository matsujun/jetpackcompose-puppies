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
package dev.matsujun.puppies.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.skydoves.landscapist.glide.GlideImage
import dev.matsujun.puppies.R
import dev.matsujun.puppies.data.Puppy
import dev.matsujun.puppies.data.puppies
import dev.matsujun.puppies.ui.theme.PuppiesTheme

@Composable
fun ListScreen(navController: NavController) {
    PuppyList(
        puppies = puppies,
        modifier = Modifier.fillMaxHeight()
    ) {
        navController.navigate("detail/${it.id}")
    }
}

@Composable
fun PuppyList(
    puppies: List<Puppy>,
    modifier: Modifier = Modifier,
    onClick: (puppy: Puppy) -> Unit
) {
    LazyColumn(modifier) {
        items(items = puppies) { puppy ->
            PuppyListItem(puppy = puppy, onClick = onClick)
            Divider()
        }
    }
}

@Composable
fun PuppyListItem(puppy: Puppy, onClick: (puppy: Puppy) -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onClick(puppy) })
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        GlideImage(
            imageModel = puppy.imageUrl ?: "",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            placeHolder = ImageBitmap.Companion.imageResource(R.drawable.loading),
            error = ImageBitmap.Companion.imageResource(R.drawable.no_image_square),
        )

        Spacer(Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = puppy.name,
                style = MaterialTheme.typography.h6
            )
            Text(
                text = "Age: ${puppy.age()}",
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PuppyListPreview() {
    PuppiesTheme {
        PuppyList(puppies = puppies) {}
    }
}
