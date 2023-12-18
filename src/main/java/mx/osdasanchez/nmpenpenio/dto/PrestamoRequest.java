package mx.osdasanchez.nmpenpenio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PrestamoRequest {
    private Integer materialId;
    private Double gramos;
}
