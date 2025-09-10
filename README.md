
# 🎯 Battleship — Hundir la Flota


> **Proyecto desarrollado como práctica de programación en Java.**

**Autor:** \[Raúl Sánchez-Pacheco Carpintero]

---

## 📌 Descripción

**Battleship** es la versión en Java del clásico juego de mesa *Hundir la Flota*. Dos jugadores colocan sus barcos en un tablero de 8x8 y disparan ciegamente al tablero rival hasta hundir toda la flota enemiga.

Características clave:

* Juego para dos jugadores humanos o contra IA.
* Inteligencia artificial básica con colocación aleatoria de barcos y disparos válidos.
* Validación de errores: posiciones repetidas, barcos fuera del tablero y orientación inválida.

---

## 🚀 Demo local / Ejecución

```bash
# 1) Clona el repositorio
git clone https://github.com/TU_USUARIO/battleship.git
cd battleship

# 2) Compila y ejecuta
javac Main.java
java Main
```

---

## 🗂️ Estructura del proyecto

```
Battleship/
├─ Main.java                # Clase principal y flujo del juego
├─ Juego.java               # Gestión de turnos y verificación de flota
├─ Jugador.java             # Clase jugador humano
├─ JugadorIA.java           # IA del jugador
├─ TableroBarcos.java       # Tablero, colocación y disparos
├─ Barco.java               # Representación de barcos
├─ img/                     # Diagramas y capturas
│  ├─ diagrama_clases.png
│  ├─ tablero.png
│  └─ disparo.png
├─ UML/                     # Archivos PlantUML y diagramas
└─ README.md                # Documentación del proyecto
```

---

## 🔍 Descripción detallada de archivos y carpetas

* **Main.java** — Punto de entrada, selección de jugadores y flujo de partida.
* **Juego.java** — Gestión de turnos, disparos y comprobación de barcos hundidos.
* **Jugador.java / JugadorIA.java** — Jugador humano y computadora (IA).
* **TableroBarcos.java** — Tablero, colocación de barcos y gestión de disparos.
* **Barco.java** — Información de cada barco: tamaño, posición, orientación y estado.
* **img/** — Capturas y diagramas del proyecto.
* **UML/** — Archivos PlantUML para diagramas de clases.

---

## 🧰 Tecnologías usadas

* Java SE 8+
* ArrayLists y matrices para tableros y barcos
* Random para IA
* Entrada de usuario mediante `Scanner`
* ASCII art para interfaz visual en consola

---

## ✅ Funcionalidades destacadas

* Colocación de barcos por jugadores humanos o IA.
* Turnos alternos de disparo hasta hundir toda la flota rival.
* Validación de errores en posiciones, orientaciones y disparos.
* IA que evita superposición de barcos y realiza disparos válidos.
* Diagramas UML generados con PlantUML para visualizar la estructura.

---

## 🧩 Diagrama de Clases (UML)


```
@startuml
class Barco {
    # columna: int[]
    # fila: int[]
    # orientacion: String
    # tamaño: int
    # estado_barco: boolean[]
    # tipo: String
}

class TableroBarcos {
    + barcos: ArrayList<Barco>
    + tablero_barcos: String[][]
    + tablero_barcos_juego: String[][]
    + colocarBarco(): boolean
    + colocarBarcoIA()
    + recibirDisparoNormal(fila:int, columna:int): boolean
}

class Jugador {
    - nombre: String
    # tb: TableroBarcos
    + dispararMisil(tableroEnemigo: TableroBarcos): boolean
}

class JugadorIA {
    - posiciones: boolean[][]
    - rand: Random
    + colocarBarcosAleatoriamente()
    + dispararMisil(tableroEnemigo: TableroBarcos): boolean
}

class Juego {
    - jugador1: Jugador
    - jugador2: Jugador
    + iniciar()
    + iniciarIA()
    + estanTodosHundidos(jugador: Jugador): boolean
}
Juego --> Jugador : jugador1, jugador2
Jugador --> JugadorIA
Jugador --> TableroBarcos : tb
TableroBarcos --> Barco : barcos
```

---


## 🚧 Estado del proyecto

* ✅ Colocación de barcos
* ✅ Disparos alternos y validación de errores
* ⚠️ Misiles especiales y torpedos (en desarrollo)
* ⚠️ Mejoras en IA y estrategia de disparo

---

## 🌟 Funciones futuras

* Implementación de misiles especiales 3x3.
* Submarinos con torpedos que barren filas completas.
* IA avanzada con estrategias de búsqueda y disparo inteligente.
* Mejor interfaz visual en consola y gráficos opcionales.
