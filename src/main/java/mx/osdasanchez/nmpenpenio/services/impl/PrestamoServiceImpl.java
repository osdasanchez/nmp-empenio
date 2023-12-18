package mx.osdasanchez.nmpenpenio.services.impl;

import mx.osdasanchez.nmpenpenio.dao.MaterialDao;
import mx.osdasanchez.nmpenpenio.dto.PrestamoDto;
import mx.osdasanchez.nmpenpenio.dto.PrestamoRequest;
import mx.osdasanchez.nmpenpenio.entity.Material;
import mx.osdasanchez.nmpenpenio.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrestamoServiceImpl implements PrestamoService {
    private final MaterialDao materialDao;

    @Autowired
    public PrestamoServiceImpl(MaterialDao materialDao) {
        this.materialDao = materialDao;
    }

    @Override
    public PrestamoDto getPrestamo(PrestamoRequest prestamoRequest) {
        PrestamoDto prestamoDto = new PrestamoDto();
        if (prestamoRequest != null) {
            Integer materialId = prestamoRequest.getMaterialId();
            Double grams = prestamoRequest.getGramos();
            Material material = this.materialDao.getMaterialById(materialId);
            if (material != null && grams != null && grams > 0) {
                Double avaluo = material.getMaterial().getPrice() * grams;
                Double prestamo = avaluo * 0.8;
                prestamoDto.setMaterial(material.getMaterial().getName());
                prestamoDto.setGramos(grams);
                prestamoDto.setPrestamo(prestamo);
            }
        }
        return prestamoDto;
    }
}
