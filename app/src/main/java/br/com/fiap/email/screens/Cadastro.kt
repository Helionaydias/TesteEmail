package br.com.fiap.email.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.email.R
import br.com.fiap.email.ui.theme.PoppinsBold
import br.com.fiap.email.ui.theme.PoppinsMedium
import br.com.fiap.email.ui.theme.PoppinsSemiBold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreen(navController: NavController) {

    var nome by remember { mutableStateOf("") }
    var dominio by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }
    var senhaVisible by remember { mutableStateOf(false) }
    var confirmarSenhaVisible by remember { mutableStateOf(false) }
    var senhaError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff253746))
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    painter = painterResource(id = R.drawable.seta_left),
                    contentDescription = "ícone voltar",
                    tint = Color(0xffFFFFFF),
                    modifier = Modifier.size(18.dp, 20.dp)
                )
            }

            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "Ajuda",
                    color = Color(0xff00ACC8),
                    fontFamily = PoppinsSemiBold,
                    textDecoration = TextDecoration.Underline // Linha abaixo do texto "Ajuda"
                )
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_locaweb),
                contentDescription = "Logo Locaweb",
                modifier = Modifier.height(40.dp).size(150.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.email),
                contentDescription = "Ícone de Email",
                modifier = Modifier.size(34.dp).align(Alignment.Bottom)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Crie sua conta",
                fontSize = 20.sp,
                color = Color(0xffF5F6F7),
                fontFamily = PoppinsBold,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Insira seus dados abaixo para criar",
                fontSize = 13.sp,
                color = Color(0xffF5F6F7),
                fontFamily = PoppinsMedium,
                textAlign = TextAlign.Center
            )
            Text(
                text = "sua conta de e-mail da locaweb",
                fontSize = 13.sp,
                color = Color(0xffF5F6F7),
                fontFamily = PoppinsMedium,
                textAlign = TextAlign.Center
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Nome completo",
                    fontSize = 13.sp,
                    color = Color(0xffF5F6F7),
                    fontFamily = PoppinsMedium,
                )

                OutlinedTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xffe0e0e0), shape = RoundedCornerShape(10.dp)),
                    placeholder = {
                        Text(
                            text = "Nome completo",
                            fontSize = 13.5.sp,
                            color = Color(0xff606A73),
                            fontFamily = PoppinsMedium,
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        cursorColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedPlaceholderColor = Color.Transparent,
                        unfocusedPlaceholderColor = Color.Transparent,

                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Dominio",
                    fontSize = 13.sp,
                    color = Color(0xffF5F6F7),
                    fontFamily = PoppinsMedium,
                )

                OutlinedTextField(
                    value = dominio,
                    onValueChange = { dominio = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xffe0e0e0), shape = RoundedCornerShape(10.dp)),
                    placeholder = {
                        Text(
                            text = "seunome@locaweb.me",
                            fontSize = 13.5.sp,
                            color = Color(0xff606A73),
                            fontFamily = PoppinsMedium,
                        )
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.email),
                            contentDescription = "Ícone de Email",
                            tint = Color(0xffF00843),
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        cursorColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedPlaceholderColor = Color.Transparent,
                        unfocusedPlaceholderColor = Color.Transparent,

                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Crie uma senha",
                    fontSize = 13.sp,
                    color = Color(0xffF5F6F7),
                    fontFamily = PoppinsMedium,
                )

                OutlinedTextField(
                    value = senha,
                    onValueChange = { senha = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xffe0e0e0), shape = RoundedCornerShape(10.dp)),
                    placeholder = {
                        Text(
                            text = "Insira sua senha",
                            fontSize = 13.5.sp,
                            color = Color(0xff606A73),
                            fontFamily = PoppinsMedium,
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            senhaVisible = !senhaVisible
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.eye),
                                tint = Color(0xffF00843),
                                modifier = Modifier.size(24.dp),
                                contentDescription = if (senhaVisible) "Hide password" else "Show password"
                            )
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = if (senhaVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        cursorColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedPlaceholderColor = Color.Transparent,
                        unfocusedPlaceholderColor = Color.Transparent,

                    )
                )

                Text(
                    text = "A senha deve conter ao menos 8 caracteres",
                    fontSize = 9.sp,
                    color = Color(0xffF5F6F7),
                    fontFamily = PoppinsMedium,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Confirme sua senha",
                    fontSize = 13.sp,
                    color = Color(0xffF5F6F7),
                    fontFamily = PoppinsMedium,
                )

                OutlinedTextField(
                    value = confirmarSenha,
                    onValueChange = { confirmarSenha = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xffe0e0e0), shape = RoundedCornerShape(10.dp)),
                    placeholder = {
                        Text(
                            text = "Confirme sua senha",
                            fontSize = 13.5.sp,
                            color = Color(0xff606A73),
                            fontFamily = PoppinsMedium,
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            confirmarSenhaVisible = !confirmarSenhaVisible
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.eye),
                                tint = Color(0xffF00843),
                                modifier = Modifier.size(24.dp),
                                contentDescription = if (confirmarSenhaVisible) "Hide password" else "Show password"
                            )
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = if (confirmarSenhaVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        cursorColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedPlaceholderColor = Color.Transparent,
                        unfocusedPlaceholderColor = Color.Transparent,

                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        if (senha.length < 8) {
                            senhaError = true
                        } else {
                            senhaError = false
                            navController.navigate("login")
                        }
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xff176276)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 42.dp)
                ) {
                    Text(
                        text = "PRÓXIMO",
                        textAlign = TextAlign.Center,
                        color = Color(0xffF5F6F7),
                        fontSize = 14.sp,
                        fontFamily = PoppinsMedium,
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(70.dp, 7.dp)
                            .background(Color(0xFFF2AB32), shape = RoundedCornerShape(10.dp))
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Box(
                        modifier = Modifier
                            .size(70.dp, 7.dp)
                            .background(Color(0xFF584F3F), shape = RoundedCornerShape(10.dp))
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Box(
                        modifier = Modifier
                            .size(70.dp, 7.dp)
                            .background(Color(0xFF584F3F), shape = RoundedCornerShape(10.dp))
                    )
                }
            }
        }
    }
}
