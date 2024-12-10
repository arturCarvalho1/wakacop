package academy.Wakadanda.wakacop.pauta.infra;

import academy.Wakadanda.wakacop.pauta.application.repository.PautaRepository;
import academy.Wakadanda.wakacop.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PautaInfraRepository implements PautaRepository {
    private final PautaSpringDataJPARepository pautaSpringDataJPARepository;

    @Override
    public Pauta salva(Pauta pauta) {
        log.info("[inicia] PautaInfraRepository - salva");
        pautaSpringDataJPARepository.save(pauta);
        log.info("[inicia] PautaInfraRepository - salva");
        return pauta;
    }

    @Override
    public Pauta buscaPorId(UUID idPauta) {
        log.info("[inicia] PautaInfraRepository - buscaPorId");
        Pauta pautaPorId = pautaSpringDataJPARepository.findById(idPauta)
                        .orElseThrow(() -> new RuntimeException("Pauta não encontrada!"));
        log.info("[finaliza] PautaInfraRepository - buscaPorId");
        return pautaPorId;
    }
}
