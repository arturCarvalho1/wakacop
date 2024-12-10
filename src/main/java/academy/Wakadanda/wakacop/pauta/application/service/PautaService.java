package academy.Wakadanda.wakacop.pauta.application.service;

import academy.Wakadanda.wakacop.pauta.application.api.NovaPautaRequest;
import academy.Wakadanda.wakacop.pauta.application.api.PautaCadastradaResponse;
import org.springframework.stereotype.Service;

@Service
public interface PautaService {
    PautaCadastradaResponse CadastraPauta(NovaPautaRequest novaPauta);
}
