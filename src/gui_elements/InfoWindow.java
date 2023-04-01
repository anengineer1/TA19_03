package gui_elements;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InfoWindow extends JFrame {

	private JPanel content_pane;
	private JTextArea info_display;
	private String text_to_diplay;

	public InfoWindow(String os_chosen, String programming, String graphic_design, String administration, int num_hours) {
		this.text_to_diplay = "Sistema operativo: " + os_chosen + "\n";
		this.text_to_diplay += "Especialidades: \n";
		
		if (!programming.isEmpty()) {
			this.text_to_diplay += programming + "\n";
		}
		
		if (!graphic_design.isEmpty()) {
			this.text_to_diplay += graphic_design + "\n";
		}
		
		if (!administration.isEmpty()) {
			this.text_to_diplay += administration + "\n";
		}
		
		this.text_to_diplay += "Número de horas: " + num_hours;
		

		initialize();
	}

	private void initialize() {
		this.setTitle("Informacion");
		this.setBounds(100, 100, 300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fillFrame();

		this.setVisible(true);

	}

	private void fillFrame() {
		this.content_pane = new JPanel();
		this.content_pane.setLayout(null);
		this.content_pane.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.setContentPane(this.content_pane);

		this.info_display = new JTextArea(this.text_to_diplay);
		this.info_display.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.content_pane.add(this.info_display);
	}
}
