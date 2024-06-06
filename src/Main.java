import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.io.*;



public class Main {
    static String user = "admin";
    static String passw = "votoporvoto";
    static int option;
    static HashMap<String, Medico> medicos = new HashMap<String, Medico>();
    static HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
    static HashMap<String, Cita> citas = new HashMap<String, Cita>();



    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            System.out.println("Escribir nombre de usuario: ");
            String username = reader.readLine();

            System.out.println("Introduce tu contrasena0: ");
            String password = reader.readLine();

            if (authenticate(username,password)){
                System.out.println("Bienvenido a Epic 3000");
                while (true){
                    showMenu();
                    option = Integer.parseInt(reader.readLine());

                    switch (option){
                        case 1:
                            createMedico();
                            break;
                        case 2:
                            createPaciente();
                            break;
                        case 3:
                            createCita();
                            break;
                        case 4:
                            showCitas();
                            break;
                        case 5:
                            System.out.println("Saliendo del programa espere...");
                            return;
                        default:
                            System.out.println("Opcion no se reconoce");

                    }
                }
            } else{
                System.out.println("Usuario o Contasena Incorrecta");
            }

        }

    }

    public static boolean authenticate(String userin, String passwin){
/*Se utiliza esta parte para revisar la contrasena*/
        return user.equals(userin) && passw.equals(passwin);
    }

    public static void showMenu() {
/*Se utiliza para mostrar el menu del programa*/
        System.out.println("1. Agregar Medico");
        System.out.println("2. Agregar Paciente");
        System.out.println("3. Hacer Cita");
        System.out.println("4. Mostrar Citas");
        System.out.println("5. Salir");

    }


    public static void createMedico() throws IOException {
/*Aqui se crean los medicos*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce el id del Doctor: ");
        String id = reader.readLine();
        System.out.println("Introduce el nombre del Doctor: ");
        String name = reader.readLine();
        System.out.println("Introduce la especialidad del Doctor: ");
        String specialty = reader.readLine();

        Medico medico = new Medico(id, name, specialty);
        medicos.put(id,medico);
        saveMedico(medico);
        System.out.println("El Doctor se ha agregado al sistema!");


    }

    public static void createPaciente() throws IOException {
/*se hace branch para crear pacientes*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce el id del Paciente: ");
        String id = reader.readLine();
        System.out.println("Introduce el nombre del Paciente: ");
        String name = reader.readLine();


        Paciente paciente = new Paciente(id, name);
        pacientes.put(id,paciente);
        savePaciente(paciente);
        System.out.println("El Paciente se ha agregado al sistema!");
    }

    public static void createCita() throws IOException {
/*se hace branch de crear cita*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce el id de la Cita: ");
        String id = reader.readLine();
        System.out.println("Introduce el id del Paciente: ");
        String pacienteid = reader.readLine();

        if (!pacientes.containsKey(pacienteid)){
            System.out.println("No se encontro el paciente en el sistema!");
            return;
        }
        System.out.println("Introduce el id del Doctor: ");
        String medicoId = reader.readLine();
            if(!medicos.containsKey(medicoId)){
                System.out.println("No se encontro el Doctor en el sistema!");
                return;
            }
        System.out.println("Introduce la fecha y hora de la cita: (MM/DD/YYYY HH:MM");
        String fechahora = reader.readLine();
        System.out.println("Introduce la razon de la cita: ");
        String motivo = reader.readLine();
        Cita cita = new Cita(id, fechahora, motivo, medicos.get(medicoId), pacientes.get(pacienteid));
        citas.put(id,cita);
        saveCita(cita);
        System.out.println(" La cita ha sido agendada! ");
    }

    public static void showCitas() throws IOException {
        /*se hace branch para mostrar citas*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduce el Folio de tu cita: ");
        String citaId = reader.readLine();

        if(citas.containsKey(citaId)){
            Cita cita = citas.get(citaId);
            System.out.println("Folio de cita: "+ cita.getId());
            System.out.println("Fecha de cita: "+ cita.getFechahora());
            System.out.println("El doctor es: "+ cita.getMedico().getName());
            System.out.println("El paciente es: "+ cita.getPaciente().getName());
            System.out.println("El motivo de la visita es: "+ cita.getMotivo());


        } else {
            System.out.println("No se encontro la cita con ese Folio!");
        }

    }

    public static void saveMedico(Medico medico) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("medicos.txt",true))){
            writer.write(medico.getId() + "," + medico.getName() + ","+medico.getSpecialty());
            writer.newLine();
        }
    }

    public static void savePaciente(Paciente paciente) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pacientes.txt",true))){
            writer.write(paciente.getId() + "," + paciente.getName());
            writer.newLine();
        }
    }
    public static void saveCita(Cita cita) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("citas.txt",true))){
            writer.write(cita.getId() + "," + cita.getFechahora()+","+cita.getMotivo()+","+cita.getMedico().getId()+","+cita.getPaciente().getId());
            writer.newLine();
        }
    }

    }