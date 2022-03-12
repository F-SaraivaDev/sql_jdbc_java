package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setId(6L);
		userposjava.setNome("Paulo Ricardo");
		userposjava.setEmail("pauloricardo@outlook.com.br");
		
		userPosDAO.salvar(userposjava);
	}
	
	@Test
	public void initlistar() {
		UserPosDAO dao = new UserPosDAO();
		List<Userposjava> list;
		try {
			list = dao.listar();
			
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("-------------------------");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initBuscar() {
		
		UserPosDAO dao = new UserPosDAO();
		
		try {
			Userposjava userposjava = dao.buscar(5L);
			
			System.out.println(userposjava);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}




































