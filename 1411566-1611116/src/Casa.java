
public class Casa implements Cloneable {
	Peca peca = null;
	public int x;
	public int y;
	private boolean marcador = false;
	
	public Casa(int posx, int posy) {
		this.x = posx;
		this.y = posy;
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (Exception e) {
			return null;
		}
	}

	public boolean getMarcador() {
		return this.marcador;
	}

	public boolean estaLivre() {
		if (this.peca != null) {	
			return false;
		}
		return true;
	}

	public void marca() {
		this.marcador = true;
	}

	public void apaga() {
		this.marcador = false;
	}

	public void movePeca(Casa c) {
		c.peca = (Peca) this.peca.clone();	
		c.peca.casax = c.x;
		c.peca.casay = c.y;
		c.peca.moveu();
		this.peca = null;
	}

	public void deslocaPeca(Casa c) {
		c.peca = (Peca) this.peca.clone();
		c.peca.casax = c.x;
		c.peca.casay = c.y;
		this.peca = null;
	}

	public static void trocaPeca(Casa ci, Casa cf) {
		if (ci.peca != null || cf.peca != null) {
			if (ci.peca == null) {
				cf.deslocaPeca(ci);
			} else if (cf.peca == null) {
				ci.deslocaPeca(cf);
			} else {
				Peca p = (Peca) cf.peca.clone();
				cf.peca = (Peca) ci.peca.clone();
				ci.peca = p;
				cf.peca.casax = cf.x;
				cf.peca.casay = cf.y;
				ci.peca.casax = ci.x;
				ci.peca.casay = ci.y;
			}
		}
	}

	public Peca getPeca() {
		return this.peca;
	}
}
