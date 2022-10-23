package pe.isil.proyectoparcial.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DatosDireccion {
    private String nroDocumento;
    private String direccion;
    private String distrito;
}
