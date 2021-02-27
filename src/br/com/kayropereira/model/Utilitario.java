package br.com.kayropereira.model;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import org.opencv.core.Mat;

public class Utilitario {

	public static BufferedImage convertMatToImage(Mat mat) {
		int type = BufferedImage.TYPE_BYTE_GRAY;
		if (mat.channels() > 1) {
			type = BufferedImage.TYPE_3BYTE_BGR;
		}

		int bufferSize = mat.channels() * mat.cols() * mat.rows();
		byte[] bytes = new byte[bufferSize];
		mat.get(0, 0, bytes);
		BufferedImage imagem = new BufferedImage(mat.cols(), mat.rows(), type);
		byte[] targetPixels = ((DataBufferByte) imagem.getRaster().getDataBuffer()).getData();
		System.arraycopy(bytes, 0, targetPixels, 0, bytes.length);
		return imagem;
	}
}