package view;

import javax.swing.JOptionPane;

import controller.ProcessosController;

public class Principal {

	public static void main (String[] args) {
		ProcessosController pCont = new ProcessosController();
		String op = JOptionPane.showInputDialog(null, "Digite a opcao \n "+ "1 - Lista Processos\n "
				+ "2 - Mata por PID\n"
				+ "3 - Mata por nome");
		
		if (op.equals("1")) {
			pCont.listaProcessos();
		}
		
		if (op.equals("2")) {
			String pid = JOptionPane.showInputDialog(null,"Digite o PID do processo: ");
			pCont.mataPID(pid);
		}
		if (op.equals("3")) {
			String nome = JOptionPane.showInputDialog(null,"Digite o nome do processo: ");
			pCont.mataNome(nome);
		}
	}

}
