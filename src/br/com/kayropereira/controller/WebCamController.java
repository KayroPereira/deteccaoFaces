package br.com.kayropereira.controller;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import br.com.kayropereira.model.FaceDetect;
import br.com.kayropereira.model.ScrollBarObserver;
import br.com.kayropereira.model.Utilitario;
import br.com.kayropereira.model.WebCamObserver;
import br.com.kayropereira.view.ScrollBarPersonalizado;

public class WebCamController implements ScrollBarObserver {
	
	private FaceDetect faceDetect;

	private List<WebCamObserver> observadoresWebCam = new ArrayList<>();

	private double scaleFactor;
	private int minNeighbors;
	private int minSize;
	private int maxSize;

	public WebCamController() {

		faceDetect = new FaceDetect();

		new Thread(new Runnable() {
			@Override
			public void run() {
				showVideo();
			}
		}).start();
	}

	public void addObserver(WebCamObserver webCamObserver) {
		observadoresWebCam.add(webCamObserver);
	}

	private void postObserver(BufferedImage image) {
		observadoresWebCam.stream().forEach(o -> o.updateImagem(image));
	}

	private void showVideo() {
		Mat video = new Mat();

		VideoCapture capture = new VideoCapture(0);

		if (capture.isOpened()) {
			while (true) {
				capture.read(video);

				if (!video.empty()) {

					postObserver(Utilitario.convertMatToImage(faceDetect.detectFace(video, getScaleFactor(),
							getMinNeighbors(), getMinSize(), getMaxSize())));
				}
			}
		}
	}

	@Override
	public void scrollBarModified(ScrollBarPersonalizado component, int value) {
		
		switch (component.getID()) {
		case 1:
			setScaleFactor(value/component.getINCREMENT_PROPORTIONAL());
			break;

		case 2:
			setMinNeighbors((int) (value/component.getINCREMENT_PROPORTIONAL()));
			break;

		case 3:
			setMinSize((int) (value/component.getINCREMENT_PROPORTIONAL()));
			break;

		case 4:
			setMaxSize((int) (value/component.getINCREMENT_PROPORTIONAL()));
			break;
		}
	}

	public double getScaleFactor() {
		return scaleFactor;
	}

	public void setScaleFactor(double scaleFactor) {
		this.scaleFactor = scaleFactor;
	}

	public int getMinNeighbors() {
		return minNeighbors;
	}

	public void setMinNeighbors(int minNeighbors) {
		this.minNeighbors = minNeighbors;
	}

	public int getMinSize() {
		return minSize;
	}

	public void setMinSize(int minSize) {
		this.minSize = minSize;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
}