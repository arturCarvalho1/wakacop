package academy.Wakadanda.wakacop.sessaovotacao.application.service;

import academy.Wakadanda.wakacop.sessaovotacao.application.api.SessaoAberturaRequest;
import academy.Wakadanda.wakacop.sessaovotacao.application.api.SessaoAberturaResponse;
import academy.Wakadanda.wakacop.sessaovotacao.application.api.VotoRequest;
import academy.Wakadanda.wakacop.sessaovotacao.application.api.VotoResponse;

import java.util.UUID;

public interface SessaoVotacaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);
    VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto);
}
