package com.example.sicbov3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(Modifier.fillMaxSize()) {
                    SimpleScreen()
                }
            }
        }
    }
}

@Composable
fun SimpleScreen() {
    var d1 by remember { mutableStateOf("") }
    var d2 by remember { mutableStateOf("") }
    var d3 by remember { mutableStateOf("") }
    var out by remember { mutableStateOf<String?>(null) }

    Column(Modifier.padding(16.dp)) {
        Text("Sicbo V3 (Build Test)", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(12.dp))
        Row {
            OutlinedTextField(d1, { d1 = it.filter { c -> c.isDigit() }.take(1) }, label = { Text("D1") })
            Spacer(Modifier.width(8.dp))
            OutlinedTextField(d2, { d2 = it.filter { c -> c.isDigit() }.take(1) }, label = { Text("D2") })
            Spacer(Modifier.width(8.dp))
            OutlinedTextField(d3, { d3 = it.filter { c -> c.isDigit() }.take(1) }, label = { Text("D3") })
            Spacer(Modifier.width(8.dp))
            Button(onClick = {
                val v1 = d1.toIntOrNull() ?: 0
                val v2 = d2.toIntOrNull() ?: 0
                val v3 = d3.toIntOrNull() ?: 0
                val total = v1 + v2 + v3
                out = "Input: $v1,$v2,$v3 | Total=$total"
            }) { Text("คำนวณ") }
        }
        Spacer(Modifier.height(16.dp))
        out?.let { Text(it) }
    }
}
