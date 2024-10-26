import java.util.Scanner;
import java.util.Random;

class Personaje {
    String nombre;
    int fuerza;
    int velocidad;
    int vida_hp;

    public Personaje(String nombre, int fuerza, int velocidad, int vida_hp) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
        this.vida_hp = vida_hp;
    }

    public void recibirDanio(int danio) {
        this.vida_hp -= danio;
        if (this.vida_hp < 0) {
            this.vida_hp = 0;
        }
        System.out.println("\n" + this.nombre + " recibió " + danio + " puntos de daño.");
        System.out.println("Vida restante de " + this.nombre + ": " + this.vida_hp + "\n");
    }

    public void mostrarEstadisticas() {
        System.out.println("\n*** Estadísticas de " + this.nombre + " ***");
        System.out.println("Fuerza: " + this.fuerza);
        System.out.println("Velocidad: " + this.velocidad);
        System.out.println("Vida: " + this.vida_hp);
        System.out.println("************************************\n");
    }
}

class SuperHero {
    Personaje personaje;

    public SuperHero(String nombre, int fuerza, int velocidad, int vida_hp) {
        this.personaje = new Personaje(nombre, fuerza, velocidad, vida_hp);
    }

    public void atacar(Personaje oponente) {
        int danio = this.personaje.fuerza;
        System.out.println(this.personaje.nombre + " ataca a " + oponente.nombre + " con " + danio + " puntos de fuerza.");
        oponente.recibirDanio(danio);
    }

    public void atacar(Personaje oponente, int poderExtra) {
        int danio = this.personaje.fuerza * poderExtra;
        System.out.println(this.personaje.nombre + " utiliza su ataque especial contra " + oponente.nombre + " con " + danio + " puntos de fuerza.");
        oponente.recibirDanio(danio);
    }

    public void defender(Personaje oponente, double porcentaje) {
        //Si la opcion del villano es atacar el superheroe reducira el daño al 50%
        int danioOriginal = oponente.fuerza;
        int danioReducido = (int) (danioOriginal * porcentaje);
        System.out.println(this.personaje.nombre + " se defiende y reduce el daño a un 50%.");
        this.personaje.recibirDanio(danioReducido);
    }

    public void recuperar(int vidaRecuperada) {
        this.personaje.vida_hp += vidaRecuperada;
        System.out.println(this.personaje.nombre + " se recupera y aumenta su vida a " + this.personaje.vida_hp + "\n");
    }

    public void mostrarEstadisticas() {
        this.personaje.mostrarEstadisticas();
    }
}

class Villano {
    Personaje personaje;

    public Villano(String nombre, int fuerza, int velocidad, int vida_hp) {
        this.personaje = new Personaje(nombre, fuerza, velocidad, vida_hp);
    }

    public void atacar(Personaje oponente, int poderExtra) {
        // Ataque duplicado: hace trampa
        int danio = this.personaje.fuerza * poderExtra; 
        System.out.println(this.personaje.nombre + " ataca con fuerza duplicada a " + oponente.nombre + " causando " + danio + " puntos de daño.");
        oponente.recibirDanio(danio);
}

    public void atacar(Personaje oponente) {
        // Ataque normal
        int danio = this.personaje.fuerza;
        System.out.println(this.personaje.nombre + " ataca a " + oponente.nombre + " con " + danio + " puntos de fuerza.");
        oponente.recibirDanio(danio);
    }

    public void hacerTrampa() {
        this.personaje.vida_hp *= 2;
        System.out.println(this.personaje.nombre + " hace trampa y duplica su vida a " + this.personaje.vida_hp + " puntos.\n");
    }

    public void mostrarEstadisticas() {
        this.personaje.mostrarEstadisticas();
    }
}

public class App {

    private static final int PODER_EXTRA = 2;
    private static final int VIDA_RECUPERADA = 20;
    private static final double PORCENTAJE_DEFENSA = 0.5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuarJuego = true;

