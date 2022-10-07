package com.bibek.happybirthday

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bibek.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    BirthdayGreetingCardWithImage(getString(R.string.happy_birthday_text),getString(
                                            R.string.birthday_card_from),getString(R.string.birthday_card_note))
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingCardWithText(name : String, from : String , note: String){
    Column {



            Text(
                text = name,
                fontSize = 30.sp, // sp is scalable pixels  // dp is called
                // density-independent pixels
                color = Color.Black,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
               fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(start = 16.dp, end = 16.dp)
            )

            Text(
                text = from,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
               fontFamily = FontFamily.Cursive,
                fontStyle = FontStyle.Italic,
                color= Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(start = 16.dp, end = 16.dp)

            )

        Text(
            text =note,
            fontSize = 26.sp,
             fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Italic,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp)

        )



    }
    
}

@Composable
fun BirthdayGreetingCardWithImage(name: String , from : String , note:String) {
  val image = painterResource(R.drawable.androidparty)

    Box {  // box is used to stack the elements inside it

        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop


            )
        BirthdayGreetingCardWithText(name = name,from = from , note = note)
    }


}



@Preview(showBackground = true,
name = "My Preview",
)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        val note = "I want you to know that i love you till infinity."
        BirthdayGreetingCardWithImage(" Happy Birthday,Sanzeena"," - from Bibek",note )


        
    }
}