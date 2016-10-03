package point_01;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Created by dsg on 19/09/16.
 */

public class SeguridadSocial {

    private List<Persona>personaList;

    HashMap<String, Persona> dniHashMap;
    HashMap<String, Persona> segSocialHashMap;

    public SeguridadSocial() {

        personaList = new ArrayList<>();
        dniHashMap = new HashMap<>();
        segSocialHashMap = new HashMap<>();
    }

    public void altaPersona(Persona persona) {
        //verificar que los nombres y el dni no se repiten

        /*dString dni = persona.getDni();
        String nom = persona.getName();

        for (Persona c : personaList) {
            if (Objects.equals(c.getDni(), dni)) {
                System.out.println("El dni SI existe");
            } else if (Objects.equals(c.getName(), nom)) {
                System.out.println("El nombre SI existe");
                break;
            }
            System.out.println("");
        }
        personaList.add(persona);
        */

            boolean repetida = personaList.stream().anyMatch(p -> persona.getDni().equals(persona.getDni())
                || persona.getSegsocial().equals(persona.getSegsocial()));
            if (!repetida) {
                dniHashMap.put(persona.getDni(), persona);
                segSocialHashMap.put(persona.getSegsocial(), persona);
            }

    }

    public void bajaPersona(String dni) {
        //personaList.removeIf(persona -> persona.getDni().equals(dni));
        dniHashMap.remove(dni);
    }

   public Persona obtenerPersonaPorDNI(String dni) {
       /*for (Persona a : personaList) {
           if (a.getDni().equals(dni)) {
               return a;
           }
       }
       return null;*/

       return dniHashMap.get(dni);
   }

   public Persona obtenerPersonaPorNumSS(String segsocial) {
       /*for (Persona a : personaList) {
           if (a.getSegsocial().equals(segsocial)) {
               return a;
           }
       }
       return null;*/

       return segSocialHashMap.get(segsocial);
   }

    public List<Persona>obtenerPersonasRangoSalarial(double min, double max) {

        /*ArrayList<Persona> Persona_salario = new ArrayList<>();

        for (Persona a : personaList) {
            if (a.getSalary() >= (min) && a.getSalary() <= (max)) {
                Persona_salario.add(a);
            }
        }
        return Persona_salario;*/

        return dniHashMap.values().stream().filter(p -> p.getSalary() > min && p.getSalary() < max).collect(Collectors.toList());
    }

    public List<Persona>obtenerPersonasMayoresQue(int old) {

        /*ArrayList<Persona> Persona_mayor = new ArrayList<>();

        for (Persona a : personaList) {
            if (a.getOld() > (edad)) {
                Persona_mayor.add(a);
            }
        }
        return Persona_mayor;*/

        return dniHashMap.values().stream().filter(persona -> persona.getOld() > old).collect(Collectors.toList());
    }

    public Collection<Persona>obtenerTodas() {

        //return personaList;

        return dniHashMap.values();
    }

    public void obtenerSalarioMaximo() {

        dniHashMap.values().stream().max(Comparator.comparing(Persona::getSalary))
                .ifPresent(maxInt -> System.out.println("Salario Máximo : "+maxInt));
    }

    public void obtenerSalarioMinimo() {

        segSocialHashMap.values().stream().min(Comparator.comparing(Persona::getSalary))
                .ifPresent(min -> System.out.println("Salario Mínimo : "+min));

    }

    public List<Persona> ordenarPersonasDNI() {

        ArrayList<Persona> ordenarPersonasDNI = new ArrayList<>(dniHashMap.values());

        ordenarPersonasDNI.sort(Comparator.comparing(Persona::getDni));

       return ordenarPersonasDNI;



        //convertir hashmap en un arraylist y ordeno el array list con un sort y el sort se tiene que comparar

    }

    public List<Persona>ordenarPersonasSegSocial() {

        ArrayList<Persona> ordenarPersonasSegSocial = new ArrayList<>(segSocialHashMap.values());

        ordenarPersonasSegSocial.sort(Comparator.comparing(Persona::getSegsocial));

        return ordenarPersonasSegSocial;

    }

    public List<Persona>ordenarPersonasNombre() {

        ArrayList<Persona> ordenarPersonasNombre = new ArrayList<>(dniHashMap.values());

        ordenarPersonasNombre.sort(Comparator.comparing(Persona::getName));

        return ordenarPersonasNombre;

    }

    public List<Persona>ordenarPersonasApellido() {

        ArrayList<Persona> ordenarPersonasApellido = new ArrayList<>(dniHashMap.values());

        ordenarPersonasApellido.sort(Comparator.comparing(Persona::getSurname));

        return ordenarPersonasApellido;

    }

    public List<Persona>ordenarPersonasEdad() {

        ArrayList<Persona> ordenarPersonasEdad = new ArrayList<>(dniHashMap.values());

        ordenarPersonasEdad.sort(Comparator.comparing(Persona::getOld));

        return ordenarPersonasEdad;

    }

    public Collection<Persona>ordenarPersonasSalario() {

        ArrayList<Persona> ordenarPersonasSalario = new ArrayList<>(dniHashMap.values());

        ordenarPersonasSalario.sort(Comparator.comparing(Persona::getSalary));

        return ordenarPersonasSalario;

    }

    @Override
    public String toString() {
        return "SeguridadSocial{"+
                "personasList=" + personaList +
                "}";
    }
}
