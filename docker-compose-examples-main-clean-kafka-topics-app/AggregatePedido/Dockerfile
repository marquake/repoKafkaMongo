# Utiliza la imagen base de Eclipse Temurin (OpenJDK) con Alpine Linux
FROM eclipse-temurin:17

# Copia el archivo JAR generado (reemplaza con el nombre de tu JAR)
COPY target/aggregate-pedidos-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8083

#docker build -t miapp .
#docker run -p 8083:8083 miapp

# Punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]