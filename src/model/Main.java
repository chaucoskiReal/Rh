package model;

import repository.CandidatoDAO;
import repository.VagaDAO;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
    try {
        menuOpcaoSistemas();
    }catch (Exception e){
        JOptionPane.showMessageDialog(null,"Erro no sistema!\n Entre em contato com o suporte!!!",
                "ERRO", 0);;
    }
    }
    private static void chamaConfirmacao () {
        int confirmacaoCadastroPaciente = JOptionPane.showConfirmDialog(null, "Deseja cadastrar uma vaga? ");
        if (confirmacaoCadastroPaciente == 0) {
            chamaCadastroVagas();
        } else if (confirmacaoCadastroPaciente == 1) {
            menuOpcaoSistemas();
        } else if (confirmacaoCadastroPaciente == 2) {
            JOptionPane.showMessageDialog(null, "PROGRAMA CANCELADO PELO USUÁRIO!",
                    "AVISO", 0);
            exit(0);
        }

    }

    private static void chamaCadastroCandidato(){
        List<Candidato> candidatos = new ArrayList<>();
        Candidato candidato = new Candidato();
        candidatos.add(candidato);

        String[] opcaoMenuVaga = {"DADOS", "VOLTAR"};
        int menuCadastroCurriculo = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcaoMenuVaga, opcaoMenuVaga[0]);

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
                CandidatoDAO.save(candidato);

                chamaCadastroCandidato();
                break;

            case 1:
                menuOpcaoSistemas();
                break;
        }
        CandidatoDAO.save(candidato);
    }



    private static void chamaCadastroVagas() {
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
        }

     static Object menuOpcaoSistemas() {
        Object[] opcaoInicial = {Candidato.CargosSistema.RH, Candidato.CargosSistema.CANDIDATO};
        Object selecionado = JOptionPane.showInputDialog(null, "Selecione qual sistema você quer acessar:",
                "MENU", 1, null, opcaoInicial, " ");

        if (selecionado == (Candidato.CargosSistema.RH)) {
            chamaRh();
        } else if (selecionado == (Candidato.CargosSistema.CANDIDATO)) {
            chamaCandidato();
        }
        return selecionado;
    }

    private static void chamaRh() {
        chamaConfirmacao();
    }

    private static void chamaCandidato(){
        chamaCadastroCandidato();
    }
}

