
package com.project.app.academico;

import com.project.app.academico.entity.Disciplina;
import com.project.app.academico.entity.Aluno;
import com.project.app.academico.entity.Turma;
import com.project.util.*;
import com.project.collection.TreeBinary;
import com.project.collection.interfaces.IIterator;
import java.util.Comparator;

public class ProgramaPrincipal {

    // Variaveis globais e principais 
    static TreeBinary<Disciplina> listaDisciplinas;
    static TreeBinary<Aluno> listaAlunos;
    static TreeBinary<Turma> listaTurmas;
    
    // Salvar os dados em um arquivo
    static ObjectFile arqListas = new ObjectFile("DataAcademico.dat");  
    
    // Será usado para ordenação no "AlunoBusiness.listarAlunos()"
    static class CompareNomeAluno implements Comparator<Aluno> {
        @Override
        public int compare(Aluno a1, Aluno a2) {
            return a1.getNomeAluno().compareToIgnoreCase(a2.getNomeAluno());
        }
    }
    
    /**
     * BUSINESS ALUSNO 
     */    
    static class AlunoBusiness {

        public static void incluir() {
            char resp;
            do {
                Keyboard.clrscr();
                int matAluno = Keyboard.readInt("Entrar com o numero de matricula do aluno: ");
                Aluno aluno = new Aluno(matAluno);

                if (listaAlunos.contains(aluno)) {
                    System.out.println("Ja existe um aluno com essa matricula!");
                } else {
                    String nomeAluno = Keyboard.readString("Entrar com o nome do aluno: ");
                    aluno.setNomeAluno(nomeAluno);
                    listaAlunos.add(aluno);

                    System.out.println();
                    System.out.println("Aluno inserido com sucesso!");
                    System.out.println();
                }
                resp = Keyboard.readChar("Outra inclusao(s/n)? ");
            } while (resp == 's');
        }
        
        public static void editar() {
            char resp;
            do {
                Keyboard.clrscr();
                int matAlunoAtual = Keyboard.readInt("Entrar com a matricula do aluno que deseja editar: ");
                Aluno alunoAtual = new Aluno(matAlunoAtual);

                if (!listaAlunos.contains(alunoAtual)) {
                    System.out.println("Matricula informada nao existe!");
                } else {
                    int matNovoAluno = Keyboard.readInt("Entrar com a NOVA matricula do aluno: ");
                    String nomeNovoAluno = Keyboard.readString("Entrar com o NOVO nome do aluno: ");
                    
                    Aluno novoAluno = new Aluno(matNovoAluno);
                    novoAluno.setNomeAluno(nomeNovoAluno); 
                    
                    listaAlunos.replace(alunoAtual, novoAluno);
                    
                    System.out.println();
                    System.out.println("Aluno removido com sucesso!");
                    System.out.println();
                }
                resp = Keyboard.readChar("Editar outro aluno (s/n)? ");
            } while (resp == 's');
        }
        
        public static void excluir() {
            char resp;
            do {
                Keyboard.clrscr();
                int matAluno = Keyboard.readInt("Entrar com a matricula do aluno que deseja excluir: ");
                Aluno aluno = new Aluno(matAluno);

                if (!listaAlunos.contains(aluno)) {
                    System.out.println("Matricula informada nao existe!");
                } else {
                    listaAlunos.remove(aluno);
                    System.out.println();
                    System.out.println("Aluno removido com sucesso!");
                    System.out.println();
                }
                resp = Keyboard.readChar("Outra exclusao(s/n)? ");
            } while (resp == 's');
        }
        
        public static void listarAlunos() {
            Keyboard.clrscr();
            System.out.println("MatAluno  Nome do Aluno                 ");
            System.out.println("--------  ------------------------------");

            if (listaAlunos.getSize() == 0) {
                Keyboard.waitEnter();
                return;
            }
            
            // IMPRIMI DA FORMA FORMAL
            /*
            IIterator<Aluno> it = listaAlunos.iterator();
            Aluno aluno = it.getFirst();
            while (aluno != null) {
                System.out.printf("   %-3d    %-30s\n", aluno.getMatAluno(), aluno.getNomeAluno());
                aluno = it.getNext();
            }
            */
            
            // IMPRIMI DA FORMA ORDENADA
            Object[] alunosOrdenados = listaAlunos.sort(new CompareNomeAluno());
            for (Object alunosOrdenado : alunosOrdenados) {
                Aluno aluno = (Aluno) alunosOrdenado;
                System.out.printf("  %-3d    %-30s\n", aluno.getMatAluno(), aluno.getNomeAluno());
            }            
            Keyboard.waitEnter();
        }
        
