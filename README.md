# Batalla de Superhéroes

Este programa simula una batalla entre un superhéroe y un villano. El usuario puede elegir al superhéroe y al villano, y luego realizar acciones para atacar, defender o recuperar vida.

## Estructura del Código

### Clases Principales

1. **Personaje**
   - Esta clase representa a un personaje en el juego, ya sea un superhéroe o un villano.
   - **Atributos:**
     - `String nombre`: El nombre del personaje.
     - `int fuerza`: La fuerza de ataque del personaje.
     - `int velocidad`: La velocidad del personaje (para proximas mejoras XD).
     - `int vida_hp`: La cantidad de vida del personaje.
   - **Métodos:**
     - `recibirDanio(int danio)`: Reduce la vida del personaje al recibir daño.
     - `mostrarEstadisticas()`: Muestra las estadísticas del personaje.

2. **SuperHero**
   - Esta clase extiende la funcionalidad de la clase `Personaje` y representa a un superhéroe.
   - **Métodos:**
     - `atacar(Personaje oponente)`: Realiza un ataque normal al oponente.
     - `atacar(Personaje oponente, int poderExtra)`: Realiza un ataque especial que causa más daño.
     - `defender()`: El heroe se defiende del ataque del villana en un 50%.
     - `recuperar()`: Aumenta la vida del superhéroe en 20 puntos.

3. **Villano**
   - Esta clase también extiende la funcionalidad de la clase `Personaje` y representa a un villano.
   - **Métodos:**
     - `atacar(Personaje oponente, int poderExtra)`: Realiza un ataque normal al oponente más trampa duplica su fuerza.
     - `atacar(Personaje oponente)`: Realiza un ataque normal al oponente.
     - `hacerTrampa()`: Duplica la vida del villano.

### Clase Principal: App

- Esta es la clase principal que contiene el método `main`, donde se ejecuta el juego.
- **Flujo del Juego:**
  1. Se crean instancias de `SuperHero` y `Villano`.
  2. Se muestran las estadísticas iniciales de los personajes.
  3. El usuario elige su superhéroe y villano.
  4. Se inicia un ciclo de batalla donde el usuario elige acciones para su superhéroe.
  5. El villano realiza una acción aleatoria.
  6. Se verifica si alguno de los personajes ha sido derrotado.
  7. Al final de la batalla, se pregunta al usuario si desea jugar otra ronda.

### Constantes

- `PODER_EXTRA`: Define el poder adicional del ataque especial (duplica).
- `VIDA_RECUPERADA`: Define la cantidad de vida que se recupera al usar la acción de recuperar (20 puntos).
- `PORCENTAJE_DEFENSA`: Define el porcentaje de defensa al usar la acción defender.

¡Disfruta la batalla!