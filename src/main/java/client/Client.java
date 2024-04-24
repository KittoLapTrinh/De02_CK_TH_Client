package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Map;

import dao.CandidateDao;
import dao.PositionDao;
import entity.Candidate;
import entity.Position;



public class Client{
	private static final String URL = "rmi://TAMNHU:1545/";
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		try {
			PositionDao positionDao = (PositionDao) Naming.lookup(URL + "position");
			CandidateDao candidateDao = (CandidateDao) Naming.lookup(URL + "candidateDao");
			
			////////////////////////////////////////////////////
			//1. Them
//			 	Position newPosition = new Position();
//			 	newPosition.setId("P112");
//	            newPosition.setName("Software Engineer");
//	            newPosition.setDescription("Develop software applications");
//	            newPosition.setSalary(50000); // Giả sử mức lương là 50000
//	            newPosition.setNumber(3); // Số lượng vị trí là 3
//	            boolean added = positionDao.add(newPosition);
//	            if (added) {
//	                System.out.println("Vị trí mới đã được thêm vào cơ sở dữ liệu.");
//	            } else {
//	                System.out.println("Không thể thêm vị trí mới vào cơ sở dữ liệu.");         
//	            }
			
			
	            /////////////////////////////////////////////////////////			
//			positionDao.listPositions("Software Engineer", 10000, 20000).forEach(System.out::println);
			
			
			/////////////////////////////////////////////////////////
//			Map<Candidate, Long> candidatesByCompanies = candidateDao.listCandidatesByCompanies();		
//            // Hiển thị danh sách ứng viên theo số công ty làm việc
//            System.out.println("Danh sách ứng viên theo số công ty làm việc:");
//            for (Map.Entry<Candidate, Long> entry : candidatesByCompanies.entrySet()) {
//                System.out.println(entry.getKey().getFullName() + " - " + entry.getValue() + " công ty");
//            }
            
            ///////////////////////////////////////////////////////////////
            Map<Candidate, Position> candidatesWithLongestWorking = candidateDao.listCandidatesWithLongestWorking();
            // Hiển thị danh sách ứng viên và vị trí làm việc lâu nhất
            System.out.println("Danh sách ứng viên và vị trí làm việc lâu nhất:");
            for (Map.Entry<Candidate, Position> entry : candidatesWithLongestWorking.entrySet()) {
                System.out.println(entry.getKey().getFullName() + " - " + entry.getValue().getName());
            }
            
            
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
