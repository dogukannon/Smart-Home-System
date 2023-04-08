
public abstract class SmartObject {
	//The purpose of the program is creating smart home. In a smart home system, there might be several intelligent objects such as smart light, smart plug, smart camera, etc.
	//These devices can be connected to the internet and they can be controlled by households remotely. Nowadays, we can use such devices to improve smart life experience thanks to internet technology and smartphones.
	

	
	
	private String alias;
	private String macId;
	private String IP;
	private boolean connectionStatus;
	
	
	public SmartObject() {	
	}
	
	
	public boolean connect(String IP) { //connection method
		this.IP=IP;
		connectionStatus = true;
		System.out.println(""+getAlias()+" connection established");
		return connectionStatus;
	}
	
	
	public boolean disconnect() { //disconnection method
		this.IP=null;
		connectionStatus =false;
		return connectionStatus;
		
	}
	public void SmartObjectToString() { // writing objet name macId and IP
		System.out.println("This is " + getClass().getSimpleName() + " device "+
			getAlias()+"\n"+"\t" + "MacId: "+ getMacId() +"\n"+"\t"+"IP: " + getIP());
				
	}
	public boolean controlConnection() { //connection control method
		if (connectionStatus==false)
			System.out.println("This device is not connected. " +getClass().getSimpleName()+
					"-> "+getAlias());
		return false;
		
	}
	//abstract methods
	public abstract boolean testObject();
	public abstract boolean shutDownObject();
	
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getMacId() {
		return macId;
	}
	public void setMacId(String macId) {
		this.macId = macId;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public boolean isConnectionStatus() {
		return connectionStatus;
	}
	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}
	
	
	
	
	
	
	

}
