/**
 * Classe responsável por chamar métodos de outras classe e que
 * interage com o usuário para a criação da lista de tarefas
 * @author João Paulo Ferreira de Moraes - TADS - 22/01/2022
 */

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		
		ArrayList<TarefasLista> lista = new ArrayList<TarefasLista>();
		
		TarefasLista tarefa = null;
		
		int identificador = 0;
		String nome;
		String descricao;
		String respUrgente;
		boolean urgente;
		int respIden;
		String saida;
		String opc;
		
		do {
			opc = JOptionPane.showInputDialog("\nA - Adicionar tarefa"
					+ "\nB - Alterar tarefa"
					+ "\nC - Buscar tarefa"
					+ "\nD - Remover tarefa"
					+ "\nF - Sair").toUpperCase(); //Menu para funções da lista
			
			switch(opc) {
			case "A":
				//Adiciona tarefas
				identificador++;
				nome = JOptionPane.showInputDialog("Insira o nome da tarefa: "); //Nome para a tarefa
				descricao = JOptionPane.showInputDialog("Insira a descrição da tarefa: "); //Descrição para tarefa
				respUrgente = JOptionPane.showInputDialog("Tarefa urgente "
						+ "[S/N]?").toUpperCase().substring(0, 1); //String para tipo de urgência da tarefa
				
				if(respUrgente.equals("S")) { //Caso a resposta seja "sim" a tarefa será urgente, caso ao contrário a tarefa não será urgente
					urgente = true;
				}else {
					urgente = false;
				}
				
				tarefa = new TarefasLista(identificador, nome, descricao, urgente);
		
				GerenciaLista.addItem(lista, tarefa);
				
				saida = GerenciaLista.exibirTarefas(lista);
				JOptionPane.showMessageDialog(null, "Lista de Tarefas:\n" + saida); //Mostra a lista com as tarefas adicionadas
				break;
			case "B":
				//Altera tarefas
				saida = GerenciaLista.exibirTarefas(lista);
				JOptionPane.showMessageDialog(null, "Alterar Tarefas:\n" + saida);
				respIden = Integer.parseInt(JOptionPane.showInputDialog("Informe o "
						+ "identificador da tarefa que deseja alterar: "));//Identificador da tarefa escolhida para ser alterada
				
				GerenciaLista.alteraItem(lista, respIden);
				saida = GerenciaLista.exibirTarefas(lista);
				JOptionPane.showMessageDialog(null, "Lista alterada com sucesso!\n" + saida);
				break;
			case "C":
				//Busca tarefas
				saida = GerenciaLista.exibirTarefas(lista);
				JOptionPane.showMessageDialog(null, saida);
				int opcBusca = Integer.parseInt(JOptionPane.showInputDialog("\n1 - Buscar por identificador"
						+ "\n2 - Buscar por nome"
						+ "\n3 - Buscar por urgência"
						+ "\nQual busca deseja fazer:")); //Menu para tipo de busca
				
				switch(opcBusca) {
				case 1:
					//Busca por identificador
					int buscaIden = Integer.parseInt(JOptionPane.showInputDialog("Informe o "
							+ "identificador da tarefa que deseja buscar: "));
					
					saida = GerenciaLista.buscarTarefa(lista, buscaIden); //String que recebe lista com as tarefas buscadas
					JOptionPane.showMessageDialog(null, saida);
					break;
				case 2:
					//Busca por nome
					String buscaNome = JOptionPane.showInputDialog("Informe o nome da tarefa que "
							+ "deseja buscar: ");
					
					saida = GerenciaLista.buscarTarefa(lista, buscaNome); //String que recebe lista com as tarefas buscadas
					JOptionPane.showMessageDialog(null, saida);
					break;
				case 3:
					//Busca por urgência
					boolean buscaUrge = Boolean.parseBoolean(JOptionPane.showInputDialog("Informe a "
							+ "urgência da tarefa que deseja buscar [true/false]: "));
					
					saida = GerenciaLista.buscarTarefa(lista, buscaUrge); //String que recebe lista com as tarefas buscadas
					JOptionPane.showMessageDialog(null, saida);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inexistente!");
				}
				break;
			case "D":
				//Remove tarefas
				saida = GerenciaLista.exibirTarefas(lista);
				JOptionPane.showMessageDialog(null, "Remover Tarefas:\n" + saida);
				respIden = Integer.parseInt(JOptionPane.showInputDialog("\nInforme o identificador da "
						+ "tarefa que deseja remover: "));
				
				GerenciaLista.removeItem(lista, respIden);
				saida = GerenciaLista.exibirTarefas(lista);
				JOptionPane.showMessageDialog(null, "Lista alterada com sucesso!\n" + saida);
				
				break;
			case "F":
				JOptionPane.showMessageDialog(null, "Saindo...");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inexistente!");
			}
		}while(!opc.equals("F"));
	}

}
