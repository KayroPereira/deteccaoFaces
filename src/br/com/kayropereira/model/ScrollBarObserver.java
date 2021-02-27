package br.com.kayropereira.model;

import br.com.kayropereira.view.ScrollBarPersonalizado;

@FunctionalInterface
public interface ScrollBarObserver {
	
	void scrollBarModified(ScrollBarPersonalizado component, int value); 
}
