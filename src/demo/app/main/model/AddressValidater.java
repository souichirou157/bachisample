package demo.app.main.model;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import demo.app.main.model.message.InvalidCatchmessage;
import demo.app.warning.address.InputAddressMissmatchException;
import demo.check.address.AddressCheck;
import demo.retouch.address.AddressRetouch;

public interface AddressValidater extends AddressCheck{
	
	
	private  boolean NullAddressCheck(AcountRegist usertable) 
	{
		
		return Objects.isNull(usertable.getAddress());
	}
	
	private static InvalidCatchmessage InvalidUser() 
	{
		
		return new InvalidCatchmessage() {
			
			@Override
			public void invalidCatchMessage(AcountRegist usertable) {
				
				super.invalidCatchMessage(usertable);
			}
					
		};
	}
	

	private void AddressRetouch(List <AcountRegist>usertable,int index)
	{

		Class clazz = AcountRegist.class;
		Field[]field = clazz.getDeclaredFields();
	
		for(Field f:field) 
		{
			if(Objects.nonNull(f.getDeclaredAnnotation(AddressRetouch.class))) 
			{
				
				System.out.println("修正");
				usertable.set(index,new AcountRegist(usertable.get(index).getId(),usertable.get(index).getName(),usertable.get(index).getAge(),f.getDeclaredAnnotation(AddressRetouch.class).address()));
			


				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/userinformation","root","");)
				{
								
						String query = "UPDATE  POSTDATA SET ADDRESS = ?  WHERE ADDRESS IS NULL  ;";
						PreparedStatement ps = con.prepareStatement(query);		
						ps.setString(1,f.getDeclaredAnnotation(AddressRetouch.class).address());
							
						ps.executeUpdate();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
									
			}
		}

}

	
	@SuppressWarnings("unused")
	@Override
public default void addresscheck(List<AcountRegist> usertable,int index) 
			
			throws InputAddressMissmatchException {
		
		
		for(int i =index; i < usertable.size(); i++) 
		{
	
			if(NullAddressCheck(usertable.get(i))) 
			{

				InvalidCatchmessage invalid = AddressValidater.InvalidUser();
				invalid.invalidCatchMessage(usertable.get(index));

				AddressRetouch(usertable,i);
				addresscheck(usertable,i);
				throw new InputAddressMissmatchException("既定値を挿入しました");
		
				}					
			}		
	}



	
	
}
		

	
	
	


