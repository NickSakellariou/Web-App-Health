package javalinvue;

public class radiologist {
	
	private int radiologistId;
	private String name;
	private int radiologistOrders;
	
	radiologist(int radiologistOrderId,String name,int radiologistOrders)
	{
		this.setRadiologistId(radiologistId);
		this.setName(name);
		this.setRadiologistOrders(radiologistOrders);
	}
	
	public void setRadiologistId(int radiologistId)
	{
		this.radiologistId=radiologistId;
	}
	public int getRadiologistId()
	{
		return this.radiologistId;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return this.name;
	}
	
	public void setRadiologistOrders(int radiologistOrders)
	{
		this.radiologistOrders=radiologistOrders;
	}
	public int getRadiologistOrders()
	{
		return this.radiologistOrders;
	}

}
