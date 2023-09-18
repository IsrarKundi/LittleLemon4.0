package com.example.littlelemon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

interface Destinations {
    val route: String
    val icon: ImageVector
    val title: String
}

object Home : Destinations {
    override val route = "Home"
    override val icon = Icons.Filled.Home
    override val title = "Home"
}

object Locations : Destinations{
    override val route = "Locations"
    override val icon = Icons.Filled.LocationOn
    override val title = "Locations"
}

object Menu : Destinations {
    override val route = "Menu"
    override val icon = Icons.Filled.Menu
    override val title = "Menu"
}

object DishDetails : Destinations {
    override val route = "DishDetails"
    override val icon = Icons.Filled.Menu
    override val title = "DishDetails"
}