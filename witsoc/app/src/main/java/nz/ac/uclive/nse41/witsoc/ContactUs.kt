package nz.ac.uclive.nse41.witsoc

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

                    Column(modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 90.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(40.dp)) {
                        Text(
                            stringResource(id = R.string.contact_heading), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier
                                .width(400.dp)
                                .padding(top = 15.dp), fontSize = 30.sp)
                            EmailButton()
                            FacebookButton()
                            InstagramButton()
                            LinkedinButton()
                            DiscordButton()
                            SignUpButton()
                    }

                }


            }
        }
    }

}

@Composable
fun LinkedinButton() {
    val context = LocalContext.current
    Button(
        elevation = ButtonDefaults.buttonElevation(8.dp),
        modifier = Modifier.width(200.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0XFFA8DAF0),
            contentColor = Color.Black),
        onClick = {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.linkedin.com/company/women-in-tech-society/?originalSubdomain=nz")))
        }) {
        Row(verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .size(30.dp),
                painter = painterResource(id = R.drawable.linkedin),
                contentDescription = "facebook"
            )

            Text(
                text = stringResource(R.string.linkedin),
                modifier = Modifier.padding(horizontal = 10.dp),
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun DiscordButton() {
    val context = LocalContext.current
    Button(
        elevation = ButtonDefaults.buttonElevation(8.dp),
        modifier = Modifier.width(200.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0XFFA8DAF0),
            contentColor = Color.Black),
        onClick = {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://discord.gg/sUH3E6yeRM")))
        }) {
        Row(verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .size(30.dp),
                painter = painterResource(id = R.drawable.discord),
                contentDescription = "facebook"
            )

            Text(
                text = stringResource(R.string.discord),
                modifier = Modifier.padding(horizontal = 10.dp),
                fontSize = 20.sp
            )
        }
    }
}



@Composable
fun FacebookButton() {
    val context = LocalContext.current
    Button(
        elevation = ButtonDefaults.buttonElevation(8.dp),
        modifier = Modifier.width(200.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0XFFA8DAF0),
            contentColor = Color.Black),
        onClick = {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/ucwitsoc/")))
        }) {
        Row(verticalAlignment = Alignment.CenterVertically,
            ) {
            Image(
                modifier = Modifier
                    .size(30.dp),
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "facebook"
            )

            Text(
                text = stringResource(R.string.facebook),
                modifier = Modifier.padding(horizontal = 10.dp),
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun InstagramButton() {
    val context = LocalContext.current
    Button(
        elevation = ButtonDefaults.buttonElevation(8.dp),
        modifier = Modifier.width(200.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0XFFA8DAF0),
            contentColor = Color.Black),
        onClick = {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/witsocuc/")))
        }) {
        Row(verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .size(30.dp),
                painter = painterResource(id = R.drawable.instagram),
                contentDescription = "instagram"
            )

            Text(
                text = stringResource(R.string.instagram),
                modifier = Modifier.padding(horizontal = 10.dp),
                fontSize = 20.sp
            )
        }
    }
}


@Composable
fun EmailButton() {
    val context = LocalContext.current
    Button(
        elevation = ButtonDefaults.buttonElevation(8.dp),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.width(200.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0XFFA8DAF0),
            contentColor = Color.Black),
                onClick = {
        context.sendMail(to = "ucwitsoc@gmail.com", subject = "")
    }) {
        Row(verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .size(30.dp),
                painter = painterResource(id = R.drawable.email),
                contentDescription = "email"
            )

            Text(
                text = stringResource(R.string.email),
                modifier = Modifier.padding(horizontal = 10.dp),
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun SignUpButton() {
    val context = LocalContext.current
    Button(
        elevation = ButtonDefaults.buttonElevation(8.dp),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.width(200.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0XFFA8DAF0),
            contentColor = Color.Black),
        onClick = {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://forms.gle/cLh5j87hNFM8qtsb8")))
        }) {
        Row(verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.signup),
                modifier = Modifier.padding(horizontal = 10.dp),
                fontSize = 20.sp
            )
        }
    }
}

fun Context.sendMail(to: String, subject: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        startActivity(intent)

}