package br.com.fiap.email.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import br.com.fiap.email.model.Email
import br.com.fiap.email.repository.EmailRepository

class MensagemViewModel(private val emailRepository: EmailRepository) : ViewModel() {

    fun salvarEmail(email: Email, onSuccess: () -> Unit, onError: (Exception) -> Unit) {
        viewModelScope.launch {
            try {
                emailRepository.salvar(email)
                onSuccess()
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
}

class MensagemViewModelFactory(
    private val emailRepository: EmailRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MensagemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MensagemViewModel(emailRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
