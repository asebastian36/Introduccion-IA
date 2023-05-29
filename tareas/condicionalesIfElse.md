# Codigo con condicionales if else

```Java
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

class RedSocial {
    private String nombre;
    private String enfoque;
    private String audiencia;

    public RedSocial(String nombre, String enfoque, String audiencia) {
        this.nombre = nombre;
        this.enfoque = enfoque;
        this.audiencia = audiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEnfoque() {
        return enfoque;
    }

    public String getAudiencia() {
        return audiencia;
    }
}

public class RedSocialFormulario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear objetos de redes sociales
        RedSocial[] redesSociales = {
            new RedSocial("Facebook", "Conexión social y compartir contenido", "General"),
            new RedSocial("Instagram", "Compartir contenido visual", "General"),
            new RedSocial("Pinterest", "Establecer debates y compartir contenido", "General"),
            new RedSocial("Reddit", "Establecer debates y compartir contenido", "General"),
            new RedSocial("Tumblr", "Compartir contenido visual y social blogging", "General"),
            new RedSocial("Twitch", "Streaming de videojuegos y contenido en vivo", "General"),
            new RedSocial("Snapchat", "Compartir contenido visual efímero", "General"),
            new RedSocial("Clubhouse", "Comunicación en audio en vivo", "General"),
            new RedSocial("Discord", "Comunicación en audio y texto para comunidades de videojuegos", "General"),
            new RedSocial("OnlyFans", "Compartir contenido exclusivo para suscriptores", "Adultos"),
            new RedSocial("LinkedIn", "Fortalecer contactos laborales", "Profesional"),
            new RedSocial("Quora", "Preguntas y respuestas", "General"),
            new RedSocial("WhatsApp", "Comunicación instantánea", "General"),
            new RedSocial("Teams", "Comunicación y colaboración en equipo", "Profesional"),
            new RedSocial("Slack", "Comunicación y colaboración en equipo", "Profesional"),
            new RedSocial("YouTube Kids", "Contenido educativo y entretenimiento para niños", "Niños"),
            new RedSocial("Kuddle", "Red social para niños", "Niños"),
            new RedSocial("PopJam", "Red social para niños", "Niños"),
            new RedSocial("Kidzworld", "Red social para niños", "Niños")
        };

        // Mostrar opciones de selección al usuario
        System.out.println("Bienvenido al formulario de selección de red social.");
        System.out.println("Por favor, elija una de las siguientes opciones:");
        System.out.println("1. Enfoque");
        System.out.println("2. Audiencia");

        // Obtener la opción de selección del usuario
        int opcion = scanner.nextInt();

        // Verificar la opción seleccionada
        if (opcion == 1) {
            System.out.println("Por favor, seleccione el enfoque de la red social:");

            // Obtener enfoques sin repetir
            Set<String> enfoquesSinRepetir = obtenerEnfoquesSinRepetir(redesSociales);

            // Mostrar enfoques sin repetir
            int contador = 1;
            for (String enfoque : enfoquesSinRepetir) {
                System.out.println(contador + ". " + enfoque);
                contador++;
            }

            // Obtener la opción de enfoque seleccionada por el usuario
            int opcionEnfoque = scanner.nextInt();

            // Obtener la red social basada en el enfoque seleccionado
            RedSocial redSeleccionada = obtenerRedPorEnfoque(redesSociales, enfoquesSinRepetir, opcionEnfoque);

            // Mostrar la red social seleccionada
            System.out.println("Usted ha elegido: " + redSeleccionada.getNombre());
        } else if (opcion == 2) {
            System.out.println("Por favor, seleccione la audiencia de la red social:");

            // Obtener audiencias sin repetir
            Set<String> audienciasSinRepetir = obtenerAudienciasSinRepetir(redesSociales);

            // Mostrar audiencias sin repetir
            int contador = 1;
            for (String audiencia : audienciasSinRepetir) {
                System.out.println(contador + ". " + audiencia);
                contador++;
            }

            // Obtener la opción de audiencia seleccionada por el usuario
            int opcionAudiencia = scanner.nextInt();

            // Obtener la red social basada en la audiencia seleccionada
            RedSocial redSeleccionada = obtenerRedPorAudiencia(redesSociales, audienciasSinRepetir, opcionAudiencia);

            // Mostrar la red social seleccionada
            System.out.println("Usted ha elegido: " + redSeleccionada.getNombre());
        } else {
            System.out.println("Opción inválida.");
        }
    }

    // Método para obtener los enfoques sin repetir
    private static Set<String> obtenerEnfoquesSinRepetir(RedSocial[] redesSociales) {
        Set<String> enfoquesSinRepetir = new HashSet<>();

        for (RedSocial red : redesSociales) {
            enfoquesSinRepetir.add(red.getEnfoque());
        }

        return enfoquesSinRepetir;
    }

    // Método para obtener las audiencias sin repetir
    private static Set<String> obtenerAudienciasSinRepetir(RedSocial[] redesSociales) {
        Set<String> audienciasSinRepetir = new HashSet<>();

        for (RedSocial red : redesSociales) {
            audienciasSinRepetir.add(red.getAudiencia());
        }

        return audienciasSinRepetir;
    }

    // Método para obtener la red social basada en el enfoque seleccionado
    private static RedSocial obtenerRedPorEnfoque(RedSocial[] redesSociales, Set<String> enfoquesSinRepetir, int opcionEnfoque) {
        String enfoqueSeleccionado = (String) enfoquesSinRepetir.toArray()[opcionEnfoque - 1];

        for (RedSocial red : redesSociales) {
            if (red.getEnfoque().equals(enfoqueSeleccionado)) {
                return red;
            }
        }

        return null; // Enfoque no encontrado
    }

    // Método para obtener la red social basada en la audiencia seleccionada
    private static RedSocial obtenerRedPorAudiencia(RedSocial[] redesSociales, Set<String> audienciasSinRepetir, int opcionAudiencia) {
        String audienciaSeleccionada = (String) audienciasSinRepetir.toArray()[opcionAudiencia - 1];

        for (RedSocial red : redesSociales) {
            if (red.getAudiencia().equals(audienciaSeleccionada)) {
                return red;
            }
        }

        return null; // Audiencia no encontrada
    }
}

```
