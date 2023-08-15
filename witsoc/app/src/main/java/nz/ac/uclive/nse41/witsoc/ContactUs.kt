package nz.ac.uclive.nse41.witsoc

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import nz.ac.uclive.nse41.witsoc.ui.theme.WitsocTheme

class ContactUs : ComponentActivity()  {

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
                ) {

                    Text("Contact Us", textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier.width(400.dp).padding(top = 15.dp), fontSize = 30.sp)

                    EmailButton()


                }


            }
        }
    }

}


@Composable
fun EmailButton() {
    val context = LocalContext.current
    Button(onClick = {
        context.sendMail(to = "ucwitsoc@gmail.com", subject = "")
    }) {
        Text(text = "Email")
    }
}

fun Context.sendMail(to: String, subject: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        startActivity(intent)

}