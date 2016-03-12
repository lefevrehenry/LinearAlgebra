package math4D;

public class Vecteur4D {
	
	private double dist_x;
	private double dist_y;
	private double dist_z;
	private double dist_w;
	
	/** Constructeur */
	public Vecteur4D(double dist_x, double dist_y, double dist_z, double dist_w) {
		this.dist_x = dist_x;
		this.dist_y = dist_y;
		this.dist_z = dist_z;
		this.dist_w = dist_w;
	}
	
	/** Constructeur par copie */
	public Vecteur4D(Vecteur4D vect) {
		this(vect.getDx(), vect.getDy(), vect.getDz(), vect.getDw());
	}
	
	/** Constructeur du vecteur AB */
	public Vecteur4D(Point4D a, Point4D b) {
		this(b.getX() - a.getX(), b.getY() - a.getY(), b.getZ() - a.getZ(), b.getW() - a.getW());
	}
	
	/** Constructeur du vecteur OA */
	public Vecteur4D(Point4D a) {
		this(a.getX(), a.getY(), a.getZ(), a.getW());
	}
	
	/** Constructeur par defaut */
	public Vecteur4D() {
		this(0, 0, 0, 0);
	}
	
	/** Retourne la composante x du vecteur */
	public double getDx() {
		return dist_x;
	}
	
	/** Retourne la composante y du vecteur */
	public double getDy() {
		return dist_y;
	}
	
	/** Retourne la composante z du vecteur */
	public double getDz() {
		return dist_z;
	}
	
	/** Retourne la composante w du vecteur */
	public double getDw() {
		return dist_w;
	}
	
	/** Set la composante x du vecteur */
	public void setDx(double dist_x) {
		this.dist_x = dist_x;
	}
	
	/** Set la composante y du vecteur */
	public void setDy(double dist_y) {
		this.dist_y = dist_y;
	}
	
	/** Set la composante z du vecteur */
	public void setDz(double dist_z) {
		this.dist_z = dist_z;
	}
	
	/** Set la composante z du vecteur */
	public void setDw(double dist_w) {
		this.dist_w = dist_w;
	}
	
	/** Retourne la norme du vecteur */
	public double getNorme() {
		return Math.sqrt(Math.pow(getDx(), 2) + Math.pow(getDy(), 2) + Math.pow(getDz(), 2) + Math.pow(getDw(), 2));
	}
	
	/** Retourne le vecteur unitaire */
	public Vecteur4D getVecteurUnitaire() {
		double norme = getNorme();
		double dx, dy, dz, dw;
		dx = getDx() / norme;
		dy = getDy() / norme;
		dz = getDz() / norme;
		dw = getDw() / norme;
		return new Vecteur4D(dx, dy, dz, dw);
	}
	
	/** Normalise le vecteur */
	public void normalized() {
		double norme = getNorme();
		setDx(getDx() / norme);
		setDy(getDy() / norme);
		setDz(getDz() / norme);
		setDw(getDw() / norme);
	}
	
	/** Ajoute le vecteur passe en parametre */
	public void plus(Vecteur4D vect) {
		setDx(getDx() + vect.getDx());
		setDy(getDy() + vect.getDy());
		setDz(getDz() + vect.getDz());
		setDz(getDw() + vect.getDw());
	}
	
	/** Soustrait le vecteur passe en parametre */
	public void minus(Vecteur4D vect) {
		setDx(getDx() - vect.getDx());
		setDy(getDy() - vect.getDy());
		setDz(getDz() - vect.getDz());
		setDw(getDw() - vect.getDw());
	}
	
	/** Multiplie par le coefficent passe en parametre */
	public void mult(double k) {
		setDx(k * getDx());
		setDy(k * getDy());
		setDz(k * getDz());
		setDw(k * getDw());
	}
	
	/** Representation textuelle d'un Vecteur2D */
	public String toString() {
		return "(" + ((int)(getDx()*100))/100.0 + " , " + ((int)(getDy()*100))/100.0 + ((int)(getDz()*100))/100.0 + ((int)(getDw()*100))/100.0 + ")";
	}
}