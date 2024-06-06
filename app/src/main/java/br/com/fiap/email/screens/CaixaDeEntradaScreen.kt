package br.com.fiap.email.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import br.com.fiap.email.R
import br.com.fiap.email.repository.EmailRepository
import br.com.fiap.email.ui.theme.PoppinsBold
import br.com.fiap.email.ui.theme.PoppinsMedium
import br.com.fiap.email.model.Email
import br.com.fiap.email.repository.getAllEmails
import br.com.fiap.email.repository.getEmailsByRemetente

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaDeEntradaScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    var remetenteState by remember {
        mutableStateOf("")
    }
    var listEmailByRemetente by remember {
        mutableStateOf(getEmailsByRemetente(remetenteState))
    }

    val context = LocalContext.current
    val emailRepository = EmailRepository(context)

    val listaDeEmails by remember {
        mutableStateOf(emailRepository.listarTodosOsEmails().also { emails ->
            Log.d("CaixaDeEntradaScreen", "Emails carregados: ${emails.size}")
        })
    }

    var email by remember {
        mutableStateOf("")
    }

    Scaffold(

        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(

                colors = TopAppBarDefaults.topAppBarColors(
                    Color(0xFF253746)
                ),

                title = {
                    Text("Caixa de entrada",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFF5F6F7),
                        fontFamily = PoppinsBold
                    )
                },



                navigationIcon = {
                    IconButton(onClick = { navController.navigate("menucaixadeentrada") }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "ícone menu",
                            tint = Color(0xFFF5F6F7),

                            )
                    }
                },

                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painter = painterResource(id =R.drawable.notifications_none_24),
                            contentDescription = "ícone notificação",
                            tint = Color(0xFFF5F6F7),

                            )
                    }
                },

                scrollBehavior = scrollBehavior,

                )


        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("mensagem") },
                containerColor = Color(0xFFF00843),
                contentColor = Color.White,
                shape = CircleShape,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
                modifier = Modifier
                    .size(80.dp)

            ) {
                Icon(painter = painterResource(id = R.drawable.pencil),
                    contentDescription = "Ícone Novo email",
                    modifier = Modifier.size(24.dp)
                )

            }

        },
        content = { innerPadding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF253746))
                    .padding(innerPadding)
            ) {
                Spacer(modifier = Modifier.height(22.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .background(Color(0xFFDBE1E7), shape = RoundedCornerShape(10.dp))
                    ) {
                        OutlinedTextField(
                            value = remetenteState,
                            onValueChange = { remetenteState = it },
                            singleLine = true,
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .fillMaxWidth(),
                            placeholder = {
                                Text(
                                    text = "Buscar por e-mail...",
                                    fontSize = 14.sp,
                                    fontFamily = PoppinsMedium,
                                    color = Color(0xFF606A73),
                                )
                            },
                            shape = RoundedCornerShape(10.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent,
                                cursorColor = Color(0xFF606A73)
                            ),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            textStyle = TextStyle(color = Color(0xFF606A73))
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clickable { /* Implement search action */ },
                        contentAlignment = Alignment.Center
                    ) {
                        IconButton(onClick = {  listEmailByRemetente = getEmailsByRemetente(remetenteState) }

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.search_24),
                                contentDescription = "Buscar",
                                tint = Color.White,
                                modifier = Modifier.size(34.dp)
                            )
                        }

                    }
                }


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
                        ),

                        ) {
                        Text(
                            "Filtrar",
                            fontSize = 14.sp
                        )
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
                                Text(
                                    "Destaques",
                                    fontSize = 14.sp
                                )
                            }



                            Button(
                                onClick = { },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xffDBE1E7),
                                    contentColor = Color(0xFF253746)
                                )
                            ) {
                                Text(
                                    text = "Outros",
                                    fontSize = 14.sp,

                                    )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Lista de emails
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {

                    items( listEmailByRemetente){
                        EmailCard(
                            email = it,


                            )
                    }
                }

            }
        }
    )
}
@Composable
fun EmailCard(email: Email) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color(0xFFF00843)),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = email.remetente.first().toString(),
                textAlign = TextAlign.Center,
                fontSize = 17.sp,
                color = Color(0xffF5F6F7)
            )

        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = email.remetente,
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xffFFFFFF)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = email.time,
                    textAlign = TextAlign.End,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xff009DB7),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }

            Text(
                text = email.assunto,
                textAlign = TextAlign.Start,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xffFFFFFF)
            )

            Text(
                text = email.detalhe,
                textAlign = TextAlign.Start,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xffA8B2BA)
            )
        }
    }
}