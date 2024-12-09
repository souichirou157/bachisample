package demo.app.main.model;


import java.util.List;

import demo.app.warning.address.InputAddressMissmatchException;
import demo.app.warning.age.InputAgeMissmatchException;

public final class  InvalidValueCheck implements AddressValidater,AgeValidater{

	public static AddressValidater addressCheck() {
		
		return new AddressValidater() {
			
			public void addresscheck(List<AcountRegist> usertable,int index) 
					throws InputAddressMissmatchException 
			{
				{
					AddressValidater.super.addresscheck(usertable,index);
					
					System.out.println("バリデーションチェック");
				}
			}
			
		};
		
	}
	public static AgeValidater ageCheck() {
		
		
		return new AgeValidater() {
			
			public void  agecheck(List<AcountRegist> usertable,int index) throws  InputAgeMissmatchException{
				
			{
				{
					AgeValidater.super.agecheck(usertable,index);
					System.out.println("バリデーションチェック");
				}
			}
			}		
			
	};
	
	}
	
}
