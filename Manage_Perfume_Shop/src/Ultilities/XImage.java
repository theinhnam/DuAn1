/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ultilities;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class XImage {
    public static Image getApplcon(){
        URL url=XImage.class.getResource("/Img/logo.png");
        return new ImageIcon(url).getImage();
    }
}
