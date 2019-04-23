package application;

import java.util.Scanner;
import java.util.Stack;

public class Program {
	
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao;
		do {
			menu();
			opcao = sc.nextInt();
			processaOpcao(opcao);
		}while(opcao != 2);
	}
	
	private static void menu() {
		System.out.println();
		System.out.println("1 - Verificar balanceamento");
		System.out.println("2 - Encerrar");
		System.out.print("    Informe a opção: ");
	}
	
	private static void processaOpcao(int opcao) {
		switch(opcao) {
		case 1:
			System.out.print("Digite uma string com até 70 caracteres: ");
			sc.nextLine();
			String string = sc.nextLine();
			System.out.println();
			System.out.println("A string \"" + string + "\" está " + verificaBalanceamento(string)+".");
			break;
		case 2:
			System.out.println("PROGRAMA ENCERRADO!!!");
			break;
		default:
			System.out.println("NÃO EXISTE ESSA OPÇÃO!!!");
			System.out.println("Tente novamente.");
		}
	}

	private static String verificaBalanceamento(String string) {
		Stack<Character> pilha = new Stack<>();
		String resposta = "desbalanceada";
		for(int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			switch(c) {
			case '{': case '[': case '(':
				pilha.push(c);
				break;
			case '}': case ']': case ')':
				if(pilha.size() == 0) {
					return resposta;
				}
				char d = pilha.pop();
				if(!((d == '{' && c =='}') || (d == '[' && c == ']') || (d == '(' && c == ')'))) {
					return resposta;
				}
			}
		}
		if(pilha.size() > 0) {
			return resposta;
		}
		
		resposta = "balanceada";
		return resposta;
	}

}
