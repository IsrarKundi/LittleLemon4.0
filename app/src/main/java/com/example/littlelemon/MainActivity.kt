package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {

                AppScreen()
            }
        }
    }
}

//@Composable
//fun MyNavigation() {
//    val navController = rememberNavController()
//    NavHost(
//        navController = navController,
//        startDestination = Home.route
//    ) {
//        composable(Home.route) {
//            HomeScreen(navController = navController)
//        }
//        composable(Locations.route){
//            LocationScreen()
//        }
//        composable(Menu.route) {
//            MenuListScreen()
//        }
//
//    }
//}

@Composable
fun MyBottomNavigation(navController: NavController) {
    val destinationList = listOf<Destinations>(
        Home,
        Locations,
        Menu
    )

    val selectedIndex = rememberSaveable {
        mutableStateOf(0)
    }

    BottomNavigation {
        destinationList.forEachIndexed { index, destinations ->
            BottomNavigationItem(
                label = {Text(text = destinations.title)},
                icon = { Icon(imageVector = destinations.icon, contentDescription = destinations.title) },
                selected = index == selectedIndex.value,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(destinationList[index].route){
                        popUpTo(Home.route)
                        launchSingleTop = false
                    }
                })
        }
    }
}
@Composable
fun AppScreen() {


    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = { DrawerPanel(scaffoldState = scaffoldState, scope = scope)},
        topBar = {
            TopAppBar(scaffoldState = scaffoldState, scope = scope)
        },
        bottomBar = { MyBottomNavigation(navController = navController)}
    ) {

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)){
            NavHost(navController = navController, startDestination = Home.route){
                composable(Home.route){
                    HomeScreen(navController)
                }
                composable(Locations.route){
                    LocationScreen()
                }
                composable(Menu.route){
                    MenuListScreen(navController)
                }
                composable(DishDetails.route){
                    DishDetails(Dish("", "", "", R.drawable.greeksalad))
                }
            }
        }
    }
}


//    Scaffold(topBar = {
//        TopAppBar()
//    }) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(it)
//        ) {
//            HomeScreen()
//
//        }
//    }
//    Scaffold(topBar = {
//        TopAppBar()
//    }) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(it)
//        ) {
//            HomeScreen()
//
//        }
//    }
