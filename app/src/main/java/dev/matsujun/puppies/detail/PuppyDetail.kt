package dev.matsujun.puppies.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import dev.matsujun.puppies.R
import dev.matsujun.puppies.data.Puppy
import dev.matsujun.puppies.data.puppies
import dev.matsujun.puppies.ui.theme.PuppiesTheme

@Composable
fun PuppyDetail(puppy: Puppy) {
    Column{
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