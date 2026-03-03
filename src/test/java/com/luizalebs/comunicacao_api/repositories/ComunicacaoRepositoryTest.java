package com.luizalebs.comunicacao_api.repositories;


import com.luizalebs.comunicacao_api.api.dto.ComunicacaoInDTO;
import com.luizalebs.comunicacao_api.infraestructure.entities.ComunicacaoEntity;
import com.luizalebs.comunicacao_api.infraestructure.repositories.ComunicacaoRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static com.luizalebs.comunicacao_api.infraestructure.enums.ModoEnvioEnum.SMS;
import static com.luizalebs.comunicacao_api.infraestructure.enums.StatusNotificacaoEnum.ENVIADO;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class ComunicacaoRepositoryTest {

    @Autowired
    ComunicacaoRepository comunicacaoRepository;

    @Autowired
    EntityManager entityManager;

    LocalDateTime dataHoraEnvio = LocalDateTime.of(2026,02,26,15,10,10);
    @Test
    @DisplayName("Should get Comunicacao sucessfully from DB")
    void findByEmailDestinatarioSuccess() {
        String email = "caua12345@gmail.com";
        ComunicacaoInDTO data = new ComunicacaoInDTO(dataHoraEnvio, "Cauã", email, "99 99999999", "Aldemir poe pijama no jaum", SMS, ENVIADO);
        ComunicacaoEntity result =  this.comunicacaoRepository.findByEmailDestinatario(email);

        createComunicacao(data);

        assertThat(result).isNotNull(); assertThat(result.getEmailDestinatario()).isEqualTo(email);
    }

    private ComunicacaoEntity createComunicacao(ComunicacaoInDTO data){
        ComunicacaoEntity newComunicacao = new ComunicacaoEntity(data);
        this.entityManager.persist(newComunicacao);
        return newComunicacao;

    }
}
