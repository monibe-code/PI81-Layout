package layout1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		//pack();
		
	}
}

class LaminaCalculadora extends JPanel{
	public LaminaCalculadora() {
		principio=true;
		setLayout(new BorderLayout());
		pantalla = new JButton("0");
		//antes de añadir el botón, lo desactivamos:
		pantalla.setEnabled(false);
		add(pantalla, BorderLayout.NORTH);
		
		//iniciamos una segunda lámina
		milamina2 = new JPanel();
		milamina2.setLayout(new GridLayout(4,4));
		
		//creamos instancia de la clase InsertaNumero: 
		ActionListener insertar= new InsertaNumero();
		
		ponerBoton("7",insertar);
		ponerBoton("8",insertar);
		ponerBoton("9",insertar);
		//ponerBoton("/");
		ponerBoton("4",insertar);
		ponerBoton("5",insertar);
		ponerBoton("6",insertar);
		//ponerBoton("*");
		ponerBoton("1",insertar);
		ponerBoton("2",insertar);
		ponerBoton("3",insertar);
		//ponerBoton("-");
		ponerBoton("0",insertar);
		ponerBoton(".",insertar);
		//ponerBoton("="); 
		//ponerBoton("+");
		
		add(milamina2, BorderLayout.CENTER);
		
		
		
		
	}
	//creamos un método para agregar botones a la lámina
	private void ponerBoton(String rotulo, ActionListener oyente) {
		JButton boton = new JButton(rotulo);
		
		boton.addActionListener(oyente);
		
		milamina2.add(boton);
		
	}
	
	//creamos clase interna que gestiona los eventos
	private class InsertaNumero implements ActionListener{

	
		public void actionPerformed(ActionEvent e) {
			//almacenamos en una variable el texto del botón pulsado
			String entrada= e.getActionCommand();
			if (principio) {
				pantalla.setText("");
				principio=false;
			}
			pantalla.setText(pantalla.getText()+entrada);
			
		}
		
	}
	private JPanel milamina2;
	private JButton pantalla;
	private boolean principio;
}