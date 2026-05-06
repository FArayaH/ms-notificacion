package com.hotel.ms_notificacion.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionResponseDTO {

    private Long id;
    private Long reservaId;
    private String destinatarioCorreo;
    private String tipoNotificacion;
    private String mensaje;
    private LocalDateTime fechaEnvio;
    private String estado;
}
