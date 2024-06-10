package br.com.fiap.email.componentes



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.email.R

@Composable
fun MensagemBottomBar() {
    BottomAppBar(
        modifier = Modifier.padding(1.dp),
        containerColor = Color(0xff25384A),
        contentColor = MaterialTheme.colorScheme.primary,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    Icons.Filled.Add, "Localized description",
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color(0xffF00843)),
                    tint = Color(0xffFFFFFF),
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.attach),
                    contentDescription = "Buscar",
                    tint = Color(0xff30CAE3),
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = "Buscar",
                    tint = Color(0xff30CAE3),
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.align_left),
                    contentDescription = "Buscar",
                    tint = Color(0xff30CAE3),
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.align_justify),
                    contentDescription = "Buscar",
                    tint =  Color(0xff30CAE3),
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.align_right),
                    contentDescription = "Buscar",
                    tint =  Color(0xff30CAE3),
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.bold),
                    contentDescription = "Buscar",
                    tint = Color(0xff30CAE3),
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.italic),
                    contentDescription = "Buscar",
                    tint = Color(0xff30CAE3),
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.underline),
                    contentDescription = "Buscar",
                    tint = Color(0xff30CAE3),
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}
