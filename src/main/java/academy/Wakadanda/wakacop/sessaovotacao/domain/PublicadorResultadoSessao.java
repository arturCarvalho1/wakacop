package academy.Wakadanda.wakacop.sessaovotacao.domain;

import academy.Wakadanda.wakacop.sessaovotacao.application.api.ResultadoSessaoResponse;

public interface PublicadorResultadoSessao {
    void publica(ResultadoSessaoResponse resultadoSessaoResponse);
}
