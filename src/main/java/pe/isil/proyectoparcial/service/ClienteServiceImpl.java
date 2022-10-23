package pe.isil.proyectoparcial.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.proyectoparcial.entity.Cliente;
import pe.isil.proyectoparcial.entity.DatosContacto;
import pe.isil.proyectoparcial.entity.DatosDireccion;
import pe.isil.proyectoparcial.infrastructure.repository.ClienteRepository;
import pe.isil.proyectoparcial.infrastructure.request.UserRequest;
import pe.isil.proyectoparcial.infrastructure.response.BasicResponse;
import pe.isil.proyectoparcial.infrastructure.response.UserResponse;

import java.util.List;

@Log4j2
@Service
public class ClienteServiceImpl implements ClienteService {

  private static final String PASSWORD = "123456";

  @Autowired private ClienteRepository clienteRepository;

  @Override
  public BasicResponse addCliente(UserRequest request) {
    try {
      if (request.getApikey().equals(PASSWORD)) {
        clienteRepository.save(this.buildClienteFromRequest(request));
        return BasicResponse.registerSuccess();
      } else {
        return BasicResponse.whenPassNotMatch();
      }
    } catch (Exception e) {
      log.error(e.getMessage());
      return BasicResponse.whenError(e.getMessage());
    }
  }

  @Override
  public UserResponse getDireccionByNroDocumento(String nroDocumento) {
    try {
      Cliente cliente = clienteRepository.findByNroDocumento(nroDocumento);
      if (!cliente.isEstado()){
        return UserResponse.builder()
                .datosCliente(null)
                .basicResponse(BasicResponse.whenInactive())
                .build();
      }
      if (cliente != null) {
        return UserResponse.builder()
                .datosCliente(buildClienteDatosDireccion(cliente))
                .basicResponse(BasicResponse.datosDireccion())
                .build();
      } else {
        return UserResponse.builder()
                .datosCliente(null)
                .basicResponse(BasicResponse.whenNoDataDireccion())
                .build();
      }

    } catch (Exception e) {
      return UserResponse.builder()
              .datosCliente(null)
              .basicResponse(BasicResponse.whenError(e.getMessage()))
              .build();
    }
  }

  @Override
  public UserResponse getContactoByNroDocumento(String nroDocumento) {
    try {
      Cliente cliente = clienteRepository.findByNroDocumento(nroDocumento);

      if (!cliente.isEstado()){
        return UserResponse.builder()
                .datosCliente(null)
                .basicResponse(BasicResponse.whenInactive())
                .build();
      }
        if (cliente != null) {
        return UserResponse.builder()
            .datosCliente(buildClienteDatosContacto(cliente))
            .basicResponse(BasicResponse.datosContacto())
            .build();
            }else{
                return UserResponse.builder()
                  .datosCliente(null)
                  .basicResponse(BasicResponse.whenNoDataContacto())
                  .build();
                }

    } catch (Exception e) {
      return UserResponse.builder()
          .datosCliente(null)
          .basicResponse(BasicResponse.whenError(e.getMessage()))
          .build();
    }

  }

  private Cliente buildClienteFromRequest(UserRequest request) {
    return Cliente.builder()
        .nombres(request.getNombres())
        .apellidos(request.getApellidos())
        .nroCelular(request.getNroCelular())
        .correo(request.getCorreo())
        .direccion(request.getDireccion())
        .distrito(request.getDistrito())
        .nroDocumento(request.getNroDocumento())
        .estado(request.isEstado())
        .build();
  }

  private DatosContacto buildClienteDatosContacto(Cliente cliente) {
    return DatosContacto.builder()
        .nroDocumento(cliente.getNroDocumento())
        .nroCelular(cliente.getNroCelular())
        .correo(cliente.getCorreo())
        .build();
  }
  private DatosDireccion buildClienteDatosDireccion(Cliente cliente) {
    return DatosDireccion.builder()
            .nroDocumento(cliente.getNroDocumento())
            .direccion(cliente.getDireccion())
            .distrito(cliente.getDistrito())
            .build();
  }

}
