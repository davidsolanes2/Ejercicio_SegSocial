package point_01;

/*
 * Created by dsg on 19/09/16.
 */
public class Main {

    public static void main(String[] args) {
        SeguridadSocial seguridadSocial = new SeguridadSocial();

        Persona jose = new Persona("39425364H", "111111111", "Jose", "Tomás", 35, 45000.00);
        Persona maria =  new Persona("39425654W", "33333333", "Maria", "Gallego", 55, 61300.20);
        Persona carlos = new Persona("39425355Q", "22222222", "Carlos", "Torres", 22, 23000.00);
        Persona anna = new Persona("39425987J", "444444444", "Anna", "Pina", 26, 17654.88);
        Persona cristina = new Persona("39426987J", "444444444", "cristina", "Pina", 26, 17654.88);

        seguridadSocial.altaPersona(jose);
        seguridadSocial.altaPersona(maria);
        seguridadSocial.altaPersona(carlos);
        seguridadSocial.altaPersona(anna);
        seguridadSocial.altaPersona(cristina);

        System.out.println("\nAltas a la seguridad social: " + seguridadSocial.obtenerTodas().toString());

        System.out.println("Baja a la seguridad social: " + anna);
        seguridadSocial.bajaPersona(anna.getDni());

        System.out.println("Lista de afiliados a la S.S.: " + seguridadSocial.obtenerTodas().toString());

        System.out.println("Obtener Persona Por DNI: " + seguridadSocial.obtenerPersonaPorDNI(jose.getDni()));

        System.out.println("Obtener Persona Por NumSS: " + seguridadSocial.obtenerPersonaPorNumSS(maria.getSegsocial()));

        System.out.println("Obtener Personas Rango Salarial: " + seguridadSocial.obtenerPersonasRangoSalarial(23000.00, 45000.00));

        System.out.println("Obtener Personas Mayores Que: " + seguridadSocial.obtenerPersonasMayoresQue(25));

    }

}
