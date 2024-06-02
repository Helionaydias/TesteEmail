package br.com.fiap.email.repository

import br.com.fiap.email.model.Email

fun getAllEmails(): List<Email> {
    return listOf(
        Email(
            id = 1,
            remetente = "Elena Flores SP",
            assunto = "Promoção de Dia das Mães",
            detalhe = "Aproveite o nosso cupom de desconto...",
            imagem = null,
            data = "2024-06-02",
            time = "15:46",
            isleia = false
        ),
        Email(
            id = 2,
            remetente = "Giovana Gusmão da Silva",
            assunto = "Acabou de postar no Instagram",
            detalhe = "Veja a mais nova postagem de Giovana...",
            imagem = null,
            data = "2024-06-02",
            time = "11:03",
            isleia = true
        ),
        Email(
            id = 3,
            remetente = "XBank",
            assunto = "Lembrete: Sua Fatura vence amanhã",
            detalhe = "Você pode pagar usando a sua conta...",
            imagem = null,
            data = "2024-06-02",
            time = "01:59",
            isleia = false
        ),
        Email(
            id = 4,
            remetente = "Sabrina Soares",
            assunto = "Você tem (1) nova mensagem!",
            detalhe = "Você recebeu uma mensagem de Sabrina...",
            imagem = null,
            data = "2024-06-01",
            time = "01:54",
            isleia = true
        )
    )
}
fun getEmailsByRemetente(remetente: String): List<Email>{
    return getAllEmails().filter{
       it.remetente.startsWith(prefix = remetente, ignoreCase = true)
    }
}