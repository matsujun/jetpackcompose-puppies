package dev.matsujun.puppies.list

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import dev.matsujun.puppies.R
import dev.matsujun.puppies.data.Puppy
import dev.matsujun.puppies.data.puppies
import dev.matsujun.puppies.ui.theme.PuppiesTheme

@Composable
fun PuppyList(puppies: List<Puppy>, modifier: Modifier = Modifier, onClick: (puppy: Puppy) -> Unit) {
    Log.d("MJ", "puppies is tried to render")
    LazyColumn(modifier) {
        items(items = puppies) { puppy ->
            Log.d("MJ", "puppy ($puppy) is tried to render")
            PuppyListItem(puppy = puppy, onClick = onClick)
            Divider()
        }
    }
}

@Composable
fun PuppyListItem(puppy: Puppy, onClick: (puppy: Puppy) -> Unit) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable(onClick = { onClick(puppy) })
        .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

            GlideImage(
                imageModel = puppy.imageUrl ?: "",
                modifier = Modifier.size(80.dp).clip(CircleShape),
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