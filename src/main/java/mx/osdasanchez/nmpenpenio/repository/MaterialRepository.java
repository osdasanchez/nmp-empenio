package mx.osdasanchez.nmpenpenio.repository;

import mx.osdasanchez.nmpenpenio.entity.Material;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface MaterialRepository extends MongoRepository<Material, Integer> {
    @Query("{ 'material_id' : ?0 }")
    Optional<Material> findByMaterial_id(Integer material_id);
}
