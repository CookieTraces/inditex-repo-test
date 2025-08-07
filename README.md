# Inditex Price Service

[![Build](https://github.com/CookieTraces/inditex-repo-test/actions/workflows/maven.yml/badge.svg)](https://github.com/CookieTraces/inditex-repo-test/actions/workflows/maven.yml)

Un servicio de ejemplo desarrollado con **Spring Boot** que expone un único endpoint para calcular el precio final de un producto en función de una fecha, una tarifa y una cadena (brand). La aplicación se inspira en una lógica típica de comercio electrónico y usa una **arquitectura hexagonal** (Ports & Adapters) para separar el dominio del resto de capas

## Tabla de contenido

- [Introducción](#introducción)
- [Despliegue en producción](#despliegue-en-producción)
- [Requisitos previos](#requisitos-previos)
- [Ejecución local](#ejecución-local)
- [Uso de la API](#uso-de-la-api)
- [Características](#características)
- [Arquitectura](#arquitectura)
- [Base de datos](#base-de-datos)
- [Testing y CI](#testing-y-ci)
- [Docker](#docker)
- [Contribuir](#contribuir)
- [Licencia](#licencia)

## Introducción

`Inditex Price Service` nace como un ejercicio técnico para demostrar cómo construir una API REST mantenible y testeable. Su responsabilidad es recibir una fecha, un identificador de producto y un identificador de marca y responder con el precio aplicable. La lógica de selección de precios está encapsulada en el dominio.

## Despliegue en producción

Puedes probar el servicio ya desplegado en **Render** sin necesidad de instalar nada:

- **API pública:** [https://inditex-repo-test.onrender.com](https://inditex-repo-test.onrender.com)
- **Swagger/OpenAPI:** [https://inditex-repo-test.onrender.com/swagger-ui/index.html](https://inditex-repo-test.onrender.com/swagger-ui/index.html)

## Requisitos previos

Para ejecutar el proyecto localmente necesitas:

- **Java 17** o superior.
- **Maven 3.9** o superior

## Ejecución local

1. Clona este repositorio y accede al directorio del proyecto:

   ```bash
   git clone https://github.com/CookieTraces/inditex-repo-test.git
   cd inditex-repo-test
