package point_01;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by dsg on 19/09/16.
 */

public class SeguridadSocial {

    private List<Persona>personaList;

    public SeguridadSocial() {
        personaList=new ArrayList<>();
    }

    public void altaPersona(Persona persona) {
        //verificar que los nombres y el dni no se repiten

        String dni = persona.getDni();
        String nom = persona.getName();

        for(int i=0; i<personaList.size(); i++) {
            Persona c = personaList.get(i);
            if (c.getDni() == dni ) {
                System.out.println("El dni SI existe");
            }
            else if (c.getName() == nom) {
                System.out.println("El nombre SI existe");
                break;
            }
            System.out.println("");
        }

        personaList.add(persona);
    }

    public void bajaPersona(String dni) {
        personaList.removeIf(persona -> persona.getDni().equals(dni));
    }

   public Persona obtenerPersonaPorDNI(String dni) {
       for (int j=0; j<personaList.size();j++) {
           Persona a = personaList.get(j);
           if (a.getDni().equals(dni)) {
               return  a;
           }
       }
       return null;
   }

   public Persona obtenerPersonaPorNumSS(String segsocial) {
       for (int j=0; j<personaList.size();j++) {
           Persona a = personaList.get(j);
           if (a.getSegsocial().equals(segsocial)) {
               return  a;
           }
       }
       return null;
   }

    public List<Persona>obtenerPersonasRangoSalarial(double min, double max) {

        ArrayList<Persona> Persona_salario = new ArrayList<>();

        for (int j=0; j<personaList.size();j++) {
            Persona a = personaList.get(j);
            if (a.getSalary()>=(min) && a.getSalary()<=(max)) {
                Persona_salario.add(a);
            }
        }
        return Persona_salario;

    }

    public List<Persona>obtenerPersonasMayoresQue(int edad) {

        ArrayList<Persona> Persona_mayor = new ArrayList<>();

        for (int j=0; j<personaList.size();j++) {
            Persona a = personaList.get(j);
            if (a.getOld()>(edad)) {
                Persona_mayor.add(a);
            }
        }
        return Persona_mayor;
    }

    public List<Persona>obtenerTodas() {

        return personaList;
    }

    @Override
    public String toString() {
        return "SeguridadSocial{"+
                "personasList=" + personaList +
                "}";
    }
}
