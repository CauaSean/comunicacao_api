package com.luizalebs.comunicacao_api.infraestructure.client;


import com.luizalebs.comunicacao_api.api.dto.TarefasDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name= "notificacao", url = "${notificacao.url}")
public interface notificacaoClient {

    @PostMapping
    ResponseEntity<Void> enviarEmail(@RequestBody TarefasDTO dto);
}
