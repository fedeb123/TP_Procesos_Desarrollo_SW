package com.uade.tpo.controllers;
import com.uade.tpo.DTO.PartidoDTO;
import com.uade.tpo.DTO.UsuarioDTO;
import com.uade.tpo.Services.IPartidoService;
import java.util.List;

public class PartidoController {
    private final IPartidoService service;
    public PartidoController(IPartidoService svc){ this.service = svc; }
    public PartidoDTO crear(Long zonaId) {
        return service.crearPartido(zonaId);
    }
    public List<UsuarioDTO> agregarYEmparejar(Long partidoId, UsuarioDTO u,
            List<Long> restricciones, Long empId) {
        return service.agregarYEmparejar(partidoId, u, restricciones, empId);
    }
    public PartidoDTO iniciar(Long partidoId, List<Long> restricciones, Long empId) {
        return service.iniciarPartido(partidoId, restricciones, empId);
    }
}
