package com.uade.tpo.Models;
import java.util.ArrayList;
import java.util.List;
import com.uade.tpo.EstadoPartido.IEstadoPartido;
import com.uade.tpo.Emparejamiento.IEmparejamiento;
import com.uade.tpo.Restriccion.IRestriccion;

public class Partido {
    private final Long id;
    private final Zona zona;
    private final List<Usuario> participantes = new ArrayList<>();
    private IEstadoPartido estado;

    public Partido(Long id, Zona zona, IEstadoPartido iEstadoPartido) {
        this.id = id;
        this.zona = zona;
        this.estado = zona.estadoInicial();
    }
    public Long getId() { return id; }
    public List<Usuario> getParticipantes() { return List.copyOf(participantes); }
    public IEstadoPartido getEstado() { return estado; }

    public void addParticipante(Usuario usuario) {
        participantes.add(usuario);
        this.estado = zona.proximoEstado(participantes.size());
    }

    public void iniciar(IEmparejamiento emparejamiento, List<IRestriccion> restricciones) {
        if (!(estado instanceof Confirmado)) {
            throw new IllegalStateException("Partido no confirmado para iniciar");
        }
        participantes.removeIf(u -> !restricciones.stream().allMatch(r -> r.aplica(u)));
        emparejamiento.emparejar(participantes);
        this.estado = new EnJuego();
    }

    public void finalizar() {
        this.estado = new Finalizado();
    }

    public void cancelar() {
        this.estado = new Cancelado();
    }
}
