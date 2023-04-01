package gui_elements;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSlider;

public class MyMainWindow extends JFrame {
	private JPanel content_pane;
	private JLabel label_os_you_use;
	private JLabel label_speciality;
	private JLabel label_hours;
	private JButton button_accept;
	private ActionListener button_action;
	private JRadioButton windowsos;
	private JRadioButton linux;
	private JRadioButton mac;
	private ButtonGroup os_of_choice;
	private JCheckBox programming;
	private JCheckBox graphic_design;
	private JCheckBox administration;
	private JSlider daily_hours;
	private InfoWindow my_info_window;

	public MyMainWindow() {
		initialize();
	}

	private void initialize() {
		this.setTitle("Enquesta");
		this.setBounds(100, 100, 600, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fillFrame();

		this.setVisible(true);

	}

	private void fillFrame() {
		this.content_pane = new JPanel();
		this.content_pane.setLayout(null);
		this.content_pane.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.setContentPane(this.content_pane);

		// Add radio buttons
		this.addRadioButtons();

		// Add the checkboxes
		this.addCheckBoxes();

		// Add the slider for number of hours
		this.addSlider();
		
		// Getting actions
		this.fillActions();

		// add button and set action
		this.addButton();

	}

	private void addRadioButtons() {
		// The label to select os
		this.label_os_you_use = new JLabel("Elije un sistema operativo");
		this.label_os_you_use.setBounds(20, 60, 200, 23);
		this.content_pane.add(this.label_os_you_use);

		// windows
		this.windowsos = new JRadioButton("Windows", true);
		this.windowsos.setActionCommand("Windows");
		this.windowsos.setBounds(20, 80, 109, 23);
		this.content_pane.add(this.windowsos);

		// GNU/Linux
		this.linux = new JRadioButton("Linux", false);
		this.linux.setActionCommand("Linux");
		this.linux.setBounds(20, 100, 109, 23);
		this.content_pane.add(this.linux);

		// Mac
		this.mac = new JRadioButton("Mac", false);
		this.mac.setActionCommand("Mac");
		this.mac.setBounds(20, 120, 109, 23);
		this.content_pane.add(this.mac);

		this.os_of_choice = new ButtonGroup();
		this.os_of_choice.add(this.windowsos);
		this.os_of_choice.add(this.linux);
		this.os_of_choice.add(this.mac);

	}

	private void addCheckBoxes() {
		// Labels for speciality
		this.label_speciality = new JLabel("Elije tu especialidad");
		this.label_speciality.setBounds(230, 60, 200, 23);
		this.content_pane.add(this.label_speciality);

		// Programming checkbox
		this.programming = new JCheckBox("Programación", false);
		this.programming.setBounds(230, 80, 150, 23);
		this.content_pane.add(this.programming);

		// Graphic design checkbox
		this.graphic_design = new JCheckBox("Diseño gráfico", false);
		this.graphic_design.setBounds(230, 100, 150, 23);
		this.content_pane.add(this.graphic_design);

		// Admistration checkbox
		this.administration = new JCheckBox("Administración", false);
		this.administration.setBounds(230, 120, 150, 23);
		this.content_pane.add(this.administration);
	}

	private void addSlider() {
		// Labels for the hours
		this.label_hours = new JLabel("Horas dedicadas en el ordenador");
		this.label_hours.setBounds(20, 160, 400, 23);
		this.content_pane.add(this.label_hours);

		this.daily_hours = new JSlider(0, 10, 5);
		this.daily_hours.setBounds(20, 180, 400, 50);
		this.daily_hours.setPaintTicks(true);
		this.daily_hours.setMajorTickSpacing(5);
		this.daily_hours.setMinorTickSpacing(1);
		this.daily_hours.setPreferredSize(new Dimension(400, 200));

		this.daily_hours.setPaintLabels(true);

		this.content_pane.add(this.daily_hours);
	}

	private void addButton() {
		this.button_accept = new JButton("Acepta");
		this.button_accept.setBounds(80, 10, 150, 20);
		this.button_accept.addActionListener(this.button_action);
		this.content_pane.add(this.button_accept);
	}

	private void fillActions() {
		this.button_action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String programming_text = "";
				String graphic_design_text = "";
				String administration_text = "";
				if (programming.isSelected()) {
					programming_text = programming.getText();
				}
				
				if (graphic_design.isSelected()) {
					graphic_design_text = graphic_design.getText();
				}
				
				if (administration.isSelected()) {
					administration_text = programming.getText();
				}
				
				my_info_window = new InfoWindow(os_of_choice.getSelection().getActionCommand(), programming_text,
						graphic_design_text, administration_text, daily_hours.getValue());
			}
		};
	}

}
