package tn.esprit.spring.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Vacation;


@Service()
public class Vacationservicelmpl implements Vacationservice{
    private List<Vacation> Vacations ;
    Vacationservicelmpl(){
    Vacations=new ArrayList<Vacation>() ;
        Vacations.add(new Vacation("A","05/08/2021","20/08/2021",15,"maladie","img1.png","X","admin1","empl1")) ;
    	Vacations.add(new Vacation("B","10/09/2021","30/09/2021",10,"voyagé","img2.png","Y","admin2","empl2")) ;
    	Vacations.add(new Vacation("C","01/11/2021","05/11/2021",4,"mon frére va ce marrié","img3.png","Z","admin3","empl3")) ;
    }

    @Override
    public List<Vacation> getVacation() {
        return Vacations;
    }

    @Override
    public void addVacation(Vacation Vacation) {
    	Vacations.add(Vacation) ;
    }

    @SuppressWarnings("unchecked")
	@Override
    public void UpdateVacation(Vacation Vacation) {
    	Vacation.remove(Vacation);
    	((List<tn.esprit.spring.entity.Vacation>) Vacation).add(Vacation);
    }

    @Override
    public void deleteVacation(String congeID) {
    

    }

	
}

