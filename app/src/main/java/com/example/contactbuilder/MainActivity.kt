package com.example.contactbuilder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactbuilder.ui.theme.ContactBuilderTheme
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
//            4 (added @OptIn for Scaffold)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        #2
        var fontFamily = FontFamily(
            Font(R.font.roboto_mono_thin, FontWeight.Thin),
            Font(R.font.roboto_mono_light, FontWeight.Light),
            Font(R.font.roboto_mono_regular, FontWeight.Normal),
            Font(R.font.roboto_mono_medium, FontWeight.Medium),
            Font(R.font.roboto_mono_semi_bold, FontWeight.SemiBold),
            Font(R.font.roboto_mono_bold, FontWeight.Bold),
            Font(R.font.roboto_mono_bold_italic, FontWeight.ExtraBold)
        )
        setContent {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.Cyan),
////                Rows use horizontalArrangement and verticalAlignment
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Bottom
//            ) {
//                Text("Hello")
//                Text("World")
//            }
//            *******************************************************************************************
//            Column(
//                modifier = Modifier
//                    .background(Color.Cyan)
//                    .fillMaxHeight(0.5f)
//                    .width(300.dp)
////                    .requiredWidth(300.dp) // Will set the width to be the parameter specified, regardless of device size, making things offscreen.
//                    .border(5.dp, Color.Gray)
//                    .padding(16.dp) // (top = 16.dp), etc to do specific sides.
//                    .border(5.dp, Color.Magenta) // Sequentially, so the border will be added before and after the padding.
//            ) {
//                Text("Hello", modifier = Modifier
//                    .offset(50.dp, 20.dp) // offset will move it like a margin, but will not push away other components
//                )
//                Spacer(modifier = Modifier.height(50.dp)) // To move anything below from an offset without wrapping it in a container and adding padding.
//                Text("World", modifier = Modifier
//                    .clickable {
//
//                    }
//                )
//            }
//            *******************************************************************************************
//            1
            /*
            val painter = painterResource(id = R.drawable.cav_puppy)
            val description = "Cavalier King Charles Spaniel Puppy"
            val title = "Everyone loves a cute puppy"
            Box(modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(16.dp)
            ) {
                ImageCard(
                    painter = painter,
                    contentDescription = description,
                    title = title)
            }
             */
//            1
//            *******************************************************************************************
//            2
//            #2 val fontFamily = FontFamily() above before our setContent
            /*
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF101010))
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 50.sp
                            )
                        ) {
                            append("J")
                        }
                        append("etpack ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 50.sp
                            )
                        ) {
                            append("C")
                        }
                        append("ompose ")
                    },
                    color = Color.White,
                    fontSize = 30.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                )
            }
             */
//            2
//            *******************************************************************************************
//            3
//            // Change the color of the Box by clicking on the ColorBox
//            Column(Modifier.fillMaxSize()){
//                val color = remember {
//                    mutableStateOf(Color.Yellow)
//                }
//                ColorBox(
//                    Modifier
//                        .fillMaxSize()
//                        .weight(1f) // weight will give both boxes the same allowable space.
//                ){
//                    color.value = it
//                }
//                Box(modifier = Modifier
//                    .background(color.value)
//                    .weight(1f)
//                    .fillMaxSize()
//                )
//            }
//            3
//            *******************************************************************************************
//            4
//            Scaffold is a layout in Compose which will make it easier to include already existing design components (top bar, toolbar, nav bar, display Snackbars, etc)
            val snackbarHostState = remember {
                SnackbarHostState()
            }
            // Replace import for remember "import androidx.compose.runtime.remember" with *
            var textFieldState by remember {
                mutableStateOf("")
            }
            val scope = rememberCoroutineScope()
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp),
                // Assign a state to the Snackbar to show within Scaffold whenever we want
                snackbarHost = {
                    SnackbarHost(hostState = snackbarHostState)
                }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                ) {
                    TextField(
                        value = textFieldState,
                        label = {
                            Text("Enter your name")
                        },
                        onValueChange = {
                            textFieldState = it
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                         scope.launch {
                             snackbarHostState.showSnackbar(
                                 "Hello $textFieldState"
                             )
                         }
                    }) {
                        Text("Please greet me")
                    }
                }
            }
//            4
//            *******************************************************************************************
        }
    }
}
//            *******************************************************************************************
//            1
/*
@Composable
// Composable functions start in capital
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(modifier = Modifier.height(200.dp)){
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}
*/
//            1
//            *******************************************************************************************
//            3
//@Composable
//fun ColorBox(
//    modifier: Modifier = Modifier,
//    updateColor: (Color) -> Unit
// ){
////    Commented to instead change the state of the parent composable
////    val color = remember {
//////        Without remember, it will default to Yellow instead of remember the last value assigned to the state.
////        mutableStateOf(Color.Yellow)
////    }
//    Box(modifier = modifier
//        .background(Color.Red)
//        .clickable {
//            updateColor(
//                Color(
//                Random.nextFloat(),
//                Random.nextFloat(),
//                Random.nextFloat(),
//                1f
//                )
//            )
//        }
//    )
//}
//            3
//            *******************************************************************************************
