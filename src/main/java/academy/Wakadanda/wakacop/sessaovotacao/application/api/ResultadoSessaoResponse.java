package academy.Wakadanda.wakacop.sessaovotacao.application.api;

import academy.Wakadanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import academy.Wakadanda.wakacop.sessaovotacao.domain.StatusSessaoVotacao;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
public class ResultadoSessaoResponse {
    private UUID id;
    private UUID IdPauta;
    private StatusSessaoVotacao status;
    private LocalDateTime momentoAbertura;
    private LocalDateTime momentoEncerramento;
    private Long totalVotos;
    private Long totalSim;
    private Long totalNao;

    public ResultadoSessaoResponse(SessaoVotacao sessao) {
        this.id = sessao.getId();
        IdPauta = sessao.getIdPauta();
        this.momentoAbertura = sessao.getMomentoAbertura();
        this.momentoEncerramento = sessao.getMomentoEncerramento();
        this.status = sessao.getStatus();
        this.totalNao = sessao.getTotalNao();
        this.totalSim = sessao.getTotalSim();
        this.totalVotos = sessao.getTotalVotos();
    }
}
