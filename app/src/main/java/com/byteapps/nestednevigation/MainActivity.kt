package com.byteapps.nestednevigation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.byteapps.nestednevigation.ui.theme.NestedNevigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NestedNevigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navHostController = rememberNavController()


                    


                   


                }
            }
        }
    }
}

@Composable
fun PhoneNumber(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Button(onClick = { navHostController.navigate(NestedScreens.Login.OTP.route) }) {
            Text(text = "Phone Number")
        }

    }
}

@Composable
fun OTPScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Button(onClick = {navHostController.navigate(NestedScreens.MainScreen.route)}) {
            Text(text = "OTP")
        }

    }
}

@Composable
fun MainScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

       Text(text = "Main Screen")

    }
}

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

            Text(text = "Home")

    }
}

@Composable
fun InboxScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Text(text = "Inbox")

    }
}

@Composable
fun OrderScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Text(text = "Order")

    }
}

@Composable
fun AccountScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Text(text = "Account")

    }
}



@Composable
fun DashboardScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Button(onClick = { navHostController.navigate(NestedScreens.MainScreen.Home.ProductList.route) }) {
            Text(text = "Dashboard")
        }

    }
}

@Composable
fun ProductListScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Button(onClick = {  navHostController.navigate(NestedScreens.MainScreen.Home.ProductDetail.route) }) {
            Text(text = "ProductList")
        }

    }
}

@Composable
fun ProductDetailScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Button(onClick = {  navHostController.navigate(NestedScreens.MainScreen.Home.ProceedOrder.route) }) {
            Text(text = "ProductDetail")
        }

    }
}

@Composable
fun ProceedOrderScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Button(onClick = { navHostController.navigate(NestedScreens.Login.OTP.route) }) {
            Text(text = "ProceedOrder")
        }

    }
}




@Composable
fun OrderListScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Button(onClick = { navHostController.navigate(NestedScreens.MainScreen.Order.OrderDetail.route) }) {
            Text(text = "OrderList")
        }

    }
}

@Composable
fun OrderDetailScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Button(onClick = { navHostController.navigate(NestedScreens.MainScreen.Order.Review.route) }) {
            Text(text = "Review")
        }

    }
}

@Composable
fun ReviewScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Button(onClick = { navHostController.navigate(NestedScreens.Login.OTP.route) }) {
            Text(text = "Review Screen")
        }

    }
}

@Composable
fun Navigation(

    navHostController: NavHostController,
    phoneNumberContent:@Composable ()->Unit,
    enterOTPContent:@Composable ()->Unit,
    dashboardContent:@Composable ()->Unit,
    productListContent:@Composable ()->Unit,
    productDetailContent:@Composable ()->Unit,
    proceedOrderContent:@Composable ()->Unit,
    addressFieldContent:@Composable ()->Unit,
    inboxContent:@Composable ()->Unit,
    ordersListContent:@Composable ()->Unit,
    orderDetailContent:@Composable ()->Unit,
    reviewContent:@Composable ()->Unit,
    accountMenuContent:@Composable ()->Unit,
    profileContent:@Composable ()->Unit,

) {

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination?.route


    val loggedIn by remember {
        mutableStateOf(false)
    }


    Column {

        NavHost(modifier = Modifier.weight(1f), navController = navHostController, startDestination = if (loggedIn) NestedScreens.MainScreen.route else NestedScreens.Login.route){


            navigation(
                route = NestedScreens.Login.route,
                startDestination = NestedScreens.Login.PhoneNumber.route
            ){

                composable(NestedScreens.Login.PhoneNumber.route){
                   phoneNumberContent()
                }
                composable(NestedScreens.Login.OTP.route){
                    enterOTPContent()
                }
            }

            navigation(
                route = NestedScreens.MainScreen.route,
                startDestination = NestedScreens.MainScreen.Home.route
            ){


                // Home Graph
                navigation(
                    route = NestedScreens.MainScreen.Home.route,
                    startDestination = NestedScreens.MainScreen.Home.Dashboard.route
                ) {
                    composable(NestedScreens.MainScreen.Home.Dashboard.route) {
                        dashboardContent()
                    }
                    composable(NestedScreens.MainScreen.Home.ProductList.route) {
                       productListContent()
                    }
                    composable(NestedScreens.MainScreen.Home.ProductDetail.route) {
                        productDetailContent()
                    }

                    //ProceedOrder Graph

                    navigation(route = NestedScreens.MainScreen.Home.ProceedOrder.route,
                        startDestination = NestedScreens.MainScreen.Home.ProceedOrder.OrderInfo.route
                    ){

                        composable(NestedScreens.MainScreen.Home.ProceedOrder.OrderInfo.route) {
                           proceedOrderContent()
                        }

                        composable(NestedScreens.MainScreen.Home.ProceedOrder.AddressField.route) {
                           addressFieldContent()
                        }

                    }

                }

                composable(route = NestedScreens.MainScreen.Inbox.route){
                    inboxContent()
                }


                // Order Graph
                navigation(
                    route = NestedScreens.MainScreen.Order.route,
                    startDestination = NestedScreens.MainScreen.Order.OrderList.route
                ) {
                    composable(NestedScreens.MainScreen.Order.OrderList.route) {
                       ordersListContent()
                    }
                    composable(NestedScreens.MainScreen.Order.OrderDetail.route) {
                       orderDetailContent()
                    }
                    composable(NestedScreens.MainScreen.Order.Review.route) {
                        reviewContent()
                    }
                }


                // Account Graph
                navigation(
                    route = NestedScreens.MainScreen.Account.route,
                    startDestination = NestedScreens.MainScreen.Account.MenuList.route
                ) {

                    composable(NestedScreens.MainScreen.Account.MenuList.route) {
                        accountMenuContent()
                    }
                    composable(NestedScreens.MainScreen.Account.Profile.route) {
                        profileContent()
                    }

                }
            }

        }

        if (currentDestination == "dashboard" || currentDestination == "order_list" || currentDestination == "menu_list" || currentDestination == "inbox"){
            BottomAppBar(navController = navHostController)
        }


    }


}

