package demo.app;

import demo.app.main.model.Container;
import demo.app.warning.InputMissmatchException;
import demo.app.warning.address.InputAddressMissmatchException;
import demo.app.warning.age.InputAgeMissmatchException;



public class App {

	public static void main(String[] args)
			
			throws InputMissmatchException
	{
		
	
		Container.getInstance((con)->{
			
			 con.regist();	
			 
			 try {
				 con.VarlidateCheck();
				 
			 
			 } catch (InputAddressMissmatchException e) {
				 e.printStackTrace();
			
			 } catch (InputAgeMissmatchException e) {
				 e.printStackTrace();
			}
						
					 
				
			con.findAll();
							
							 	
		});
		
	
			
	}



}

//try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/information","root","");){
//	
//	for(int i =0; i < array.size();i++)
//	{
//
//		String query = "UPDATE  POSTDATA SET ADDRESS =?  WHERE ADDRESS = NULL  ;";
//		PreparedStatement ps = con.prepareStatement(query);
//
//		ps.setString(1, array.get(i).getName());
//		ps.setInt(2, array.get(i).getAge());
//		ps.setString(3, array.get(i).getAddress());
//		ps.setInt(4, array.get(i).getId());
//
//		ps.executeUpdate();
//	}
//	
//	
//	
//	
//		
//} catch (SQLException e) {
//	// TODO 自動生成された catch ブロック
//	e.printStackTrace();
//}
//
//}

