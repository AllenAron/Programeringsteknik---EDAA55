import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	private double x;
	private double y;
	private SimpleWindow w;
	private int alpha;
	private boolean penDown;
	
	/** Skapar en sköldpadda som ritar i ritfönstret w. Från början 
	    befinner sig sköldpaddan i punkten x, y med pennan lyft och 
	    huvudet pekande rakt uppåt i fönstret (i negativ y-riktning). */
	public Turtle(SimpleWindow w, int x, int y) {
		this.x = x;
		this.y = y;
		this.w = w;
		alpha = 90;
		penDown = false;
	}

	/** Sänker pennan. */
	public void penDown() {
		penDown = true;
	}
	
	/** Lyfter pennan. */
	public void penUp() {
		penDown = false;
	}
	
	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		double a = alpha * Math.PI / 180;
		double newX = x + n * Math.cos(a);
		double newY = y - n * Math.sin(a);
		w.moveTo((int) x, (int) y);
		if (penDown) {
			w.lineTo((int) Math.round(newX), (int) Math.round(newY));
		}
		x = newX;
		y = newY;
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		alpha += beta;
	}

	/** Går till punkten newX, newY utan att rita. Pennans läge (sänkt
	    eller lyft) och huvudets riktning påverkas inte. */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		alpha = 90;
	}

	/** Tar reda på x-koordintaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) Math.round(x);
	}

 	/** Tar reda på y-koordintaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) Math.round(y);
	}
  
	/** Tar reda på sköldpaddans riktning, i grader från positiv x-led. */
 	public int getDirection() {
 		return alpha;
	}
}
