package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;


public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		IO.println("==== test #1 - Department findbyId =====");
		Department dep  = departmentDao.findById(3);
		IO.println(dep);


		IO.println("==== test #2 - Department findAll =====");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			IO.println(obj);
		}

		IO.println("==== test #3 - Department insert =====");
		Department newDepartment = new Department(null,"Desenvolvimento");
		departmentDao.insert(newDepartment);
		IO.println("Insersed ! new Id = "+newDepartment.getId());
		
		IO.println("==== test #4 - Departmennt update =====");
		dep = departmentDao.findById(1);
		dep.setName("Novo Dep 1");
		departmentDao.update(dep);
		IO.println("Atualizado");

		IO.println("==== test #5 - Department Delete =====");
		IO.print("inset Id from delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		IO.println("Delete Complet");
		sc.close();


	}

}
