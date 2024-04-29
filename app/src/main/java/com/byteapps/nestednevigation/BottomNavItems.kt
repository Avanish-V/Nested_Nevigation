package com.byteapps.karigar.presentation.Screens.bottomBarScreens.BottomBar


import com.byteapps.nestednevigation.NestedScreens
import com.byteapps.nestednevigation.R
import com.byteapps.serrvicewala.Utils.NavigationRoutes.BottomNavRoutes


data class navItems(

    val item: String,
    val icon: Int,
    val iconBold: Int,
    val route: String
)


val items = listOf(
    navItems(
        "Home",
        R.drawable.home,
        R.drawable.home_solid,
        NestedScreens.MainScreen.Home.Dashboard.route
    ),
    navItems(
        "Inbox",
        R.drawable.home,
        R.drawable.home_solid,
        NestedScreens.MainScreen.Inbox.route
    ),
    navItems(
        "Orders",
        R.drawable.memo_pad,
        R.drawable.memo_solid,
        NestedScreens.MainScreen.Order.OrderList.route
    ),
    navItems(
        "Account",
        R.drawable.user,
        R.drawable.user_solid,
        NestedScreens.MainScreen.Account.MenuList.route
    )
)