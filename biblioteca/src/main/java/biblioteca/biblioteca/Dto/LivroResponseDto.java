package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroPostPutDto {

    @JsonProperty("isbn")
    private Long isbn;

    @JsonProperty("tituloLivro")
    private String tituloLivro;

    @JsonProperty("autorLivro")
    private String autorLivro;

    @JsonProperty("anoLivro")
    private String anoLivro;

    @JsonProperty("edicaoLivro")
    private String edicaoLivro;
}