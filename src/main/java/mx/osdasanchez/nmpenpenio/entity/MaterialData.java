package mx.osdasanchez.nmpenpenio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "materiales")
public class MaterialData {
    private String name;
    private Double price;
}
