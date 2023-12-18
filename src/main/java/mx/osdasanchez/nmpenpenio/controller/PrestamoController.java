package mx.osdasanchez.nmpenpenio.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.osdasanchez.nmpenpenio.dto.PrestamoDto;
import mx.osdasanchez.nmpenpenio.dto.PrestamoRequest;
import mx.osdasanchez.nmpenpenio.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prestamo")
@Tag(name = "prestamo", description = "Prestamo API para obtener el monto  del prestamo," +
        " evaluando el material y el peso del articulo.")
public class PrestamoController {

    private final PrestamoService prestamoService;

    @Autowired
    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @Operation(summary = "Obtiene el monto del prestamo")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "obtiene el monto de prestamo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PrestamoDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "recurso no encontrado", content = @Content)})
    @PostMapping(value = "/monto",
            produces = MediaType.APPLICATION_JSON_VALUE,
            headers = "Accept=" + MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrestamoDto> getMontoPrestamo(@RequestBody final PrestamoRequest prestamoRequest) {
        this.prestamoService.getPrestamo(prestamoRequest);
        return null;
    }
}
