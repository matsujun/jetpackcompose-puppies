package dev.matsujun.puppies.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dev.matsujun.puppies.ui.theme.PuppiesTheme

class DetailFragment : Fragment() {
    private val viewModel: DetailViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.setPuppyId(arguments?.getInt("puppyId"))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        setContent {
            Text(text = "hogehoge")
            val puppy by viewModel.puppyData.observeAsState()
            PuppiesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    PuppyDetail(puppy!!)
                }
            }
        }
    }
}