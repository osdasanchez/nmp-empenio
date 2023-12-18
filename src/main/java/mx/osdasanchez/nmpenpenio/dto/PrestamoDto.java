package mx.osdasanchez.nmpenpenio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PrestamoDto {
    private String material;
    private Double gramos;
    private Double prestamo;
}
