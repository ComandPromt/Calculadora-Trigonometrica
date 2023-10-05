
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;

import com.buttons.simple.MaterialButton;
import com.buttons.simple.SimpleButton;
import com.comboBox.comboSuggestion.ComboBoxSuggestion;
import com.spinner.decimal.DecimalSpinner;
import com.textarea.NTextArea;

@SuppressWarnings("all")

public class Main extends javax.swing.JFrame {

	private DecimalSpinner opuesto;

	private ComboBoxSuggestion calculo;

	private DecimalSpinner angulo;

	private DecimalSpinner adyacente;

	private DecimalSpinner hipotenusa;

	private TrianguloRectangulo triangulo;

	private NTextArea texto;

	private SimpleButton btnNewButton_2;

	private int rotacion;

	private void ponerValores() {

		triangulo.setHipotenusa(Float.toString(hipotenusa.getValor()));

		triangulo.setOpuesto(Float.toString(opuesto.getValor()));

		triangulo.setAdyacente(Float.toString(adyacente.getValor()));

		triangulo.setAngulo(Float.toString(angulo.getValor()));

	}

	public Main() throws IOException {

		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/imagenes/trigonometria.png")));

		rotacion = 1;

		setTitle("CalculadoraTrigonometrica");

		initComponents();

		setVisible(true);

	}

	private void rotar(boolean adelante) {

		if (adelante) {

			if (rotacion < 4) {

				rotacion++;

			}

			else {

				rotacion = 1;

			}

		}

		else {

			if (rotacion > 1) {

				rotacion--;

			}

			else {

				rotacion = 4;

			}

		}

		triangulo.rotar(rotacion);

	}

	public static void main(String[] args) {

		try {

			new Main().setVisible(true);

		}

		catch (Exception e) {

		}

	}

