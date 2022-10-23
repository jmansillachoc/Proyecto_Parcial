package pe.isil.proyectoparcial.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.isil.proyectoparcial.infrastructure.request.UserRequest;
import pe.isil.proyectoparcial.infrastructure.response.BasicResponse;
import pe.isil.proyectoparcial.infrastructure.response.UserResponse;
import pe.isil.proyectoparcial.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

  @Autowired private ClienteService clienteService;

  @GetMapping("/getcontact")
  public ResponseEntity<UserResponse> getContacto(
      @RequestParam(name = "nroDocumento", required = true) String nroDocumento) {
    UserResponse response = clienteService.getContactoByNroDocumento(nroDocumento);
    if (response.getBasicResponse().getCode() == 404) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.status(response.getBasicResponse().getCode()).body(response);
  }

  @GetMapping("/getaddress")
  public ResponseEntity<UserResponse> getDireccion(
      @RequestParam(name = "nroDocumento", required = true) String nroDocumento) {
    UserResponse response = clienteService.getDireccionByNroDocumento(nroDocumento);
    if (response.getBasicResponse().getCode() == 404) {
      return ResponseEntity.badRequest().body(null);
    }
    return ResponseEntity.status(response.getBasicResponse().getCode()).body(response);
  }

  @PostMapping("/addperson")
  public ResponseEntity<BasicResponse> addCliente(
          @RequestBody UserRequest request) {
    BasicResponse response = clienteService.addCliente(request);
    return ResponseEntity.status(response.getCode()).body(response);
  }
}
