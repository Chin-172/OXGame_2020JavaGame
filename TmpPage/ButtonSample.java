import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSample {

    public static void BTN(){
        JFrame      screen = new JFrame();
        JLabel      jl = new JLabel();    
        JPanel      jp = new JPanel();
        ImageIcon   imageIcon = new ImageIcon();    // Used for resize background 
        Image       image;
        Image       tmpimg;

        // Default setting
        screen.setTitle("ButtonSample");
        screen.setVisible(true);
        screen.setSize(1024,780);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set image position
        imageIcon = new ImageIcon("Img/info.png");
        image = imageIcon.getImage();
        tmpimg = image.getScaledInstance(200, 120,  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(tmpimg);


        // Add button
        JButton OKBtn = new JButton("OK");
        jp.add(OKBtn);
        OKBtn.setPreferredSize(new Dimension(100,50));   // Resize Btn (w,h)
        
        //Add image to button
        imageIcon = new ImageIcon("Img\\info.png");
        JButton ImgBtn = new JButton(imageIcon);
        ImgBtn.setContentAreaFilled(false);             // Remove Btn Background
        ImgBtn.setFocusable(false);                     //inside line invisible
        ImgBtn.setBorderPainted(false);                 //outside line invisible
        jp.add(ImgBtn);

        // Button mouse over background setting
        ImgBtn.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ImgBtn.setContentAreaFilled(true); 
                ImgBtn.setBackground(Color.GREEN);
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ImgBtn.setBackground(UIManager.getColor("control"));
                ImgBtn.setContentAreaFilled(false); 
            }
        });
        
        // Click count
        ImgBtn.addActionListener(new ActionListener() {
            int         count = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                ImgBtn.setText("Click " + count ++);
            }
        });
        screen.add(jp);

       
        screen.validate();
    }
    public static void main(String[] args){
        BTN();
    }
}
