# Imagen base de Java
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR al contenedor
COPY target/tu-aplicacion.jar app.jar

# Exponer el puerto 8025
EXPOSE 8025

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]