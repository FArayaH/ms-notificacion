package com.hotel.ms_notificacion.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionRequestDTO {

    @NotNull(message = "El ID de la reserva es obligatorio")
    private Long reservaId;

    @NotBlank(message = "El correo del destinatario es obligatorio")
    @Email(message = "Debe ser un formato de correo electrónico válido")
    private String destinatarioCorreo;

    @NotBlank(message = "El tipo de notificación es obligatorio")
    private String tipoNotificacion;

    @NotBlank(message = "El mensaje no puede estar vacío")
    private String mensaje;
}
