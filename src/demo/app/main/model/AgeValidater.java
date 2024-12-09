package demo.app.main.model;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

import demo.app.main.model.message.InvalidCatchmessage;
import demo.app.warning.age.InputAgeMissmatchException;
import demo.check.age.AgeCheck;
import demo.retouch.age.AgeRetouch;

public interface AgeValidater extends AgeCheck{
	
	
	private boolean NotAnIntegerCheck(AcountRegist usertable) {
		
		return Objects.isNull(usertable.getAge());
	}
	
	private static InvalidCatchmessage InvalidUser() {
		
		return new InvalidCatchmessage() {
			
			@Override
			public void invalidCatchMessage(AcountRegist usertable) {
				
				super.invalidCatchMessage(usertable);
			}
					
		};
	}


	private void AgeRetouch(List<AcountRegist> usertable,int index) {
		Class<?> clazz =  AcountRegist.class;
		
		Field [] field = clazz.getDeclaredFields();
		
		for(Field f : field) {
			
			if(Objects.nonNull(f.getDeclaredAnnotation(AgeRetouch.class))) {
				usertable.set(index,new AcountRegist(index,usertable.get(index).getName(),f.getDeclaredAnnotation(AgeRetouch.class).age(),usertable.get(index).getAddress()));
			}
			
		}
	}
	@Override
	public default void agecheck(List<AcountRegist> usertable,int index) throws  InputAgeMissmatchException{
		
		InvalidValueCheck   AgeCheck = new InvalidValueCheck();
		for(int i =0; i < usertable.size();i++) 
		{
			if(NotAnIntegerCheck(usertable.get(i)))  
			{

				AgeRetouch(usertable,i);	
				agecheck(usertable,i);
				InvalidCatchmessage invalid =  AgeValidater.InvalidUser();
				invalid.invalidCatchMessage(usertable.get(index));
				
				
				throw new InputAgeMissmatchException("既定値を挿入しました");
				
	
			}
		}
		
	}
}
