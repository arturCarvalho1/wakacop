package academy.Wakadanda.wakacop.pauta.application.service;

import academy.Wakadanda.wakacop.pauta.application.api.NovaPautaRequest;
import academy.Wakadanda.wakacop.pauta.application.api.PautaCadastradaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PautaApplicationService implements PautaService {
    @Override
    public PautaCadastradaResponse CadastraPauta(NovaPautaRequest novaPauta) {
        log.info("[inicia] PautaApplicationService - CadastraPauta");
        log.info("[novaPauta] {}",novaPauta);
        log.info("[inicia] PautaApplicationService - CadastraPauta");
        return null;
    }
}
