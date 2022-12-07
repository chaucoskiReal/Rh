package repository;

import java.sql.SQLException;
import java.util.List;


public interface IGenericDAO<E> {

    void salvar(E objeto);

    void remover(E objeto) throws SQLException, ClassNotFoundException;

    List<E> buscarTodos();

    List<E> buscarPorNome(String nome);

    //teste
}

