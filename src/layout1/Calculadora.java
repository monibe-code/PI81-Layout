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
		setTitle("Calculadora MoniBe");
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
		
		//fondo general suave
		setBackground(new Color(224,242,230));
		
		pantalla = new JButton("0");
		//antes de añadir el botón, lo desactivamos:
		pantalla.setEnabled(false);
		pantalla.setBackground(new Color(230,220,255));
		pantalla.setFont(new Font("Arial", Font.BOLD,20));
		pantalla.setForeground(Color.DARK_GRAY);
		add(pantalla, BorderLayout.NORTH);
		
		//iniciamos una segunda lámina
		milamina2 = new JPanel();
		//milamina2.setLayout(new GridLayout(4,4));
		milamina2.setLayout(new GridLayout(4,4,5,5));
		milamina2.setBackground(new Color(224,242,230));
		
		//creamos instancia de la clase InsertaNumero: 
		ActionListener insertar= new InsertaNumero();
		ActionListener orden= new AccionOrden();
		
		ponerBoton("7",insertar,true);
		ponerBoton("8",insertar,true);
		ponerBoton("9",insertar,true);
		ponerBoton("/", orden,false);
		ponerBoton("4",insertar,true);
		ponerBoton("5",insertar,true);
		ponerBoton("6",insertar,true);
		ponerBoton("*", orden,false);
		ponerBoton("1",insertar,true);
		ponerBoton("2",insertar,true);
		ponerBoton("3",insertar,true);
		ponerBoton("-", orden,false);
		ponerBoton("0",insertar,true);
		ponerBoton(".",insertar,true);
		ponerBoton("=", orden,false); 
		ponerBoton("+", orden,false);
		
		add(milamina2, BorderLayout.CENTER);
		
		ultimaOperacion="=";
		
		
	}
	//creamos un método para agregar botones a la lámina
	private void ponerBoton(String rotulo, ActionListener oyente, boolean esNumero) {
		JButton boton = new JButton(rotulo);
		boton.addActionListener(oyente);
		boton.setFocusPainted(false);
		boton.setForeground(Color.DARK_GRAY);
		
		if(esNumero) {
			boton.setBackground(new Color(173,216,230));
		}else {
			boton.setBackground(new Color(255,182,193));
		}
		
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
	
	private class AccionOrden implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String operacion= e.getActionCommand();
			calcular(Double.parseDouble(pantalla.getText()));
			ultimaOperacion=operacion;
			principio = true; 
		}
		
		public void calcular(double x) {
			if (ultimaOperacion.equals("+")) {
				resultado+=x;
			}
			else if(ultimaOperacion.equals("-")) {
				resultado-=x;
			}
			else if(ultimaOperacion.equals("*")) {
				resultado*=x;
			}
			else if(ultimaOperacion.equals("/")) {
				resultado/=x;
			}
			else if(ultimaOperacion.equals("=")) {
				resultado=x;
			}
			
			pantalla.setText(""+resultado);
		}
		
	}
	
	private JPanel milamina2;
	private JButton pantalla;
	private boolean principio;
	private double resultado;
	private String ultimaOperacion;
}