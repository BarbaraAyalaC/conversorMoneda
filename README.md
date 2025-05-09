# conversorMoneda

# 💱 Conversor de Monedas en Java

Este es un sencillo conversor de monedas desarrollado en Java, que utiliza la API de [ExchangeRate-API](https://www.exchangerate-api.com) para obtener los tipos de cambio en tiempo real.

## 🚀 Características

- Convierte entre cualquier par de monedas (por ejemplo, USD a EUR).
- Interfaz por consola para introducir datos.
- Consumo de API en tiempo real con tasas actualizadas.

## 📦 Requisitos

- Java 8 o superior
- Conexión a internet
- La librería JSON de `org.json` (ver abajo)

## 🔧 Dependencias

Este proyecto utiliza la librería `org.json` para manejar las respuestas JSON de la API.

### Si usas Maven:

Agrega esto a tu archivo `pom.xml`:

```xml
<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20230227</version>
</dependency>
