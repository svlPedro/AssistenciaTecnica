package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidades.ArCondicionado;
import util.JPAUtil;

public class ArCondicionadoDAO {
	
	public static void salvar(ArCondicionado arc) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(arc);
		em.getTransaction().commit();
		em.close();
	}

	public static void deletar(ArCondicionado arc) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		arc = em.find(ArCondicionado.class, arc.getId());
		em.remove(arc);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<ArCondicionado> listarTodos() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select a from ArCondicionado a");
		List<ArCondicionado> lista = q.getResultList();
		em.close();
		return lista;
	}	
}