package br.com.fiap.email.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import br.com.fiap.email.model.Email
import br.com.fiap.email.repository.EmailRepository

class CaixaDeEntradaViewModel(private val emailRepository: EmailRepository) : ViewModel() {

    private val _emails = MutableStateFlow<List<Email>>(emptyList())
    val emails: StateFlow<List<Email>> = _emails

    init {
        loadEmails()
    }

    private fun loadEmails() {
        viewModelScope.launch {
            _emails.value = emailRepository.listarTodosOsEmails()
        }
    }

    fun searchEmailsByRemetente(remetente: String) {
        viewModelScope.launch {
            _emails.value = emailRepository.getEmailsByRemetente(remetente)
        }
    }
}

class CaixaDeEntradaViewModelFactory(
    private val emailRepository: EmailRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CaixaDeEntradaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CaixaDeEntradaViewModel(emailRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
