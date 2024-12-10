package academy.Wakadanda.wakacop.pauta.application.api;

import academy.Wakadanda.wakacop.pauta.domain.Pauta;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;
@Getter
@ToString
public class PautaCadastradaResponse {
    private UUID id;

    public PautaCadastradaResponse(Pauta pauta) {
        this.id = pauta.getId();
    }
}
