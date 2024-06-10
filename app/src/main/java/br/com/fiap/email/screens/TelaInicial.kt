package br.com.fiap.email.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.email.R
import br.com.fiap.email.ui.theme.PoppinsBold
import br.com.fiap.email.ui.theme.PoppinsMedium

@Composable
fun InicialScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff253746)) // Fundo verde
            .padding(58.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        // Adicionando o logo e o ícone de email
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_locaweb),
                contentDescription = "Logo Locaweb",
                modifier = Modifier
                    .height(40.dp)
                    .size(171.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.email),
                contentDescription = "Ícone de Email",
                modifier = Modifier
                    .size(34.dp)
                    .align(Alignment.Bottom)
            )
        }

        Text(
            text = "Vamos começar?",
            fontSize = 24.sp,
            color = Color(0xffF5F6F7),
            fontFamily = PoppinsBold,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Escolha uma das opções abaixo:",
            fontSize = 10.sp,
            color = Color(0xffF5F6F7),
            fontFamily = PoppinsMedium,
            textAlign = TextAlign.Center
        )

        Button(
            onClick = {
                navController.navigate("login")
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xffF00843)),
            modifier = Modifier
                .fillMaxWidth()
                .pointerInput(Unit) {  } // Adiciona o modificador pointerInput

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

        Button(
            onClick = {
                navController.navigate("cadastro")
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff176276)),
            modifier = Modifier
                .fillMaxWidth()
                .pointerInput(Unit) {  } // Adiciona o modificador pointerInput

        ) {
            Text(
                text = "CRIAR UMA CONTA",
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center,
                color = Color(0xffF5F6F7),
                fontSize = 14.sp,
                fontFamily = PoppinsMedium,
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        val annotatedString = buildAnnotatedString {
            append("Eu concordo com os ")
            pushStringAnnotation(tag = "TOS", annotation = "https://www.locaweb.com.br/termos-servico")
            withStyle(style = SpanStyle(color = Color(0xff009DB7), textDecoration = TextDecoration.Underline)) {
                append("Termos de Serviço")
            }
            pop()
            append(" e a ")
            pushStringAnnotation(tag = "PP", annotation = "https://www.locaweb.com.br/politica-privacidade")
            withStyle(style = SpanStyle(color = Color(0xff009DB7), textDecoration = TextDecoration.Underline)) {
                append("Política de Privacidade")
            }
            pop()
            append(" da Locaweb.")
        }
        ClickableText(
            text = annotatedString,
            style = TextStyle(
                color = Color(0xffF5F6F7),
                fontSize = 12.sp,
                fontFamily = PoppinsMedium,
                textAlign = TextAlign.Center
            ),
            onClick = { offset ->
                annotatedString.getStringAnnotations(tag = "TOS", start = offset, end = offset)
                    .firstOrNull()?.let { annotation ->
                        // handle TOS link click
                    }
                annotatedString.getStringAnnotations(tag = "PP", start = offset, end = offset)
                    .firstOrNull()?.let { annotation ->
                        // handle PP link click
                    }
            },
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}
