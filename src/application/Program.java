package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		IO.println("==== test #1 - Seller findbyId =====");
		Seller seller = sellerDao.findById(3);
		IO.println(seller);

		IO.println("==== test #2 - Seller findbyDepartment =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			IO.println(obj);
			
		}

		
	}

}
