import java.util.ArrayList;
import java.util.Arrays;




public class SmartHome {

	ArrayList<SmartObject> smartObjectList =new ArrayList<>();;
	
	
	public SmartHome() {
	}
	
	public boolean addSmartObject(SmartObject smartObject) { //adding smart object
		smartObjectList.add(smartObject);
		int IP;
		IP=100+smartObjectList.indexOf(smartObject); //setting IP for smart objects
		smartObject.setIP("10.0.0." + IP);
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println("Adding new SmartObject");
		System.out.println("------------------------------------------------------------------");
		smartObject.connect(smartObject.getIP()); //connect the object
		smartObject.testObject(); //testing object 
		return true;
	}
	
	
	public boolean removeSmartObject(SmartObject smartObject) { //removing smart object
		smartObjectList.remove(smartObject);
		return smartObjectList.remove(smartObject);
	}
	
	public void controlLocation(boolean onCome) { //checking on come and on leave
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println("Location Control: OnCome");
		System.out.println("------------------------------------------------------------------");
	  if (onCome==true) {
			for(int i=0; i<smartObjectList.size();i++) {
				if (smartObjectList.get(i) instanceof LocationControl) 
					((LocationControl) smartObjectList.get(i)).onCome();
				}			
				
			}
	  else { 
		for(int j=0; j<smartObjectList.size();j++) {
			if (smartObjectList.get(j) instanceof LocationControl) 
				((LocationControl) smartObjectList.get(j)).onLeave();
		}	
	}
  }
	
	
	
	public void controlMotion(boolean hasMotion, boolean isDay) { //checking object having control motion
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println("MotionControl: HasMotion, isDay");
		System.out.println("------------------------------------------------------------------");	
		for(int i=0; i<smartObjectList.size() ; i++) {
			if (smartObjectList.get(i) instanceof MotionControl) 
				 ((MotionControl) smartObjectList.get(i)).controlMotion(hasMotion, isDay);
		}
		
	}
	
	public void controlProgrammable() { //checking object can be programmable if can using run program method
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println("Programmable: runProgram");
		System.out.println("------------------------------------------------------------------");
		for(int i=0; i<smartObjectList.size();i++) {
			if (smartObjectList.get(i) instanceof Programmable) 
				((Programmable) smartObjectList.get(i)).runProgram();	
	  }
	}
	
	
	public void controlTimer(int seconds) {  //checking object can be programmable if can calling set timer method or cancel timer
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println("Programmable Timer = " + seconds + "seconds");
		System.out.println("------------------------------------------------------------------");
		for (int i=0; i<smartObjectList.size();i++) {
			if (smartObjectList.get(i) instanceof Programmable)
				if(seconds>0) 
					((Programmable) smartObjectList.get(i)).setTimer(seconds);
				else if(seconds==0) 
					((Programmable) smartObjectList.get(i)).cancelTimer();
				
				}
		}
	public void controlTimerRandomly() { //checking object can be programmable if can randomly programmable timer 5 or 10 seconds
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println("Programmable Timer = 5 or 10 seconds randomly");
		System.out.println("------------------------------------------------------------------");
		for(int i=0; i<smartObjectList.size();i++) {
		int random = (int)(Math.random()*3); 
		int seconds = 0;
		
		switch(random) {
		case 0:
			 seconds=0; break;
		case 1:	
			 seconds=5; break;
		case 2:	
			 seconds=10; break;
		
		}
		if (smartObjectList.get(i) instanceof Programmable) {
			if(seconds>0)
				((Programmable) smartObjectList.get(i)).setTimer(seconds);	
			else if (seconds==0)
				((Programmable) smartObjectList.get(i)).cancelTimer();
	}
 }		
	}		
		
	public void sortCameras() { //sorting cameras 
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println("Sort Smart Cameras");
		System.out.println("------------------------------------------------------------------");
		ArrayList<SmartCamera> smartCameraList = new ArrayList<>();
		for(SmartObject object : smartObjectList) {
			if (object instanceof SmartCamera) 
				smartCameraList.add((SmartCamera) object);
		}
		Object [] smartCameras=smartCameraList.toArray(); // converting ArrayList to array
		Arrays.sort(smartCameras);
		for(Object a: smartCameras) //printing cameras
			System.out.println(a);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	