        public static void matricularAluno() {
            Keyboard.clrscr();
            int matAluno = Keyboard.readInt("Entrar com o numero de matricula do aluno: ");
            Aluno aluno = new Aluno(matAluno);

            if (listaAlunos.contains(aluno)) {
                aluno = listaAlunos.retrieve(aluno);
                System.out.println("Aluno selecionado: " + aluno.getNomeAluno());
                System.out.println();

                int codDisc = Keyboard.readInt("Entrar com o codigo da disciplina: ");
                Disciplina disciplina = new Disciplina(codDisc);

                if (listaDisciplinas.contains(disciplina)) {
                    disciplina = listaDisciplinas.retrieve(disciplina);
                    System.out.println("Disciplina selecionada: " + disciplina.getNomeDisc());
                    System.out.println();

                    int codTurma = Keyboard.readInt("Entrar com o codigo da turma: ");
                    Turma turma = new Turma(disciplina.getCodDisc(), codTurma);

                    if (listaTurmas.contains(turma)) {
                        String resp = Keyboard.readString("Deseja realmente fazer a matricula?(s/n) ");
                        if (resp.equals("s")) {
                            aluno.matricular(turma);
                            System.out.println("Matriculado com sucesso!");
                            System.out.println();
                            Keyboard.waitEnter();
                        }
                    } else {
                        System.out.println("Turma inexistente!");
                        Keyboard.waitEnter();
                    }
                } else {
                    System.out.println("Disciplina inexistente!");
                    Keyboard.waitEnter();
                }
            } else {
                System.out.println("Matricula inexistente!");
                Keyboard.waitEnter();
            }
        }
        
        public static void listarDisciplinasMatriculadasPorAluno() {
            Keyboard.clrscr();
            int matAluno = Keyboard.readInt("Entrar com o numero de matricula do aluno: ");
            Aluno aluno = new Aluno(matAluno);

            if (listaAlunos.contains(aluno)) {
                aluno = listaAlunos.retrieve(aluno);
                System.out.println();
                System.out.println();
                System.out.println("NumMat: " + aluno.getMatAluno() + "  Nome do Aluno: " + aluno.getNomeAluno());
                System.out.println();

                System.out.println("CodTurma  Nome da Disciplina            ");
                System.out.println("--------  ------------------------------");

                if (!aluno.estaMatriculadoEmAlgumaTurma()) {
                    Keyboard.waitEnter();
                    return;
                }

                IIterator<Turma> it = listaTurmas.iteratorElement();
                Turma turma = it.getFirst();
                while (turma != null) {
                    if (aluno.procuraTurma(turma)) {
                        Disciplina disciplina = listaDisciplinas.retrieve(new Disciplina(turma.getCodDisc()));
                        System.out.printf("  %-3d     %-30s\n", turma.getCodTurma(), disciplina.getNomeDisc());
                    }
                    turma = it.getNext();
                }
                Keyboard.waitEnter();

            } else {
                System.out.println("Matricula inexistente!");
            }
        }
        
    }
    
    
    /**
     * BUSINESS DISCIPLINA 
     */    
    static class DisciplinaBusiness {
        
        public static void incluir() {
            char resp;
            do {
                Keyboard.clrscr();
                int codDisc = Keyboard.readInt("Entrar com o codigo da disciplina: ");
                Disciplina disciplina = new Disciplina(codDisc);

                if (listaDisciplinas.contains(disciplina)) {
                    System.out.println("Codigo de disciplina ja existente!");
                } else {
                    String nomeDisc = Keyboard.readString("Entrar com o nome: ");
                    disciplina.setNomeDisc(nomeDisc);
                    listaDisciplinas.add(disciplina);
                    System.out.println();
                    System.out.println("Disciplina inserida com sucesso!");
                    System.out.println();
                }
                resp = Keyboard.readChar("Outra inclusao(s/n)? ");
            } while (resp == 's');
        }
        
