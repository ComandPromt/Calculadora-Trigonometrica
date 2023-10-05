import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TrianguloRectangulo extends JLabel {

	private String hipotenusa;

	private String adyacente;

	private String opuesto;

	private String angulo;

	private int rotacion;

	public void rotar(int rotacion) {

		this.rotacion = rotacion;

		repaint();

	}

	public String getHipotenusa() {

		return hipotenusa;

	}

	public String getAdyacente() {

		return adyacente;

	}

	public String getOpuesto() {

		return opuesto;

	}

	public String getAngulo() {

		return angulo;

	}

	public void setHipotenusa(String hipotenusa) {

		this.hipotenusa = hipotenusa;

		repaint();

	}

	public void setAdyacente(String adyacente) {

		this.adyacente = adyacente;

		repaint();

	}

	public void setOpuesto(String opuesto) {

		this.opuesto = opuesto;

		repaint();

	}

	public void setAngulo(String angulo) {

		this.angulo = angulo;

		repaint();

	}

	public TrianguloRectangulo() {

		rotacion = 1;

		hipotenusa = "";

		adyacente = "";

		opuesto = "";

		angulo = "";

		setFont(getFont().deriveFont(Font.PLAIN, 19f));

	}

	@Override
	public void paint(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		int x = 0;

		int y = 0;

		int anchura = getWidth();

		int altura = getHeight();

		Point punto1;

		Point punto2;

		Point punto3;

		switch (rotacion) {

		case 1:

			punto1 = new Point(x, y);

			punto2 = new Point(x, y + (altura - 25));

			punto3 = new Point(x + anchura, y + (altura - 25));

			break;

		case 2:

			punto1 = new Point(x, y);

			punto2 = new Point(x + anchura, y);

			punto3 = new Point(x, y + altura);

			break;

		case 3:

			punto1 = new Point(x, y);

			punto2 = new Point(x + anchura, y);

			punto3 = new Point(x + anchura, y + (altura));

			break;

		default:

			punto1 = new Point(x + anchura, y);

			punto2 = new Point(x, y + altura);

			punto3 = new Point(x + anchura, y + altura);

			break;
		}

		int[] puntosX = { punto1.x, punto2.x, punto3.x };

		int[] puntosY = { punto1.y, punto2.y, punto3.y };

		g2.setStroke(new BasicStroke(2));

		g2.setColor(Color.BLUE);

		g2.drawPolygon(puntosX, puntosY, 3);

		g2.setColor(Color.GRAY);

		switch (rotacion) {

		case 1:

			if (!angulo.isEmpty()) {

				g2.drawString(angulo + "°", (anchura / 1.8f), altura - 35);

			}

			if (!adyacente.isEmpty()) {

				g2.drawString(adyacente, 25, altura - 5);

			}

			if (!opuesto.isEmpty()) {

				g2.drawString(opuesto, 12, altura / 2);

			}

			if (!hipotenusa.isEmpty()) {

				g2.drawString(hipotenusa, anchura / 3.5f, altura / 5f);

			}

			break;

		case 2:

			if (!angulo.isEmpty()) {

				g2.drawString(angulo + "°", 10, altura - 80);

			}

			if (!adyacente.isEmpty()) {

				g2.drawString(adyacente, 10, altura - 170);

			}

			if (!opuesto.isEmpty()) {

				g2.drawString(opuesto, anchura / 3, 25);

			}

			if (!hipotenusa.isEmpty()) {

				g2.drawString(hipotenusa, anchura / 1.7f, altura / 2);

			}

			break;

		case 3:

			if (!angulo.isEmpty()) {

				g2.drawString(angulo + "°", 60, 25);

			}

			if (!adyacente.isEmpty()) {

				g2.drawString(adyacente, anchura / 1.6f, 25);

			}

			if (!opuesto.isEmpty()) {

				g2.drawString(opuesto, anchura / 1.40f, 100);

			}

			if (!hipotenusa.isEmpty()) {

				g2.drawString(hipotenusa, anchura / 5f, altura / 2);

			}

			break;

		default:

			if (!angulo.isEmpty()) {

				g2.drawString(angulo + "°", 50, altura - 15);

			}

			if (!adyacente.isEmpty()) {

				g2.drawString(adyacente, anchura / 1.6f, altura - 15);

			}

			if (!opuesto.isEmpty()) {

				g2.drawString(opuesto, anchura / 1.4f, 180);

			}

			if (!hipotenusa.isEmpty()) {

				g2.drawString(hipotenusa, anchura / 5f, altura / 2);

			}

			break;

		}

	}

}
