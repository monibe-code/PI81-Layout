package layout1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

public class Layouts_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoLayout marco=new MarcoLayout();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}

class MarcoLayout extends JFrame{
	public MarcoLayout() {
		setTitle("Prueba Acciones");
		setBounds(600,350,600,300);
		PanelLayout lamina = new PanelLayout();
		PanelLayout2 lamina2 = new PanelLayout2();
		add(lamina, BorderLayout.NORTH);
		add(lamina2, BorderLayout.SOUTH);
	}
}

class PanelLayout extends JPanel{
	public PanelLayout() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JButton("Amarillo"));
		add(new JButton("Rojo"));

	}
}

class PanelLayout2 extends JPanel{
	public PanelLayout2() {
		setLayout(new BorderLayout());
		add(new JButton("Azul"), BorderLayout.WEST);
		add(new JButton ("Verde"), BorderLayout.EAST);
		add(new JButton ("Negro"), BorderLayout.CENTER);
	}
}