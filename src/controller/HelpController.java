package controller;

import javax.swing.JOptionPane;

import view.KlotskiApp;

public class HelpController {
	public void printHelp(KlotskiApp app) {
		String helpMsg = "This is a simple implimentation of Klotski using EBC design. \n"
				+ "Select an tile: click the tile \n"
				+ "Move the tile: press ASDW keys \n\n"
				+ "Author: Rui Huang \n"
				+ "WPI CS3733 B18 - Individual Project";
		JOptionPane.showMessageDialog(app, helpMsg);	
	}
}
