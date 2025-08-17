package layout1;

import java.awt.*;

import javax.swing.*;

public class Calculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCalculadora mimarco= new MarcoCalculadora();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

class MarcoCalculadora extends JFrame{
	public MarcoCalculadora() {
		setTitle("Calculadora");
		setBounds(500,300,450,300);
		LaminaCalculadora milamina= new LaminaCalculadora();
		add(milamina);
		
		
	}
}

class LaminaCalculadora extends JPanel{
	public LaminaCalculadora() {
		setLayout(new BorderLayout());
		JButton pantalla = new JButton("0");
		pantalla.setEnabled(false);
		add(pantalla, BorderLayout.NORTH);
		
		//iniciamos una segunda lámina
		milamina2 = new JPanel();
		milamina2.setLayout(new GridLayout(4,4));
		ponerBoton("7");
		ponerBoton("8");
		ponerBoton("9");
		ponerBoton("/");
		ponerBoton("4");
		ponerBoton("5");
		ponerBoton("6");
		ponerBoton("*");
		ponerBoton("1");
		ponerBoton("2");
		ponerBoton("3");
		ponerBoton("-");
		ponerBoton("0");
		ponerBoton(".");
		ponerBoton("=");
		ponerBoton("+");
		
		add(milamina2, BorderLayout.CENTER);
		
		
		
		
	}
	//creamos un método para agregar botones a la lámina
	private void ponerBoton(String rotulo) {
		JButton boton = new JButton(rotulo);
		milamina2.add(boton);
		
	}
	private JPanel milamina2;
}