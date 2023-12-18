package mx.osdasanchez.nmpenpenio.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.osdasanchez.nmpenpenio.dto.MaterialDto;
import mx.osdasanchez.nmpenpenio.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/material")
@Tag(name = "material", description = "Material API para listar los materiales y sus precios en gramos")
public class MaterialController {

    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @Operation(summary = "Obtiene todos los materiales")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "materiales encontrados", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MaterialDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "materiales no encontrados", content = @Content)})
    @GetMapping(value = "/list")
    public ResponseEntity<List<MaterialDto>> gelAllMaterial() {

        List<MaterialDto> materialDtoList = this.materialService.getAllMaterials();

        return new ResponseEntity<>(materialDtoList, HttpStatus.OK);
    }

    @Operation(summary = "Obtiene el material por id")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "material encontrado", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MaterialDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "material no encontrado", content = @Content)})
    @GetMapping(value = "/{id}")
    public ResponseEntity<MaterialDto> getMaterialById(@Parameter(description = "id del material a buscar", required = true)
                                          @PathVariable("id") String id) {
        MaterialDto materialDto = this.materialService.getMaterialById(Integer.parseInt(id));
        return new ResponseEntity<>(materialDto, HttpStatus.OK);
    }
}
