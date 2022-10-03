import java.util.*;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class ex2sem3 {
	public static void main(String[] args) {
		String conta;
		conta = showInputDialog("Informe a equação: ");
		conta = conta.replaceAll(" ", "");
		conta = conta.toUpperCase();
		calc(conta);
			
	}
	public static void calc(String conta){
		Stack<Double> pilha = new Stack<Double>();
		char ch;
		for(int i = 0; i < conta.length(); i++) {
			ch = conta.charAt(i);
			if(ch != ' ') {
			switch(ch) {
				case '+':
				case '-':
				case '*':
				case '/':
				case '%':
				case '^':
				case '(':
				case ')':
					break;
					default:
					String aux2 = "";
					aux2 += ch;
						if(aux2.matches("[A-Z]*")) {
							char aux = showInputDialog("Informe o valor de: " + ch).charAt(0);
							conta = conta.replace(ch, aux);
					}
			}
		}
	}
			for(int i = 0; i < conta.length(); i++) {
				ch = conta.charAt(i);
				double x , y;
				if(ch != ' ') {
					switch(ch) {
						case '+':
							x = pilha.pop();
							y = pilha.pop();
							y = y + x;
							pilha.push(y);
							break;
						case '-':
							x = pilha.pop();
							y = pilha.pop();
							y = y - x;
							pilha.push(y);
							break;
						case '*':
							x = pilha.pop();
							y = pilha.pop();
							y = y * x;
							pilha.push(y);
							break;
						case '/':
							x = pilha.pop();
							y = pilha.pop();
							y = y / x;
							pilha.push(y);
							break;
						case '%':
							x = pilha.pop();
							y = pilha.pop();
							y = y % x;
							pilha.push(y);
							break;
						case '^':
							x = pilha.pop();
							y = pilha.pop();
							y = Math.pow(y, x);
							pilha.push(y);
							break;
						case '(':
						case ')':
							break;
						default:
							double aux = (double) Character.digit(ch, 10);
							pilha.push(aux);
					}
				}
			}
			showMessageDialog(null, "Resultado: " + pilha.pop());
		}
	}

