package nz.ac.uclive.nse41.witsoc

import androidx.compose.ui.res.stringResource

sealed class BottomNavItem(
    var title: String,
    var icon: Int
) {
    object Home :
        BottomNavItem(
            "About",
            R.drawable.home
        )

    object List :
        BottomNavItem(
            "Events",
            R.drawable.events
        )

    object Analytics :
        BottomNavItem(
            "Contact Us",
            R.drawable.contact
        )
}