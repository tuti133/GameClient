/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gameclient.view.LoginFrm;

/**
 *
 * @author Admin
 */
public class GameClient {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		LoginFrm loginFrm = new LoginFrm();
		loginFrm.setVisible(true);
	}

}
