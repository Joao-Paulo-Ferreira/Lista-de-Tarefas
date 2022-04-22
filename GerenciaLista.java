/**
 * Classe de funcionalidades da lista de tarefas
 * @author João Paulo Ferreira de Moraes - TADS - 22/01/2022
 */

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class GerenciaLista {

	public static void addItem(ArrayList<TarefasLista> lista, TarefasLista tarefa) {
		//Método que adiciona tarefas na lista
		if(tarefa != null) {
			lista.add(tarefa);
		}else {
			System.out.println("Item vazio!");
		}
		
	}

	public static void removeItem(ArrayList<TarefasLista> lista, int identificador) {
		//Método que remove a tarefa com o identificador passado como parâmetro na lista
		Iterator<TarefasLista> it;
		it = lista.iterator();
		TarefasLista tarefa;
		while(it.hasNext()) {
			tarefa = it.next();
			if(lista == null) {
				JOptionPane.showMessageDialog(null, "Lista vazia!");
			}else {
				if(tarefa.getIdentificador() == identificador) {
					it.remove();
				}
			}
		}
	}
	
	public static void alteraItem(ArrayList<TarefasLista> lista, int identificador) {
		//Método que realiza alterações em determinada tarefa da lista
		Iterator<TarefasLista> busca;
		busca = lista.iterator();
		TarefasLista tarefa;
		int opc = 0;
		while(busca.hasNext()) {
			tarefa = busca.next();
			do{
				if(tarefa.getIdentificador() == identificador) {
					opc = Integer.parseInt(JOptionPane.showInputDialog("\n1-Alterar nome"
							+ "\n2-Alterar descrição"
							+ "\n3-Alterar urgência"
							+ "\n0-Sair"
							+ "\nQual atributo do item deseja alterar?")); //Menu para alterações nas tarefas

					switch(opc) {
					case 1: 
						//Altera nome da tarefa na lista
						String novoNome = JOptionPane.showInputDialog("Insira um novo nome: ");
						tarefa.setNome(novoNome);
						break;
					case 2:
						//Altera descrição da tarefa na lista
						String novaDescricao = JOptionPane.showInputDialog("Insira uma nova descrição: ");
						tarefa.setDescricao(novaDescricao);
						break;
					case 3: 
						//Altera urgência da tarefa na lista
						if(tarefa.getUrgente() == false) {
							tarefa.setUrgente(true);
						}else {
							tarefa.setUrgente(false);
						}
						break;
					case 0:
						JOptionPane.showMessageDialog(null, "Saindo...");
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opção inexistente!");
					}
				}
			}while(opc != 0);
		}

	}

	public static String exibirTarefas(ArrayList<TarefasLista> lista) {
		//Método responsável pela exibição das tarefas na lista
		Iterator<TarefasLista> it;
		it = lista.iterator();
		TarefasLista tarefaAux;
		String saida = "";
		while(it.hasNext()) {
			tarefaAux = it.next();
			saida += tarefaAux.toString() + "\n"; 
		}
		return saida;
	}
	
	public static String buscarTarefa(ArrayList<TarefasLista> lista, int identificador) {
		//Método que percorre a lista e realiza a busca pelo identificador da tarefa
		Iterator<TarefasLista> busca;
		busca = lista.iterator();
		TarefasLista tarefa;
		String saida = "";
		while(busca.hasNext()){
			tarefa = busca.next();
			if(tarefa.getIdentificador() == identificador) { //Caso haja no array a tarefa com o identificador passado como parâmetro essa tarefa é salva no array para ser retornada ao final
				saida += tarefa.toString() + "\n";
			}
		}
		return saida;
	}
	
	public static String buscarTarefa(ArrayList<TarefasLista> lista, String nome) {
		//Método que percorre a lista e realiza a busca pelo tipo nome da tarefa
		Iterator<TarefasLista> busca;
		busca = lista.iterator();
		TarefasLista tarefa;
		String saida = "";
		while(busca.hasNext()){
			tarefa = busca.next();
			if(tarefa.getNome().equals(nome)) { //Caso haja no array a tarefas com o nome passado como parâmetro essas tarefas são salvas no array para serem retornadas ao final
				saida += tarefa.toString() + "\n";
			}
		}
		return saida;
	}
	
	public static String buscarTarefa(ArrayList<TarefasLista> lista, boolean urgente) {
		//Método que percorre a lista e realiza a busca pelo tipo de urgência
		Iterator<TarefasLista> busca;
		busca = lista.iterator();
		TarefasLista tarefa;
		String saida = "";
		while(busca.hasNext()){
			tarefa = busca.next();
			if(tarefa.getUrgente() == urgente) { //Caso haja no array a tarefas com a urgência passada como parâmetro essas tarefas são salvas no array para serem retornadas ao final
				saida += tarefa.toString() + "\n";
			}
		}
		return saida;
	}
	
}
