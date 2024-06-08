package br.com.fiap.email.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun FilterSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { /* TODO: Implement filter action */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF172938),
                contentColor = Color(0xFFFFFFFF)
            )
        ) {
            Text("Filtrar", fontSize = 14.sp)
        }

        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier.weight(2f)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { /* TODO: Implement highlights action */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF172938),
                        contentColor = Color(0xFFFFFFFF)
                    ),
                    modifier = Modifier
                        .offset(x = (20).dp)
                        .zIndex(1f)
                ) {
                    Text("Destaques", fontSize = 14.sp)
                }

                Button(
                    onClick = { /* TODO: Implement other action */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffDBE1E7),
                        contentColor = Color(0xFF253746)
                    )
                ) {
                    Text("Outros", fontSize = 14.sp)
                }
            }
        }
    }
}


