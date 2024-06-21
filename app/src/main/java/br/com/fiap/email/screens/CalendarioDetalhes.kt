package br.com.fiap.email.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import br.com.fiap.email.R
import br.com.fiap.email.ui.theme.PoppinsRegular
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarioDetalhes(navController: NavController) {
    val currentMonth = remember { mutableStateOf(YearMonth.of(2024, 5)) }

    Scaffold(
        topBar = { CalendarTopBarDetail(navController) },
        floatingActionButton = { AddEventButtonDetail(navController) },
        content = { paddingValues ->
            CalendarContentDetail(paddingValues, navController, currentMonth)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarTopBarDetail(navController: NavController) {
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
fun AddEventButtonDetail(navController: NavController) {
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
fun CalendarContentDetail(paddingValues: PaddingValues, navController: NavController, currentMonth: MutableState<YearMonth>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF172938))
            .padding(paddingValues)
    ) {
        MonthNavigatorDetail(currentMonth)
        WeekDaysHeaderDetail()
        CalendarGridDetail(navController, currentMonth.value)
        EventsList()
    }
}

@Composable
fun MonthNavigatorDetail(currentMonth: MutableState<YearMonth>) {
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
            text =  currentMonth.value.month.getDisplayName(TextStyle.FULL, Locale("pt", "BR")).replaceFirstChar { it.uppercase() },
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
fun WeekDaysHeaderDetail() {
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
fun CalendarGridDetail(navController: NavController, currentMonth: YearMonth) {
    val daysInMonth = currentMonth.lengthOfMonth()
    val firstDayOfWeek = YearMonth.of(2024, 5).atDay(1).dayOfWeek.value % 7 // Ajuste para que 1 de Maio de 2024 caia na quarta-feira
    val previousMonth = currentMonth.minusMonths(1)
    val nextMonth = currentMonth.plusMonths(1)
    val daysInPreviousMonth = previousMonth.lengthOfMonth()

    // Dias do mês anterior a preencher antes do dia 1 de maio
    val previousMonthDays = (daysInPreviousMonth - firstDayOfWeek + 1..daysInPreviousMonth).toList().map { it.toString() }
    // Dias do mês de junho a preencher depois do final de maio
    val nextMonthDays = (1..42 - (daysInMonth + firstDayOfWeek)).toList().map { it.toString() }

    val days = previousMonthDays + (1..daysInMonth).toList().map { it.toString() } + nextMonthDays
    val totalGridCells = 42

    LazyVerticalGrid(
        columns = GridCells.Fixed(7),
        content = {
            items(totalGridCells) { index ->
                val dayNumber = days.getOrNull(index) ?: ""
                val isSpecialDay = (dayNumber == "3" && index == firstDayOfWeek + 2) || (dayNumber == "23" && index == firstDayOfWeek + 22) || (dayNumber == "2" && index >= daysInMonth + firstDayOfWeek + 1)
                val specialDayColor = when {
                    dayNumber == "3" && index == firstDayOfWeek + 2 -> Color(0xffF00843)
                    dayNumber == "23" && index == firstDayOfWeek + 22 -> Color(0xffF5F6F7)
                    dayNumber == "2" && index >= daysInMonth + firstDayOfWeek + 1 -> Color(0xffF5F6F7)
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
fun EventsList() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF253746))
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        // Título e data dos eventos
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Eventos de hoje",
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
               modifier = Modifier.padding( 5.dp)
            )

            Text(
                text = "Terça, 23 de Maio",
                color = Color(0xffF5F6F7),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        // Fundo Azul com Padding Horizontal e bordas arredondadas
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 7.dp, topEnd = 7.dp))
                .background(Color(0xFF172938))
                .padding(horizontal = 15.dp)
        ) {
            // Usar um Box para empilhar os elementos
            Box {
                Column {
                    for (hour in 8..19) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = String.format("%02d:00", hour),
                                color = Color(0xffF5F6F7),
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                modifier = Modifier.width(60.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(7.dp))

                        Divider(
                            color = Color(0xFF203A50),
                            thickness = 1.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 5.dp)
                        )

                        Spacer(modifier = Modifier.height(32.dp))
                    }

                    // Última hora sem divisor
                    Text(
                        text = "19:00",
                        color = Color(0xffF5F6F7),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        modifier = Modifier.width(60.dp)
                    )
                }

                // Adiciona os cartões de eventos em cima dos divisores
                Column {
                    EventItem(
                        startHour = 8,
                        endHour = 9,
                        title = "Academia",
                        participants = listOf("GC", "BF"),
                        leftBorderColor = Color(0xffF00843),
                        shapes = listOf(Color(0xffF2AB32), Color(0xffF00843)),
                        modifier = Modifier.padding(start = 75.dp, top = 0.dp, bottom = 0.dp)
                    )
                    Spacer(modifier = Modifier.height(90.dp)) // Ajuste a altura para posicionar o próximo cartão
                    EventItem(
                        startHour = 11,
                        endHour = 12,
                        title = "Almoço com a Sa",
                        participants = listOf("GC", "S"),
                        leftBorderColor = Color(0xffF2AB32),
                        shapes = listOf(Color(0xffF2AB32), Color(0xff30CAE3)),
                        modifier = Modifier.padding(start = 75.dp, top = 0.dp, bottom = 0.dp)
                    )
                    Spacer(modifier = Modifier.height(135.dp)) // Ajuste a altura para posicionar o próximo cartão
                    EventItem(
                        startHour = 15,
                        endHour = 16,
                        title = "Ler livros/estudar",
                        participants = listOf("GC"),
                        leftBorderColor = Color(0xff30CAE3),
                        shapes = listOf(Color(0xffF2AB32)),
                        modifier = Modifier.padding(start = 75.dp, top = 0.dp, bottom = 0.dp)
                    )
                    Spacer(modifier = Modifier.height(95.dp)) // Ajuste a altura para posicionar o próximo cartão
                    EventItem(
                        startHour = 17,
                        endHour = 18,
                        title = "Reunião faculdade",
                        participants = listOf("GC"),
                        leftBorderColor = Color(0xff46E342),
                        shapes = listOf(Color(0xffF2AB32)),
                        modifier = Modifier.padding(start = 75.dp, top = 0.dp, bottom = 0.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun EventItem(
    startHour: Int,
    endHour: Int,
    title: String,
    participants: List<String>,
    leftBorderColor: Color,
    shapes: List<Color>,
    modifier: Modifier = Modifier
) {
    val eventHeight = 80.dp // 80dp por hora, ajustável conforme necessário

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(eventHeight)
            .padding(vertical = 0.dp) // Removido o padding vertical entre o divider e o cartão
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF0E1E2C))
            .zIndex(1f) // Garantir que o cartão esteja na frente do divisor
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0E1E2C))
                .padding(start = 0.dp, top = 1.dp, end = 1.dp),
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
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 10.sp // Reduzido o tamanho do texto
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
                            .size(20.dp) // Reduzido o tamanho do ícone
                            .padding(end = 4.dp) // Reduzido o padding
                    )
                    Text(
                        text = String.format("%02d:00 até", startHour),
                        color = Color(0xffF5F6F7),
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 10.sp, // Reduzido o tamanho do texto
                        modifier = Modifier.padding(start = 4.dp) // Reduzido o padding
                    )
                    Text(
                        text = String.format("%02d:00", endHour),
                        color = Color(0xffF5F6F7),
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 10.sp, // Reduzido o tamanho do texto
                        modifier = Modifier.padding(start = 2.dp) // Reduzido o padding para alinhamento
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
                            .size(20.dp) // Reduzido o tamanho das shapes
                            .background(color, shape = CircleShape)
                            .padding(2.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = participants.getOrNull(index) ?: "",
                            color = Color.White,
                            fontFamily = PoppinsRegular,
                            fontSize = 8.sp, // Reduzido o tamanho do texto
                            textAlign = TextAlign.Center
                        )
                        Box(
                            modifier = Modifier
                                .size(3.dp) // Reduzido o tamanho do shape interno
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
