package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class WeatherGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblLocation;
	private JTextField jtfCity;
	private JButton btnNewButton;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblLocation_2;
	private JLabel lblWeather;
	private JLabel lblTemperature;
	private JPanel panelIcon;
	private JLabel lblIcon;

	/**
	 * Create the frame.
	 */
	public WeatherGUI() {
		setTitle("WeatherApp ");
		setPreferredSize(new Dimension(0, 200));
		setMinimumSize(new Dimension(0, 200));
		setMaximumSize(new Dimension(2147483647, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(getPanel(), GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(getLblLocation())
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(getJtfCity(), GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(getBtnNewButton())))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(getLblLocation())
								.addComponent(getJtfCity(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(getBtnNewButton()))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getPanel(), GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE).addContainerGap()));
		contentPane.setLayout(gl_contentPane);
		
		GUIControler.getWeatherEntry(
				GUIControler.getLocation(GUIControler.getExternalIpAddress(contentPane), contentPane), lblLocation_2,
				lblWeather, lblTemperature, lblIcon, contentPane);
	}

	private JLabel getLblLocation() {
		if (lblLocation == null) {
			lblLocation = new JLabel("Location:");
		}
		return lblLocation;
	}

	private JTextField getJtfCity() {
		if (jtfCity == null) {
			jtfCity = new JTextField();
			jtfCity.setColumns(10);
		}
		return jtfCity;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Get");
			btnNewButton.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					GUIControler.getWeather(jtfCity, lblLocation_2, lblWeather, lblTemperature, lblIcon, contentPane);
				}
			});
			btnNewButton.setMnemonic(KeyEvent.VK_ENTER);
			btnNewButton.requestFocus();
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIControler.getWeather(jtfCity, lblLocation_2, lblWeather, lblTemperature, lblIcon, contentPane);
				}
			});
		}
		return btnNewButton;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(getPanel_1_1(),
					GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE));
			gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(getPanel_1_1(),
					GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE));
			panel.setLayout(gl_panel);
		}
		return panel;
	}

	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
					.createSequentialGroup().addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(getLblTemperature(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
									Short.MAX_VALUE)
							.addGroup(Alignment.TRAILING,
									gl_panel_1.createSequentialGroup()
											.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
													.addComponent(getLblWeather(), Alignment.LEADING,
															GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
													.addComponent(getLblLocation_2(), GroupLayout.DEFAULT_SIZE,
															GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addGap(42)))
					.addGap(21).addComponent(getPanelIcon(), GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
					.addContainerGap()));
			gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
					.createSequentialGroup().addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(getPanelIcon(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
									GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING,
									gl_panel_1.createSequentialGroup().addComponent(getLblLocation_2())
											.addPreferredGap(ComponentPlacement.RELATED).addComponent(getLblWeather())
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getLblTemperature())))
					.addContainerGap(21, Short.MAX_VALUE)));
			panel_1.setLayout(gl_panel_1);
		}
		return panel_1;
	}

	private JLabel getLblLocation_2() {
		if (lblLocation_2 == null) {
			lblLocation_2 = new JLabel("Location");
			lblLocation_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return lblLocation_2;
	}

	private JLabel getLblWeather() {
		if (lblWeather == null) {
			lblWeather = new JLabel("Weather");
			lblWeather.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		}
		return lblWeather;
	}

	private JLabel getLblTemperature() {
		if (lblTemperature == null) {
			lblTemperature = new JLabel("Temperature");
			lblTemperature.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lblTemperature;
	}

	private JPanel getPanelIcon() {
		if (panelIcon == null) {
			panelIcon = new JPanel();
			panelIcon.add(getLblIcon());
		}
		return panelIcon;
	}

	private JLabel getLblIcon() {
		if (lblIcon == null) {
			lblIcon = new JLabel("");
			lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblIcon;
	}
}
