
package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.* // ✅ Imports Column, Row, padding, fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import com.example.jetpackcomposetutorial.ui.theme.JetPackComposeTutorialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            JetPackComposeTutorialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // ✅ FIX: Pass `modifier` to MessageCard, NOT to Message
                    MessageCard(
                        msg = Message("Android", "Jetpack Compose"),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// ✅ FIX: Remove `modifier` from Message class
data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) { // ✅ Add opening `{` here!

        Image(
            painter = painterResource(R.drawable.muzi),
            contentDescription = "Mossi",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Black, CircleShape),
            contentScale = ContentScale.Crop
        )

        Column(modifier = modifier.padding(8.dp)) { // ✅ FIX: Wrap in Column
            Text(text = msg.author)
            Text(text = msg.body)
        }
    } // ✅ Add closing `}` for Row
}

// ✅ Preview Function
@Preview(showBackground = true)
@Composable
fun MessageCardPreview() {
    MessageCard(
        msg = Message("Mossaz", "Hey, take a look at Jetpack Compose, it's great!")
    )
}
