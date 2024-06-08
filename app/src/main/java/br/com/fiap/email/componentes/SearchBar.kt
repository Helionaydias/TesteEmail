package br.com.fiap.email.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.email.R
import br.com.fiap.email.ui.theme.PoppinsMedium

@Composable
fun SearchBar(
    remetenteState: String,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit
) {
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
                onValueChange = onValueChange,
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
                textStyle = TextStyle(color = Color(0xFF606A73))
            )
        }
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color(0xff253746), shape = RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            IconButton(onClick = onSearch) {
                Icon(
                    painter = painterResource(id = R.drawable.search_24),
                    contentDescription = "Buscar",
                    tint = Color.White,
                    modifier = Modifier.size(34.dp)
                )
            }
        }
    }
}
