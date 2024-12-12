package academy.Wakadanda.wakacop.sessaovotacao.application.api;

import academy.Wakadanda.wakacop.sessaovotacao.domain.OpcaoVoto;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VotoRequest {
    private String cpfAssociado;
    private OpcaoVoto opcao;
}
