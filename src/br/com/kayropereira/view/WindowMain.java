package br.com.kayropereira.view;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class WindowMain extends JFrame{

	protected final int SCALE_FACTOR = 120;
	protected final int MIN_NEIGH_BORS = 2;
	protected final int MIN_SIZE = 200;
	protected final int MAX_SIZE = 280;
	
	protected final int WIDTH;
	protected final int HEIGHT;
	
	private UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
	
	private PainelWebCam jpWebCam;
	
	public WindowMain(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
		
		
		try {
			UIManager.setLookAndFeel(looks[3].getClassName());
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		setTitle("Detectar Face");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		jpWebCam = new PainelWebCam();

		ControlesParametros conteinerParametros = new ControlesParametros();
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpWebCam, GroupLayout.PREFERRED_SIZE, jpWebCam.getWidth(), GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(conteinerParametros, GroupLayout.PREFERRED_SIZE, conteinerParametros.getWidth(), GroupLayout.PREFERRED_SIZE)
					.addContainerGap(176, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(conteinerParametros, GroupLayout.PREFERRED_SIZE, conteinerParametros.getHeight(), GroupLayout.PREFERRED_SIZE)
						.addComponent(jpWebCam, GroupLayout.PREFERRED_SIZE, jpWebCam.getHeight(), GroupLayout.PREFERRED_SIZE))
					.addContainerGap(158, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

		jpWebCam.addObserverPainelWebCam(conteinerParametros);
		
		conteinerParametros.setSbScaleFactorValue(SCALE_FACTOR);
		conteinerParametros.setSbMinNeighbor(MIN_NEIGH_BORS);
		conteinerParametros.setSbMinSize(MIN_SIZE);
		conteinerParametros.setSbMaxSize(MAX_SIZE);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}