package br.com.fiap.email.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.R
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.email.ui.theme.PoppinsBold
import br.com.fiap.email.ui.theme.PoppinsMedium

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MensagemScreen(navController: NavController) {
    var scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    var textfield by remember {
        mutableStateOf("")
    }
    var textfield2 by remember {
        mutableStateOf("")
    }
    var textfield3 by remember {
        mutableStateOf("")
    }
    var textfield4 by remember {
        mutableStateOf("")
    }
    var textfield5 by remember {
        mutableStateOf("")
    }

    var showCcAndCco by remember { mutableStateOf(false) }


        Scaffold(
            modifier = Modifier
                .nestedScroll(scrollBehavior.nestedScrollConnection)
                .background(Color(0xFF253746)),

            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        Color(0xFF253746)

                    ),
                    title = {
                        Text("Nova mensagem",
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
                                contentDescription = "ícone fechar mensagem",
                                tint = Color(0xFFF5F6F7),
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                painter = painterResource(id = br.com.fiap.email.R.drawable.enviar),
                                contentDescription = "ícone enviar mensagem",
                                tint = Color(0xFF30CAE3),
                                modifier = Modifier.size(width = 20.dp, height = 16.dp)
                            )
                        }
                    },

                    scrollBehavior = scrollBehavior,

                )


            },



        ) { innerPadding ->
            Box ( modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .imePadding()
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()


                ) {
                    TextField(
                        value =textfield,
                        onValueChange = {novoValor ->
                            textfield = novoValor
                        },
                        placeholder = {
                            Text(text = "Assunto")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF172938)),
                        colors = TextFieldDefaults.colors(
                            unfocusedIndicatorColor = Color(0xff172938),
                            focusedIndicatorColor = Color.Transparent,
                            cursorColor = Color(0xffF5F6F7),
                            unfocusedPlaceholderColor = Color(0xffABBBCB),

                            ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        )

                    )
                    TextField(
                        value =textfield2,
                        onValueChange = {novoValor ->
                            textfield2 = novoValor
                        },
                        placeholder = {
                            Text(text = "Para:")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF172938)),
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
                            IconButton(onClick = { showCcAndCco = !showCcAndCco}) {

                            }
                            Icon(painter = painterResource(id = br.com.fiap.email.R.drawable.forward),
                                contentDescription = "Ícone Novo email",
                                modifier = Modifier.size(16.dp),
                                tint = Color(0xff30CAE3),
                            )
                        }

                    )

                    if (showCcAndCco){

                        TextField(
                            value =textfield3,
                            onValueChange = {novoValor ->
                                textfield3 = novoValor
                            },
                            placeholder = {
                                Text(text = "Cc")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFF172938)),
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
                            value =textfield4,
                            onValueChange = {novoValor ->
                                textfield4 = novoValor
                            },
                            placeholder = {
                                Text(text = "Cco")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFF172938)),
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
                        value =textfield5,
                        onValueChange = {novoValor ->
                            textfield5 = novoValor
                        },

                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFF25384A)),
                        colors = TextFieldDefaults.colors(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                        ),

                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Default
                        ),
                        maxLines = Int.MAX_VALUE

                    )


                }

                BottomAppBar(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .background(Color(0xFF172938))
                        .imePadding()
                        .navigationBarsPadding(),
                    actions = {
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.attach),
                            contentDescription = "Buscar",
                            tint = Color.White,
                            modifier = Modifier.size(34.dp)
                        )
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.camera),
                            contentDescription = "Buscar",
                            tint = Color.White,
                            modifier = Modifier.size(34.dp)
                        )
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.align_left),
                            contentDescription = "Buscar",
                            tint = Color.White,
                            modifier = Modifier.size(34.dp)
                        )
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.align_justify),
                            contentDescription = "Buscar",
                            tint = Color.White,
                            modifier = Modifier.size(34.dp)
                        )
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.align_right),
                            contentDescription = "Buscar",
                            tint = Color.White,
                            modifier = Modifier.size(34.dp)
                        )
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.bold),
                            contentDescription = "Buscar",
                            tint = Color.White,
                            modifier = Modifier.size(34.dp)
                        )
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.italic),
                            contentDescription = "Buscar",
                            tint = Color.White,
                            modifier = Modifier.size(34.dp)
                        )
                        Icon(
                            painter = painterResource(id = br.com.fiap.email.R.drawable.underline),
                            contentDescription = "Buscar",
                            tint = Color.White,
                            modifier = Modifier.size(34.dp)
                        )


                    }
                )
            }
        }

}