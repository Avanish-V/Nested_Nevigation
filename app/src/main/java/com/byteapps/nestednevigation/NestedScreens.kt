package com.byteapps.nestednevigation

sealed class NestedScreens(val route: String) {


    object Login : NestedScreens("login"){

        object PhoneNumber : NestedScreens("phone_number")
        object OTP : NestedScreens("otp")
    }


    object MainScreen : NestedScreens("main") {

        object Home : NestedScreens("home"){

            object Dashboard : NestedScreens("dashboard")
            object ProductList : NestedScreens("product_list")
            object ProductDetail : NestedScreens("product_detail")

            object ProceedOrder : NestedScreens("proceed_order"){

                object OrderInfo : NestedScreens("order_info")
                object AddressField : NestedScreens("address_field")

            }

        }

        object Inbox : NestedScreens("inbox")

        object Order : NestedScreens("order"){

            object OrderList : NestedScreens("order_list")
            object OrderDetail : NestedScreens("order_detail")
            object Review : NestedScreens("review")
        }

        object Account : NestedScreens("account"){

            object MenuList : NestedScreens("menu_list")
            object Profile : NestedScreens("profile")


        }
    }



}