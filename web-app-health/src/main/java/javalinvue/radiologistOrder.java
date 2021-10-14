package javalinvue;

public class radiologistOrder {
	
	private int radiologistOrderId;
	private String name;
	private String surname;
	private String father;
	private String mother;
	private String gender;
	private String birthdate;
	private String address;
	private String homephone;
	private String mobilephone;
	private String orderDate;
	private String causes;
	private String radiologistOperation;
	private String suggestedExecutionDate;
	private int priority;
	
	radiologistOrder(int radiologistOrderId,String name,String surname,String father,String mother,String gender,String birthdate,String address,String homephone,String mobilephone,String orderDate,String causes,String radiologistOperation,String suggestedExecutionDate,int priority)
	{
		this.setRadiologistOrderId(radiologistOrderId);
		this.setName(name);
		this.setSurname(surname);
		this.setFather(father);
		this.setMother(mother);
		this.setGender(gender);
		this.setBirthdate(birthdate);
		this.setAddress(address);
		this.setHomephone(homephone);
		this.setMobilephone(mobilephone);
		this.setOrderDate(orderDate);
		this.setCauses(causes);
		this.setRadiologistOperation(radiologistOperation);
		this.setSuggestedExecutionDate(suggestedExecutionDate);
		this.setPriority(priority);
	}
	
	public void setRadiologistOrderId(int radiologistOrderId)
	{
		this.radiologistOrderId=radiologistOrderId;
	}
	public int getRadiologistOrderId()
	{
		return this.radiologistOrderId;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return this.name;
	}
	
	public void setSurname(String surname)
	{
		this.surname=surname;
	}
	public String getSurname()
	{
		return this.surname;
	}
	
	public void setFather(String father)
	{
		this.father=father;
	}
	public String getFather()
	{
		return this.father;
	}
	
	public void setMother(String mother)
	{
		this.mother=mother;
	}
	public String getMother()
	{
		return this.mother;
	}
	
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	public String getGender()
	{
		return this.gender;
	}
	
	public void setBirthdate(String birthdate)
	{
		this.birthdate=birthdate;
	}
	public String getBirthdate()
	{
		return this.birthdate;
	}
	
	public void setAddress(String address)
	{
		this.address=address;
	}
	public String getAddress()
	{
		return this.address;
	}
	
	public void setHomephone(String homephone)
	{
		this.homephone=homephone;
	}
	public String getHomephone()
	{
		return this.homephone;
	}
	
	public void setMobilephone(String mobilephone)
	{
		this.mobilephone=mobilephone;
	}
	public String getMobilephone()
	{
		return this.mobilephone;
	}
	
	public void setOrderDate(String orderDate)
	{
		this.orderDate=orderDate;
	}
	public String getOrderDate()
	{
		return this.orderDate;
	}
	
	public void setCauses(String causes)
	{
		this.causes=causes;
	}
	public String getCauses()
	{
		return this.causes;
	}
	
	public void setRadiologistOperation(String radiologistOperation)
	{
		this.radiologistOperation=radiologistOperation;
	}
	public String getRadiologistOperation()
	{
		return this.radiologistOperation;
	}
	
	public void setSuggestedExecutionDate(String suggestedExecutionDate)
	{
		this.suggestedExecutionDate=suggestedExecutionDate;
	}
	public String getSuggestedExecutionDate()
	{
		return this.suggestedExecutionDate;
	}
	
	public void setPriority(int priority)
	{
		this.priority=priority;
	}
	public int getPriority()
	{
		return this.priority;
	}

}
