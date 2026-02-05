package com.luizalebs.comunicacao_api.infraestructure.client.config;

import com.luizalebs.comunicacao_api.infraestructure.exceptions.BusinessException;
import com.luizalebs.comunicacao_api.infraestructure.exceptions.EmailException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response){

        String mensagemErro = mensagemErro(response);

        switch (response.status()){
            case 403:
                return new EmailException("Erro:" + mensagemErro);
            default:
                return new BusinessException("Erro: " + mensagemErro);
        }
    }

    private String mensagemErro(Response response){
        try {
            if(Objects.isNull(response.body())){
                return "";
            }
            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
