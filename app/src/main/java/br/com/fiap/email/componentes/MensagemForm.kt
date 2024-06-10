package br.com.fiap.email.componentes

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import br.com.fiap.email.R

@Composable
fun MensagemForm(
    textfield: String,
    textfield2: String,
    textfield3: String,
    textfield4: String,
    textfield5: String,
    onTextFieldChange: (String) -> Unit,
    onTextField2Change: (String) -> Unit,
    onTextField3Change: (String) -> Unit,
    onTextField4Change: (String) -> Unit,
    onTextField5Change: (String) -> Unit,
    showCcAndCco: Boolean,
    onShowCcAndCcoChange: (Boolean) -> Unit
) {
    TextField(
        value = textfield,
        onValueChange = onTextFieldChange,
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
        onValueChange = onTextField2Change,
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
            IconButton(onClick = { onShowCcAndCcoChange(!showCcAndCco) }) {
                Icon(
                    painter = painterResource(id = R.drawable.forward),
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
            onValueChange = onTextField3Change,
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
            onValueChange = onTextField4Change,
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
        onValueChange = onTextField5Change,
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


