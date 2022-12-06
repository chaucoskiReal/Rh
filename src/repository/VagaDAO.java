package repository;

import model.Vaga;

import java.util.ArrayList;
import java.util.List;

public final class VagaDAO {

    private static List<Vaga> vagas = new ArrayList<>();

    public static List<Vaga> findVaga(){return vagas;}

    public static void save(Vaga vaga){vagas.add(vaga);}

    public static void save(List<Vaga> vagaList){vagas.addAll(vagaList);}




}
