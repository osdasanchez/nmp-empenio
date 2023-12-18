package mx.osdasanchez.nmpenpenio.services;

import mx.osdasanchez.nmpenpenio.dto.PrestamoDto;
import mx.osdasanchez.nmpenpenio.dto.PrestamoRequest;

public interface PrestamoService {
    PrestamoDto getPrestamo(PrestamoRequest prestamoRequest);
}
