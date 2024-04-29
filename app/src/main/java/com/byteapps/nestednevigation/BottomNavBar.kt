package com.byteapps.nestednevigation

import android.util.Log
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.byteapps.karigar.presentation.Screens.bottomBarScreens.BottomBar.items

@Composable
fun BottomAppBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val destination = navBackStackEntry?.destination

    NavigationBar(

        containerColor = Color.White,
        modifier = Modifier
            .shadow(elevation = 5.dp)
            .height(75.dp),
        contentColor = Color.Transparent


    ) {

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {

                    Icon(
                        painter = painterResource(id =  if (destination?.route == item.route) item.iconBold else item.icon),
                        contentDescription = null,
                        modifier = Modifier.size(22.dp)
                    )

                    Log.d("currentDestination1",destination?.route.toString())
                    Log.d("currentDestination2",item.route)

                },
                label = { Text(item.item, fontWeight = FontWeight.Normal) },
                selected = destination?.hierarchy?.any {
                    it.route == item.route
                } == true,
                onClick = {

                    if (destination?.route != item.route) {
                        navController.navigate(item.route) {

                            popUpTo(navController.graph.findStartDestination().id) {

                                saveState = false
                            }

                            launchSingleTop = true
                            restoreState = true
                        }
                    }


                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    indicatorColor = MaterialTheme.colorScheme.onTertiary,
                    selectedTextColor = MaterialTheme.colorScheme.primary
                )


            )
        }
    }
}