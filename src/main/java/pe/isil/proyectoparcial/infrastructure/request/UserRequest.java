package pe.isil.proyectoparcial.infrastructure.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRequest {
    private Long id;
    private String nombres;
    private String apellidos;
    private String nroCelular;
    private String correo;
    private String direccion;
    private String distrito;
    private String nroDocumento;
    private boolean estado;
    private String apikey;
}
