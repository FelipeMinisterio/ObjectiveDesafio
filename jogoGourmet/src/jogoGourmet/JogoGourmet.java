package jogoGourmet;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JogoGourmet {

	JFrame jFrame;
	Object[] options = { "Sim", "Nao" };

	JogoGourmet(List<TipoDeComida> tiposDeComidas){
				
		jFrame = new JFrame();
		Object[] options = {"Sim","Nao"};
		int response = 0;

		response = JOptionPane.showConfirmDialog(jFrame,"Pense em um prato que gosta","Jogo Gourmet", JOptionPane.PLAIN_MESSAGE);	
		if(response == -1) {
			System.exit(1);
		}
			for(int x=0;x<tiposDeComidas.size();x++) {
				response = JOptionPane.showOptionDialog(jFrame,"O prato que voce pensou e "+tiposDeComidas.get(x).nome+" ? ","Confirm",JOptionPane.YES_NO_CANCEL_OPTION,
					    JOptionPane.QUESTION_MESSAGE, null, options,options[1]);	
				if(response == -1) {
					System.exit(1);
				}
				if(response == 0) {
					response = JOptionPane.showOptionDialog(jFrame,"O prato que voce pensou e "+tiposDeComidas.get(x).comida+" ? ","Confirm",JOptionPane.YES_NO_CANCEL_OPTION,
						    JOptionPane.QUESTION_MESSAGE, null, options,options[1]);					
				if(response == 0) {
					JOptionPane.showMessageDialog(jFrame, "Acertei mais uma vez !", "Jogo Gourmet", 1);
					new JogoGourmet(tiposDeComidas);
				}else {
					if(response == -1) {
						System.exit(1);
					}
					if(tiposDeComidas.get(x).subTipo.size() == 0) {
						String comida = JOptionPane.showInputDialog(jFrame,"Qual foi o prato que voce pensou?","Desisto", JOptionPane.PLAIN_MESSAGE);
						String tipoComida = JOptionPane.showInputDialog(jFrame,comida+" e _____ mas "+tiposDeComidas.get(x).comida+" nao.","Desisto", JOptionPane.PLAIN_MESSAGE);
						TipoDeComida tpComida = new TipoDeComida();
						tpComida.nome = tipoComida;
						tpComida.comida = comida;
						tiposDeComidas.get(x).subTipo.add(tpComida);
						new JogoGourmet(tiposDeComidas);
					}else {
						if(response == -1) {
							System.exit(1);
						}
						for(int y=0;y<tiposDeComidas.get(x).subTipo.size();y++) {
							response = JOptionPane.showOptionDialog(jFrame,"O prato que voce pensou e "+tiposDeComidas.get(x).subTipo.get(y).nome+" ? ","Confirm",JOptionPane.YES_NO_CANCEL_OPTION,
								    JOptionPane.QUESTION_MESSAGE, null, options,options[1]);
							if(response == 0) {
								response = JOptionPane.showOptionDialog(jFrame,"O prato que voce pensou e "+tiposDeComidas.get(x).subTipo.get(y).comida+" ? ","Confirm", JOptionPane.YES_NO_CANCEL_OPTION,
									    JOptionPane.QUESTION_MESSAGE, null, options,options[1]);
							if(response == 0) {
								JOptionPane.showMessageDialog(jFrame,"Acertei mais uma vez !","Jogo Gourmet",1);	
								new JogoGourmet(tiposDeComidas);
							}
							}
							if(y == tiposDeComidas.get(x).subTipo.size() - 1) {
								String comida = JOptionPane.showInputDialog(jFrame,"Qual foi o prato que voce pensou?","Desisto", JOptionPane.PLAIN_MESSAGE);
								String tipoComida = JOptionPane.showInputDialog(jFrame,comida+"e _____ mas"+tiposDeComidas.get(x).subTipo.get(y).comida+" nao.","Desisto", JOptionPane.PLAIN_MESSAGE);
								TipoDeComida tpComida = new TipoDeComida();
								tpComida.nome = tipoComida;
								tpComida.comida = comida;
								tiposDeComidas.get(x).subTipo.add(tpComida);
								new JogoGourmet(tiposDeComidas);
							}
						}
						
					}
				}
				}
				if(x == tiposDeComidas.size() - 1) {
					response = JOptionPane.showOptionDialog(jFrame,"O prato que voce pensou e Bolo de Chocolate ? ","Jogo Gourmet",JOptionPane.YES_NO_CANCEL_OPTION,
						    JOptionPane.QUESTION_MESSAGE, null, options,options[1]);
					if(response == 0) {
						JOptionPane.showMessageDialog(jFrame,"Acertei mais uma vez !","Jogo Gourmet", 1);	
						new JogoGourmet(tiposDeComidas);
					}else {
						if(response == -1) {
							System.exit(1);
						}			
					String comida = JOptionPane.showInputDialog(jFrame,"Qual foi o prato que voce pensou?","Desisto", JOptionPane.PLAIN_MESSAGE);
					String tipoComida = JOptionPane.showInputDialog(jFrame,comida+" e _____ mas Bolo de Chocolate nao.","Desisto", JOptionPane.PLAIN_MESSAGE);
					TipoDeComida tpComida = new TipoDeComida();
					tpComida.nome = tipoComida;
					tpComida.comida = comida;
					tiposDeComidas.add(tpComida);
					new JogoGourmet(tiposDeComidas);
					}
				}
				
				
			}
	}

	public static void main(String[] args) {
		List<TipoDeComida> tiposDeComidas = new ArrayList<TipoDeComida>();

		TipoDeComida tpComida = new TipoDeComida();
		tpComida.nome = "Massa";
		tpComida.comida = "Lasanha";

		tiposDeComidas.add(tpComida);

		new JogoGourmet(tiposDeComidas);
	}
}
