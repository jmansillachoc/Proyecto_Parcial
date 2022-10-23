package pe.isil.proyectoparcial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "Cliente")
@Table(name = "tb_cliente")

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombres;
  private String apellidos;
  private String nroCelular;
  private String correo;
  private String direccion;
  private String distrito;
  private String nroDocumento;
  private boolean estado;

}
