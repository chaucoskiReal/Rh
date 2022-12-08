package repository;

<<<<<<< HEAD
        import model.Candidato;
        import model.Vaga;

        import java.sql.*;
        import java.util.ArrayList;
        import java.util.List;
=======
import model.Candidato;
import model.Vaga;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
>>>>>>> origin/master

public class VagaRepository {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db_rh";
<<<<<<< HEAD
        Connection connection = DriverManager.getConnection(url, "root", "010670Mae");
=======
        Connection connection = DriverManager.getConnection(url, "root", "");
>>>>>>> origin/master


        return connection;
    }

    public void insere(Vaga vaga) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("insert into " +
                "vaga values(?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, vaga.getCodigoVaga());
        stmt.setString(2, vaga.getDescVaga());
        stmt.setString(3, String.valueOf(vaga.getDescRequisitos()));
        stmt.setInt(4,vaga.getStatusVaga().ordinal());
        stmt.setString(5, String.valueOf(vaga.getDataInicio()));
        stmt.setString(6, String.valueOf(vaga.getDataFim()));


        int i = stmt.executeUpdate();
        System.out.println(i + " linhas inseridas");
        connection.close();

    }

    public Integer proximoCodigo() throws SQLException, ClassNotFoundException {

        List<Vaga> vaga = new ArrayList<>();

        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("select max(cd_vaga) from vaga ");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            return resultSet.getInt(1) + 1;
        }
        return 1;
    }

    public void update(Vaga vaga) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("update vaga " + "SET ds_vaga = ?, ds_requisito = ? " +
                ", cd_status = ?, dt_inicio = ?, dt_fim = ?,  WHERE cd_vaga = ?");

        stmt.setString(1, vaga.getDescVaga());
        stmt.setString(2, String.valueOf(vaga.getDescRequisitos()));
        stmt.setInt(3,vaga.getStatusVaga().ordinal());
        stmt.setString(4, String.valueOf(vaga.getDataInicio()));
        stmt.setString(5, String.valueOf(vaga.getDataFim()));
        stmt.setInt(6, vaga.getCodigoVaga());
        int i = stmt.executeUpdate();
        System.out.println(i + "linhas atualizadas");
        connection.close();
    }

<<<<<<< HEAD
    public void delete(Vaga vaga) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM candidato " + " WHERE cd_candidato = ? ");

        stmt.setInt(1, vaga.getCodigoVaga().intValue());
=======
    public void delete(Candidato candidato) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM candidato " + " WHERE cd_candidato = ? ");

        stmt.setInt(1, candidato.getCodigo().intValue());
>>>>>>> origin/master
        stmt.executeUpdate();
        connection.close();
    }

<<<<<<< HEAD
    public List<Vaga> busca() throws SQLException, ClassNotFoundException {
        List<Vaga> vagas = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("select * from vaga");
=======
    public List<Candidato> busca() throws SQLException, ClassNotFoundException {
        List<Candidato> candidatos = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("select * from candidatos");
>>>>>>> origin/master
        ResultSet resultSet = stmt.executeQuery();



<<<<<<< HEAD
        return vagas;
    }
}
=======
        return candidatos;
    }
}


>>>>>>> origin/master
