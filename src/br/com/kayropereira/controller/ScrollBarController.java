package br.com.kayropereira.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.kayropereira.model.ScrollBarObserver;
import br.com.kayropereira.view.ScrollBarPersonalizado;

public class ScrollBarController implements ScrollBarObserver {
	
	private List<ScrollBarObserver> observers = new ArrayList<>();

	public ScrollBarController(ScrollBarPersonalizado scrollBar) {
		scrollBar.addScrollBarObserver(this);
	}
	
	public void addScrollBarObserver(ScrollBarObserver observer) {
		observers.add(observer);
	}

	@Override
	public void scrollBarModified(ScrollBarPersonalizado component, int value) {
		
		observers.stream().forEach(e -> e.scrollBarModified(component, value));
		
	}
}
