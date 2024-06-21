package br.com.fiap.email.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.email.R
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(navController: NavController) {
    val currentMonth = remember { mutableStateOf(YearMonth.of(2023, 5)) }

    Scaffold(
        topBar = { CalendarTopBar(navController) },
        floatingActionButton = { AddEventButton(navController) },
        content = { paddingValues ->
            CalendarContent(paddingValues, navController, currentMonth)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarTopBar(navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "Calendário",
                color = Color(0xffF5F6F7),
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
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color(0xffF5F6F7)
                )
            }
        },
        actions = {
            IconButton(onClick = { /* Implementar ação de pesquisa */ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Pesquisar",
                    tint = Color(0xffF5F6F7)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF253746))
    )
}

@Composable
fun AddEventButton(navController: NavController) {
    FloatingActionButton(
        onClick = { navController.navigate("adicionarevento") },
        containerColor = Color(0xffF00843),
        contentColor = Color(0xffFFFFFF),
        shape = RoundedCornerShape(60.dp)
    ) {
        Icon(Icons.Default.Add, contentDescription = "Adicionar Evento")
    }
}

@Composable
fun CalendarContent(paddingValues: PaddingValues, navController: NavController, currentMonth: MutableState<YearMonth>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF172938))
            .padding(paddingValues)
    ) {
        MonthNavigator(currentMonth)
        WeekDaysHeader()
        CalendarGrid(navController, currentMonth.value)
        EventsSection()
    }
}

@Composable
fun MonthNavigator(currentMonth: MutableState<YearMonth>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF172938)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { currentMonth.value = currentMonth.value.minusMonths(1) },
            modifier = Modifier.padding(start = 5.dp)
        ) {
            Icon(
                Icons.Default.KeyboardArrowLeft,
                contentDescription = "Mês Anterior",
                tint = Color(0xffF5F6F7)
            )
        }
        Text(
            text = currentMonth.value.month.getDisplayName(TextStyle.FULL, Locale.getDefault()).replaceFirstChar { it.uppercase() },
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            color = Color(0xffF5F6F7),
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold
        )
        IconButton(
            onClick = { currentMonth.value = currentMonth.value.plusMonths(1) },
            modifier = Modifier.padding(end = 5.dp)
        ) {
            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "Próximo Mês",
                tint = Color(0xffF5F6F7)
            )
        }
    }
}

@Composable
fun WeekDaysHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color(0xFF172938)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val diasDaSemana = listOf("DOM", "SEG", "TER", "QUA", "QUI", "SEX", "SAB")
        diasDaSemana.forEach { dia ->
            Text(
                text = dia,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                color = Color(0xffF00843),
                fontSize = 12.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun CalendarGrid(navController: NavController, currentMonth: YearMonth) {
    val daysInMonth = currentMonth.lengthOfMonth()
    val days = listOf(31) + (1..daysInMonth).toList() + (1..11).toList()
    val totalGridCells = 42

    LazyVerticalGrid(
        columns = GridCells.Fixed(7),
        content = {
            items(totalGridCells) { index ->
                val dayNumber = if (index < days.size) days[index].toString() else ""
                val isSpecialDay = (dayNumber == "3" && index == 3) || (dayNumber == "23" && index == 23) || (dayNumber == "2" && index >= daysInMonth + 2)
                val specialDayColor = when {
                    dayNumber == "3" && index == 3 -> Color(0xffF00843)
                    dayNumber == "23" && index == 23 -> Color(0xffF5F6F7)
                    dayNumber == "2" && index >= daysInMonth + 2 -> Color(0xffF5F6F7)
                    else -> Color.Transparent
                }
                Box(
                    modifier = Modifier

                        .size(50.dp)
                        .background(
                            color = specialDayColor,
                            shape = CircleShape
                        )
                        .clickable(enabled = dayNumber.isNotEmpty()) {
                            navController.navigate("detailedcalendarscreen/$dayNumber")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = dayNumber,
                        color = if (specialDayColor != Color.Transparent) Color.Black else Color(0xff30CAE3),
                        fontSize = 12.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        },
        modifier = Modifier.background(Color(0xFF172938))
    )
}

@Composable
fun EventsSection() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF253746))
            .padding(16.dp)
    ) {
        EventsOfTheDay()
    }
}

@Composable
fun EventsOfTheDay() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Eventos de hoje",
                color = Color(0xffF5F6F7),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
            Text(
                text = "Terça, 23 de Maio",
                color = Color(0xffF5F6F7),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                modifier = Modifier.wrapContentWidth(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF253746))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.calendario2),
                contentDescription = "Sem eventos",
                tint = Color(0xff76818B),
                modifier = Modifier.size(50.dp)
            )
            Text(
                text = "Você não tem nenhum evento para hoje",
                color = Color(0xff76818B),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}