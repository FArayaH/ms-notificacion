package com.hotel.ms_notificacion.config;

import com.hotel.ms_notificacion.model.Notificacion;
import com.hotel.ms_notificacion.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private NotificacionRepository notificacionRepository;

    @Override
    public void run(String... args) throws Exception {

        if (notificacionRepository.count() == 0) {

            // 1. Notificación enviada exitosamente
            Notificacion n1 = new Notificacion();
            n1.setReservaId(1L);
            n1.setDestinatarioCorreo("felipe@ejemplo.com");
            n1.setTipoNotificacion("CONFIRMACION_RESERVA");
            n1.setMensaje("Su reserva en el hotel ha sido confirmada con éxito.");
            n1.setFechaEnvio(LocalDateTime.now().minusDays(2));
            n1.setEstado("ENVIADO");
            notificacionRepository.save(n1);

            // 2. Notificación pendiente por enviar
            Notificacion n2 = new Notificacion();
            n2.setReservaId(2L);
            n2.setDestinatarioCorreo("antonia@ejemplo.com");
            n2.setTipoNotificacion("ALERTA_PAGO");
            n2.setMensaje("Estimado cliente, tiene un pago pendiente por procesar.");
            n2.setFechaEnvio(LocalDateTime.now().minusDays(1));
            n2.setEstado("PENDIENTE");
            notificacionRepository.save(n2);

            // 3. Otra notificación enviada
            Notificacion n3 = new Notificacion();
            n3.setReservaId(3L);
            n3.setDestinatarioCorreo("sofia@ejemplo.com");
            n3.setTipoNotificacion("RECORDATORIO_CHECKIN");
            n3.setMensaje("Recuerde que su check-in es mañana a las 14:00 hrs.");
            n3.setFechaEnvio(LocalDateTime.now());
            n3.setEstado("ENVIADO");
            notificacionRepository.save(n3);

            System.out.println("Las 3 notificaciones han sido insertadas correctamente");
        } else {
            System.out.println("DataInitializer: La base de datos ya tiene datos, omitiendo carga");
        }
    }

}
