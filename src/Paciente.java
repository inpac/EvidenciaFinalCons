public class Paciente {
    String id;
    String name;

    public Paciente (String id, String name){
        setId(id);
        setName(name);
    }

    private void setName(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    private void setId(String id) {
        this.id = id;

    }

    public String getId() {
        return id;
    }


}
