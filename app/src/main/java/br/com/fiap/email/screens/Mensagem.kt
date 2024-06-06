package br.com.fiap.email.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.email.repository.EmailRepository
import br.com.fiap.email.model.Email
import br.com.fiap.email.ui.theme.PoppinsBold
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MensagemScreen(navController: NavController, context: Context) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val emailRepository = EmailRepository(context)
    val coroutineScope = rememberCoroutineScope()

    var textfield by remember { mutableStateOf("") }
    var textfield2 by remember { mutableStateOf("") }
    var textfield3 by remember { mutableStateOf("") }
    var textfield4 by remember { mutableStateOf("") }
    var textfield5 by remember { mutableStateOf("") }
    var showCcAndCco by remember { mutableStateOf(false) }
    val imePadding = WindowInsets.ime.asPaddingValues()

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .padding(imePadding),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xff253746),
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Nova mensagem",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFF5F6F7),
                        fontFamily = PoppinsBold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("caixadeentrada") }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Ícone fechar mensagem",
                            tint = Color(0xFFF5F6F7),
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        coroutineScope.launch {//cria um novo email e salva no banco de dados
                            val email = Email(
                                remetente = "seu_email@dominio.com",
                                assunto = textfield,
                                detalhe = textfield5,
                                imagem = null,
                                data = "2024-06-04",
                                time = "10:00",
                                isleia = false
                            )
                            emailRepository.salvar(email)
                            navController.navigate("caixadeentrada")
                        }
                    }) {
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.enviar),
                            contentDescription = "Ícone enviar mensagem",
                            tint = Color(0xFF30CAE3),
                            modifier = Modifier.size(width = 20.dp, height = 16.dp)
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
        bottomBar = {
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
                            painter = painterResource(id = br.com.fiap.email.R.drawable.attach),
                            contentDescription = "Buscar",
                            tint = Color(0xff30CAE3),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.camera),
                            contentDescription = "Buscar",
                            tint = Color(0xff30CAE3),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.align_left),
                            contentDescription = "Buscar",
                            tint =  Color(0xff30CAE3),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.align_justify),
                            contentDescription = "Buscar",
                            tint =  Color(0xff30CAE3),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.align_right),
                            contentDescription = "Buscar",
                            tint =  Color(0xff30CAE3),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.bold),
                            contentDescription = "Buscar",
                            tint = Color(0xff30CAE3),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.italic),
                            contentDescription = "Buscar",
                            tint = Color(0xff30CAE3),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.underline),
                            contentDescription = "Buscar",
                            tint = Color(0xff30CAE3),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFF253746))
        ) {
            TextField(
                value = textfield,
                onValueChange = { novoValor -> textfield = novoValor },
                placeholder = { Text(text = "Assunto") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color(0xff172938),
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = Color(0xffF5F6F7),
                    unfocusedPlaceholderColor = Color(0xffABBBCB)
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
            TextField(
                value = textfield2,
                onValueChange = { novoValor -> textfield2 = novoValor },
                placeholder = { Text(text = "Para:") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color(0xff172938),
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = Color(0xffF5F6F7),
                    unfocusedPlaceholderColor = Color(0xffF5F6F7)
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                trailingIcon = {
                    IconButton(onClick = { showCcAndCco = !showCcAndCco }) {
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.forward),
                            contentDescription = "Ícone Novo email",
                            modifier = Modifier.size(16.dp),
                            tint = Color(0xff30CAE3),
                        )
                    }
                }
            )

            if (showCcAndCco) {
                TextField(
                    value = textfield3,
                    onValueChange = { novoValor -> textfield3 = novoValor },
                    placeholder = { Text(text = "Cc") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        unfocusedIndicatorColor = Color(0xff172938),
                        focusedIndicatorColor = Color.Transparent,
                        cursorColor = Color(0xffF5F6F7),
                        unfocusedPlaceholderColor = Color(0xffF5F6F7)
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    )
                )
                TextField(
                    value = textfield4,
                    onValueChange = { novoValor -> textfield4 = novoValor },
                    placeholder = { Text(text = "Cco") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        unfocusedIndicatorColor = Color(0xff172938),
                        focusedIndicatorColor = Color.Transparent,
                        cursorColor = Color(0xffF5F6F7),
                        unfocusedPlaceholderColor = Color(0xffF5F6F7)
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Done
                    )
                )
            }

            TextField(
                value = textfield5,
                onValueChange = { novoValor -> textfield5 = novoValor },
                modifier = Modifier.fillMaxSize(),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Default
                ),
                maxLines = Int.MAX_VALUE,
            )
        }
    }
}
