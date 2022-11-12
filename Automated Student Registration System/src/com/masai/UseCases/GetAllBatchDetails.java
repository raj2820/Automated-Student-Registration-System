package com.masai.UseCases;

import java.util.List;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.model.AdminBatchDTO;

public class GetAllBatchDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		AdminDao dao =new AdminDaoImpl();
		
		
try {
			
			List<AdminBatchDTO> dtos = dao.getStudentsInAllBatches();
			dtos.forEach(s->System.out.println("Student name :" +s.getSname()+" \n"+"Roll number : "+s.getRoll()+ "\n"+"COurse Id : "+s.getCid()+
					"\n"+"Course Name : "+s.getCname()+" \n"+"\n"+"Batch id : "+s.getBid()+"\n"+"Batch Name : "+s.getBatchname()+"\n"+"Batch Capacity(Seats) : "+s.getSeats()
				+"\n"	+"=================================================================="));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		
		
		
	}

}
