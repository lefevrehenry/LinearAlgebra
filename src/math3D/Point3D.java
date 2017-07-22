package math3D;

public class Point3D {
	
	public double x, y, z;
	
	/** Constructeur */
	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/** Constructeur par copie */
	public Point3D(Point3D point) {
		this(point.getX(), point.getY(), point.getZ());
	}
	
	/** Constructeur par defaut */
	public Point3D() {
		this(0, 0, 0);
	}
	
	/** Clone et retourne le point */
	public Point3D clone() {
		return new Point3D(getX(), getY(), getZ());
	}
	
	/** Retourne la composante x du point */
	public double getX() {
		return x;
	}
	
	/** Retourne la composante y du point */
	public double getY() {
		return y;
	}
	
	/** Retourne la composante z du point */
	public double getZ() {
		return z;
	}
	
	/** Set la composante x du point */
	public void setX(double x) {
		this.x = x;
	}
	
	/** Set la composante y du point */
	public void setY(double y) {
		this.y = y;
	}
	
	/** Set les composantes du point */
	public void set(double x, double y, double z) {
		setX(x);
		setY(y);
		setZ(z);
	}
	
	/** Set la composante z du point */
	public void setZ(double z) {
		this.z = z;
	}
	
	/** Retourne la distance a l'origine */
	public double getModule() {
		return Math.sqrt(getX()*getX() + getY()*getY() + getZ()*getZ());
	}
	
	/** Translate le point */
	public void translation(double dx, double dy, double dz) {
		setX(getX() + dx);
		setY(getY() + dy);
		setZ(getZ() + dz);
	}
	
	/** Translate le point */
	public void translation(Vecteur3D t) {
		translation(t.getDx(), t.getDy(), t.getDz());
	}
	
	/** Rotation du point autour d'un axe (dx, dy, dz) et avec un angle donne en radian */
	public void rotation(double dx, double dy, double dz, double radian) {
		double x = getX();
		double y = getY();
		double z = getZ();
		double cos = Math.cos(radian);
		double sin = Math.sin(radian);
		setX(   x * (Math.pow(dx, 2) + (1 - Math.pow(dx, 2)) * cos) +
				y * (dx*dy * (1 - cos) - dz*sin) +
				z * (dx*dz * (1 - cos) + dy*sin) );
		setY(   x * (dx*dy * (1 - cos) + dz*sin) +
				y * (Math.pow(dy, 2) + (1 - Math.pow(dy, 2)) * cos) +
				z * (dy*dz * (1 - cos) - dx*sin) );
		setZ(   x * (dx*dz * (1 - cos) - dy*sin) +
				y * (dy*dz * (1 - cos) + dx*sin) +
				z * (Math.pow(dz, 2) + (1 - Math.pow(dz, 2)) * cos) );
	}
	
	/** Rotation du point autour d'un axe et avec un angle donne en radian */
	public void rotation(Vecteur3D axis, double radian) {
		Vecteur3D unit = axis.getVecteurUnitaire();
		double dx = unit.getDx();
		double dy = unit.getDy();
		double dz = unit.getDz();
		rotation(dx, dy, dz, radian);
	}
	
	/** Retourne la distance entre les deux points */
	public double distance(Point3D p) {
		return Point3D.distance(this, p);
	}
	
	/** Representation textuelle d'un Point3D */
	public String toString() {
		return "(" + getX() + ", " + getY() + ", " + getZ() + ")";
	}
	
	/** Retourne la distance entre deux points */
	public static double distance(Point3D p1, Point3D p2) {
		Vecteur3D vect = new Vecteur3D(p1, p2);
		return vect.getNorme();
	}
}
