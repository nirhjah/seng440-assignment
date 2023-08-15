package nz.ac.uclive.nse41.witsoc

import android.content.Intent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun BottomNavigation() {

    val items = listOf(
        BottomNavItem.About,
        BottomNavItem.Events,
        BottomNavItem.Contact
    )

    NavigationBar {
        items.forEach { item ->
            AddItem(
                screen = item
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem
) {

    val mContext = LocalContext.current
    NavigationBarItem(
        label = {

            if (screen.title == "About") {
                Text(text = stringResource(id = R.string.about_heading))
            }
            if (screen.title == "Events") {
                Text(text = stringResource(id = R.string.events_heading))
            }
            if (screen.title == "Contact Us") {
                Text(text = stringResource(id = R.string.contact_heading))
            }



        },

        // The icon resource
        icon = {
            Icon(
                painterResource(id = screen.icon),
                contentDescription = screen.title
            )
        },

        selected = true,

        alwaysShowLabel = true,

        onClick = { if (screen.title == "About") {
            mContext.startActivity(Intent(mContext, MainActivity::class.java))}

            if (screen.title == "Events") {
                mContext.startActivity(Intent(mContext, Events::class.java))
            }

            if (screen.title == "Contact Us") {
                mContext.startActivity(Intent(mContext, ContactUs::class.java))

            }


        },

        colors = NavigationBarItemDefaults.colors()
    )
}