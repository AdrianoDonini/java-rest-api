package br.com.fatecomerce.api.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Categoria {
    private Integer idCategoria;
    private String nomeCategoria;
    private String descricaoCategoria;

    public void test() {
        Categoria c = new Categoria(idCategoria = 1, nomeCategoria = "Tiago", descricaoCategoria="Viado");
    }
}
