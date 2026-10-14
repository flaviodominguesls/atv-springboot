package biblioteca.biblioteca.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "tb_autor")
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("isbn")
    private Long isbn;

    @Column(name = "ds_tituloLivro", nullable = false)
    @JsonProperty("tituloLivro")
    private String tituloLivro;

    @Column(name = "ds_autorLivro", nullable = false)
    @JsonProperty("autorLivro")
    private String autorLivro;

    @Column(name = "ds_anoLivro", nullable = false)
    @JsonProperty("anoLivro")
    private String anoLivro;

    @Column(name = "ds_edicaoLivro", nullable = false)
    @JsonProperty("edicaoLivro")
    private String edicaoLivro;
    
}
