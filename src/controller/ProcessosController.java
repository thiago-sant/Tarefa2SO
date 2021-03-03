package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessosController {
	public ProcessosController() {
		super();
	}
	
	String os = System.getProperty("os.name");
	
	public String listaProcessos() {
		if (os.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha !=null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		if (os.contains("Linux")) {
			try {
			Process p = Runtime.getRuntime().exec("ps -ef");
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader (fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha !=null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public String mataPID(String pid) {
		if (os.contains("Windows")) {
		try {
			Runtime.getRuntime().exec("TASKKILL /PID "+pid);
			System.out.println("Processo "+pid+" finalizado com sucesso!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		if(os.contains("Linux")) {
			try {
				Runtime.getRuntime().exec("kill -9 "+pid);
				System.out.println("Processo "+pid+" finalizado com sucesso!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return pid;
	}
	
	public String mataNome(String nome) {
		if (os.contains("Windows")) {
			try {
				Runtime.getRuntime().exec("TASKKILL /IM "+nome);
				System.out.println("Processo "+nome+" finalizado com sucesso!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (os.contains("Linux")) {
			try {
				Runtime.getRuntime().exec("pkill -f "+nome);
				System.out.println("Processo "+nome+" finalizado com sucesso!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return nome;
	}
}
