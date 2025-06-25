package com.uade.tpo.Services.impl;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.DTO.PartidoDTO;
import com.uade.tpo.DTO.UsuarioDTO;
import com.uade.tpo.storage.IPartidoRepository;
import com.uade.tpo.storage.IZonaRepository;
import com.uade.tpo.Services.IPartidoService;
import com.uade.tpo.Restriccion.IRestriccion;
import com.uade.tpo.Emparejamiento.IEmparejamiento;
import java.util.*;
import java.util.stream.Collectors;

public class PartidoService implements IPartidoService {
    private final IPartidoRepository partidoRepo;
    private final IZonaRepository zonaRepo;
    private final Map<Long, IRestriccion> restriccionMap;
    private final Map<Long, IEmparejamiento> empMap;
    public PartidoService(IPartidoRepository pr, IZonaRepository zr,
                         Map<Long,IRestriccion> restrMap,
                         Map<Long,IEmparejamiento> empMap) {
        this.partidoRepo = pr; this.zonaRepo = zr;
        this.restriccionMap = restrMap; this.empMap = empMap;
    }
    @Override
    public PartidoDTO crearPartido(Long zonaId) {
        var z = zonaRepo.findById(zonaId).orElseThrow();
        var p = new Partido(z, z.estadoInicial());
        partidoRepo.save(p);
        return PartidoDTO.fromModel(p);
    }
    @Override
    public List<UsuarioDTO> agregarYEmparejar(Long partidoId, UsuarioDTO uDto,
        List<Long> restriccionIds, Long empId) {
        var p = partidoRepo.findById(partidoId).orElseThrow();
        var u = new Usuario(uDto.id, uDto.nombre, uDto.email, uDto.fechaRegistro, uDto.nivel, 0, null);
        p.addParticipante(u);
        var restricciones = restriccionIds.stream().map(restriccionMap::get).collect(Collectors.toList());
        p.iniciar(empMap.get(empId), restricciones);
        partidoRepo.save(p);
        return p.getParticipantes().stream()
            .map(UsuarioDTO::fromModel).collect(Collectors.toList());
    }
    @Override
    public PartidoDTO iniciarPartido(Long partidoId, List<Long> restriccionIds, Long empId) {
        var p = partidoRepo.findById(partidoId).orElseThrow();
        var restricciones = restriccionIds.stream().map(restriccionMap::get).collect(Collectors.toList());
        p.iniciar(empMap.get(empId), restricciones);
        partidoRepo.save(p);
        return PartidoDTO.fromModel(p);
    }
}
