package com.rexssecurity.dao;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.rexpress.beans.UserBean;
import com.rexpress.common.dao.CommonDaoImpl;
import com.rexpress.entities.ConfigOptions;
import com.rexssecurity.entitys.Usuario;
import com.rexssecurity.services.Role;

@Repository
public class UsuarioDaoImpl extends CommonDaoImpl<Usuario, Integer> implements UsuarioDao {

	private static final Logger logger = LogManager.getLogger(UsuarioDaoImpl.class);

	@Override
	public Class<Usuario> getDaoTypeClass() {
		// TODO Auto-generated method stub

		return Usuario.class;
	}

	@Override
	public void altaUsuario(Usuario entity) {

		create(entity);

	}

	@Override
	public List<Usuario> userQueryCorreo(UserBean usuariobean) {


		List<Usuario> listaUsuarios = (List<Usuario>) createNamedQuery("Usuario.findByCorreo")
				.setParameter("correo", usuariobean.getCorreo()).getResultList();

		return listaUsuarios;
	}

	@Override
	public List<Usuario> usersQueryRole(String value) {
		// TODO Auto-generated method stub

		List<Usuario> listaUsuarios = createNamedQuery("Usuario.findByRole").setParameter("role", value)
				.getResultList();
		// List listaUsuarios=(List) createHQLQuery("SELECT * FROM test.usuario
		// WHERE tipo=USU");

		return listaUsuarios;
	}

	@Override
	public List<Usuario> listaUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> listaUsuarios = (List<Usuario>) createNamedQuery("Usuario.list").getResultList();
		getEntityManager().close();
		return listaUsuarios;
	}

	@Override
	public Usuario userQueryNombre(String nombre) {
		Usuario usuario2 = (Usuario) createNamedQuery("Usuario.findByNombre").setParameter("nombre", nombre)
				.getSingleResult();
		return usuario2;
	}

	@Override
	public List<Usuario> userQueryNombreList(String nombre) {
		List<Usuario> listaUsuarios = createNamedQuery("Usuario.findByNombre").setParameter("nombre", nombre)
				.getResultList();
		return listaUsuarios;
	}

	@Override
	public List<Usuario> usersQueryFilter(String tipo, String campo, String valor) {
		String query = "SELECT * FROM test.usuarios where ";
		if (tipo != null)
			query += "role = '" + tipo + "' and " + campo + " like '%" + valor + "%'";
		else
			query += campo + " like '%" + valor + "%'";

		List<Usuario> listaUsuarios = (List<Usuario>) createNativeQuery(query, Usuario.class).getResultList();
		return listaUsuarios;
	}

	@Override
	public void listPrubea() {
		// TODO Auto-generated method stub
		
		List<Usuario> lista =createNamedQuery("Usuario.list",Usuario.class).getResultList();
		List<?> lista2 =getSessionManager().getNamedQuery("listaOpciones").list();
	//	List<Usuario> lista=	getSessionManager().getNamedQuery("usuarioALL").list();
		
		
		Usuario ap= (Usuario) lista.get(0);
	}

}
