package pe.isil.proyectoparcial.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DatosContacto {
    private String nroDocumento;
    private String nroCelular;
    private String correo;
}
