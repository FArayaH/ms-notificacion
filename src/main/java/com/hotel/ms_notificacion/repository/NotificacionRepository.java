package com.hotel.ms_notificacion.repository;
import com.hotel.ms_notificacion.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long>{
    // Método para filtrar notificaciones por su estado
    List<Notificacion> findByEstado(String estado);


}
