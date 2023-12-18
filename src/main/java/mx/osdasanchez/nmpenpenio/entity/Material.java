package mx.osdasanchez.nmpenpenio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "materiales")
public class Material {

    private ObjectId id;
    private Integer material_id;
    private MaterialData material;
}
