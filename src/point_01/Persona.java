package point_01;

/*
 * Created by dsg on 19/09/16.
 */
public class Persona {

    private String dni;
    private String segsocial;
    private String name;
    private String surname;
    private int old;
    private double salary;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSegsocial() {
        return segsocial;
    }

    public void setSegsocial(String segsocial) {
        this.segsocial = segsocial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Persona(String dni, String segsocial, String name, String surname, int old, double salary) {
        this.dni = dni;
        this.segsocial = segsocial;
        this.name = name;
        this.surname = surname;
        this.old = old;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                "surname='" + surname + '\'' +
                "dni='" + dni + '\'' +
                "segsocial='" + segsocial + '\'' +
                "old=" + old +
                "salary=" + salary +
                '}';
    }
}
