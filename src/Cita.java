public class Cita {


    String id;
    String fechahora;
    String motivo;
    Medico medico;
    Paciente paciente;

    public Cita(String id, String fechahora, String motivo,Medico medico, Paciente paciente){
        setId(id);
        setFechahora(fechahora);
        setMotivo(motivo);
        setMedico(medico);
        setPaciente(paciente);

    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }



}

