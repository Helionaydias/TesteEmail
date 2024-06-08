package br.com.fiap.email.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.fiap.email.model.Email

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaDeEntradaContent(
    emails: List<Email>,
    remetenteState: String,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit,
    innerPadding: PaddingValues
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF253746))
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(22.dp))
        SearchBar(
            remetenteState = remetenteState,
            onValueChange = onValueChange,
            onSearch = onSearch
        )
        FilterSection()
        Spacer(modifier = Modifier.height(8.dp))
        EmailList(emails)
    }
}
