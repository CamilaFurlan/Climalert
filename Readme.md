# Climalert

Climalert es un sistema de monitoreo climático desarrollado con Spring Boot. Su objetivo es consultar periódicamente el estado del clima mediante WeatherAPI, almacenar la info obtenida y generar alertas automáticas por correo electrónico cuando se detectan alertas.

## Funcionalidades

- Consulta periódica del clima utilizando WeatherAPI.
- Almacenamiento del historial de consultas.
- Procesamiento automático de alertas climáticas.
- Envío de notificaciones por correo electrónico mediante SMTP (Mailtrap).
- Ejecución automática de tareas utilizando `@Scheduled`.

## Condiciones de alerta

Se genera una alerta cuando se cumplen simultáneamente las siguientes condiciones:

- Temperatura mayor a **35 °C**
- Humedad mayor a **60 %**

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Maven
- Mailtrap (SMTP)
- WeatherAPI

## Estructura del proyecto

```
climalert/
├── pom.xml
└── climalert-service/
    ├── config/
    ├── dto/
    ├── models/
    ├── repositories/
    ├── services/
    └── resources/
```

## Configuración

En `application.properties` deben configurarse las credenciales de WeatherAPI y del servidor SMTP.

## Funcionamiento

El sistema realiza dos tareas programadas:

- Cada **5 minutos** consulta WeatherAPI y almacena el clima obtenido.
- Cada **1 minuto** verifica el último registro almacenado y, si corresponde, envía una alerta por correo electrónico.
