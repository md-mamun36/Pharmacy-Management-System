package PharmecyProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class WelcomePage extends JFrame {

    private ImageIcon img, img2, img3, img4, img5, img6;
    private Container c;
    private JLabel lab, label, label2, label3, label4, label5, label6;
    private Font font;

    WelcomePage() {
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = windowSize.width / 2;
        int h = windowSize.height / 2;

        setTitle("Frame Demu");
        setSize(w, h);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WelcomePage.EXIT_ON_CLOSE);
        setResizable(false);
        initialized();
    }

    public void initialized() {
        c = this.getContentPane();

        //set background img
        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("src/Icons/pharmecy_2.png"));
        add(background);
//        background.setLayout(new FlowLayout());

//        label=new JLabel("set Icon");
//        label.setBounds(10, 10, 200, 35);
//        background.add(label);
        //inatialized images
        img = new ImageIcon("src/Icons/prod.png");
        img2 = new ImageIcon("src/Icons/selling.png");
        img3 = new ImageIcon("src/Icons/COMP.png");
        img4 = new ImageIcon("src/Icons/about.png");
        img5 = new ImageIcon("src/Icons/DETAIS.png");
        img6 = new ImageIcon("src/Icons/exit.png");

        //add label
        font = new Font("Times new Roman", Font.BOLD, 23);
        lab = new JLabel("WELCOME! TO OUR PHARMACY MANAGEMENT SYSTEM.");
        lab.setFont(font);
        lab.setBounds(0, 0, 680, 50);
        lab.setOpaque(true);
        lab.setBackground(Color.ORANGE);
        lab.setVerticalTextPosition(JLabel.CENTER);
        background.add(lab);

        label = new JLabel(img);
        background.add(label);
        label.setBounds(25, 80, img.getIconWidth(), 70);
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));

        label2 = new JLabel(img2);
        background.add(label2);
        label2.setBounds(245, 80, img2.getIconWidth(), 70);
        label2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        label3 = new JLabel(img3);
        background.add(label3);
        label3.setBounds(465, 80, img3.getIconWidth(), 70);
        label3.setCursor(new Cursor(Cursor.HAND_CURSOR));

        label4 = new JLabel(img4);
        background.add(label4);
        label4.setBounds(245, 220, img4.getIconWidth(), 70);
        label4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        label5 = new JLabel(img5);
        background.add(label5);
        label5.setBounds(25, 220, img5.getIconWidth(), 70);
        label5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        label6 = new JLabel(img6);
        background.add(label6);
        label6.setBounds(465, 220, img6.getIconWidth(), 70);
        label6.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //ADD mouse LISTENER
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                AddProduct ap=new AddProduct();
                ap.setVisible(true);
                dispose();
            }
        });
        //label2 mouselistener
        label2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                SellingPage slp=new SellingPage();
                slp.setVisible(true);
                 dispose();
            }
        });
        //label3 mouselistener
        label3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                dispose();
                AddDragCompany dc = new AddDragCompany();
                dc.setVisible(true);
            }
        });
        //label4 mouselistener
        label4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                  try {
                    Desktop.getDesktop().browse(new URI("https://www.facebook.com/profile.php?id=100007695907789"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //label5 mouselistener
        label5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                DataDetails dd=new DataDetails();
                dd.setVisible(true);
                dispose();
            }
        });
        //label6 mouselistener
        label6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int exit = JOptionPane.showConfirmDialog(null, "Do you want to Exit?", "Quit!", JOptionPane.YES_NO_OPTION);
                if (exit == 0) {
                    System.exit(0);
                }
            }
        });

    }

    public static void main(String[] args) {
        WelcomePage jf = new WelcomePage();
        jf.setVisible(true);
    }
}
