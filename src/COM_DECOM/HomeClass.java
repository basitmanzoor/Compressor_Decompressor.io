package COM_DECOM;

import COMP_DECOMP_Action.compressor;
import COMP_DECOMP_Action.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
public class HomeClass extends JFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;

    HomeClass(){
        this.setTitle("Compressor and Decompressor");
        this.setSize(800,700);
//        this.setLocation(400,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        compressButton = new JButton("SELECT TO COMPRESS");
        compressButton.setBounds(100,100,200,50);
        compressButton.addActionListener(this);

        decompressButton = new JButton("SELECT TO DECOMPRESS");
        decompressButton.setBounds(200,100,200,50);
        decompressButton.addActionListener(this);


        this.add(compressButton);
        this.add(decompressButton);
        this.getContentPane().setBackground(Color.CYAN);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }

        if(e.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
    }
}
