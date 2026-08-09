# Learning Platform

Plataforma de aprendizaje desarrollada con una arquitectura basada en microservicios utilizando Spring Boot, Docker y GitHub Actions.

El proyecto está compuesto por dos microservicios principales que permiten gestionar cursos e inscripciones de estudiantes.

## 🏗️ Arquitectura

```text
                    Learning Platform
                           │
              ┌────────────┴────────────┐
              │                         │
              ▼                         ▼
       Curso Service            Inscripcion Service
          :8081                       :8082
              │                         │
              └────────────┬────────────┘
                           │
                    Docker Network
                           │
                      Docker Compose
