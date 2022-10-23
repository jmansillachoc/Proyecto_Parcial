package pe.isil.proyectoparcial.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.isil.proyectoparcial.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
 public Cliente findByNroDocumento(String nroDocumento);
 public Cliente findByNroDocumentoAndEstado(String nroDocumento,int estado);
}
