package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();

		userposjava.setNome("Julio");
		userposjava.setEmail("juliocarlos@outlook.com.br");

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

	@Test
	public void initAtualizar() {

		try {

			UserPosDAO dao = new UserPosDAO();

			Userposjava objetoBanco = dao.buscar(5L);

			objetoBanco.setNome("Nome mudado com o método atualizar");

			dao.atualizar(objetoBanco);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void iniDeletar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(5L);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testeInsertTelefone() {

		Telefone telefone = new Telefone();
		telefone.setNumero("(21) 2405 2668");
		telefone.setTipo("residencial");
		telefone.setUsuario(10L);

		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);

	}

}
