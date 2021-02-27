package dev.matsujun.puppies

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import dev.matsujun.puppies.detail.DetailScreen
import dev.matsujun.puppies.list.ListScreen
import dev.matsujun.puppies.ui.theme.PuppiesTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PuppiesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "list") {
        composable(
            route = "list",
            arguments = listOf(navArgument("puppyId") { type = NavType.IntType })
        ) {
            ListScreen(navController)
        }
        composable(
            route = "detail/{puppyId}",
            arguments = listOf(navArgument("puppyId") { type = NavType.IntType })
        ) {
            DetailScreen(navController, it.arguments?.getInt("puppyId")!!)
        }
    }
}