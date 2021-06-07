/**
 *
 * @author Ida Bagus Ryogassa Avatara
 * Note to self: work on question (e)!!
 */


public class Vehicles {
    
    public static void main(String[] args) {
       
        PoliceCar arr[];
    
      
    }

// POLICE CAR
class PoliceCar implements IsEmergancy, LandVehicle {
	
	int policeID= 1203343247;
        
	@Override
	public void drive() {   
                System.out.print("V");
	}

	@Override
	public void soundSiren() {
		System.out.print("WAY");
		
	}
        
	public void arrest() {
		System.out.print("A");
		
	}
        
	
}

class Jeep implements  LandVehicle {
	public void soundHorn(){
            
        }

	@Override
	public void drive() {
		
		
	}
           
}


class Hovercraft implements LandVehicle,SeaVehicle {
	public void enterLand(){
        
        }
	
        public void enterSea(){
	
        }
        
	@Override
	public void drive() {
		
		
	}
        
        @Override
	public void launch() {
		
		
	}

        
}


class Frigate implements SeaVehicle {
	public void fireGun(){
        
        }

	@Override
	public void launch() {
		
		
	}
        
}
// Interfaces
public interface IsEmergancy {
	public void soundSiren();
			
}


public interface Vehicle {
	String name = "";
	int maxPassengers = 7;
	int maxSpeed = 250;
	
}


public interface LandVehicle extends Vehicle {
	int numWheels = 10;
	public void drive();
        
}


public interface SeaVehicle extends Vehicle {
	int displacement = 2;
	public void launch();
        
}


}
