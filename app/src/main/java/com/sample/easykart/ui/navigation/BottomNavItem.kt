package com.sample.easykart.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.sample.easykart.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Home : Screen("home", R.string.home, Icons.Filled.Home)
    object Favourite : Screen("wishlist", R.string.wishlist, Icons.Filled.Favorite)
    object Profile : Screen("profile", R.string.profile, Icons.Filled.Person)

    object ProductDetail : Screen("Product Detail", R.string.home, Icons.Filled.Home)
}
