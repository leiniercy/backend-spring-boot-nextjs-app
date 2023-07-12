/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.backend.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;
import lombok.*;

/**
 *
 * @author Admin
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book extends AbstractEntity {

    @Schema(
            description = "Book title",
            example = "Introduction of the web programing",
            required = true
    )
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[ a-zA-Z0-9 À-ÿ\\u00f1\\u00d1 /#@$¿?!¡()-_,.]*)*[a-zA-Z0-9 À-ÿ\\u00f1\\u00d1 /#@$¿?!¡()-_,. ]+$", message = "El título es incorrecto, solo puede utlizar los siguientes caracteres especiales /#@$¿?!¡()-_,.")
    @Size(min = 2, max = 255, message = "Debe tener mínimo 2 caracteres")
    @Column(nullable = false)
    private String title;

    @Schema(
            description = "Author of the book",
            example = "Jhon Deep",
            required = true
    )
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$", message = "El nombre del autor es incorrecto, use solo letras")
    @Size(min = 2, max = 255, message = "Debe tener mínimo 2 caracteres")
    @Column(nullable = false)
    private String author;

    @Schema(
            description = "Book price",
            example = "10.0",
            minimum = "0",
            maximum = "inifinite",
            required = true
    )
    @NotNull(message = "Campo requerido")
    @Min(message = "Mínimo 0", value = 0)
    @Column(nullable = false)
    private float price;
}
