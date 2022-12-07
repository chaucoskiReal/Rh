package model;

import repository.CandidatoDAO;
import repository.ProcessoSeletivoDAO;
import repository.VagaDAO;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//    try {
        menuOpcaoSistemas();
//    }catch (Exception e){
//        JOptionPane.showMessageDialog(null,"Erro no sistema!\n Entre em contato com o suporte!!!",
//                "ERRO", 0);;
//    }
    }
    private static void chamaConfirmacaoVaga() throws SQLException, ClassNotFoundException {
        Integer opcaoCrud = chamaOpcaoCrud();
        Vaga vaga = null;
        switch (opcaoCrud){
            case 0: //inserir
                vaga = chamaCadastroVagas();
            break;

            case 1: //alterar, tem que fazer as opcoes de alteracao
                break;

            case 2: //excluir, tem que fazer isso tambem
        }

    }

    private static Integer chamaOpcaoCrud(){
        String[] opcao = {"Inserção", "Alteração", "Exclusão"};
        int tipoOpcao = JOptionPane.showOptionDialog(null,"Escolha uma opção: ",
                "Operação no cadastro: ",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,opcao,
        opcao[0]);
            return tipoOpcao;
    }


    private static void chamaConfirmacaoProcessoSeletivo() throws SQLException, ClassNotFoundException {
        Integer opcaoCrud = chamaOpcaoCrud();
        ProcessoSeletivo processoSeletivo = null;
        switch (opcaoCrud){
            case 0: //inserir
                processoSeletivo = chamaProcessoSeletivo();
                break;

            case 1: //alterar, tem que fazer as opcoes de alteracao
                break;

            case 2: //excluir, tem que fazer isso tambem
        }
    }
    private static ProcessoSeletivo chamaProcessoSeletivo() throws SQLException, ClassNotFoundException {
        List<ProcessoSeletivo> processoSeletivos = new ArrayList<>();
        ProcessoSeletivo processoSeletivo = new ProcessoSeletivo();
        processoSeletivos.add(processoSeletivo);

        String[] opcaoMenuProcessoSeletivo = {"DADOS", "VOLTAR"};
        int menuCadastroProcessoSeletivo = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastro Processo Seletivo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoMenuProcessoSeletivo, opcaoMenuProcessoSeletivo[0]);

        switch (menuCadastroProcessoSeletivo) {
            case 0:
                processoSeletivo.setCodigoProcessoSeletivo(1);
                String dsStatusProcessoSeletivo = JOptionPane.showInputDialog("Escreva a descrição do status do processo seletivo: ");
                processoSeletivo.setDescStatusProcesso(dsStatusProcessoSeletivo);

                String dtInicio = JOptionPane.showInputDialog("Escreva a data inicio do processo seletivo: ");
                processoSeletivo.setDataInicio(LocalDate.parse(dtInicio));

                String dtFim = JOptionPane.showInputDialog("Escreva a data fim do processo seletivo: ");
                processoSeletivo.setDataFim(LocalDate.parse(dtFim));


                processoSeletivos.add(processoSeletivo);
                ProcessoSeletivoDAO.save(processoSeletivo);

                chamaProcessoSeletivo();
                break;

            case 1:
                menuOpcaoSistemas();
                break;
        }
        ProcessoSeletivoDAO.save(processoSeletivo);
        return processoSeletivo;
    }


    private static Candidato chamaCadastroCandidato() throws SQLException, ClassNotFoundException {

        List<Candidato> candidatos = new ArrayList<>();
        Candidato candidato = new Candidato();
        candidatos.add(candidato);

        String[] opcaoMenuCandidato = {"DADOS", "VOLTAR"};
        int menuCadastroCurriculo = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoMenuCandidato, opcaoMenuCandidato[0]);

        switch (menuCadastroCurriculo) {
            case 0:
                candidato.setCodigo(1);
                String dsCandidato = JOptionPane.showInputDialog("Escreva a descrição do candidato: ");
                candidato.setDescCandidato(dsCandidato);

                String dtNascimento = JOptionPane.showInputDialog("Escreva a sua data de nascimento: ");
                candidato.setDataNascimento(LocalDate.parse(dtNascimento));

                String cpf = JOptionPane.showInputDialog("Escreva seu cpf: ");
                candidato.setCpf(cpf);

                String descCurriculo = JOptionPane.showInputDialog("Escreva a descrição do seu curriculo: ");
                candidato.setDescCurriculo(descCurriculo);

                String descEmail = JOptionPane.showInputDialog("Escreva o seu email: ");
                candidato.setDescEmail(descEmail);

                candidatos.add(candidato);
                CandidatoDAO candidatoDAO = new CandidatoDAO();

                candidatoDAO.salvar(candidato);

                chamaCadastroCandidato();
                break;

            case 1:
                menuOpcaoSistemas();
                break;
        }

        return candidato;
    }



    private static Vaga chamaCadastroVagas() throws SQLException, ClassNotFoundException {
            List<Vaga> vagas = new ArrayList<>();
            Vaga vaga = new Vaga();
            vagas.add(vaga);
            String[] opcaoMenuVaga = {"DADOS", "VOLTAR"};
            int menuCadastroVaga = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                    "Menu Cadastro",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoMenuVaga, opcaoMenuVaga[0]);

            switch (menuCadastroVaga) {
                case 0:
                    vaga.setCodigoVaga(1);

                    Object[] status = {Status.status.ABERTO,Status.status.ANDAMENTO,Status.status.CONCLUIDO};
                    Object selecionado = JOptionPane.showInputDialog(null, "Selecione qual o status da vaga:",
                            "MENU", 1, null, status, " ");

                    if(selecionado == (Status.status.ABERTO)){
                        vaga.setDescStatus("ABERTO");
                    }else if (selecionado == (Status.status.ANDAMENTO)){
                        vaga.setDescStatus("ANDAMENTO");
                    }else if (selecionado == (Status.status.CONCLUIDO)){
                        vaga.setDescStatus("CONCLUIDOS");
                    }


                    String dsVaga = JOptionPane.showInputDialog("Escreva a descrição da vaga: ");
                    vaga.setDescVaga(dsVaga);

                    String dsRequisitos = JOptionPane.showInputDialog("Escreva a descrição dos requisitos: ");
                    vaga.setDescRequisitos(dsRequisitos);



                    vagas.add(vaga);
                    VagaDAO.save(vaga);

                    chamaCadastroVagas();
                    break;

                case 1:
                    menuOpcaoSistemas();
                    break;
            }
            VagaDAO.save(vagas);
        return vaga;
    }

     static Object menuOpcaoSistemas() throws SQLException, ClassNotFoundException {
        Object[] opcaoInicial = {Candidato.CargosSistema.RH, Candidato.CargosSistema.CANDIDATO, Candidato.CargosSistema.PROCESSOSELETIVO};
        Object selecionado = JOptionPane.showInputDialog(null, "Selecione qual sistema você quer acessar:",
                "MENU", 1, null, opcaoInicial, " ");

        if (selecionado == (Candidato.CargosSistema.RH)) {
            chamaRh();
        } else if (selecionado == (Candidato.CargosSistema.CANDIDATO)) {
            chamaCandidato();
        }else if(selecionado == Candidato.CargosSistema.PROCESSOSELETIVO){
            chamaProcessoSeletivo();
        }
        return selecionado;
    }

    private static void chamaRh() throws SQLException, ClassNotFoundException {
        chamaConfirmacaoVaga();
    }

    private static void chamaCandidato() throws SQLException, ClassNotFoundException {
        chamaCadastroCandidato();
    }
}

