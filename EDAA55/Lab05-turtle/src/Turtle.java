import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	double alpha = 90;
	double x;
	double y;
	boolean isPenDown = false;
	SimpleWindow w;
	// Exempel på attribut: alpha, får användas i hela turtle-klassen då den är deklarerad utanför metoderna
	// Exempel på parameter: n, får bara användas när man anropar metoden forward och i metoden forward
	// Exempel på lokal variabel: beta, används bara i och är endast deklarerad i metoden left så den går inte att använda någon annanstans

	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
	 * sköldpaddan i punkten x, y med pennan lyft och huvudet pekande rakt uppåt i
	 * fönstret (i negativ y-riktning).
	 */
	public Turtle(SimpleWindow w0, int x0, int y0) {
		x = x0;
		y = y0;
		w = w0;
	}

	/** Sänker pennan. */
	public void penDown() {
		isPenDown = true;
	}

	/** Lyfter pennan. */
	public void penUp() {
		isPenDown = false;
	}

	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		w.moveTo((int) Math.round(x), (int) Math.round(y));
		x = x + n * Math.cos(Math.toRadians(alpha));
		y = y - n * Math.sin(Math.toRadians(alpha));
		if (isPenDown == true) {
			w.lineTo((int) Math.round(x), (int) Math.round(y));
		} else {
			w.moveTo((int) Math.round(x), (int) Math.round(y));
		}
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		alpha = alpha + beta;
	}

	/**
	 * Går till punkten newX, newY utan att rita. Pennans läge (sänkt eller lyft)
	 * och huvudets riktning påverkas inte.
	 */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		alpha = 90;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) Math.round(x);
	}

	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) Math.round(y);
	}

	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
	public int getDirection() {
		return (int) Math.round(alpha);
	}
}
