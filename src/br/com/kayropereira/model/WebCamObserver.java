package br.com.kayropereira.model;

import java.awt.image.BufferedImage;

@FunctionalInterface
public interface WebCamObserver {

	void updateImagem(BufferedImage image);
}
