@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package br.com.fiap.email.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.email.R
import br.com.fiap.email.ui.theme.PoppinsMedium
import br.com.fiap.email.ui.theme.PoppinsRegular
import br.com.fiap.email.ui.theme.PoppinsSemiBold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEventScreen(navController: NavController) {
    Scaffold(
        topBar = { AddEventTopBar(navController) },
        content = { paddingValues ->
            AddEventContent(paddingValues)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEventTopBar(navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "Adicionar Novo Evento",
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
                    painter = painterResource(id = R.drawable.seta_left),
                    contentDescription = "Voltar",
                    modifier = Modifier.size(22.dp),
                    tint = Color(0xffF5F6F7)
                )
            }
        },
        actions = {
            IconButton(onClick = { /* Implementar ação de salvar */ }) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Salvar",
                    tint = Color(0xffF5F6F7)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF253746))
    )
}

@Composable
fun AddEventContent(paddingValues: PaddingValues) {
    var titulo by rememberSaveable { mutableStateOf("") }
    var adicionarPessoas by rememberSaveable { mutableStateOf("") }
    var isDiaInteiro by rememberSaveable { mutableStateOf(false) }
    var localizacao by rememberSaveable { mutableStateOf("") }
    var descricao by rememberSaveable { mutableStateOf("") }
    var isPrivado by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF253746))
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            TituloTextField(titulo) { titulo = it }
            Divider(color = Color(0xff172938))
            AdicionarPessoasRow(adicionarPessoas) { adicionarPessoas = it }
            Divider(color = Color(0xff172938))
            DiaInteiroRow(isDiaInteiro) { isDiaInteiro = it }
            Divider(color = Color(0xff172938))
            DataHorarioSection()
            Divider(color = Color(0xff172938))
            LocalizacaoTextField(localizacao) { localizacao = it }
            Divider(color = Color(0xff172938))
            DescricaoTextField(descricao) { descricao = it }
            Divider(color = Color(0xff172938))
            RepeticaoTextField()
            Divider(color = Color(0xff172938))
            AlertasTextField()
            Divider(color = Color(0xff172938))
            PrivadoRow(isPrivado) { isPrivado = it }
            Divider(color = Color(0xff172938))
            CategoriaTextField()
            Divider(color = Color(0xff172938))
            AnexosTextField()
            Divider(color = Color(0xff172938))
        }
    }
}

@Composable
fun TituloTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Título", color = Color(0xffABBBCB), fontFamily = PoppinsSemiBold) },
        leadingIcon = {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(Color(0xffF2AB32), shape = CircleShape)
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.pen),
                contentDescription = "Verificar",
                modifier = Modifier
                    .size(22.dp)
                    .padding(end = 8.dp),
                tint = Color(0xffF2AB32)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,

            cursorColor = Color.White,
            focusedLabelColor = Color(0xffABBBCB),
            unfocusedLabelColor = Color(0xffABBBCB)
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun AdicionarPessoasRow(value: String, onValueChange: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text("Adicionar pessoas", color = Color(0xffF5F6F7), fontFamily = PoppinsMedium, fontSize = 14.sp) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.pessoas),
                    contentDescription = "Adicionar pessoas",
                    modifier = Modifier.size(22.dp),
                    tint = Color(0xff30CAE3)
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,

                cursorColor = Color.White,
                focusedLabelColor = Color(0xffF5F6F7),
                unfocusedLabelColor = Color(0xffF5F6F7)
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "Gabriel, ...",
            color = Color(0xffABBBCB),
            fontFamily = PoppinsSemiBold,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.pen),
            contentDescription = "Próximo",
            modifier = Modifier
                .size(22.dp)
                .padding(end = 8.dp),
            tint = Color(0xffF2AB32)
        )
    }
}

