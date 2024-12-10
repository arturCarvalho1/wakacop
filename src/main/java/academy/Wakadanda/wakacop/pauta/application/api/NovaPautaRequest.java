package academy.Wakadanda.wakacop.pauta.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@ToString
public class NovaPautaRequest {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotNull
    private UUID idAssociadoAutor;

        public String getTitulo() {
            return titulo;
        }

        public String getDescricao() {
            return descricao;
        }

        public UUID getIdAssociadoAutor() {
            return idAssociadoAutor;
        }
    }


