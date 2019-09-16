import java.util.Date;

public class Session {
        
    Days sessionDay;
    Date arrivalTime;
    Date departureTime;
    
    public Session(Days sessionDay, Date arrivalTime, Date departureTime){        
        this.sessionDay = sessionDay;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;        
    }
    
    public Days getSessionDay(){
        return this.sessionDay;
    }
    
    public Date getArrivalTime(){
        return this.arrivalTime;
    }
    
    public Date getDepartureTime(){
        return this.departureTime;
    }   
    
    public void setDepartureTime(Date departureTime){
        this.departureTime = departureTime;
    }
    
    public void setArrivalTime(Date arrivalTime){
        this.arrivalTime = arrivalTime;
    }    
}