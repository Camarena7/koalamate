package com.example.koalamate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.koalamate.ui.theme.KoalamateTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    val temas = listOf(
      Tema("Números Naturales")
    )
    setContent {
      KoalamateTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Greeting(
            name = "Android",
            modifier = Modifier.padding(innerPadding)
          )
          LazyColumn {
            items(temas){ topico ->
              CardView(topico)
            }
          }
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

@Composable
fun CardView(tema: Tema) {
  Card(
    modifier = Modifier.fillMaxSize()
      .padding(12.dp)
  ) {
    Row {
      Image(
        painter = painterResource(
          id = R.drawable.math),
        contentDescription = "Operaciones Básicas",
        modifier = Modifier.width(100.dp)
          .height(100.dp)
      )
      Text(
        text = tema.titulo,
        modifier = Modifier.padding(36.dp)
      )
    }

  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  KoalamateTheme {
    Greeting("Android")
  }
}