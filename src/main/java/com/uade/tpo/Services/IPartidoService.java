package com.uade.tpo.Services;
import com.uade.tpo.DTO.PartidoDTO;
import com.uade.tpo.DTO.UsuarioDTO;
import java.util.List;
public interface IPartidoService {
    PartidoDTO crearPartido(Long zonaId);
    List<UsuarioDTO> agregarYEmparejar(Long partidoId, UsuarioDTO usuarioDto,
        List<Long> restriccionIds, Long emparejamientoId);
    PartidoDTO iniciarPartido(Long partidoId, List<Long> restriccionIds, Long emparejamientoId);
}
