package academy.Wakadanda.wakacop.pauta.application.service;

import academy.Wakadanda.wakacop.pauta.application.api.NovaPautaRequest;
import academy.Wakadanda.wakacop.pauta.application.api.PautaCadastradaResponse;
import academy.Wakadanda.wakacop.pauta.domain.Pauta;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface PautaService {
    PautaCadastradaResponse CadastraPauta(NovaPautaRequest novaPauta);
    Pauta getPautaPorId( UUID idPauta);
}
