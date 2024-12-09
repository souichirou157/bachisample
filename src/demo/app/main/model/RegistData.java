package demo.app.main.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.register.Register;

public final class RegistData implements Register{
	
	@Override

	public List<AcountRegist> regist()
	{
		ResultSet rs =null;
		PreparedStatement ps = null;
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/userinformation","root","");){
			
			String query = "SELECT *  FROM  POSTDATA ;";
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			

			List<AcountRegist> 		array = new ArrayList<AcountRegist>();
			int i =0;
			while(rs.next()) {
			array.add(i,new AcountRegist(rs.getInt("ID"),rs.getString("NAME"),
						                  rs.getInt("AGE"),rs.getString("ADDRESS")));
				i++;
			}
			

			return array;
				
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			
			return null;
		}
		
	}

	protected List<AcountRegist> addData() {
		
		return regist();
	}
	

	
	protected void getData(List<AcountRegist> array ) 
	{
		System.out.println("------------更新完了------------");
		
	
		
		
		System.out.println();
		for(AcountRegist acr: array) 
		{
			
			System.out.print("ID::  ");
			System.out.println(acr.getId());
			System.out.print("氏名:: ");
			System.out.println(acr.getName());
			System.out.print("年齢:: ");
			System.out.println(acr.getAge());
			System.out.print("住所:: ");
			System.out.println(acr.getAddress());
			System.out.println();
		}
	}
	

}
