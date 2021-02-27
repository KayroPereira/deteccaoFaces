package br.com.kayropereira.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import br.com.kayropereira.controller.ScrollBarController;
import br.com.kayropereira.model.ScrollBarObserver;

@SuppressWarnings("serial")
public class ControlesParametros extends JPanel implements ScrollBarObserver {

	protected final int WIDTH_PANEL = 220;
	protected final int HEIGHT_PANEL = 250;

	private JLabel jLScaleFactorValue;
	private JLabel jLMinNeighborsValue;
	private JLabel jLMinSizeValue;
	private JLabel jLMaxSizeValue;

	private ScrollBarPersonalizado sbScaleFactor;
	private ScrollBarPersonalizado sbMinNeighbor;
	private ScrollBarPersonalizado sbMinSize;
	private ScrollBarPersonalizado sbMaxSize;

	private Set<ScrollBarController> observersScrollBar = new HashSet<>();

	public ControlesParametros() {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setSize(new Dimension(WIDTH_PANEL, HEIGHT_PANEL));

		JLabel jLScaleFactor = new JLabel("Scale Factor");
		sbScaleFactor = new ScrollBarPersonalizado(1, 101, 1000, 100.0);
		observersScrollBar.add(sbScaleFactor.getSbCtrl());
		sbScaleFactor.getSbCtrl().addScrollBarObserver(this);

		JLabel jLMinNeighbors = new JLabel("Min Neighbors");
		sbMinNeighbor = new ScrollBarPersonalizado(2, 1, 40, 1.0);
		observersScrollBar.add(sbMinNeighbor.getSbCtrl());
		sbMinNeighbor.getSbCtrl().addScrollBarObserver(this);

		JLabel jLMinSize = new JLabel("Min Size");
		sbMinSize = new ScrollBarPersonalizado(3, 1, 310, 1.0);
		observersScrollBar.add(sbMinSize.getSbCtrl());
		sbMinSize.getSbCtrl().addScrollBarObserver(this);

		JLabel jLMaxSize = new JLabel("Max Size");
		sbMaxSize = new ScrollBarPersonalizado(4, 1, 1010, 1.0);
		observersScrollBar.add(sbMaxSize.getSbCtrl());
		sbMaxSize.getSbCtrl().addScrollBarObserver(this);

		jLScaleFactorValue = new JLabel("0");

		jLMinNeighborsValue = new JLabel("0");

		jLMinSizeValue = new JLabel("0");

		jLMaxSizeValue = new JLabel("0");

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addComponent(sbScaleFactor, GroupLayout.PREFERRED_SIZE, 138,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jLScaleFactorValue,
												GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
								.addGroup(
										groupLayout.createSequentialGroup().addGap(19).addComponent(
												jLScaleFactor, GroupLayout.PREFERRED_SIZE, 102,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(9)
														.addComponent(jLMinNeighbors, GroupLayout.PREFERRED_SIZE, 121,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout
														.createSequentialGroup()
														.addComponent(sbMinNeighbor, GroupLayout.PREFERRED_SIZE, 138,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(jLMinNeighborsValue, GroupLayout.PREFERRED_SIZE,
																42, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(9).addComponent(jLMinSize,
												GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(sbMinSize, GroupLayout.PREFERRED_SIZE, 138,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(jLMinSizeValue, GroupLayout.PREFERRED_SIZE, 42,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addGap(9).addComponent(jLMaxSize,
												GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(sbMaxSize, GroupLayout.PREFERRED_SIZE, 138,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(jLMaxSizeValue, GroupLayout.PREFERRED_SIZE, 42,
														GroupLayout.PREFERRED_SIZE)))))
						.addGap(18)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(jLScaleFactor)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(sbScaleFactor,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(jLScaleFactorValue))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(jLMinNeighbors)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(sbMinNeighbor,
												GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
								.addComponent(jLMinNeighborsValue))
						.addGap(18).addComponent(jLMinSize).addGap(6)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(jLMinSizeValue, Alignment.TRAILING)
								.addComponent(sbMinSize, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 17,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(18).addComponent(jLMaxSize)
										.addGap(6).addComponent(sbMaxSize, GroupLayout.PREFERRED_SIZE, 17,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING,
										groupLayout.createSequentialGroup().addGap(41).addComponent(jLMaxSizeValue)))
						.addContainerGap(35, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	public Set<ScrollBarController> getControles() {
		return observersScrollBar;
	}

	@Override
	public void scrollBarModified(ScrollBarPersonalizado component, int value) {
		
		switch (component.getID()) {
		case 1:
			jLScaleFactorValue.setText((value / component.getINCREMENT_PROPORTIONAL()) + "");
			break;

		case 2:
			jLMinNeighborsValue.setText(((int) (value / component.getINCREMENT_PROPORTIONAL())) + "");
			break;

		case 3:
			jLMinSizeValue.setText(((int) (value / component.getINCREMENT_PROPORTIONAL())) + "");
			break;

		case 4:
			jLMaxSizeValue.setText(((int) (value / component.getINCREMENT_PROPORTIONAL())) + "");
			break;
		}
	}

	public void setSbScaleFactorValue(int value) {
		sbScaleFactor.setValue(value);
	}

	public void setSbMinNeighbor(int value) {
		sbMinNeighbor.setValue(value);
	}

	public void setSbMinSize(int value) {
		sbMinSize.setValue(value);
	}

	public void setSbMaxSize(int value) {
		sbMaxSize.setValue(value);
	}
}
