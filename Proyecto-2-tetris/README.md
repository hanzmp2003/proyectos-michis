# Proyecto: Tetris – Tarea Programada 2  

Universidad de Costa Rica  
CI-0112 Programación 1  
II Ciclo, 2025  

## Objetivo y Alcance
El objetivo de este proyecto es desarrollar una versión **funcional y simplificada del clásico Tetris** en **consola**, aplicando los principios de la **Programación Orientada a Objetos (POO)**.

El juego permite al usuario mover y rotar piezas que caen dentro de un tablero de 10×20, con el fin de completar líneas horizontales, acumular puntos y evitar que las piezas se amontonen hasta el tope del tablero.

**Extras que hicimos con cariño ^w^:**
- Implementación de sonidos: movimiento, rotación, hard drop, chocar con el borde, completar una línea, inicio del juego y game over. 
- Enseñar la siguiente pieza. 
- Ghost piece (para mostrar dónde se colocará la pieza).
- Se añadieron 3 piezas adicionales a lo indicado. 

## Cómo Compilar y Ejecutar
- Clonar el repositorio en tu máquina usando el comando git clone https://github.com/hanzmp2003/proyectos-michis.git
- Entrar en la carpeta del proyecto correspondiente a Tetris, ejemplo: cd C:\Users\user1\proyectos-michis\Proyecto-2-tetris
- Compilar los archivos Java del proyecto, javac *.java
- Ejecutar el programa principal, java.Main
- Consideración adicional: el proyecto incluye efectos de sonido como característica opcional. Para que funcionen correctamente, es importante ejecutar el programa desde la carpeta raíz del proyecto, ya que las rutas de los archivos de audio dependen de esa ubicación.

## Controles
- W → Rotar la pieza (sentido horario).  
- A → Mover a la izquierda.  
- D → Mover a la derecha.  
- S → Acelerar la caída de la pieza.  
- Enter → Actualiza el juego para simular la caída automática de la pieza.

## Decisiones de Diseño
El proyecto se desarrolló siguiendo una **arquitectura modular basada en POO**, separando las responsabilidades principales en clases específicas para mejorar cohesión y reducir acoplamiento. Cada archivo .java contiene un objeto con métodos específicos para asegurar que sea fácilmente modificable en futuras ediciones. Está dividido en 2 subcarpetas, una conteniendo la lógica del código y otra con efectos de sonido que son implementados en el juego. 

**Por qué esta estructura:**  
La estructura del proyecto se diseñó para mantener una separación clara entre la lógica del juego y los recursos externos, facilitando la comprensión y el mantenimiento del código. La carpeta principal contiene únicamente las clases necesarias para ejecutar el Tetris, organizadas en módulos independientes que representan elementos fundamentales del juego (tablero, piezas, motor de juego y control). Esto permite que cada componente pueda modificarse o mejorarse sin afectar el resto del sistema.  

La separación adicional en una segunda carpeta con efectos de sonido permite extender el proyecto sin mezclar archivos relacionados con la jugabilidad y la representación auditiva. Gracias a esta organización modular, el código es más escalable, más fácil de depurar y ofrece una base sólida para futuras expansiones, como mejoras visuales, nuevos modos de juego o una interfaz gráfica.

## Limitaciones conocidas y trabajo futuro
- Actualmente el juego no se mueve solo, es decir, la terminal no se actualiza por sí sola después de determinado tiempo como el juego original, en cambio, se actualiza cada vez que se presiona una tecla de movimiento o presionar **Enter** para que genere el movimiento natural.
- No se incluyen por defecto SRS kicks.  
- La implementación de colores usa códigos ANSI; en terminales que no soporten ANSI la visualización será limitada.  
- No contiene un sistema de dificultad por nivel. 
- Trabajo futuro: Para una posible mejora del juego, se podría implementar la automatización del movimiento de las piezas conforme al tiempo, interfaz gráfica con botones, menú interactivo con configuraciones, sistema de guardado del puntaje más alto por usuario y animaciones de eliminación de una línea completada. 

## Integrantes
- Hanz Madrigal Porras, C4G754  
- Chun Ping Liu Li, C5G492  
- Emanuel Sancho Sánchez, C07332  
- Jefferson Emanuel Miranda Sabala, C24874

## Profesor y Asistente
- Profesor: Rodrigo Li Qiu  
- Asistente: GatitoAutonomo