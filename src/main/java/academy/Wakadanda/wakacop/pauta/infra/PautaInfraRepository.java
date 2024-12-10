package academy.Wakadanda.wakacop.pauta.infra;

import academy.Wakadanda.wakacop.pauta.application.repository.PautaRepository;
import academy.Wakadanda.wakacop.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
