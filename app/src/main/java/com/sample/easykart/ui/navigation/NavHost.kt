package com.sample.easykart.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.sample.easykart.data.model.ProductItem
import com.sample.easykart.ui.screens.productdetail.ProductDetailScreen
import com.sample.easykart.ui.screens.productlist.ProductListScreen
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun NavHost() {
    val navController = rememberNavController()
    androidx.navigation.compose.NavHost(navController, startDestination = "home") {
        composable("home") {
            ProductListScreen() {
                navController.navigate("product/${it.id}")
            }
        }
        composable(
            "product/{id}",
            arguments = listOf(navArgument("id") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val id= backStackEntry.arguments?.getString("id") ?: "1"
            ProductDetailScreen() {
                navController.popBackStack()
            }
        }
    }
}


