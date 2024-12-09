package demo.app.main.model;

import java.util.List;
import java.util.function.Consumer;

import demo.app.warning.address.InputAddressMissmatchException;
import demo.app.warning.age.InputAgeMissmatchException;

public class Container {
	
	private List<AcountRegist> array ;
	private static final RegistData container = new RegistData();
	
	
	public Container() {
			
	}
	
	
	public static Consumer< Container> getInstance (Consumer<Container> regist)
	{
		
		regist.accept(new Container());
		
		return regist;
	}
	
	public void VarlidateCheck() 
			
			throws InputAddressMissmatchException, InputAgeMissmatchException 
	{
		AddressValidater adv  =	InvalidValueCheck.addressCheck();
		AgeValidater agv  =	InvalidValueCheck.ageCheck();

		adv.addresscheck(array, 0);
		agv.agecheck(array, 0);

	}
	
	
	
	
	public List<AcountRegist> regist() {
		
			array = container.addData();
			
		return array;
	}
	

	public void findAll() {

		
		container.getData(array);
	}


	

}
