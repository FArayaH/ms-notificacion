package com.hotel.ms_notificacion.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "notificacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // aca re;acionamos la notificación con la reserva que se genero
    private Long reservaId;

    // esto es a quien va dirigido el mensaje o correo
    private String destinatarioCorreo;

    // esto seria algo tal que asif "CONFIRMACION_RESERVA", "ALERTA_PAGO", "RECORDATORIO_CHECKIN"
    private String tipoNotificacion;

    // el texto del mensaje
    private String mensaje;

    private LocalDateTime fechaEnvio;

    // lo que deberia tirar "ENVIADO", "PENDIENTE", "ERROR"
    private String estado;
}
