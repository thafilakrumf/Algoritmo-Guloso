import java.util.ArrayList;
import java.util.*;

import javax.swing.JOptionPane;

public class Main {
	

	public static void main(String[] args) {
		
		Objeto objeto = null;
		int cont = 0;
		
		int mochila = Integer.parseInt(JOptionPane.showInputDialog("Digite a capacidade da mochila: "));
		
		ArrayList<Objeto> objetos = new ArrayList<>();
		
		cont = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de objetos: ")); 
		
		for (int i=0;i<cont;i++) {
			objeto = new Objeto();
			objeto.setNome(JOptionPane.showInputDialog("Digite o nome do objeto "+(i+1)));
			objeto.setPeso(Integer.parseInt(JOptionPane.showInputDialog("Digite o peso do objeto -> "+objeto.getNome())));
			objeto.setLucro(Integer.parseInt(JOptionPane.showInputDialog("Digite o lucro do objeto ->"+objeto.getNome())));
			objetos.add(objeto);
		}		
		algoritmoGuloso(objetos, mochila);
		
	}
	
	// Comparação do maior valor do objeto
	public static Objeto maiorValor(ArrayList<Objeto> objetos) {
		
		double lucro = 0;
		Objeto objeto = null;
		
		for (Objeto o: objetos) {
			if (lucro <= (o.getLucro()/o.getPeso())) {
				lucro = o.getLucro()/o.getPeso();
				objeto = o;
			}
		}
		
		return objeto;
		
	}
	// Maior peso e valor da mochina do algoritmo guloso	
	public static void algoritmoGuloso(ArrayList<Objeto> objetos, int mochila) {
		
		int peso = 0;
		Objeto objeto = null;
		String itens = "-----Algoritmo Guloso-----\n\n Serão selecionados os itens:\n";
		
		while (peso<= mochila && !objetos.isEmpty()) {
			objeto = maiorValor(objetos);
			peso += objeto.getPeso();
			if (peso<=mochila) {
				itens += objeto.getNome()+"\n";
				objetos.remove(objeto);
			}
			else {
				peso -= objeto.getPeso();
				objetos.remove(objeto);
			}
		}
		
		JOptionPane.showMessageDialog(null, itens);
		
} }