# Inditex Price Service

Servicio REST, desarrollado en **Spring Boot** utilizando **arquitectura hexagonal** (Ports & Adapters). Consta de un endpoint para obtener el precio final de un producto según una fecha, tarifa y cadena, simulando la lógica de precios de un comercio electrónico.

---

## Despliegue en producción

La aplicación está desplegada en **Render**:

- **API pública**:  
  [https://inditex-repo-test.onrender.com](https://inditex-repo-test.onrender.com)

- **Swagger/OpenAPI online**:  
  [https://inditex-repo-test.onrender.com/swagger-ui/index.html](https://inditex-repo-test.onrender.com/swagger-ui/index.html)

---

## Características principales

- **Consulta de precios por fecha, producto y cadena** usando una base de datos en memoria (**H2**).
- **Arquitectura hexagonal** para máxima mantenibilidad y testabilidad.
- **OpenAPI/Swagger** documentado y accesible online.
- **Cobertura y calidad de código** con tests unitarios y de integración, además de análisis mutacional con **PITEST**.
- **Contenerización** con Docker: lista para despliegue y ejecución fácil.
- **CI/CD en GitHub Actions**: se ejecutan automáticamente `mvn package` y **pitest** en cada push.

---

## Arquitectura

El proyecto se ha creado con el patrón **hexagonal (Ports & Adapters)**:

- **Dominio**: Reglas de negocio y entidades.
- **Aplicación**: Casos de uso.
- **Infraestructura**: Adaptadores REST y persistencia H2.
- **Tests**: Cobertura de tests para dominio y endpoints.

---

## 📚 OpenAPI y documentación

- **Swagger UI en la instancia desplegada:**  
  [https://inditex-repo-test.onrender.com/swagger-ui/index.html](https://inditex-repo-test.onrender.com/swagger-ui/index.html)
- **OpenAPI yaml/json local:**  
  Disponible en `src/main/resources`
  > Puedes abrirlo localmente o importarlo en Postman/Insomnia.

---

## Base de datos (H2)

La base de datos H2 se inicializa con la tabla `PRICES` y los datos de ejemplo siguientes:

| BRAND_ID | START_DATE           | END_DATE             | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE  | CURR |
|----------|----------------------|----------------------|------------|------------|----------|--------|------|
| 1        | 2020-06-14 00:00:00  | 2020-12-31 23:59:59  | 1          | 35455      | 0        | 35.50  | EUR  |
| 1        | 2020-06-14 15:00:00  | 2020-06-14 18:30:00  | 2          | 35455      | 1        | 25.45  | EUR  |
| 1        | 2020-06-15 00:00:00  | 2020-06-15 11:00:00  | 3          | 35455      | 1        | 30.50  | EUR  |
| 1        | 2020-06-15 16:00:00  | 2020-12-31 23:59:59  | 4          | 35455      | 1        | 38.95  | EUR  |

---

## Testing y CI

- **Tests automáticos** validan la API con ejemplos típicos de negocio.
- **PITEST** se utiliza para análisis mutacional, asegurando que los tests sean robustos y el código fiable.
- **GitHub Actions**:  
  En cada push/pull request se ejecutan:
    - `mvn package` para compilar y validar los tests.
    - **pitest** para análisis mutacional y calidad de tests.

---

## Docker

El servicio está preparado para ejecutarse en cualquier entorno compatible con Docker.

### Dockerfile utilizado:
[Dockerfile](Dockerfile)