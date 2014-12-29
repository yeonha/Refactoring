package refactoring;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();
    
    public Customer(String _name) {
        super();
        this._name = _name;
    }
    
    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }
    
    public String getName() {
        return _name;
    }
    
    public String statement() {
        Enumeration<Rental> rentals = _rentals.elements();
        
        String result = getName() + " 고객님의 대여 기록 \n";
        
        while(rentals.hasMoreElements() ) {
            Rental each = (Rental) rentals.nextElement();
           
            result += "\t" + each.getMovie().getTitle()+ "\t" + String.valueOf(each.getCharge()) + "\n" ;
        }
        
        result += "누적 대여료 : " + String.valueOf(getTotalCharge() ) + "\n";
        result += "적립포인트 : " + String.valueOf(getFrequentRenterPoins());
        return result;
        
    }
    public String htmlStatement() {
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "<H1><EM>" + getName() + " 고객님의 대여 기록" +  "</EM></H1><P> \n";
        
        while(rentals.hasMoreElements() ) {
            Rental each = (Rental) rentals.nextElement();
           
            result += "\t" + each.getMovie().getTitle()+ "\t" + String.valueOf(each.getCharge()) + "<BR> \n" ;
        }
        
        result += "<P>누적 대여료 : <EM>" + String.valueOf(getTotalCharge() ) + "</EM><P>\n";
        result += "적립포인트 : <EM>" + String.valueOf(getFrequentRenterPoins()) +"</EM><P>";
        
        return result;
    }
    
    private double getTotalCharge() {
        double result = 0 ;
        Enumeration<Rental> rentals = _rentals.elements();
        
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        
        return result;
    }
    
    private int getFrequentRenterPoins() {
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
          
          while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
          }
          return frequentRenterPoints;
    }
    
}
