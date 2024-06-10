package br.com.fiap.email.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.email.R
import br.com.fiap.email.ui.theme.PoppinsBold
import br.com.fiap.email.ui.theme.PoppinsMedium
import br.com.fiap.email.ui.theme.PoppinsSemiBold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }
    val tamanhoSenha = 8

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff253746)) // Fundo verde
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { /*TODO*/ }) {
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
                    textDecoration = TextDecoration.Underline
                )
            }
        }

        // Adicionando o logo no topo
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_locaweb),
                contentDescription = "Logo Locaweb",
                modifier = Modifier
                    .height(40.dp)
                    .size(170.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.email), // Certifique-se de ter este recurso no diretório drawable
                contentDescription = "Ícone de Email",
                modifier = Modifier
                    .size(34.dp)
                    .align(Alignment.Bottom)
            )
        }

        Text(
            text = "Iniciar sessão",
            fontSize = 20.sp,
            color = Color(0xffF5F6F7),
            fontFamily = PoppinsBold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Insira seus dados para fazer o login",
            fontSize = 12.sp,
            color = Color(0xffF5F6F7),
            fontFamily = PoppinsMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(48.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = "Nome de usuário ou e-mail",
                    fontSize = 13.sp,
                    color = Color(0xffF5F6F7),
                    fontFamily = PoppinsMedium,
                )
                Spacer(modifier = Modifier.height(4.dp)) // Adicionando espaçamento de 4dp entre o texto e o OutlinedTextField
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                        if (email.isNotEmpty()) emailError = false
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xffDBE1E7), shape = RoundedCornerShape(10.dp)),
                    placeholder = {
                        Text(
                            text = "Insira usuário ou e-mail",
                            fontSize = 13.5.sp,
                            color = Color(0xff606A73),
                            fontFamily = PoppinsMedium,
                        )
                    },
                    textStyle = LocalTextStyle.current.copy(color = Color.Black), // Adicionando a cor do texto aqui
                    isError = emailError,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent,
                        cursorColor = Color.Black,
                    )
                )
                if (emailError) {
                    Text(
                        text = "E-mail é obrigatório!",
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Red,
                        textAlign = TextAlign.End
                    )
                }
                Spacer(modifier = Modifier.height(21.dp))
                Text(
                    text = "Senha",
                    fontSize = 13.sp,
                    color = Color(0xffF5F6F7),
                    fontFamily = PoppinsMedium,
                )
                Spacer(modifier = Modifier.height(4.dp)) // Adicionando espaçamento de 4dp entre o texto e o OutlinedTextField
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        if (it.length <= tamanhoSenha) password = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xffDBE1E7), shape = RoundedCornerShape(10.dp)),
                    placeholder = {
                        Text(
                            text = "Insira sua senha",
                            fontSize = 13.5.sp,
                            color = Color(0xff606A73),
                            fontFamily = PoppinsMedium,
                        )
                    },
                    textStyle = LocalTextStyle.current.copy(color = Color.Black), // Adicionando a cor do texto aqui
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisible = !passwordVisible
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.eye),
                                modifier = Modifier.size(24.dp),
                                tint = Color(0xffF00843),
                                contentDescription = if (passwordVisible) "Hide password" else "Show password"
                            )
                        }
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent,
                        cursorColor = Color.Black,
                    )
                )
                Spacer(modifier = Modifier.height(105.dp))
                Button(
                    onClick = {
                        if (email.isEmpty()) {
                            emailError = true
                        } else {
                            // Navegue para a tela de caixa de entrada ao clicar em "INICIAR SESSÃO"
                            navController.navigate("caixadeentrada")
                        }
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xffF00843)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "INICIAR SESSÃO",
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Center,
                        color = Color(0xffF5F6F7),
                        fontSize = 14.sp,
                        fontFamily = PoppinsMedium,
                    )
                }
                Spacer(modifier = Modifier.height(22.dp))
                TextButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "Esqueci minha senha",
                        color = Color(0xff00ACC8),
                        fontFamily = PoppinsSemiBold,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
    }
}
