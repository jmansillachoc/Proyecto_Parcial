package pe.isil.proyectoparcial.infrastructure.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasicResponse {

    private int code;
    private String message;


    public static BasicResponse whenSuccess(){
        return BasicResponse.builder()
                .code(200)
                .message("Success")
                .build();
    }
    public static BasicResponse registerSuccess(){
        return BasicResponse.builder()
                .code(200)
                .message("Registro Exitoso")
                .build();
    }

    public static BasicResponse whenCreate(){
        return BasicResponse.builder()
                .code(201)
                .message("Create")
                .build();
    }
    public static BasicResponse datosDireccion(){
        return BasicResponse.builder()
                .code(201)
                .message("Direccion Existe")
                .build();
    }
    public static BasicResponse datosContacto(){
        return BasicResponse.builder()
                .code(201)
                .message("Contacto Existe")
                .build();
    }

    public static BasicResponse whenPassNotMatch(){
    return BasicResponse.builder()
        .code(500)
        .message("Password o apikey incorrecto")
        .build();
    }

    public static BasicResponse whenInactive(){
        return BasicResponse.builder()
                .code(500)
                .message("Cliente Inactivo")
                .build();
    }

    public static BasicResponse whenError(String message){
        return BasicResponse.builder()
                .code(500)
                .message(message)
                .build();
    }

    public static BasicResponse whenNoDataFound(String resource){
        return BasicResponse.builder()
                .code(404)
                .message("No "+resource +" found")
                .build();
    }
    public static BasicResponse whenNoDataDireccion(){
        return BasicResponse.builder()
                .code(404)
                .message("Direccion no existe")
                .build();
    }
    public static BasicResponse whenNoDataContacto(){
        return BasicResponse.builder()
                .code(404)
                .message("Contacto no existe")
                .build();
    }
}