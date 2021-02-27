package br.com.kayropereira.controller;

import org.opencv.core.Core;

import br.com.kayropereira.view.WindowMain;

public class DeteccaoController {
	
	public static void main(String[] args) {
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		new WindowMain(640, 320);
	}
}