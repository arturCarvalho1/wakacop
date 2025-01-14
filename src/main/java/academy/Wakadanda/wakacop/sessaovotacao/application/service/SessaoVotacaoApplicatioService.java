package academy.Wakadanda.wakacop.sessaovotacao.application.service;

import academy.Wakadanda.wakacop.associado.application.service.AssociadoService;
import academy.Wakadanda.wakacop.pauta.application.service.PautaService;
import academy.Wakadanda.wakacop.pauta.domain.Pauta;
import academy.Wakadanda.wakacop.sessaovotacao.application.api.*;
import academy.Wakadanda.wakacop.sessaovotacao.domain.PublicadorResultadoSessao;
import academy.Wakadanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import academy.Wakadanda.wakacop.sessaovotacao.domain.VotoPauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoApplicatioService implements SessaoVotacaoService{
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PautaService pautaService;
    private final AssociadoService associadoService;
    private final PublicadorResultadoSessao publicadorResultadoSessao;

    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.debug("[inicia] SessaoVotacaoApplicatioService - abreSessao");
        Pauta pauta = pautaService.getPautaPorId(sessaoAberturaRequest.getIdPauta());
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.salva(new SessaoVotacao(sessaoAberturaRequest, pauta));
        log.debug("[finaliza] SessaoVotacaoApplicatioService - abreSessao");
        return new SessaoAberturaResponse(sessaoVotacao);
    }

    @Override
    public VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto) {
        log.debug("[inicia] SessaoVotacaoApplicatioService - recebeVoto");
        SessaoVotacao sessao = sessaoVotacaoRepository.buscaPorId(idSessao);
        VotoPauta voto = sessao.recebeVoto(novoVoto,associadoService, publicadorResultadoSessao);
        sessaoVotacaoRepository.salva(sessao);
        log.debug("[finaliza] SessaoVotacaoApplicatioService - recebeVoto");
        return new VotoResponse(voto);
    }

    @Override
    public ResultadoSessaoResponse obtemResultado(UUID idSessao) {
        log.debug("[inicia] SessaoVotacaoApplicatioService - obtemResultado");
        SessaoVotacao sessao = sessaoVotacaoRepository.buscaPorId(idSessao);
        ResultadoSessaoResponse resultado = sessao.obtemResultado(publicadorResultadoSessao);
        sessaoVotacaoRepository.salva(sessao);
        log.debug("[finaliza] SessaoVotacaoApplicatioService - obtemResultado");
        return resultado;
    }
}
