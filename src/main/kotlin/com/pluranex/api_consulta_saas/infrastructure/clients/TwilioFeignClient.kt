package com.pluranex.api_consulta_saas.infrastructure.clients

import com.pluranex.api_consulta_saas.infrastructure.responses.TwilioResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "twilioClient",
    url = "\${twilio.api.url}"
)
interface TwilioFeignClient {

    @PostMapping("/Messages.json")
    fun enviarMensagem(
        @RequestParam("To") destinatario: String,
        @RequestParam("From") remetente: String,
        @RequestParam("Body") mensagem: String
    ): TwilioResponse
}
