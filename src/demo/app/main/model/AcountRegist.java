package demo.app.main.model;
import java.util.function.Consumer;

import demo.retouch.address.AddressRetouch;
import demo.retouch.age.AgeRetouch;

public class AcountRegist{ 

	private Integer id ;
	private String name;
	
	@AgeRetouch(age = 0) 
	private Integer age;
	@AddressRetouch(address = "未入力")
	private String address;
	
	AcountRegist(){}
	
	AcountRegist(int id ,String name,Integer age
			,String address)
	{
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	AcountRegist(int id,String name,Integer age)
	{
		this.id = id;
		this.name = name;
		this.age = age;
		
	}
	AcountRegist(int id ,String name,String address)
	{
		this.id = id;
		this.name = name;
		this.address = address;
		 
		
	}
	 AcountRegist(int id ,String name) {
		 this.id = id;
		 this.name = name;
	}
	 
	public static Consumer<AcountRegist> getInstance (Consumer<AcountRegist> regist)
	{
		 
		 regist.accept(new AcountRegist());
		 
		 return regist;
	}
	
	Integer getId() {
		return this.id;
	}
	
	 String getName()
	{
		return this.name;
		
	}
	
	String getAddress() 
	{
		return this.address;
	}
	
	Integer getAge() {
		
		return this.age;
	}
		
	
}


//


///	if(Objects.nonNull(user.address)) return true;
//
//throw new InputMismatchException("既定値を入力します");
//	
//}/		if(user.age >=0)  return true;
//	
//	throw new InputMismatchException("整数値で年齢を入力してください");
