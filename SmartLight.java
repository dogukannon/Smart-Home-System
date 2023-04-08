import java.util.Calendar;



public class SmartLight extends SmartObject implements LocationControl , Programmable{
	
	
	private boolean hasLightTurned;
	private Calendar programTime;
	private boolean programAction;
	
	
	public SmartLight(String alias, String macId) {
		setAlias(alias);
		setMacId(macId);
	}
	
	public void turnOnLight() {    	//turn on light method for lights
		if (super.isConnectionStatus()==true) {
		if (hasLightTurned==false) {
			hasLightTurned=true;
		programTime=Calendar.getInstance();
		System.out.println("Smart Light - "+getAlias() +" is turned on now "+
		"(Current time: "+ getProgramTime() + ")");
	}
		else if  (hasLightTurned==true)
			System.out.println("Smart Light - Living Room Light has been already turned on");
		}
	}
	
	
	public void turnOffLight() {		//turn off light method for lights
		if (super.isConnectionStatus()==true) {
		if (hasLightTurned == true) {
			hasLightTurned = false;
		programTime=Calendar.getInstance();
		System.out.println("Smart Light - " + getAlias() +" is turned off now "+
			"(Current time: "+ getProgramTime() + ")");
		}
		else if (hasLightTurned == false)
			System.out.println("Smart Light - Living Room Light has been already turned off");
		}		
	}
	
	@Override
	public boolean testObject() {  //method  to see if it is working properly
		if (super.isConnectionStatus() == true) {
			System.out.println("Test is starting for SmartLight");
		super.SmartObjectToString();
		turnOnLight();
		turnOffLight();
		System.out.println("Test completed for SmartLight");
		System.out.println();	
		return true;
		}
		else
		return false;
		
		
	}
	@Override
	public boolean shutDownObject() {  //Shutdown method it closing object
		if (super.isConnectionStatus() == true) {
			super.SmartObjectToString();
			if (hasLightTurned == true)
				hasLightTurned= false;
			return true;
		}
		else return false;
		
	}
	
	
	@Override
	public void onLeave() {
		if (super.isConnectionStatus() == true) {
			if  (hasLightTurned == true) 
				System.out.println("On Leave -> Smart Light - "+ getAlias());
				turnOffLight();		
		}
	}
	
	
	
	@Override
	public void onCome() {
		if (super.isConnectionStatus() == true) {
			if  (hasLightTurned == false) 
				System.out.println("On Come -> Smart Light - "+ getAlias());
				turnOnLight();	
	     }
	}
	
	@Override
	
	public void setTimer(int seconds) { //set the timer of a smart light with the given amount of seconds and turn it off or on
		
	 if (super.isConnectionStatus() == true) {
		programTime=Calendar.getInstance();
		if (hasLightTurned==true) {
		programAction=true;
		System.out.println("Smart light - " + getAlias()+ " will be turned off "+ seconds + " seconds later! "+
		"(Current Time: "+getProgramTime()+")");
		}
	   if (hasLightTurned==false) {
		programAction=false;
		System.out.println("Smart light - " + getAlias()+ " will be turned on "+ seconds + " seconds later! "+
	   "(Current Time: "+ getProgramTime()+")");
		   }
	   programTime.add(Calendar.SECOND, seconds);
	 }
	}
	
	@Override
	public void cancelTimer() { //canceling timer
		if (super.isConnectionStatus() == true)
			programTime=null;
				
	}
	
	@Override
	public void runProgram() { //run program method  for the set timer method to work 
		if (programTime==null) {
			
		}
		else if ((programTime.get(Calendar.HOUR_OF_DAY)==Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) && (programTime.get(Calendar.MINUTE)==Calendar.getInstance().get(Calendar.MINUTE)) && (programTime.get(Calendar.SECOND)==Calendar.getInstance().get(Calendar.SECOND))) {
			if (programAction==true) {
				hasLightTurned=false;
			System.out.println("runProgram -> Smart Light - "+ getAlias());	
			System.out.println("Smart Light - "+ getAlias() +" is turned off now (Current time:" +getProgramTime() +")");
			}
			else if (programAction==false) {
				hasLightTurned=true;
			System.out.println("runProgram -> Smart Light - "+ getAlias());	
			System.out.println("Smart Light - "+ getAlias() +" is turned on now (Current time:" + getProgramTime()+")");
				}
		}
		 
		
	}
	
	public boolean isHasLightTurned() {
		return hasLightTurned;
	}
	public void setHasLightTurned(boolean hasLightTurned) {
		this.hasLightTurned = hasLightTurned;
	}
	public String getProgramTime() { //get time in proper format
		String hour="";
		String minutes="";
		String seconds="";
		
		if (programTime.get(Calendar.HOUR_OF_DAY) < 10) 
	     hour+= "0"+programTime.get(Calendar.HOUR_OF_DAY);
		else 
		hour+=programTime.get(Calendar.HOUR_OF_DAY);
	
		
		if (programTime.get(Calendar.MINUTE) < 10) 
		 minutes+= "0"+programTime.get(Calendar.MINUTE); 
		else 
		  minutes+=programTime.get(Calendar.MINUTE);
		
		
		if (programTime.get(Calendar.SECOND) < 10) 
		 seconds+= "0"+programTime.get(Calendar.SECOND);
		else 
		  seconds+=programTime.get(Calendar.SECOND);
	
		return hour+ ":" + minutes +":"+seconds;
	}
	
	public void setProgramTime(Calendar programTime) {
		this.programTime = programTime;
	}
	public boolean isProgramAction() {
		return programAction;
	}
	public void setProgramAction(boolean programAction) {
		this.programAction = programAction;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
