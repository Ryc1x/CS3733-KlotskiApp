package controller;

import javax.swing.JOptionPane;

import view.KlotskiApp;

public class ExitApplication {
	public boolean confirm(KlotskiApp app) {
		return JOptionPane.showConfirmDialog (app, "Do you wish to exit Application?") == JOptionPane.OK_OPTION;	
	}
}
