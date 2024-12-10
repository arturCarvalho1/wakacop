package academy.Wakadanda.wakacop.pauta.application.service;

import academy.Wakadanda.wakacop.pauta.application.api.NovaPautaRequest;
import academy.Wakadanda.wakacop.pauta.application.api.PautaCadastradaResponse;
import academy.Wakadanda.wakacop.pauta.application.repository.PautaRepository;
import academy.Wakadanda.wakacop.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class PautaApplicationService implements PautaService {
    private final PautaRepository pautaRepository;

    @Override
    public PautaCadastradaResponse CadastraPauta(NovaPautaRequest novaPauta) {
        log.info("[inicia] PautaApplicationService - CadastraPauta");
        log.info("[novaPauta] {}",novaPauta);
        Pauta pauta = pautaRepository.salva(new Pauta(novaPauta));
        log.info("[inicia] PautaApplicationService - CadastraPauta");
        return new PautaCadastradaResponse(pauta);
    }

    @Override
    public Pauta getPautaPorId(UUID idPauta) {
        log.info("[inicia] PautaApplicationService - getPautaPorId");
        Pauta pautaPorId = pautaRepository.buscaPorId(idPauta);
        log.info("[inicia] PautaApplicationService - getPautaPorId");
        return pautaPorId;
    }
}
