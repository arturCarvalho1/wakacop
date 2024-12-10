package academy.Wakadanda.wakacop.sessaovotacao.application.service;

import academy.Wakadanda.wakacop.pauta.application.repository.PautaRepository;
import academy.Wakadanda.wakacop.pauta.application.service.PautaService;
import academy.Wakadanda.wakacop.pauta.domain.Pauta;
import academy.Wakadanda.wakacop.sessaovotacao.application.api.SessaoAberturaRequest;
import academy.Wakadanda.wakacop.sessaovotacao.application.api.SessaoAberturaResponse;
import academy.Wakadanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoApplicatioService implements SessaoVotacaoService{
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PautaService pautaService;

    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.info("[inicia] SessaoVotacaoApplicatioService - abreSessao");
        Pauta pauta = pautaService.getPautaPorId(sessaoAberturaRequest.getIdPauta());
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.salva(new SessaoVotacao(sessaoAberturaRequest, pauta));
        log.info("[finaliza] SessaoVotacaoApplicatioService - abreSessao");
        return new SessaoAberturaResponse(sessaoVotacao);
    }
}
