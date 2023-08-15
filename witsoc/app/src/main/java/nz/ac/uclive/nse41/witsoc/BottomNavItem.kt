package nz.ac.uclive.nse41.witsoc


sealed class BottomNavItem(

    var title: String,
    var icon: Int
) {
    object About :
        BottomNavItem(

            "About",
            R.drawable.home
        )

    object Events :
        BottomNavItem(
            "Events",
            R.drawable.events
        )

    object Contact :
        BottomNavItem(
            "Contact Us",
            R.drawable.contact
        )
}