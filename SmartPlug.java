import java.util.Calendar;




public class SmartPlug extends SmartObject implements Programmable{
	
	
	private boolean status;
	private Calendar programTime;
	private boolean programAction;
	
	public SmartPlug(String Alias, String macId) {
		setAlias(Alias);
		setMacId(macId);
	}
	
	public void turnOn() { //turn on method for plug
		if (super.isConnectionStatus()==true) {
			if (status==false) {
				status=true;
				programTime=Calendar.getInstance();
				System.out.println("Smart Plug - "+ getAlias()+" is turned on now " +
				"(Current time: "+ getProgramTime()+ ")");
			}
			else if (status==true) {
				System.out.println("Smart Plug - "+ getAlias() + " has been already turned on");
			}
		}
	}
	
	public void turnOff() { //turn off method for plug
		if (super.isConnectionStatus()==true) {
			if (status==true) {
				status=false;
				programTime=Calendar.getInstance();
				System.out.println("Smart Plug - "+ getAlias()+" is turned off now " +
				"(Current time: "+ getProgramTime() + ")");
			}
			else if (status==false) {
				System.out.println("Smart Plug - "+ getAlias() + " has been already turned off");
			}
		}
	}	

	@Override
	public boolean testObject() {  //method  to see if it is working properly
		if (super.isConnectionStatus() == true) {
			System.out.println("Test is starting for SmartPlug");
			super.SmartObjectToString();
			turnOn();
			turnOff();
			System.out.println("Test completed for SmartPlug");
			System.out.println();
			return true;
			}
		else return false;
		
	}
	
	@Override
	public boolean shutDownObject() {  //Shutdown method it closing object
		if (super.isConnectionStatus() == true) {
			super.SmartObjectToString();
			if (status == true)
				status= false;
			return true;
		}
		else return false;
	}
	
	
	@Override
	public void setTimer(int seconds) { //set the timer of a smart plug with the given amount of seconds and turn it off or on
		
		 if (super.isConnectionStatus() == true) {
			programTime=Calendar.getInstance();
			if (status==true) {
			programAction=true;
			System.out.println("Smart plug - " + getAlias() + " will be turned off "+ seconds + " seconds later! "+
			"(Current Time: "+getProgramTime()+")");
			}
		   if (status==false) {
			programAction=false;
			System.out.println("Smart plug - " + getAlias() + " will be turned on "+ seconds + " seconds later! "+
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
	public void runProgram() {  //run program method  for the set timer method to work 
		
		   if (programTime==null)  {
				
			}
		   else if ((programTime.get(Calendar.HOUR_OF_DAY)==Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) && (programTime.get(Calendar.MINUTE)==Calendar.getInstance().get(Calendar.MINUTE)) && (programTime.get(Calendar.SECOND)==Calendar.getInstance().get(Calendar.SECOND))) {
			if (programAction==true) {
				status=false; 
			System.out.println("runProgram -> Smart Plug - "+ getAlias());	
			System.out.println("Smart Plug - "+ getAlias() +" is turned off now (Current time:" + getProgramTime()+")");
			}
			else if (programAction==false) {
				status=true;
				System.out.println("runProgram -> Smart Plug - "+ getAlias());	
				System.out.println("Smart Plug - "+ getAlias() +" is turned on now (Current time:" + getProgramTime()+")");
				}
			
		}
         
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
