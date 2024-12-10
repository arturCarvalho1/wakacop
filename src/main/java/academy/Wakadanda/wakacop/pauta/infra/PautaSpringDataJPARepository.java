package academy.Wakadanda.wakacop.pauta.infra;

import academy.Wakadanda.wakacop.pauta.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PautaSpringDataJPARepository extends JpaRepository<Pauta, UUID> {
}
