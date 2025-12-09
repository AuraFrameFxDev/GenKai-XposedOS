package dev.aurakai.auraframefx.ui.gates

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AgentHubScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Agent Hub", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Central command center for agents", style = MaterialTheme.typography.bodyLarge)

        Button(onClick = { navController.popBackStack() }, modifier = Modifier.padding(top = 24.dp)) {
            Text("Back")
        }
    }
}

