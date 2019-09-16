
import java.text.SimpleDateFormat;

public class Course {
    String courseName;
    String courseId;
    int courseCredits;
    int sessionAmount;
    Session[] sessions;
    
    public Course(String courseName, String courseId, int courseCredits){
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseCredits = courseCredits;
        this.sessionAmount = 0;
        this.sessions = new Session[100];
    }
    
    public Session getSession(int sessionIndex){
        return this.sessions[sessionIndex];
    }
    
    public String getCourseName(){
        return this.courseName;
    }
    
    public String getCourseId(){
      return this.courseId;  
    };
    
    public int getCourseCredits(){
        return this.courseCredits;
    }
    
    public int getSessionAmount(){
        return this.sessionAmount;
    }
    
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    
    public void setCourseCredits(int courseCredits){
        this.courseCredits = courseCredits;
    }
    
    public void addSession(Session newSession){
        this.sessions[this.sessionAmount++] = newSession;
    }
    
    public static void printFormatedCourse(Course availableCourse, SimpleDateFormat dayFormat){        
        System.out.println("Course name: " + availableCourse.getCourseName() + "\n");
        System.out.println("Course ID: " + availableCourse.getCourseId() + "\n");
        System.out.println("Credit value: " + availableCourse.getCourseCredits() + "\n");
        for (int j = 0; j < availableCourse.getSessionAmount(); j++) {
            System.out.println("\n" + availableCourse.sessions[j].getSessionDay() + "\n");
            System.out.println(dayFormat.format(availableCourse.sessions[j].getArrivalTime()) + " - " + dayFormat.format(availableCourse.sessions[j].getDepartureTime()));            
        }
    }
}
