package jogoGourmet;

import java.util.ArrayList;
import java.util.List;

public class TipoDeComida {
	
	public String nome;
	public String comida;
	public List<TipoDeComida> subTipo;
	
	public TipoDeComida() {
	subTipo = new ArrayList<TipoDeComida>();
	
	}
}