@Composable
fun DiaInteiroRow(isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.evento),
            contentDescription = "Dia Inteiro",
            modifier = Modifier.size(22.dp),
            tint = Color(0xff009DB7),
        )
        Text(
            text = "Evento de Dia Inteiro",
            color = Color(0xffF5F6F7),
            fontFamily = PoppinsMedium,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xff30CAE3),
                uncheckedThumbColor = Color(0xffF5F6F7),
                checkedTrackColor = Color(0xff253746),
                uncheckedTrackColor = Color(0xff253746),
                checkedBorderColor = Color(0xff30CAE3),
                uncheckedBorderColor = Color(0xffF5F6F7)
            ),
            modifier = Modifier.scale(0.75f)
        )
    }
}

@Composable
fun DataHorarioSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp), // Diminuir o padding vertical
        horizontalArrangement = Arrangement.Center
    ) {
        DataSection()
        Spacer(modifier = Modifier.width(16.dp)) // Diminuir o espaçamento horizontal
        HorarioSection()
    }
}

@Composable
fun DataSection() {
    Column(
        modifier = Modifier
            .background(Color(0xff172938), shape = RoundedCornerShape(7.dp))
            .padding(8.dp)
    ) {
        Text(
            text = "Data",
            color = Color(0xffB5CFD6),
            fontFamily = PoppinsMedium,
            fontSize = 12.sp
        )
        Text(
            text = "Quinta, 2 de Maio",
            color = Color(0xff009DB7),
            fontFamily = PoppinsSemiBold,
            fontSize = 12.sp
        )
        Text(
            text = "Hoje",
            color = Color(0xffF5F6F7),
            fontFamily = PoppinsMedium,
            fontSize = 12.sp
        )
    }
}

@Composable
fun HorarioSection() {
    Column(
        modifier = Modifier
            .background(Color(0xff172938), shape = RoundedCornerShape(7.dp))
            .padding(8.dp)
    ) {
        Text(
            text = "Horário",
            color = Color(0xffB5CFD6),
            fontFamily = PoppinsMedium,
            fontSize = 12.sp
        )
        Text(
            text = buildAnnotatedString {
                append("18:00 ")
                withStyle(style = SpanStyle(color = Color.Red)) {
                    append(">")
                }
                append(" 19:00")
            },
            color = Color(0xff009DB7),
            fontFamily = PoppinsSemiBold,
            fontSize = 12.sp
        )
        Text(
            text = "Duração: 1 hora",
            color = Color(0xffF5F6F7),
            fontFamily = PoppinsMedium,
            fontSize = 12.sp
        )
    }
}

@Composable
fun LocalizacaoTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                "Definir localização",
                color = Color(0xffABBBCB),
                fontFamily = PoppinsSemiBold,
                fontSize = 14.sp
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.localizacao),
                contentDescription = "Localização",
                modifier = Modifier.size(22.dp),
                tint = Color(0xff009DB7)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,

            cursorColor = Color.White,
            focusedLabelColor = Color(0xffABBBCB),
            unfocusedLabelColor = Color(0xffABBBCB)
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun DescricaoTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                "Descrição do Evento",
                color = Color(0xffABBBCB),
                fontFamily = PoppinsMedium,
                fontSize = 14.sp
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.descricao),
                contentDescription = "Descrição",
                modifier = Modifier.size(22.dp),
                tint = Color(0xff009DB7)
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.pen),
                contentDescription = "Próximo",
                modifier = Modifier
                    .size(22.dp)
                    .padding(end = 8.dp),
                tint = Color(0xffF2AB32)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,

            cursorColor = Color.White,
            focusedLabelColor = Color(0xffABBBCB),
            unfocusedLabelColor = Color(0xffABBBCB)
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun RepeticaoTextField() {
    TextField(
        value = "",
        onValueChange = {},
        label = {
            Text(
                "Repetição",
                color = Color(0xffABBBCB),
                fontFamily = PoppinsMedium,
                fontSize = 14.sp
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.repeticao),
                contentDescription = "Repetição",
                modifier = Modifier.size(22.dp),
                tint = Color(0xff009DB7)
            )
        },
        trailingIcon = {
            Text("Nunca", modifier = Modifier.padding(end = 8.dp))
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,

            cursorColor = Color.White,
            focusedLabelColor = Color(0xffABBBCB),
            unfocusedLabelColor = Color(0xffABBBCB)
        ),
        modifier = Modifier.fillMaxWidth(),
        readOnly = true
    )
}

