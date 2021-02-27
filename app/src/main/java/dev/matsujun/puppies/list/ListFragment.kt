package dev.matsujun.puppies.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dev.matsujun.puppies.R
import dev.matsujun.puppies.data.puppies
import dev.matsujun.puppies.ui.theme.PuppiesTheme

class ListFragment: Fragment() {

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
            PuppiesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    PuppyList(
                        puppies = puppies,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        val bundle = bundleOf("puppyId" to it.id)
                        findNavController().navigate(R.id.nav_detail, bundle)
                    }
                }
            }
        }
    }
}