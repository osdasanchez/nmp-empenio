package mx.osdasanchez.nmpenpenio.dao;

import mx.osdasanchez.nmpenpenio.entity.Material;

import java.util.List;

public interface MaterialDao {
    public List<Material> getAllMaterials();

    public Material getMaterialById(Integer id);
}
