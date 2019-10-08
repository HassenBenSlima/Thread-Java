import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon sans, avec, droite, gauche;
	private JLabel label;
	private int id;

	public ImagePanel(int id) {
		this.id = id;
		try {
			sans = new ImageIcon("images\\philo_" + String.valueOf(id) + "_s.jpg");
			avec = new ImageIcon("images\\philo_" + String.valueOf(id) + "_a.jpg");
			droite = new ImageIcon("images\\philo_" + String.valueOf(id) + "_d.jpg");
			gauche = new ImageIcon("images\\philo_" + String.valueOf(id) + "_g.jpg");
			label = new JLabel(sans);
			add(label);
		} catch (Exception ex) {
			System.out.println("mal9ach sawer\n \\images\\philo_" + String.valueOf(id) + "X non trouver");
		}
	}

	public int getId() {
		return id;
	}

	public void setDroite() {
		label.setIcon(droite);
		this.repaint();
	}

	public void setGauche() {
		label.setIcon(gauche);
		this.repaint();
	}

	public void setAvec() {
		label.setIcon(avec);
		this.repaint();
	}

	public void setSans() {
		label.setIcon(sans);
		this.repaint();
	}

}