@Composable
fun AlertasTextField() {
    TextField(
        value = "",
        onValueChange = {},
        label = {
            Text(
                "Alertas",
                color = Color(0xffABBBCB),
                fontFamily = PoppinsMedium,
                fontSize = 14.sp
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.alertas),
                contentDescription = "Alertas",
                modifier = Modifier.size(22.dp),
                tint = Color(0xff009DB7)
            )
        },
        trailingIcon = {
            Text(
                "15 minutos antes",
                color = Color(0xffF5F6F7),
                fontFamily = PoppinsRegular,
                fontSize = 14.sp,
                modifier = Modifier.padding(end = 8.dp)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,

            cursorColor = Color.White,
            focusedLabelColor = Color(0xffABBBCB),
            unfocusedLabelColor = Color(0xffABBBCB)
        ),
        modifier = Modifier.fillMaxWidth(),
        readOnly = true
    )
}

@Composable
fun PrivadoRow(isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp), // Ajustar padding para manter consistência
    ) {
        Icon(
            painter = painterResource(id = R.drawable.privado),
            contentDescription = "Privado",
            modifier = Modifier.size(22.dp),
            tint = Color(0xff009DB7)
        )
        Text(
            text = "Privado",
            color = Color(0xffABBBCB),
            fontFamily = PoppinsMedium,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 20.dp) // Ajustar padding para manter consistência
        )
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xff30CAE3),
                uncheckedThumbColor = Color(0xffF5F6F7),
                checkedTrackColor = Color(0xff253746),
                uncheckedTrackColor = Color(0xff253746),
                checkedBorderColor = Color(0xff30CAE3),
                uncheckedBorderColor = Color(0xffF5F6F7)
            ),
            modifier = Modifier.scale(0.75f)
        )
    }
}

@Composable
fun CategoriaTextField() {
    TextField(
        value = "",
        onValueChange = {},
        label = {
            Text(
                "Categoria",
                color = Color(0xffABBBCB),
                fontFamily = PoppinsMedium,
                fontSize = 14.sp
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.categoria),
                contentDescription = "Categoria",
                modifier = Modifier.size(22.dp),
                tint = Color(0xff009DB7)
            )
        },
        trailingIcon = {
            Text(
                "Nenhuma",
                color = Color(0xffF5F6F7),
                fontFamily = PoppinsRegular,
                fontSize = 14.sp,
                modifier = Modifier.padding(end = 8.dp)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,

            cursorColor = Color.White,
            focusedLabelColor = Color(0xffABBBCB),
            unfocusedLabelColor = Color(0xffABBBCB)
        ),
        modifier = Modifier.fillMaxWidth(),
        readOnly = true
    )
}

@Composable
fun AnexosTextField() {
    TextField(
        value = "",
        onValueChange = {},
        label = {
            Text(
                "Anexos",
                color = Color(0xffABBBCB),
                fontFamily = PoppinsMedium,
                fontSize = 14.sp
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.attach),
                contentDescription = "Anexos",
                modifier = Modifier.size(22.dp),
                tint = Color(0xff009DB7)
            )
        },
        trailingIcon = {
            Text(
                "1 Anexo disponível",
                color = Color(0xff009DB7),
                fontFamily = PoppinsMedium,
                fontSize = 14.sp,
                modifier = Modifier.padding(end = 8.dp)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = Color.White,
            focusedLabelColor = Color(0xffABBBCB),
            unfocusedLabelColor = Color(0xffABBBCB)
        ),
        modifier = Modifier.fillMaxWidth(),
        readOnly = true
    )
}
