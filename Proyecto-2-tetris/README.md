# Proyecto: Tetris – Tarea Programada 2  

Universidad de Costa Rica  
CI-0112 Programación 1  
II Ciclo, 2025  

## Objetivo y Alcance
El objetivo de este proyecto es desarrollar una versión **funcional y simplificada del clásico Tetris** en **consola**, aplicando los principios de la **Programación Orientada a Objetos (POO)**.

El juego permite al usuario mover y rotar piezas que caen dentro de un tablero de 10×20, con el fin de completar líneas horizontales, acumular puntos y evitar que las piezas se amontonen hasta el tope del tablero.

**Alcance mínimo:**
- Juego corriendo en terminal.  
- Control por teclado (WASD + Enter).  
- Piezas con gravedad y posibilidad de mover/rotar.  
- Detección de colisiones, fijado de piezas y limpieza de líneas (versión recursiva).  
- Puntaje básico y game over por alcanzar la altura límite.

## Cómo Compilar y Ejecutar
- Clonar el repositorio en tu máquina usando el comando git clone https://github.com/hanzmp2003/proyectos-michis.git
- Entrar en la carpeta del proyecto correspondiente a Tetris, cd C:\Users\hanzm\proyectos-michis\Proyecto-2-tetris
- Compilar los archivos Java del proyecto, javac *.java
- Ejecutar el programa principal, java Main

## Controles
- W → Rotar la pieza (sentido horario).  
- A → Mover a la izquierda.  
- D → Mover a la derecha.  
- S → Acelerar la caída de la pieza.  
- Enter → Confirmar el movimiento.  

## Decisiones de Diseño
El proyecto se desarrolló siguiendo una **arquitectura modular basada en POO**, separando las responsabilidades principales en clases específicas para mejorar cohesión y reducir acoplamiento.
*(Se modifica luego)*

**Por qué esta estructura:**  
*(Se modifica luego)*

## Limitaciones conocidas y Trabajo Futuro
- Actualmente el juego puede requerir presionar **Enter** para procesar cada comando (limitación aceptada por lectura en consola).  
- No se incluyen por defecto SRS kicks ni ghost piece.  
- La implementación de colores usa códigos ANSI; en terminales que no soporten ANSI la visualización será limitada.  
- Trabajo futuro: *(Se modifica luego)*

## Integrantes
- Hanz Madrigal Porras, C4G754  
- Chun Ping Liu Li, C5G492  
- Emanuel Sancho Sánchez, C07332  
- Jefferson Emanuel Miranda Sabala, C24874

## Profesor y Asistente
- Profesor: Rodrigo Li Qiu  
- Asistente: GatitoAutonomo
