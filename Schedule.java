import java.util.Arrays;
import java.util.Date;

public class Schedule {
    int maxCredits;
    int courseCount;
    int totalCredits;
    Course userCourses[];
    
    public Schedule(int maxCredits, int totalCredits){
        this.userCourses = new Course[100];
        this.maxCredits = maxCredits;
        this.totalCredits = totalCredits;        
        this.courseCount = 0;
    }
    
    public int getMaxCredits(){
        return this.maxCredits;
    }
    
    public Course getUserCourse(int courseIndex){
        return this.userCourses[courseIndex];
    }

    public int getCourseCount(){
        return this.courseCount;
    }
    
    public int getTotalCredits(){
        return this.totalCredits;
    }
    
    public void setMaxCredits(int maxCredits){
        this.maxCredits = maxCredits;
    }
    
    public void setTotalCredits(int totalCredits){
        this.totalCredits = totalCredits;
    }
    
    public String enrollToCourse(Course course){
        if(findCourseById(course.getCourseId())) return "Already enrolled to course! \n";
        if(this.totalCredits + course.getCourseCredits() > this.maxCredits) return "Credit limit reached \n";
        
        for(int i = 0; i < this.courseCount; i++){
            for(int j = 0; j < this.userCourses[i].getSessionAmount(); j++){
                    Date course1Start = this.userCourses[i].getSession(j).getArrivalTime();
                    Date course1End = this.userCourses[i].getSession(j).getDepartureTime();
                for(int k = 0; k < course.getSessionAmount(); k++){
                    Date course2Start = course.getSession(k).getArrivalTime();
                    Date course2End = course.getSession(k).getDepartureTime();
                   if(isOverlapping(course1Start, course1End, course2Start, course2End)) return "Schedule overlaps! \n";
                }
            }       
        }
        this.totalCredits += course.getCourseCredits();
        this.userCourses[this.courseCount] = course;
        this.courseCount++;
        return "Successful enrollment \n";
    }
    
    public String unenrollToCourse(String courseId){
        if(!findCourseById(courseId)) return "Course not found \n";
        Course newCourses[] = new Course[100];
        for(int i = 0, k = 0; i < this.courseCount; i++){
            if(this.userCourses[i].getCourseId().equals(courseId)) continue;
            newCourses[k++] = this.userCourses[i];
        }
        this.userCourses = Arrays.copyOf(newCourses, 100);
        this.courseCount--;
        return "Successful unenrollment \n";
    }
    
    private boolean findCourseById(String courseId){
        boolean isEnrolledToCourse = false;
        for(int i = 0; i < this.courseCount; i++){
            if(this.userCourses[i].getCourseId().equals(courseId)) isEnrolledToCourse = true;
        }
        return isEnrolledToCourse;
    }
    
    private boolean isOverlapping(Date course1StartDate, Date course1EndDate, Date course2StartDate, Date course2EndDate){
        return course1StartDate.before(course2EndDate) && course2StartDate.before(course1EndDate);
    }
}
