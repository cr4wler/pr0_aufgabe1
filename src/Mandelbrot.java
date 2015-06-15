
public class Mandelbrot {

	private final double X_POS = 0.25;
	private final double Y_POS = 0.0;
	private final int MAX_ITERATIONS = 10000;
	private int x_size, y_size;
	
	
	public Mandelbrot(int x_size, int y_size) {
		this.x_size = x_size;
		this.y_size = y_size;
	}
	
	/**
	 * Scales the given value in given dimension according to given scaling.
	 * @param value Coordinate value to be scaled.
	 * @param dim Dimension of the coordinate to be scaled.
	 * @param scaling Scaling to be applied to the given coordinate.
	 * @return Returns the scaled coordinate value.
	 */
	public double scale(double value, int dim, double scaling) {
		double result = 0.0;
		
		//TODO
		// Gegebene X/Y Koordinate skalieren (wichtig für Zoom)
		
		return result;
	}
	
	/**
	 * Method to calculate number of iterations needed for |Z_n| to get larger than 2.0. (Calculate whether number is part of the Mandelbrot set or not) 
	 * @param x X-coordinate or real part of complex number.
	 * @param y Y-coordinate or imaginary part of complex number.
	 * @return Returns the number of iterations needed to reach |Z_n| > 2.0, or 0 if MAX_ITERATIONS is reached.
	 */
	public int calcValue(double x, double y) {
		int result = 0;
		
		// TODO
		// Schleife implementieren zur Berechnung von Z_{n+1} = (Z_n)^2 + C
		// C ist eine komplexe Zahl mit x als reelem Teil und y als komplexem Teil
		// Komplexe Zahlen allgemein: C = a + b * i
		// Hier also C = x + y * i, wobei i^2 = -1 ist.
		// TIPP: man braucht nicht mit i zu rechnen.
		// Schleifenabbruchbedingungen:
		//   a) MAX_ITERATIONS erreicht (dann 0 returnen)
		//   b) |Z_n| > 2 (dann Anzahl der durchlaufenen Iterationen returnen)
		
		return result;
	}	
}
