package ar.edu.utn.frba.ddsi.climalert.services.impl;

import ar.edu.utn.frba.ddsi.climalert.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climalert.services.NotificacionesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificacionesServiceImpl implements NotificacionesService {

    private final JavaMailSender mailSender;
    @Value("${alert.mail.recipients}")
    private String destinatarios;

    public NotificacionesServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void enviarAlerta(Clima clima) {

        SimpleMailMessage mensaje = new SimpleMailMessage();

        mensaje.setTo(destinatarios.split(","));

        mensaje.setSubject("⚠️ Alerta Climática");

        mensaje.setText(
                "Se detectaron condiciones climáticas peligrosas.\n\n" +
                        "Temperatura: " + clima.getTemperatura() + " °C\n" +
                        "Humedad: " + clima.getHumedad() + " %\n" +
                        "Condición: " + clima.getCondicion() + "\n" +
                        "Última actualización: " + clima.getFechaActualizacion() + "\n" +
                        "Fecha de consulta: " + clima.getFechaConsulta()
        );

        try {
            mailSender.send(mensaje);
            System.out.println("Correo enviado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al enviar el correo: " + e.getMessage());
        }
    }
}