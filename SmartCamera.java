import java.util.Calendar;





public class SmartCamera extends SmartObject implements MotionControl, Comparable<SmartCamera> {
		
	
		private boolean status;
		private int batteryLife;
		private boolean nightVision;
		
		
	public SmartCamera(String alias, String macId, boolean nightVision, int batteryLife) {
		setAlias(alias);
		setMacId(macId);
		this.nightVision=nightVision;
		this.batteryLife=batteryLife;	
		
	}
	
	public void recordOn(boolean isDay) { //record on method for camera	
	if (super.isConnectionStatus()==true)	{
	   if ((isDay==false && nightVision==true) || isDay==true) { //checking camera can be record  in day or night
			if (status==false) {
				status=true;
				System.out.println("Smart Camera - "+ getAlias() +" is turned on now");
			}
			else if (status==true) {
				System.out.println("Smart Camera - "+ getAlias() + " has been already turned on");
			}
	}
	   else if ((isDay==false && nightVision==false)) { //if camera can not record in night
		   System.out.println("Sorry! Smart Camera - "+ getAlias() +" does not have night vision feature.");
		    }
	 } 

	}		
	public void  recordOff() {  //record off method for camera
		if (super.isConnectionStatus()==true) {
			if (status==true) {
				status=false;
				System.out.println("Smart Camera - "+ getAlias() +" is turned off now" );
			}
			else if (status==false) {
				System.out.println("Smart Camera - "+ getAlias() + " has been already turned off");
			}
		}
	}
	@Override
	public boolean testObject() { //method  to see if it is working properly
	if (super.isConnectionStatus() == true) {
		System.out.println("Test is starting for SmartCamera");
		super.SmartObjectToString();
		System.out.println("Test is starting for SmartCamera day time");
		recordOn(true);
		recordOff();
		System.out.println("Test is starting for SmartCamera night time");
		recordOn(false);
		recordOff();
		System.out.println("Test completed for SmartCamera");
		System.out.println();
		return true;
	
	}
	else return false; 
	}
	
	@Override
	public boolean shutDownObject() { //Shutdown method it closing object
		if (super.isConnectionStatus() == true) {
			super.SmartObjectToString();
			if (status == true)
				status= false;
			return true;
		}
		else return false;
	}
	
	
	@Override 
	public boolean controlMotion (boolean hasMotion, boolean isDay) { //motion control if there is a motion it start recording
		if (hasMotion == true) {
			System.out.println("Motion detected!");
			if(isDay==true) {
				status=true;
				System.out.println("Smart Camera - " + getAlias() + " is turned on now");
			}
			else if(isDay==false && nightVision==true) {
				status=true;
				System.out.println("Smart Camera - " + getAlias() + " is turned on now");
			}			
		}
		else 
			System.out.println("Motion not detected!");
	return hasMotion;
	}
	
	@Override 
	public int compareTo(SmartCamera smartCamera) {  //comparing camera's batterylife
		if (batteryLife > smartCamera.getBatteryLife())
			return 1;
		else if(batteryLife == smartCamera.getBatteryLife())
			return 0;
		else return -1;
	}
	
	@Override
	public String toString() { //printing camera's battery and whether it is recording or not
		
		if(status==true) {
			return "Smart Camera -> " + getAlias() + "'s battery life is " + batteryLife + " status is recording";
		}
		else
			return "Smart Camera -> " + getAlias() + "'s battery life is " + batteryLife + " status is not recording";	
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getBatteryLife() {
		return batteryLife;
	}
	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}
	public boolean isNightVision() {
		return nightVision;
	}
	public void setNightVision(boolean nightVision) {
		this.nightVision = nightVision;
	}

}
