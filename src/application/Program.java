package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

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

		IO.println("==== test #3 - Seller findAll =====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			IO.println(obj);
		}

		IO.println("==== test #4 - Seller insert =====");
		Seller newSeller = new Seller(null,"Greg","greg@gmail.com",new Date(),4000.00,department);
		sellerDao.insert(newSeller);
		IO.println("Insersed ! new Id = "+newSeller.getId());
		
		IO.println("==== test #5 - Seller update =====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		IO.println("Atualizado");

		IO.println("==== test #5 - Seller update =====");
		IO.print("inset Id from delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		IO.println("Delete Complet");
		sc.close();

		
	}

}
