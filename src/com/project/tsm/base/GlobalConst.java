/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.tsm.base;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Osvaldo Erens
 */
public class GlobalConst {
    public static String USER_NAME ="username"; 
    
    
    public static void succesAlert(String message){
        JOptionPane.showMessageDialog(null, message + " Success !");
    }
    
    public static void failedAlert(String message){
        JOptionPane.showMessageDialog(null, message + " Failed !");
    }
    public static void notifAlert(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    
    public static void centerJinternalFrame(JDesktopPane desktopPane, JInternalFrame internalFrame){
        desktopPane.add(internalFrame);
        Dimension desktopSize = desktopPane.getSize();
        Dimension jInternalFrameSize = internalFrame.getSize();
        internalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
            (desktopSize.height- jInternalFrameSize.height)/2);
        internalFrame.setVisible(true);
        desktopPane.getDesktopManager().maximizeFrame(internalFrame);
    }
    
}
