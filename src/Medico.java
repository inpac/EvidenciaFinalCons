public class Medico {

    String id;
    String name;
    String specialty;
    
    public Medico(String id, String name, String specialty){
        setId(id);
        setName(name);
        setSpecialty(specialty);

    }

    public void setSpecialty(String specialty){
        this.specialty = specialty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }


}
