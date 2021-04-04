package tn.esprit.spring.entity;

import java.util.Objects;



public class Vacation {
    private Long congeID ;
    private String startTime  ;
    private String endTime  ;
    private int duration;
    private String status;
    private String pic;
    private String userId;
    private String validator;
    private String Sender;
    
    

    
    public Vacation( Long congeID, String startTime ,String endTime
    		,int duration,String status,String pic,String userId,String validator,String Sender   ) {
        this.congeID = congeID;
        this.startTime= startTime;
        this.endTime = endTime ;
        this.duration = duration ;
        this.status = status ;
        this.pic = pic ;
        this.userId = userId ;
        this.validator = validator ;
        this.Sender = Sender ;
    }

   

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vacation)) return false;
        Vacation Vacation = (Vacation) o;
        return Objects.equals(congeID, Vacation.congeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(congeID);
    }

	public void remove(Vacation vacation) {
		// TODO Auto-generated method stub
		
	}
}
