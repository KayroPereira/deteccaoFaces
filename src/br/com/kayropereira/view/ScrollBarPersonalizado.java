package br.com.kayropereira.view;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollBar;

import br.com.kayropereira.controller.ScrollBarController;
import br.com.kayropereira.model.ScrollBarObserver;

@SuppressWarnings("serial")
public class ScrollBarPersonalizado extends JScrollBar implements AdjustmentListener {

	private final int ID;
	private final int MIN_VALUE;
	private final int MAX_VALUE;
	private final double INCREMENT_PROPORTIONAL;

	private ScrollBarController sbCtrl;
	private List<ScrollBarObserver> observers = new ArrayList<>();

	public ScrollBarPersonalizado(int id, int minValue, int maxValue, double incrementProportional) {
		ID = id;
		MIN_VALUE = minValue;
		MAX_VALUE = maxValue;
		INCREMENT_PROPORTIONAL = incrementProportional;

		setOrientation(JScrollBar.HORIZONTAL);
		setMinimum(MIN_VALUE);
		setMaximum(MAX_VALUE);
		
		addAdjustmentListener(this);
		sbCtrl = new ScrollBarController(this);
	}

	public void addScrollBarObserver(ScrollBarObserver observer) {
		observers.add(observer);
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		observers.stream().forEach(o -> o.scrollBarModified(this, e.getValue()));
	}

	public int getID() {
		return ID;
	}

	public double getINCREMENT_PROPORTIONAL() {
		return INCREMENT_PROPORTIONAL;
	}

	public ScrollBarController getSbCtrl() {
		return sbCtrl;
	}
}
