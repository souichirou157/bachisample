//package main;
//
//import java.util.List;
//
//import demo.app.acount.AcountRegist;
//import demo.app.acount.Container;
//import demo.app.acount.InputMismatchException;
//
//public class AcountInfoApp {
//
//	public static void main(String[] args) {
//
//		
//		Container.getInstance((con)->{
//	
//			List<AcountRegist> array = con.regist();
//			
//			for(int i =0; i < 	con.regist().size();i++) 
//			{
//				try {
//					
//					con.agecheck(array.get(i));
//					con.adresscheck(array.get(i));
//				} 
//				catch (InputMismatchException e) 
//				{
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				}
//				
//			}
//		});
//	}
//
//
//
//}
