package nz.ac.uclive.nse41.witsoc

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.startActivity
import nz.ac.uclive.nse41.witsoc.ui.theme.WitsocTheme


class Events : ComponentActivity() {




    private val events = listOf<Event>(
        Event("Wellbeing Workshop", "15/08 | 6pm", "social", "https://fb.me/e/W5aRT1tB"),
        Event("First Year Panel w WiE & UC ENG", "21/08 | 6pm", "talk", "https://events.humanitix.com/diversity-in-engineering-panel-discussion?_ga=2.248800583.150471578.1691357784-291075914.1642034933"),
        Event("Bingo Night","25/08 | 7-9pm", "social", ""),
        Event("Trimble Lunch & Learn","6/09 | 12:30-2:30pm", "workplace", ""),
        Event("Movie Night","Date TBD", "social", ""),
        Event("Welcome Back Cozy Vibes","Date TBD", "social", ""),
        Event("Exec Recruitment Event","Date TBD", "social", ""),
        Event("Catalyst Office Tour","Date TBD", "workplace", ""),
        Event("Coffee Time","Date TBD", "coffee time", "")
    )



    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            WitsocTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavigation()
                    },
                    containerColor =  Color(0xFFCCBFF7)
                ) {}
                Text(stringResource(R.string.events_heading), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier.width(400.dp).padding(top = 15.dp), fontSize = 30.sp)

                EventsList(events)

            }
        }
    }
}



@Composable
fun EventsList(events: List<Event>) {
    val mContext = LocalContext.current

    val listState = rememberLazyListState()


    LazyColumn(
        state = listState,

        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 80.dp, top = 55.dp),

        ) {
        items(events) { event ->
            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0XFFA8DAF0),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .clickable {

                        if (event.eventURL.isBlank()) {
                            Toast.makeText(mContext, "Event doesn't have a link yet, check back later!", Toast.LENGTH_LONG).show()
                        } else {
                            mContext.startActivity(
                                Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(event.eventURL)))
                        }
                    }

            ) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 10.dp)) {
                    eventTypeIcon(event.eventType)
                    Column() {
                        Text(
                            text = event.name,
                            modifier = Modifier.padding(all = 10.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = event.date,
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .padding(bottom = 15.dp)
                        )
                    }
                    EmailEventButton("Event Enquiry: " + event.name)
                }
            }
        }
    }
}

@Composable
fun eventTypeIcon(eventType : String) {
    if (eventType == "workshop") {
        Icon(painter = painterResource(id = R.drawable.events), contentDescription = "workshop", modifier = Modifier.size(40.dp))
    }
    if (eventType == "coffee time") {
        Icon(painter = painterResource(id = R.drawable.coffee), contentDescription = "coffee time", modifier = Modifier.size(40.dp))
    }
    if (eventType == "social") {
        Icon(painter = painterResource(id = R.drawable.social), contentDescription = "social", modifier = Modifier.size(40.dp))
    }
    if (eventType == "workplace") {
        Icon(painter = painterResource(id = R.drawable.workplace), contentDescription = "workplace", modifier = Modifier.size(40.dp))
    }
    if (eventType == "talk") {
        Icon(painter = painterResource(id = R.drawable.talk), contentDescription = "talk", modifier = Modifier.size(40.dp))
    }
}


@Composable
fun EventNotificationButton(event : Event) {
    val context = LocalContext.current

    IconButton(
        onClick = {

        }
    ) {
        Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "Notification", modifier = Modifier.size(30.dp))


    }

}


@Composable
fun EmailEventButton(emailSubject : String) {
    val context = LocalContext.current

    IconButton(
        onClick = {
            context.sendMail(to = "ucwitsoc@gmail.com", subject = emailSubject)
        }
    ) {
        Icon(imageVector = Icons.Outlined.Email, contentDescription = "Email", modifier = Modifier.size(30.dp))


    }

}


/*

class Events : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WitsocTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }





}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WitsocTheme {
        Greeting("Android")
    }
}
*/
