import se.lth.cs.pt.window.SimpleWindow;

public class SimpleWindowExample {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "Drawing Window");
		int thickness = 20;
		w.setLineWidth(thickness);
		w.moveTo(250, 250);
		w.lineTo(300, 300);
	}
}
