@file:OptIn(ExperimentalMaterial3Api::class)

package br.com.fiap.email.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.email.R
import br.com.fiap.email.ui.theme.PoppinsMedium
import br.com.fiap.email.ui.theme.PoppinsRegular
import br.com.fiap.email.ui.theme.PoppinsSemiBold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarioDetalhes(navController: NavController) {
    Scaffold(
        topBar = { CalendarTopBar(navController) },
        floatingActionButton = { AddEventButton() },
        content = { paddingValues ->
            CalendarContent(paddingValues)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarTopBarList(navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "Calendário",
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    painter = painterResource(id = R.drawable.seta_left),
                    contentDescription = "Voltar",
                    modifier = Modifier.size(22.dp),
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = { /* Implementar ação de pesquisa */ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Pesquisar",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF253746))
    )
}

@Composable
fun AddEventButton() {
    FloatingActionButton(onClick = { /* Implementar ação de adicionar evento */ }) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Adicionar Evento",
            tint = Color.White
        )
    }
}

@Composable
fun CalendarContent(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF253746))
            .padding(paddingValues)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            CalendarView()
            Spacer(modifier = Modifier.height(16.dp))
            EventsList()
        }
    }
}

@Composable
fun CalendarView() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Maio",
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}

@Composable
fun EventsList() {
    Column {
        Text(
            text = "Eventos de hoje",
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        EventItem(
            time = "08:00 até 09:30",
            title = "Academia",
            participants = listOf("GC", "BF"),
            leftBorderColor = Color(0xffF00843),
            shapes = listOf(Color(0xffF2AB32), Color(0xffF00843))
        )
        EventItem(
            time = "12:00 até 13:00",
            title = "Almoço com a Sa",
            participants = listOf("GC", "S"),
            leftBorderColor =  Color(0xffF2AB32),
            shapes = listOf(Color(0xffF2AB32), Color(0xff30CAE3))
        )
        EventItem(
            time = "15:00 até 16:00",
            title = "Ler livros/estudar",
            participants = listOf("GC"),
            leftBorderColor = Color(0xff30CAE3),
            shapes = listOf(Color(0xffF2AB32))
        )
        EventItem(
            time = "17:30 até 18:30",
            title = "Reunião faculdade",
            participants = listOf("GC"),
            leftBorderColor = Color(0xff46E342),
            shapes = listOf(Color(0xffF2AB32))
        )
    }
}

@Composable
fun EventItem(
    time: String,
    title: String,
    participants: List<String>,
    leftBorderColor: Color,
    shapes: List<Color>
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .width(400.dp)
            .height(80.dp)  // Ajustar a altura para 80 dp
            .padding(vertical = 4.dp)
            .clip(RoundedCornerShape(8.dp)) // Apply rounded corners
            .background(Color(0xFF0E1E2C)) // Background color
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0E1E2C)) // Ensure background color for the entire row
                .padding(start = 0.dp, top = 1.dp, bottom = 1.dp, end = 1.dp), // Inner padding with space for left border
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(4.dp)
                    .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp))
                    .background(leftBorderColor)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = title,
                    color = Color(0xffF5F6F7),
                    fontFamily = PoppinsSemiBold,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.clock),
                        contentDescription = "Clock Icon",
                        tint = Color.Cyan,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 8.dp)
                    )
                    Text(
                        text = time,
                        color = Color(0xffF5F6F7),
                        fontFamily = PoppinsRegular,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                shapes.forEachIndexed { index, color ->
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .background(color, shape = CircleShape)
                            .padding(2.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = participants.getOrNull(index) ?: "",
                            color = Color.White,
                            fontFamily = PoppinsRegular,
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center
                        )
                        Box(
                            modifier = Modifier
                                .size(5.dp)
                                .background(Color.Green, shape = CircleShape)
                                .align(Alignment.BottomEnd)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = { /* Implementar ação de opções */ }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Opções",
                    tint = Color(0xff30CAE3)
                )
            }
        }
    }
}
