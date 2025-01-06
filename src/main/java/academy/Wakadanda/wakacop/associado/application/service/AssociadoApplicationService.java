package academy.Wakadanda.wakacop.associado.application.service;

import academy.Wakadanda.wakacop.associado.infra.client.ConsultaCPFResponse;
import academy.Wakadanda.wakacop.associado.infra.client.SerproClientFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AssociadoApplicationService implements AssociadoService{
    private final SerproClientFeign serproClientFeign;
    @Override
    public void validaAssociadoAptoVoto(String cpfAssociado) {
        log.debug("[inicia] AssociadoApplicationService - validaAssociadoAptoVoto");
        ConsultaCPFResponse consultaCPFResponse = serproClientFeign.consultaCPF(TOKEN, cpfAssociado);
        valida(consultaCPFResponse);
        log.debug("[finaliza] AssociadoApplicationService - validaAssociadoAptoVoto");
    }

    private void valida(ConsultaCPFResponse consultaCPFResponse) {
        if (consultaCPFResponse.isInvalid()) {
            throw new RuntimeException("CPF associado invalido!");
        }
    }

    private static final String TOKEN = "Bearer 06aef429-a981-3ec5-a1f8-71d38d86481e";
}
