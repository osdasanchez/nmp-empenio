package mx.osdasanchez.nmpenpenio.services;

import mx.osdasanchez.nmpenpenio.dto.MaterialDto;
import mx.osdasanchez.nmpenpenio.entity.Material;

import java.util.List;

public interface MaterialService {
    public List<MaterialDto> getAllMaterials();

    public MaterialDto getMaterialById(Integer id);
}
