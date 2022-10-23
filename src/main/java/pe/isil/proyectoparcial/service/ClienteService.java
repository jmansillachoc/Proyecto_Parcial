package pe.isil.proyectoparcial.service;

import pe.isil.proyectoparcial.infrastructure.request.UserRequest;
import pe.isil.proyectoparcial.infrastructure.response.BasicResponse;
import pe.isil.proyectoparcial.infrastructure.response.UserResponse;

public interface ClienteService {

    public BasicResponse addCliente(UserRequest request);
    public UserResponse getContactoByNroDocumento(String nroDocumento);
    public UserResponse getDireccionByNroDocumento(String nroDocumento);

}