        public static void excluir() {
            char resp;
            do {
                Keyboard.clrscr();
                int codDisc = Keyboard.readInt("Entrar com o codigo da disciplina que deseja excluir: ");
                Disciplina disciplina = new Disciplina(codDisc);

                if (!listaDisciplinas.contains(disciplina)) {
                    System.out.println("Codigo de disciplina inexistente!");
                } else {

                    if (procuraDisciplinaNaTurma(disciplina.getCodDisc())) {
                        System.out.println();
                        System.out.println("Nao pode excluir a disciplina. Existem turmas associadas a essa disciplina.");
                        Keyboard.waitEnter();
                        return;
                    }

                    disciplina = listaDisciplinas.retrieve(disciplina);
                    listaDisciplinas.remove(disciplina);
                    System.out.println();
                    System.out.println("Disciplina removida com sucesso!");
                    System.out.println();
                }
                resp = Keyboard.readChar("Outra exclusao(s/n)? ");
            } while (resp == 's');
        }
        
        public static void listarDisciplinas() {
            Keyboard.clrscr();
            System.out.println("CodDisc  Nome da Disciplina            ");
            System.out.println("-------  ------------------------------");

            if (listaDisciplinas.getSize() == 0) {
                Keyboard.waitEnter();
                return;
            }

            IIterator<Disciplina> it = listaDisciplinas.iteratorElement();
            Disciplina disciplina = it.getFirst();
            while (disciplina != null) {
                System.out.printf("  %-3d    %-30s\n", disciplina.getCodDisc(), disciplina.getNomeDisc());
                disciplina = it.getNext();
            }
            Keyboard.waitEnter();
        }
        
        public static boolean procuraDisciplinaNaTurma(int codDisc) {
            IIterator<Turma> it = listaTurmas.iteratorElement();
            Turma turma = it.getFirst();
            while (turma != null) {
                if (turma.getCodDisc() == codDisc) {
                    return true;
                }
                turma = it.getNext();
            }
            return false;
        }
        
    }
    
    
    /**
     * BUSINESS TURMA 
     */    
    static class TurmaBusiness  {
    
        public static void incluir() {
            char resp;
            do {
                Keyboard.clrscr();
                int codDisc = Keyboard.readInt("Entrar com o codigo da disciplina: ");
                Disciplina disciplina = new Disciplina(codDisc);
                if (listaDisciplinas.contains(disciplina)) {
                    disciplina = listaDisciplinas.retrieve(disciplina);
                    System.out.println("Disciplina selecionada: " + disciplina.getNomeDisc());
                    System.out.println();
                    System.out.println();

                    int codTurma = Keyboard.readInt("Entrar com o codigo da turma: ");
                    Turma turma = new Turma(codDisc, codTurma);

                    if (!listaTurmas.contains(turma)) {
                        listaTurmas.add(turma);
                        System.out.println("Nova turma cadastrada com sucesso!");
                    } else {
                        System.out.println("Nao � poss�vel cadastrar duas turmas iguais!");
                    }
                } else {
                    System.out.println("Disciplina inexistente!");
                }

                resp = Keyboard.readChar("Outra inclusao(s/n)? ");
            } while (resp == 's');
        }        
        
        public static void excluir() {
            char resp;
            do {
                Keyboard.clrscr();
                int codDisc = Keyboard.readInt("Entrar com o codigo da disciplina: ");
                Disciplina disciplina = new Disciplina(codDisc);
                if (listaDisciplinas.contains(disciplina)) {
                    System.out.println("Disciplina selecionada: " + disciplina.getNomeDisc());
                    System.out.println();
                    System.out.println();

                    int codTurma = Keyboard.readInt("Entrar com o codigo da turma: ");
                    Turma turma = new Turma(codDisc, codTurma);

                    if (!listaTurmas.contains(turma)) {
                        System.out.println("Turma informada nao existe!");
                        System.out.println();
                    } else {
                        listaTurmas.remove(turma);
                        System.out.println("Turma excluida com sucesso!");
                    }
                } else {
                    System.out.println("Disciplina inexistente!");
                }

                resp = Keyboard.readChar("Outra exclusao(s/n)? ");
            } while (resp == 's');
        }   
        
