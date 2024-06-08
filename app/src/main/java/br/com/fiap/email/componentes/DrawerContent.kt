package br.com.fiap.email.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.email.R
import br.com.fiap.email.ui.theme.PoppinsBold
import br.com.fiap.email.ui.theme.PoppinsRegular
import br.com.fiap.email.ui.theme.PoppinsSemiBold
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(navController: NavController, drawerState: DrawerState) {
    ModalDrawerSheet(modifier = Modifier.fillMaxWidth(0.80f)) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xff172938))
                    .padding(vertical = 20.dp, horizontal = 14.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(0xffF00843)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "G",
                            color = Color(0xffF5F6F7),
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(0xff176276)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "+",
                            color = Color(0xffFFFFFF),
                            fontWeight = FontWeight.Bold,
                            fontFamily = PoppinsRegular
                        )
                    }
                }
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                ) {
                    IconButton(onClick = { /* Navegar para configurações */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.configuracao),
                            contentDescription = "Configurações",
                            tint = Color(0xff00ACC8),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    IconButton(onClick = { /* Navegar para ajuda */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ajuda),
                            contentDescription = "Ajuda",
                            tint = Color(0xff00ACC8),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .weight(3f)
                    .background(Color(0xff253746))
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight()
            ) {
                Text(
                    text = "Gabriel Carvalho",
                    color = Color(0xffF5F6F7),
                    modifier = Modifier.padding(top = 12.dp, bottom = 4.dp),
                    style = TextStyle(
                        color = Color(0xffF5F6F7),
                        fontFamily = PoppinsBold
                    )
                )
                Text(
                    text = "gabriel.carvalho@example.com",
                    color = Color(0xffC0D5E7),
                    modifier = Modifier.padding(bottom = 16.dp),
                    style = TextStyle(
                        color = Color(0xffC0D5E7),
                        fontSize = 12.sp,
                        fontFamily = PoppinsRegular
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Divider(color = Color(0xff172938),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding( top = 8.dp, bottom = 8.dp)

                ){
                    Text(
                        text = "Favoritos",
                        style = TextStyle(color = Color(0xffD9D9D9)),
                        fontFamily = PoppinsSemiBold,
                        fontSize = 12.sp

                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(id = R.drawable.pen),
                        contentDescription = "Favoritos",
                        tint = Color(0xffF2AB32),

                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(10.dp)
                    )

                }
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 8.dp)

                ) {

                    DrawerMenuItem(navController, "Caixa de entrada", R.drawable.caixaentrada, "caixaDeEntrada", drawerState)

                }


                    DrawerMenuItem(navController, "Enviados", R.drawable.enviados, "enviados", drawerState)
                Spacer(modifier = Modifier.height(16.dp))
                Divider(color = Color(0xff172938),  modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding( top = 8.dp, bottom = 8.dp)

                ) {

                    Text(
                        text = "Pastas",
                        style = TextStyle(color = Color(0xffFFFFFF)),
                        fontFamily = PoppinsSemiBold,
                        fontSize = 12.sp

                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(id = R.drawable.pen),
                        contentDescription = "Pastas",
                        tint = Color(0xffF2AB32),

                        modifier = Modifier
                            .size(10.dp)
                    )


                }

                DrawerMenuItem(navController, "Rascunhos", R.drawable.rascunho, "rascunhos", drawerState)
                    DrawerMenuItem(navController, "Favoritos", R.drawable.favoritos, "favoritos", drawerState)
                    DrawerMenuItem(navController, "Arquivados", R.drawable.arquivados, "arquivados", drawerState)
                    DrawerMenuItem(navController, "Spam", R.drawable.span, "spam", drawerState)
                    DrawerMenuItem(navController, "Excluídos", R.drawable.excluidos, "excluidos", drawerState)
                    DrawerMenuItem(navController, "Calendário", R.drawable.calendario, "calendario", drawerState)
                    DrawerMenuItem(navController, "Notas", R.drawable.notas, "notas", drawerState)

            }
        }
    }
}
