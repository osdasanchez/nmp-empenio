package mx.osdasanchez.nmpenpenio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MaterialDto {
    private Integer id;
    private MaterialDataDto material;
}
