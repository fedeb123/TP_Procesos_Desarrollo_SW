package com.uade.tpo.DTO;
import java.util.List;
import java.util.stream.Collectors;
public class PartidoDTO {
    public Long id;
    public Long zonaId;
    public List<UsuarioDTO> participantes;
    public String estado;
    public static PartidoDTO fromModel(Partido p) {
        PartidoDTO d = new PartidoDTO();
        d.id = p.getId(); d.zonaId = p.getZona().getId();
        d.estado = p.getEstado().name();
        d.participantes = p.getParticipantes().stream()
            .map(UsuarioDTO::fromModel).collect(Collectors.toList());
        return d;
    }
}
