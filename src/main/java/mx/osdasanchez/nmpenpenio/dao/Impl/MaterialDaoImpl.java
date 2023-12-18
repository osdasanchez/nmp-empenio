package mx.osdasanchez.nmpenpenio.dao.Impl;


import mx.osdasanchez.nmpenpenio.dao.MaterialDao;
import mx.osdasanchez.nmpenpenio.entity.Material;
import mx.osdasanchez.nmpenpenio.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialDaoImpl implements MaterialDao {

    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialDaoImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }
    @Override
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    @Override
    public Material getMaterialById(Integer id) {
        return materialRepository.findByMaterial_id(id).orElse(null);
    }
}