        public static void listarTurmas() {
            Keyboard.clrscr();
            System.out.println("codTurma  Disciplina                    ");
            System.out.println("--------  ------------------------------");

            if (listaTurmas.getSize() == 0) {
                Keyboard.waitEnter();
                return;
            }

            IIterator<Turma> it = listaTurmas.iteratorElement();
            Turma turma = it.getFirst();
            while (turma != null) {
                Disciplina disciplina = listaDisciplinas.retrieve(new Disciplina(turma.getCodDisc()));
                System.out.printf("  %-3d    %-30s\n", turma.getCodTurma(), disciplina.getNomeDisc());
                turma = it.getNext();
            }
            Keyboard.waitEnter();
        }    
    
    }

    
    //**************************************************************************//
    //	 MENUS E SUBMENUS DO SISTEMA		 										   										   //
    //**************************************************************************//
    static void mostrarMenuManutencaoAlunos() {
        int opcao;
        Keyboard.clrscr();
        do {
            Keyboard.clrscr();
            opcao = Keyboard.menu("Incluir Aluno/Editar Aluno/Excluir Aluno/Listar Alunos/Retornar");
            switch (opcao) {
                case 1:
                    AlunoBusiness.incluir();
                    break;
                case 2:
                    AlunoBusiness.editar();
                    break;
                case 3:
                    AlunoBusiness.excluir();
                    break;
                case 4:
                    AlunoBusiness.listarAlunos();
                    break;
            }
        } while (opcao < 5);
        mostrarMenuPrincipal();
    }

    
    static void mostrarMenuManutencaoDisciplinas() {
        int opcao;
        Keyboard.clrscr();
        do {
            Keyboard.clrscr();
            opcao = Keyboard.menu("Incluir Disciplina/Excluir Disciplina/Listar Disciplinas/Retornar");
            switch (opcao) {
                case 1:
                    DisciplinaBusiness.incluir();
                    break;
                case 2:
                    DisciplinaBusiness.excluir();
                    break;
                case 3:
                    DisciplinaBusiness.listarDisciplinas();
                    break;
            }
        } while (opcao < 4);
        mostrarMenuPrincipal();
    }

    
    static void mostrarMenuManutencaoTurmas() {
        int opcao;
        Keyboard.clrscr();
        do {
            Keyboard.clrscr();
            opcao = Keyboard.menu("Incluir Turma/Excluir Turma/Listar Turmas/Retornar");
            switch (opcao) {
                case 1:
                    TurmaBusiness.incluir();
                    break;
                case 2:
                    TurmaBusiness.excluir();
                    break;
                case 3:
                    TurmaBusiness.listarTurmas();
                    break;
            }
        } while (opcao < 4);
        mostrarMenuPrincipal();
    }

    
    static void mostrarMenuMatricula() {
        int opcao;
        Keyboard.clrscr();
        do {
            Keyboard.clrscr();
            opcao = Keyboard.menu("Matricular Aluno/Listar disciplinas matriculadas pelo aluno/Retornar");
            switch (opcao) {
                case 1:
                    AlunoBusiness.matricularAluno();
                    break;
                case 2:
                    AlunoBusiness.listarDisciplinasMatriculadasPorAluno();
                    break;
            }
        } while (opcao < 3);
        mostrarMenuPrincipal();
    }

    
    static void mostrarMenuPrincipal() {
        int opcao;
        Keyboard.clrscr();
        do {
            Keyboard.clrscr();
            opcao = Keyboard.menu("Manutencao de Alunos/Manutencao de Disciplinas/Manutencao de Turmas/Matricula/Terminar");
            switch (opcao) {
                case 1:
                    mostrarMenuManutencaoAlunos();
                    break;
                case 2:
                    mostrarMenuManutencaoDisciplinas();
                    break;
                case 3:
                    mostrarMenuManutencaoTurmas();
                    break;
                case 4:
                    mostrarMenuMatricula();
                    break;
            }
        } while (opcao < 5);
    } 

    
    //**************************************************************************//
    //	 PROGRAMA PRINCIPAL		 										   										   //
    //**************************************************************************//
    @SuppressWarnings("unchecked")
    static void lerArquivo() {
        if (arqListas.reset()) {
            listaDisciplinas = (TreeBinary<Disciplina>) arqListas.read();
            listaAlunos = (TreeBinary<Aluno>) arqListas.read();
            listaTurmas = (TreeBinary<Turma>) arqListas.read();
            arqListas.closeFile();
        } else {
            listaDisciplinas = new TreeBinary<Disciplina>();
            listaAlunos = new TreeBinary<Aluno>();
            listaTurmas = new TreeBinary<Turma>();
        }
    }
     
    
    static void gravarArquivo() {
        arqListas.rewrite();
        arqListas.write(listaDisciplinas);
        arqListas.write(listaAlunos);
        arqListas.write(listaTurmas);
        arqListas.closeFile();
    }
    
    
    public static void main(String[] args) {
        
        lerArquivo();
        
        mostrarMenuPrincipal();
        
        gravarArquivo();
        
        System.out.println("\nFim do programa");
        
    }

}
