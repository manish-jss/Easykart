package com.sample.easykart.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sample.easykart.R
import com.sample.easykart.ui.screens.productdetail.ProductDetailScreen
import com.sample.easykart.ui.screens.productlist.ProductListScreen

@Composable
fun AppContent() {
    val items = listOf(
        Screen.Home,
        Screen.Favourite,
        Screen.Profile
    )

    val navController = rememberNavController()
    val showBottomBar =
        navController.currentBackStackEntryAsState().value?.destination?.route in items.map { it.route }
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigation(backgroundColor = MaterialTheme.colorScheme.background) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    items.forEach { screen ->
                        BottomNavigationItem(
                            icon = { Icon(screen.icon, contentDescription = null) },
                            label = { Text(stringResource(screen.resourceId)) },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    // on the back stack as users select items
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            },
                            selectedContentColor = MaterialTheme.colorScheme.primary,
                            //unselectedContentColor = Color.Black,
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.Home.route,
            Modifier.padding(innerPadding)
        ) {

            composable(Screen.Home.route) {
                ProductListScreen() {
                    navController.navigate(Screen.ProductDetail.route + "/${it.id}")
                }
            }
            composable(Screen.Profile.route) { ProfileUI(navController) }
            composable(Screen.Favourite.route) { FavouriteScreenUI(navController) }
            composable(
                Screen.ProductDetail.route + "/{id}",
                arguments = listOf(navArgument("id") {
                    type = NavType.StringType
                })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id") ?: "1"
                ProductDetailScreen() {
                    navController.popBackStack()
                }
            }
        }
    }
}

@Composable
fun FavouriteScreenUI(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = stringResource(id = R.string.wishlist),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun ProfileUI(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Profile Screen",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
        )
    }
}