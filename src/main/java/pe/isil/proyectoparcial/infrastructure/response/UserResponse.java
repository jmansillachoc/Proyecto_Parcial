package pe.isil.proyectoparcial.infrastructure.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

     private Object datosCliente;
     private BasicResponse basicResponse;

}
