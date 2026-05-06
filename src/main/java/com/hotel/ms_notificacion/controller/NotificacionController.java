package com.hotel.ms_notificacion.controller;
import com.hotel.ms_notificacion.dto.NotificacionRequestDTO;
import com.hotel.ms_notificacion.dto.NotificacionResponseDTO;
import com.hotel.ms_notificacion.service.NotificacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/v1/notificacion")
public class NotificacionController {
    @Autowired
    private NotificacionService notificacionService;

    // POST: Para crear y "enviar" la notificación
    @PostMapping
    public ResponseEntity<?> enviar(@Valid @RequestBody NotificacionRequestDTO requestDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getAllErrors().get(0).getDefaultMessage());
        }
        try {
            NotificacionResponseDTO respuesta = notificacionService.enviarNotificacion(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }

    // GET: Para listar
    @GetMapping
    public ResponseEntity<List<NotificacionResponseDTO>> listarNotificaciones(
            @RequestParam(required = false) String estado) {

        if (estado != null && !estado.isEmpty()) {
            return ResponseEntity.ok(notificacionService.obtenerPorEstado(estado));
        }
        return ResponseEntity.ok(notificacionService.obtenerTodas());
    }

}
