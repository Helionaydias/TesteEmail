package br.com.fiap.email.screens

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.fiap.email.componentes.*
import br.com.fiap.email.repository.EmailRepository
import br.com.fiap.email.viewModel.CaixaDeEntradaViewModel
import br.com.fiap.email.viewModel.CaixaDeEntradaViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaDeEntradaScreen(navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    var remetenteState by remember { mutableStateOf("") }

    val context = LocalContext.current
    val emailRepository = EmailRepository(context)
    val viewModel: CaixaDeEntradaViewModel = viewModel(
        factory = CaixaDeEntradaViewModelFactory(emailRepository)
    )
    val emails by viewModel.emails.collectAsState()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navController, drawerState)
        }
    ) {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopBar(navController, scrollBehavior, scope, drawerState)
            },
            floatingActionButton = {
                NovaMensagemFAB(navController)
            },
            content = { innerPadding ->
                CaixaDeEntradaContent(
                    emails = emails,
                    remetenteState = remetenteState,
                    onValueChange = { remetenteState = it },
                    onSearch = { viewModel.searchEmailsByRemetente(remetenteState) },
                    innerPadding = innerPadding
                )
            }
        )
    }
}
