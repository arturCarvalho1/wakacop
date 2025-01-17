package academy.Wakadanda.wakacop.pauta.application.api;

import academy.Wakadanda.wakacop.pauta.application.service.PautaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PautaController implements PautaAPI{
    private final PautaService pautaService;

    @Override
    public PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta) {
        log.info("[inicia] PautaController - cadastraPauta");
        PautaCadastradaResponse pautaCadastrada = pautaService.CadastraPauta(novaPauta);
        log.info("[finaliza] PautaController - cadastraPauta");
        return pautaCadastrada;
    }
}
