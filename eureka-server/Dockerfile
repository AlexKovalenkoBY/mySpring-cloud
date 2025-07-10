

# Используем официальный образ OpenJDK
FROM eclipse-temurin:17-jdk-jammy

# Рабочая директория
WORKDIR /app

# Копируем JAR-файл
COPY target/eureka-server-*.jar app.jar

# Порт, который будет слушать Eureka
EXPOSE 8761

# Запуск сервиса
ENTRYPOINT ["java", "-jar", "app.jar"]