	public void initComponents() throws IOException {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		setResizable(false);

		JLabel lblNewLabel = new JLabel("");

		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/imagenes/angle.png")));

		angulo = new DecimalSpinner();

		angulo.getEditor().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					ponerValores();

				}

			}

		});

		JLabel lblCatetoAdyacente = new JLabel("Cateto adyacente");

		lblCatetoAdyacente.setFont(new Font("Dialog", Font.PLAIN, 25));

		lblCatetoAdyacente.setHorizontalAlignment(SwingConstants.CENTER);

		adyacente = new DecimalSpinner();

		adyacente.setDecimals(3);

		adyacente.getEditor().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					ponerValores();

				}

			}

		});

		JLabel lblCatetoAdyacente_1 = new JLabel("Cateto opuesto");

		lblCatetoAdyacente_1.setFont(new Font("Dialog", Font.PLAIN, 25));

		lblCatetoAdyacente_1.setHorizontalAlignment(SwingConstants.CENTER);

		opuesto = new com.spinner.decimal.DecimalSpinner();

		opuesto.setDecimals(3);

		opuesto.getEditor().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					ponerValores();

				}

			}

		});

		JLabel lblHipotenusa = new JLabel("Hipotenusa");

		lblHipotenusa.setFont(new Font("Dialog", Font.PLAIN, 25));

		lblHipotenusa.setHorizontalAlignment(SwingConstants.CENTER);

		hipotenusa = new com.spinner.decimal.DecimalSpinner();

		hipotenusa.setDecimals(3);

		hipotenusa.getEditor().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					ponerValores();

				}

			}

		});

		calculo = new ComboBoxSuggestion();

		calculo.addItem("Hipotenusa");

		calculo.addItem("Adyacente");

		calculo.addItem("Opuesto");

		MaterialButton btnNewButton = new MaterialButton();

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ponerValores();

				switch (calculo.getSelectedIndex()) {

				case 0:

					try {

						if (adyacente.getValor() > 0f) {

							hipotenusa.setValor(
									adyacente.getValor() / ((float) Math.cos(Math.toRadians(angulo.getValor()))));

							triangulo.setHipotenusa(Float.toString(hipotenusa.getValor()));

							texto.setText("hipotenusa = cateto adyacente / coseno del angulo");

						}

						else if (opuesto.getValor() > 0f) {

							hipotenusa.setValor(
									opuesto.getValor() / ((float) Math.sin(Math.toRadians(angulo.getValor()))));

							triangulo.setHipotenusa(Float.toString(hipotenusa.getValor()));

							texto.setText("hipotenusa = cateto opuesto / seno del angulo");

						}

					}

					catch (Exception e2) {

					}

					break;

				case 1:

					try {

						if (opuesto.getValor() > 0f) {

							adyacente.setValor(
									opuesto.getValor() / ((float) Math.tan(Math.toRadians(angulo.getValor()))));

							triangulo.setAdyacente(Float.toString(adyacente.getValor()));

							texto.setText("cateto adyacente = cateto opuesto / tangente del angulo ");

						}

						else if (hipotenusa.getValor() > 0f) {

							adyacente.setValor(
									(((float) Math.cos(Math.toRadians(angulo.getValor()))) * hipotenusa.getValor()));

							triangulo.setAdyacente(Float.toString(adyacente.getValor()));

							texto.setText("cateto adyacente = coseno del angulo * hipotenusa");

						}

					}

					catch (Exception e2) {

					}

					break;

				default:

					try {

						if (adyacente.getValor() > 0f) {

							opuesto.setValor(
									((float) Math.tan(Math.toRadians(angulo.getValor()))) * adyacente.getValor());

							triangulo.setOpuesto(Float.toString(opuesto.getValor()));

							texto.setText("cateto opuesto = tangente del angulo * adyacente");

						}

						else if (hipotenusa.getValor() > 0f) {

							opuesto.setValor(
									((float) Math.sin(Math.toRadians(angulo.getValor()))) * hipotenusa.getValor());

							triangulo.setOpuesto(Float.toString(opuesto.getValor()));

							texto.setText("cateto opuesto = seno del angulo * hipotenusa");

						}

					}

					catch (Exception e2) {

					}

					break;

				}

			}

		});

		btnNewButton.setSelectedIcon(new ImageIcon(Main.class.getResource("/imagenes/angle.png")));

		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 25));

		btnNewButton.setText("Calcular");

		btnNewButton.setBorderRadius(100);

		btnNewButton.setBackground(Color.WHITE);

		btnNewButton.setForeground(Color.MAGENTA);

		btnNewButton.setRippleColor(Color.LIGHT_GRAY);

		triangulo = new TrianguloRectangulo();

		texto = new NTextArea("");

		texto.setFont(new Font("Dialog", Font.PLAIN, 20));

		SimpleButton btnNewButton_1 = new SimpleButton("");

		btnNewButton_1.setIcon(new ImageIcon(Main.class.getResource("/imagenes/back.png")));

		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				rotar(false);

			}

		});

		btnNewButton_2 = new SimpleButton("");

		btnNewButton_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				rotar(true);

			}

		});

		btnNewButton_2.setIcon(new ImageIcon(Main.class.getResource("/imagenes/next.png")));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout
								.createSequentialGroup().addGap(32).addGroup(layout
										.createParallelGroup(Alignment.LEADING, false).addComponent(
												lblHipotenusa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(
												hipotenusa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(layout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout
														.createParallelGroup(Alignment.LEADING, false)
														.addComponent(adyacente, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(lblCatetoAdyacente, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(lblCatetoAdyacente_1, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(opuesto, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addGroup(layout
																.createSequentialGroup().addComponent(lblNewLabel)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(angulo, GroupLayout.PREFERRED_SIZE, 180,
																		GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup().addGap(49)
												.addComponent(triangulo, GroupLayout.PREFERRED_SIZE, 311,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 83,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(
														btnNewButton_2, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup().addGap(40)
												.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(calculo, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(layout.createSequentialGroup()
																.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE,
																		205, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(texto, GroupLayout.PREFERRED_SIZE, 299,
																		GroupLayout.PREFERRED_SIZE)))))
								.addContainerGap(39, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
						.addGap(30)
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(calculo, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(angulo, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(31)
										.addGroup(layout.createParallelGroup(Alignment.TRAILING)
												.addComponent(adyacente, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGroup(layout.createSequentialGroup()
														.addComponent(lblCatetoAdyacente, GroupLayout.PREFERRED_SIZE,
																36, GroupLayout.PREFERRED_SIZE)
														.addGap(76))))
								.addGroup(layout.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 144,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(8).addComponent(texto,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addGap(6)
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(triangulo, GroupLayout.PREFERRED_SIZE, 257,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(15).addGroup(layout
										.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup()
												.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(122)
												.addComponent(lblHipotenusa, GroupLayout.PREFERRED_SIZE, 36,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(hipotenusa, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(layout.createSequentialGroup().addGap(250)
								.addComponent(lblCatetoAdyacente_1, GroupLayout.PREFERRED_SIZE, 36,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(opuesto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(29, Short.MAX_VALUE)));

		getContentPane().setLayout(layout);

		setSize(new Dimension(850, 598));

		setLocationRelativeTo(null);

	}

	public void actionPerformed(ActionEvent arg0) {

	}

	public void stateChanged(ChangeEvent e) {

	}
}
