package br.com.kayropereira.model;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class FaceDetect{

	public Mat detectFace(Mat image, double scaleFactor, int minNeighbors, int minSize, int maxSize) {

		Mat imageColor = image;

		Mat imageGray = new Mat();

		Imgproc.cvtColor(imageColor, imageGray, Imgproc.COLOR_BGR2GRAY);

		CascadeClassifier classifier = new CascadeClassifier("cascades/haarcascade_frontalface_default.xml");

		MatOfRect facesDetected = new MatOfRect();

		// Padrão de chamada
//		classifier.detectMultiScale(imagemCinza, facesDetectadas);

		// Chamada com parâmetros com ajustes, visando melhorar a detecção		
		classifier.detectMultiScale(imageGray, facesDetected, 
				scaleFactor, 					// scale factor
				minNeighbors, 					// minNeighbors
				0, 								// flags
				new Size(minSize, minSize),		// minSize
				new Size(maxSize, maxSize)); 	// maxSize		

		for (Rect rects : facesDetected.toArray()) {
			Imgproc.rectangle(imageColor, new Point(rects.x, rects.y),
					new Point(rects.x + rects.width, rects.y + rects.height), new Scalar(0, 0, 255), 2);
		}
		return imageColor;
	}
}