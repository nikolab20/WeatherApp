package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class WeatherGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblLocation;
	private JTextField jtfCity;
	private JButton btnNewButton;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblLocation_2;
	private JLabel lblTime;
	private JLabel lblTemperature;
	private JPanel panel_2;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public WeatherGUI() {
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
		
		try {
			GUIControler.getWeatherEntry(GUIControler.getLocation(GUIControler.getExternalIpAddress()), lblLocation_2, lblTime, lblTemperature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						GUIControler.getWeather(jtfCity, lblLocation_2, lblTime, lblTemperature);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
													.addComponent(getLblTime(), Alignment.LEADING,
															GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
													.addComponent(getLblLocation_2(), GroupLayout.DEFAULT_SIZE,
															GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addGap(42)))
					.addGap(21).addComponent(getPanel_2(), GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
					.addContainerGap()));
			gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
					.createSequentialGroup().addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(getPanel_2(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
									GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING,
									gl_panel_1.createSequentialGroup().addComponent(getLblLocation_2())
											.addPreferredGap(ComponentPlacement.RELATED).addComponent(getLblTime())
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

	private JLabel getLblTime() {
		if (lblTime == null) {
			lblTime = new JLabel("Time");
		}
		return lblTime;
	}

	private JLabel getLblTemperature() {
		if (lblTemperature == null) {
			lblTemperature = new JLabel("Temperature");
			lblTemperature.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblTemperature;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.add(getLblNewLabel());
		}
		return panel_2;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon(GUIControler.getImage()));
		}
		return lblNewLabel;
	}
}
