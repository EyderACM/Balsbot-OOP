import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class BalsBot {
    public static void main(String[] args) throws ParseException{
        SimpleDateFormat dayFormat = new SimpleDateFormat("HH:mm");                
        
        Course calculoIntegral = new Course("Calculo integral", "CI1", 20);
        Course orientadaObjetos = new Course("Programacion orientada a objetos", "OBJ1", 10);
        Course teoriaComputacion = new Course("Teoria de la computacion", "T01", 10);
        Course arquitecturaComputadoras = new Course("Arquitectura de computadoras", "AC1", 10);
        Course algebraLineal = new Course("Algebra Lineal", "AL1", 10);
        Course estructurasDatos = new Course("Estructuras de datos", "ED1", 10);
        
        /*Calculo Integral horario*/
        calculoIntegral.addSession(new Session(Days.MONDAY, dayFormat.parse("07:30"), dayFormat.parse("09:00")));
        calculoIntegral.addSession(new Session(Days.TUESDAY, dayFormat.parse("07:30"), dayFormat.parse("09:00")));
        calculoIntegral.addSession(new Session(Days.FRIDAY, dayFormat.parse("10:30"), dayFormat.parse("12:00")));
        /*Orientada a objetos*/
        orientadaObjetos.addSession(new Session(Days.MONDAY, dayFormat.parse("09:00"), dayFormat.parse("10:30")));
        orientadaObjetos.addSession(new Session(Days.TUESDAY, dayFormat.parse("09:00"), dayFormat.parse("10:30")));
        orientadaObjetos.addSession(new Session(Days.THURSDAY, dayFormat.parse("09:00"), dayFormat.parse("10:30")));
        /*Teoría de la computación*/
        teoriaComputacion.addSession(new Session(Days.MONDAY, dayFormat.parse("10:30"), dayFormat.parse("12:00")));
        teoriaComputacion.addSession(new Session(Days.THURSDAY, dayFormat.parse("07:30"), dayFormat.parse("09:00")));
        teoriaComputacion.addSession(new Session(Days.FRIDAY, dayFormat.parse("07:30"), dayFormat.parse("09:00")));
        /*Arquitectura de computadoras*/
        arquitecturaComputadoras.addSession(new Session(Days.TUESDAY, dayFormat.parse("10:30"), dayFormat.parse("12:00")));
        arquitecturaComputadoras.addSession(new Session(Days.WEDNESDAY, dayFormat.parse("11:00"), dayFormat.parse("12:30")));
        arquitecturaComputadoras.addSession(new Session(Days.FRIDAY, dayFormat.parse("09:00"), dayFormat.parse("10:30")));
        /*Estructuras de datos*/
        estructurasDatos.addSession(new Session(Days.MONDAY, dayFormat.parse("07:30"), dayFormat.parse("09:00")));
        
        Course availableCourses[] = {calculoIntegral, orientadaObjetos, teoriaComputacion, arquitecturaComputadoras, algebraLineal, estructurasDatos};              
        Schedule mySchedule = new Schedule(50, 0);
        
        int decision;
        Scanner decisionScanner = new Scanner(System.in);
        
        do{
            System.out.println("Bienvenido a SICEI2\n");
            System.out.println("Acciones disponibles\n");
            System.out.println("1.- Mostrar asignaturas disponibles\n");
            System.out.println("2.- Cargar asignaturas\n");
            System.out.println("3.- Remover asignatura\n");
            System.out.println("4.- Mostrar mi calendario\n");
            System.out.println("0.- Salir\n\n");
            System.out.println("Ingresa una accion: \n");
            
            decision = parseInt(decisionScanner.nextLine());
            
            switch(decision){
                case 1:
                    for(Course availableCourse : availableCourses){
                        Course.printFormatedCourse(availableCourse, dayFormat);
                    }                    
                break;
                case 2:
                    String courseId;
                    Course selectedCourse = null;                    
                    boolean foundCourse = false;
                    System.out.println("Ingresa el ID del curso \n");
                    courseId = decisionScanner.nextLine();
                    for(Course availableCourse : availableCourses){
                        if(availableCourse.getCourseId().equals(courseId)){
                            selectedCourse = availableCourse;
                            foundCourse = true;
                        }
                    }
                    if(foundCourse){
                        System.out.println(mySchedule.enrollToCourse(selectedCourse) + "\n");
                    }else{
                        System.out.println("Curso no encontrado \n\n");
                    }
                break;
                case 3:
                    System.out.println("\nIngresa el ID del curso que deseas eliminar\n");
                    String toDeleteCourseId = decisionScanner.nextLine();
                    System.out.println(mySchedule.unenrollToCourse(toDeleteCourseId));
                break;
                case 4:
                    System.out.println("\nMi calendario:\n\n");
                    for(int i = 0; i < mySchedule.getCourseCount(); i++){
                        Course.printFormatedCourse(mySchedule.getUserCourse(i), dayFormat);
                    }                    
            }
            
        }while(decision != 0);
        
    }
}
