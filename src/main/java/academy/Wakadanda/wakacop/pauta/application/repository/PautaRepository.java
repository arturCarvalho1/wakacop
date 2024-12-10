package academy.Wakadanda.wakacop.pauta.application.repository;

import academy.Wakadanda.wakacop.pauta.domain.Pauta;

import java.util.UUID;

public interface PautaRepository {
    Pauta salva(Pauta pauta);
    Pauta buscaPorId(UUID idPauta);
}
