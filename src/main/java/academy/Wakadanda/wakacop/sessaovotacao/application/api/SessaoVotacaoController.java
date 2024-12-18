package academy.Wakadanda.wakacop.sessaovotacao.application.api;

import academy.Wakadanda.wakacop.sessaovotacao.application.service.SessaoVotacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class SessaoVotacaoController implements SessacaoVotacaoAPI{
    private final SessaoVotacaoService sessaoVotacaoService;

    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.info("[inicia] SessaoVotacaoController - abreSessao");
        SessaoAberturaResponse sessaoAberturaResponse = sessaoVotacaoService.abreSessao(sessaoAberturaRequest);
        log.info("[finaliza] SessaoVotacaoController - abreSessao");
        return sessaoAberturaResponse;
    }

    @Override
    public VotoResponse recebeVoto(UUID idSessao,VotoRequest novoVoto) {
        log.info("[inicia] SessaoVotacaoController - recebeVoto");
        log.info("[idSessao] {}", idSessao);
        VotoResponse votoResponse = sessaoVotacaoService.recebeVoto(idSessao, novoVoto);
        log.info("[finaliza] SessaoVotacaoController - recebeVoto");
        return votoResponse;
    }
}
