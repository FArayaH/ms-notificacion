package com.hotel.ms_notificacion.service;

import com.hotel.ms_notificacion.dto.NotificacionRequestDTO;
import com.hotel.ms_notificacion.dto.NotificacionResponseDTO;
import com.hotel.ms_notificacion.model.Notificacion;
import com.hotel.ms_notificacion.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificacionService {
    @Autowired
    private NotificacionRepository notificacionRepository;

    // Metodo 1: Enviar una notificación nueva
    public NotificacionResponseDTO enviarNotificacion(NotificacionRequestDTO requestDTO) {

        Notificacion notificacion = new Notificacion();
        notificacion.setReservaId(requestDTO.getReservaId());
        notificacion.setDestinatarioCorreo(requestDTO.getDestinatarioCorreo());
        notificacion.setTipoNotificacion(requestDTO.getTipoNotificacion());
        notificacion.setMensaje(requestDTO.getMensaje());

        // El sistema asigna la hora exacta en la que se genera la alerta
        notificacion.setFechaEnvio(LocalDateTime.now());
        notificacion.setEstado("ENVIADO");

        Notificacion guardada = notificacionRepository.save(notificacion);
        return convertirAResponseDTO(guardada);
    }

    // Metodo 2: Obtener todas las notificaciones
    public List<NotificacionResponseDTO> obtenerTodas() {
        return notificacionRepository.findAll().stream()
                .map(this::convertirAResponseDTO)
                .collect(Collectors.toList());
    }

    // Metodo 3: Obtener notificaciones filtradas por estado (Para Postman)
    public List<NotificacionResponseDTO> obtenerPorEstado(String estado) {
        return notificacionRepository.findByEstado(estado).stream()
                .map(this::convertirAResponseDTO)
                .collect(Collectors.toList());
    }

    // Metodo auxiliar para no repetir código
    private NotificacionResponseDTO convertirAResponseDTO(Notificacion noti) {
        return new NotificacionResponseDTO(
                noti.getId(), noti.getReservaId(), noti.getDestinatarioCorreo(),
                noti.getTipoNotificacion(), noti.getMensaje(),
                noti.getFechaEnvio(), noti.getEstado()
        );
    }
}
