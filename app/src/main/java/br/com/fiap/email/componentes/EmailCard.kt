package br.com.fiap.email.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.email.model.Email

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
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
                    color = Color(0xffFFFFFF)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = email.time,
                    textAlign = TextAlign.End,
                    fontSize = 10.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
                    color = Color(0xff009DB7),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }

            Text(
                text = email.assunto,
                textAlign = TextAlign.Start,
                fontSize = 12.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold,
                color = Color(0xffFFFFFF)
            )

            Text(
                text = email.detalhe,
                textAlign = TextAlign.Start,
                fontSize = 10.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                color = Color(0xffA8B2BA)
            )
        }
    }
}
