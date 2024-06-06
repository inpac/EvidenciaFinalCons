public class Cita {


    String id;
    String fechahora;
    String motivo;
    Medico medico;
    Paciente paciente;

    public Cita(String id, String fechahora, String motivo,Medico medico, Paciente paciente){

        this.id = id;
        this.fechahora = fechahora;
        this.motivo = motivo;
        this.medico = medico;
        this.paciente = paciente;

    }
    public String getId(){
        return id;
    }
    public String getFechahora(){
        return fechahora;
    }
    public String getMotivo(){
        return motivo;
    }
    public Medico getMedico(){
        return medico;
    }
    public Paciente getPaciente(){
        return paciente;
    }



    }



