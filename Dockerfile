# Usa una imagen base de Java
FROM openjdk:11-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR construido al contenedor
COPY target/proyect-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que corre la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
