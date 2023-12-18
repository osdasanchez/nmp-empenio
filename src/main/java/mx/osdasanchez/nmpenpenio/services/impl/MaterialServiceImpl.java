package mx.osdasanchez.nmpenpenio.services.impl;

import mx.osdasanchez.nmpenpenio.dao.MaterialDao;
import mx.osdasanchez.nmpenpenio.dto.MaterialDataDto;
import mx.osdasanchez.nmpenpenio.dto.MaterialDto;
import mx.osdasanchez.nmpenpenio.entity.Material;
import mx.osdasanchez.nmpenpenio.entity.MaterialData;
import mx.osdasanchez.nmpenpenio.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialDao materialDao;

    @Autowired
    public MaterialServiceImpl(MaterialDao materialDao) {
        this.materialDao = materialDao;
    }

    @Override
    public List<MaterialDto> getAllMaterials() {
        List<MaterialDto> materialDtoList = new ArrayList<>();
        List<Material> materialList = this.materialDao.getAllMaterials();
        if (materialList != null && !materialList.isEmpty()) {
            materialList.forEach(material -> {
                MaterialDto materialDto = new MaterialDto();
                MaterialDataDto materialDataDto = new MaterialDataDto();
                materialDataDto.setName(material.getMaterial().getName());
                materialDataDto.setPrice(material.getMaterial().getPrice());
                materialDto.setId(material.getMaterial_id());
                materialDto.setMaterial(materialDataDto);
                materialDtoList.add(materialDto);
            });
        }
        return materialDtoList;
    }

    @Override
    public MaterialDto getMaterialById(Integer id) {
        MaterialDto materialDto = new MaterialDto();
        Material material = this.materialDao.getMaterialById(id);
        if (material != null) {
            MaterialDataDto materialDataDto = new MaterialDataDto();
            materialDataDto.setName(material.getMaterial().getName());
            materialDataDto.setPrice(material.getMaterial().getPrice());
            materialDto.setId(material.getMaterial_id());
            materialDto.setMaterial(materialDataDto);
        }

        return materialDto;
    }
}
