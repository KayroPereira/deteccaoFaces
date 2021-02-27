package br.com.kayropereira.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import br.com.kayropereira.controller.WebCamController;
import br.com.kayropereira.model.WebCamObserver;

@SuppressWarnings("serial")
public class PainelWebCam extends JPanel implements WebCamObserver {

	protected final int WIDTH_WEBCAM = 350;
	protected final int HEIGHT_WEBCAM = 250;

	private WebCamController webCtrl;

	public PainelWebCam() {
		webCtrl = new WebCamController();

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setSize(WIDTH_WEBCAM, HEIGHT_WEBCAM);
		webCtrl.addObserver(this);
	}

	@Override
	public void updateImagem(BufferedImage image) {
		Graphics gr = getGraphics();
		gr.drawImage(image, 0, 0, WIDTH_WEBCAM, HEIGHT_WEBCAM, null);
	}

	public void addObserverPainelWebCam(ControlesParametros controles) {
		controles.getControles().stream().forEach(e -> e.addScrollBarObserver(webCtrl));
	}
}