        while (continuarJuego) {
            // Crear superheroes y villanos 2 y 2
            SuperHero superman = new SuperHero("Superman", 30, 20, 100);
            SuperHero batman = new SuperHero("Batman", 25, 18, 90);
            Villano lexLuthor = new Villano("Lex Luthor", 25, 15, 80);
            Villano joker = new Villano("Joker", 20, 22, 70);

            // Mostrar estadísticas iniciales de cada personaje
            System.out.println("----- Bienvenido a la Batalla -----\n");
            System.out.println("Estadísticas iniciales:");
            superman.mostrarEstadisticas();
            batman.mostrarEstadisticas();
            lexLuthor.mostrarEstadisticas();
            joker.mostrarEstadisticas();

            // Elegir el personaje con el queremos jugar
            System.out.println("Es tu turno, elige a tu héroe:");
            System.out.println("1. Superman");
            System.out.println("2. Batman");
            int opcionHeroe;
            do {// Validamos que la opcion elegida sea la correcta
                System.out.print("Elige a tu héroe (1 o 2):");
                opcionHeroe = scanner.nextInt();
            } while (opcionHeroe < 1 || opcionHeroe > 2);
            // Operador ternario para guardar el héroe elegido
            SuperHero heroeElegido = opcionHeroe == 1 ? superman : batman;

            //Elegimos el villno al queremos enfrentarnos
            System.out.println("\nElige tu villano oponente:");
            System.out.println("1. Lex Luthor");
            System.out.println("2. Joker");
            int opcionVillano;
            do {// Validamos que la opcion elegida sea la correcta
                System.out.print("Elige tu villano oponente (1 o 2):");
                opcionVillano = scanner.nextInt();
            } while (opcionVillano < 1 || opcionVillano > 2);
            // Operador ternario para guardar el héroe elegido
            Villano villanoElegido = opcionVillano == 1 ? lexLuthor : joker;

            System.out.println("\n-----" + heroeElegido.personaje.nombre + " VS " + villanoElegido.personaje.nombre + "-----\n");

            // Inicio de la batalla
            boolean batallaActiva = true; // Variable bandera

            while (batallaActiva) {
                // Opciones del jugador
                System.out.println("\nElige tu acción:");
                System.out.println("1. Atacar");
                System.out.println("2. Ataque especial");
                System.out.println("3. Defender");
                System.out.println("4. Recuperar");
                int accionHeroe;
                do {// Validamos que la opcion elegida sea la correcta
                    System.out.println("Elige tu acción (1-4):");
                    accionHeroe = scanner.nextInt();
                } while (accionHeroe < 1 || accionHeroe > 4);

                switch (accionHeroe) {
                    case 1:// Ataque normal
                        heroeElegido.atacar(villanoElegido.personaje);
                        break;
                    case 2:// Ataque duplicado
                        heroeElegido.atacar(villanoElegido.personaje, PODER_EXTRA);
                        break;
                    case 3:// Se defiende si el villano ataca
                        System.out.println(heroeElegido.personaje.nombre + " elige defenderse.");
                        break;
                    case 4: // Su vida aumenta
                        heroeElegido.recuperar(VIDA_RECUPERADA);
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }

                // Verificar si el villano ha sido derrotado
                if (villanoElegido.personaje.vida_hp <= 0) {
                    System.out.println("\n¡El villano " + villanoElegido.personaje.nombre + " ha sido derrotado!");
                    batallaActiva = false;
                    break;
                }

                // Turno del villano con acción aleatoria
                System.out.println("\nTurno del villano: " + villanoElegido.personaje.nombre);
                Random random = new Random();
                int accionVillano = random.nextInt(3) + 1;

                switch (accionVillano) {
                    case 1:// Ataque con trampa
                        // Validamos si la opción del heroe es defenderse
                        if (accionHeroe == 3) { 
                            heroeElegido.defender(villanoElegido.personaje, PORCENTAJE_DEFENSA);
                        } else {
                            villanoElegido.atacar(heroeElegido.personaje, PODER_EXTRA);
                        }
                        break;
                    case 2:// El villano hace trampa y aumenta su vida
                        villanoElegido.hacerTrampa();
                        break;
                    case 3:// Realiza un ataque normal
                        // Validamos si la opción del heroe es defenderse
                        if (accionHeroe == 3) { 
                            heroeElegido.defender(villanoElegido.personaje, PORCENTAJE_DEFENSA);
                        } else {
                            villanoElegido.atacar(heroeElegido.personaje, PODER_EXTRA);
                        }
                }

                // Verificar si el superhéroe ha sido derrotado
                if (heroeElegido.personaje.vida_hp <= 0) {
                    System.out.println("\n¡El héroe " + heroeElegido.personaje.nombre + " ha sido derrotado!");
                    batallaActiva = false;
                    break;
                }

                // Cada que hay una roda se muestran las estadisticas
                heroeElegido.mostrarEstadisticas();
                villanoElegido.mostrarEstadisticas();
            }

            // Preguntar al usuario si quiere seguir jugando
            System.out.println("¿Quieres jugar otra vez? (s/n)");
            // continuarJuego será true si la respuesta es 's' o 'S', false en caso contrario
            continuarJuego = scanner.next().equalsIgnoreCase("s");
        }

        System.out.println("\nGracias por jugar. ¡Hasta la próxima!");
        scanner.close();
    }
}
