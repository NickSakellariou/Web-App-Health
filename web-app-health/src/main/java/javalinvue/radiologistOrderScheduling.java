package javalinvue;

public class radiologistOrderScheduling {
	
	private String radiologist;
	private String executionDate;
	
	radiologistOrderScheduling(String radiologist,String executionDate)
	{
		this.setRadiologist(radiologist);
		this.setExecutionDate(executionDate);
	}
	
	public void setRadiologist(String radiologist)
	{
		this.radiologist=radiologist;
	}
	public String getRadiologist()
	{
		return this.radiologist;
	}
	
	public void setExecutionDate(String executionDate)
	{
		this.executionDate=executionDate;
	}
	public String getExecutionDate()
	{
		return this.executionDate;
	}

}
