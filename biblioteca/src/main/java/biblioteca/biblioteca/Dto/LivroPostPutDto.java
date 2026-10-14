package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroPostPutDto {

    @JsonProperty("tituloLivro")
    @NotBlank(message = "titulo nao pode ser vazio")
    private String tituloLivro;

    @JsonProperty("autorLivro")
    @NotBlank(message = "nome do autor nao pode ser vazio")
    private String autorLivro;

    @JsonProperty("anoLivro")
    @NotBlank(message = "ano nao pode ser vazio")
    private String anoLivro;

    @JsonProperty("edicaoLivro")
    @NotBlank(message = "edicao nao pode ser vazia")
    private String edicaoLivro;
}
