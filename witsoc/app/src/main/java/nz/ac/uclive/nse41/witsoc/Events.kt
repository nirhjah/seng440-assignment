package nz.ac.uclive.nse41.witsoc

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Email
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nz.ac.uclive.nse41.witsoc.ui.theme.WitsocTheme
import java.text.SimpleDateFormat
import java.util.Locale


class Events() : ComponentActivity() {


    private val events = listOf<Event>(
        Event(WiTSocApp.getAppResources().getString(R.string.wellbeingworkshop), "2023-08-15T18:00:00", "2023-08-15T20:00:00", "social", "https://fb.me/e/W5aRT1tB"),
        Event(WiTSocApp.getAppResources().getString(R.string.firstyearpanel), "2023-08-21T18:00:00", "2023-08-21T20:00:00", "talk", "https://events.humanitix.com/diversity-in-engineering-panel-discussion?_ga=2.248800583.150471578.1691357784-291075914.1642034933"),
        Event(WiTSocApp.getAppResources().getString(R.string.coffeetime),"2023-08-25T10:00:00", "2023-08-25T11:00:00", "coffee time", "https://docs.google.com/forms/d/e/1FAIpQLSdpwF8JlLDEtd-jaGVMhxbhYODfye4BVsIWiFlk5e3kw1vGfg/viewform"),
        Event(WiTSocApp.getAppResources().getString(R.string.bingo),"2023-08-25T19:00:00", "2023-08-25T21:00:00", "social", ""),
        Event(WiTSocApp.getAppResources().getString(R.string.lunchandlearn), "2023-09-6T12:30:00", "2023-09-6T14:30:00", "workplace", ""),
        Event(WiTSocApp.getAppResources().getString(R.string.movienight),"", "", "social", ""),
        Event(WiTSocApp.getAppResources().getString(R.string.welcomebackevent),"", "", "social", ""),
        Event(WiTSocApp.getAppResources().getString(R.string.execrecruitmentevent),"", "", "social", ""),
        Event(WiTSocApp.getAppResources().getString(R.string.officetourcatalyst),"", "", "workplace", ""),
        Event(WiTSocApp.getAppResources().getString(R.string.coffeetime),"", "", "coffee time", "")
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
                Text(stringResource(R.string.events_heading), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier
                    .width(400.dp)
                    .padding(top = 15.dp), fontSize = 30.sp)

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

            val formattedStart = formatAndReturnDate(event.startTime)
            val formattedEnd = formatAndReturnTime(event.endTime)

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
                            Toast
                                .makeText(
                                    mContext,
                                    mContext.getString(R.string.toast),
                                    Toast.LENGTH_LONG
                                )
                                .show()
                        } else {
                            mContext.startActivity(
                                Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(event.eventURL)
                                )
                            )
                        }
                    }

            ) {

                Box {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        eventTypeIcon(event.eventType)

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentWidth(Alignment.Start)
                                .alignByBaseline()
                        ) {

                            Column(
                                verticalArrangement = Arrangement.spacedBy(0.1.dp),
                                horizontalAlignment = Alignment.End
                            ) {

                                Text(
                                    text = event.name,
                                    modifier = Modifier
                                        .padding(all = 10.dp)
                                        .align(Alignment.Start),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 19.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )

                                Row(
                                    modifier = Modifier.align(Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = formattedStart
                                    )
                                    Text(
                                        text = formattedEnd
                                    )


                                }

                            }

                        }

                        Column(
                            verticalArrangement = Arrangement.spacedBy(0.1.dp),
                            horizontalAlignment = Alignment.End
                        ) {
                            EventNotificationButton(event)

                            EmailEventButton("Event Enquiry: " + event.name)
                        }
                    }
                }
            }

        }
    }
}

@Composable
fun eventTypeIcon(eventType : String) {
    if (eventType == "workshop") {
        Icon(painter = painterResource(id = R.drawable.events), contentDescription = "workshop", modifier = Modifier
            .size(40.dp)
            .padding(end = 8.dp))
    }
    if (eventType == "coffee time") {
        Icon(painter = painterResource(id = R.drawable.coffee), contentDescription = "coffee time", modifier = Modifier
            .size(40.dp)
            .padding(end = 8.dp))
    }
    if (eventType == "social") {
        Icon(painter = painterResource(id = R.drawable.social), contentDescription = "social", modifier = Modifier
            .size(40.dp)
            .padding(end = 8.dp))
    }
    if (eventType == "workplace") {
        Icon(painter = painterResource(id = R.drawable.workplace), contentDescription = "workplace", modifier = Modifier
            .size(40.dp)
            .padding(end = 8.dp))
    }
    if (eventType == "talk") {
        Icon(painter = painterResource(id = R.drawable.talk), contentDescription = "talk", modifier = Modifier
            .size(40.dp)
            .padding(end = 8.dp))
    }
}


@Composable
fun EventNotificationButton(event : Event) {
    val context = LocalContext.current

    if (event.startTime.isNotBlank() && event.endTime.isNotBlank()) {
        IconButton(
            onClick = {
                val mSimpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                val mStartTime = mSimpleDateFormat.parse(event.startTime)
                val mEndTime = mSimpleDateFormat.parse(event.endTime)
                val intent = Intent(Intent.ACTION_EDIT)
                intent.type = "vnd.android.cursor.item/event"
                intent.putExtra("beginTime", mStartTime.time)
                intent.putExtra("allDay", false)
                intent.putExtra("endTime", mEndTime.time)
                intent.putExtra("title", event.name)
                context.startActivity(intent)
            }
        ) {
            Icon(
                imageVector = Icons.Outlined.DateRange,
                contentDescription = "Add to Calendar",
                modifier = Modifier.size(30.dp)
            )
        }
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

fun formatAndReturnDate(inputDateString: String): String {
    if (inputDateString.isNotBlank()) {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMMM HH:mm", Locale.getDefault())

        inputFormat.parse(inputDateString)?.run {
            return outputFormat.format(this)
        }
    }
    return "Date TBD"
}

fun formatAndReturnTime(inputDateString: String): String {
    if (inputDateString.isNotBlank()) {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

        inputFormat.parse(inputDateString)?.run {
            return "- " + outputFormat.format(this)
        }
    }
    return ""
}


