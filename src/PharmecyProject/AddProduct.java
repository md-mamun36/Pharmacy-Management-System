package PharmecyProject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class AddProduct extends JFrame {

    private Container c;
    private JLabel lab, label, label2, label3, label4, label5, label6, label7, label8;
    private Font font, font1, font2;
    private JTextField pid, pname, pgenname, pcomname, punit, pprice, psNo, puse;
    private JButton update, submit, delet, view, exit, change;
    private JTable tbl;
    private JScrollPane jscrol;
    private String[] cols = {"Medicine_Id", "Medicine_Name", "Generic_Name", "Company", "Quentity", "Unit_price", "Shelf-No", "Uses"};
    String[] rows = new String[8];
    private DefaultTableModel model;

    AddProduct() {
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = windowSize.width;
        int h = windowSize.height;

        setTitle("");
        setSize(w, h);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WelcomePage.DISPOSE_ON_CLOSE);
//        setResizable(false);
        initialized(w);

    }

    //creating initialized method
    public void initialized(int w) {
        c = this.getContentPane();
        c.setLayout(null);

//            c.setBackground(Color.orange);
        //create font
        font = new Font("Times new Roman", Font.BOLD, 25);
        font1 = new Font("Times new Roman", Font.BOLD, 18);
        font2 = new Font("Times new Roman", Font.BOLD, 14);

        //add label
        lab = new JLabel("WELCOME! TO PRODUCT ADDING  SYSTEM.");
        lab.setFont(font);
        lab.setBounds(0, 0, w, 50);
        lab.setOpaque(true);
        lab.setBackground(Color.ORANGE);
        lab.setHorizontalAlignment(JLabel.CENTER);
        c.add(lab);

        label = new JLabel("MedicIne_Id:");
        c.add(label);
        label.setBounds(10, 70, 200, 30);
        label.setFont(font1);

        label2 = new JLabel("Madicine_Name:");
        c.add(label2);
        label2.setBounds(10, 120, 200, 30);
        label2.setFont(font1);

        label3 = new JLabel("Generic_Name:");
        c.add(label3);
        label3.setBounds(10, 170, 150, 30);
        label3.setFont(font1);

        label4 = new JLabel("Company_Name:");
        c.add(label4);
        label4.setBounds(10, 220, 150, 30);
        label4.setFont(font1);

        label5 = new JLabel("Quentity:");
        c.add(label5);
        label5.setBounds(410, 70, 150, 30);
        label5.setHorizontalAlignment(JLabel.CENTER);
        label5.setFont(font1);

        label6 = new JLabel("Unit_Price:");
        c.add(label6);
        label6.setBounds(410, 120, 150, 30);
        label6.setHorizontalAlignment(JLabel.CENTER);
        label6.setFont(font1);

        label7 = new JLabel("Shelf_No:");
        c.add(label7);
        label7.setBounds(410, 170, 150, 30);
        label7.setHorizontalAlignment(JLabel.CENTER);
        label7.setFont(font1);

        label7 = new JLabel("Used_For:");
        c.add(label7);
        label7.setBounds(410, 220, 150, 30);
        label7.setHorizontalAlignment(JLabel.CENTER);
        label7.setFont(font1);

        //creating text field
        pid = new JTextField();
        pid.setBounds(175, 70, 200, 30);
        pid.setFont(font2);
        c.add(pid);

        pname = new JTextField();
        pname.setBounds(175, 120, 200, 30);
        pname.setFont(font2);
        c.add(pname);

        pgenname = new JTextField();
        pgenname.setBounds(175, 170, 200, 30);
        pgenname.setFont(font2);
        c.add(pgenname);

        pcomname = new JTextField();
        pcomname.setBounds(175, 220, 200, 30);
        pcomname.setFont(font2);
        c.add(pcomname);

        punit = new JTextField();
        punit.setBounds(550, 70, 200, 30);
        punit.setFont(font2);
        c.add(punit);

        pprice = new JTextField();
        pprice.setBounds(550, 120, 200, 30);
        pprice.setFont(font2);
        c.add(pprice);

        psNo = new JTextField();
        psNo.setBounds(550, 170, 200, 30);
        psNo.setFont(font2);
        c.add(psNo);

        puse = new JTextField();
        puse.setBounds(550, 220, 200, 30);
        puse.setFont(font2);
        c.add(puse);

        //creating Button
        delet = new JButton("DELETE");
        delet.setBounds(250, 280, 100, 30);
        delet.setFont(font2);
        c.add(delet);

        submit = new JButton("ADD");
        submit.setBounds(400, 280, 100, 30);
        submit.setFont(font2);
        c.add(submit);

        update = new JButton("UPDATE");
        update.setBounds(550, 280, 100, 30);
        update.setFont(font2);
        c.add(update);

        view = new JButton("VIEW-PRODUCT");
        view.setBounds(350, 330, 200, 30);
        view.setFont(font2);
        c.add(view);

        change = new JButton("BACKGROUND COLOR");
        change.setBounds(1000, 70, 250, 50);
        change.setBackground(Color.GREEN);
        change.setFont(font1);
        c.add(change);

        exit = new JButton("BACK TO HOME");
        exit.setBounds(1000, 150, 250, 50);
        exit.setBackground(Color.red);
        exit.setForeground(Color.white);
        exit.setFont(font1);
        c.add(exit);

        //creating table
        tbl = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(cols);
        JTableHeader tableHeader = tbl.getTableHeader();
        tableHeader.setFont(font1);

        tbl.setModel(model);
        tbl.setRowHeight(22);
        tbl.setFont(font2);
        tbl.setSelectionForeground(Color.white);
        tbl.setBackground(Color.white);
        tbl.setSelectionBackground(Color.blue);

        jscrol = new JScrollPane(tbl);
        jscrol.setBounds(20, 370, 1050, 300);
        c.add(jscrol);

        //add product add button listener
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        //add view product button listener
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        // add tbl clicked listener
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        //add update listener
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        //add delet listener
        delet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        //add exit listener
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                int exit = JOptionPane.showConfirmDialog(null, "Do you want to leave this page?", "Exit", JOptionPane.YES_NO_OPTION);
//                if (exit == 0) {
//                   
//                }

                dispose();
                WelcomePage wlc = new WelcomePage();
                wlc.setVisible(true);
            }
        });
        //add background change listener
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Color color = JColorChooser.showDialog(null, "Choose a Color", Color.red);
                c.setBackground(color);
            }
        });

    }

    //create add method
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (punit.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Provide Product Quentity.", "Need!", 2);
        } else if (pcomname.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Provide the Company Name.", "Need!", 2);
        } else if (pprice.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Provide the unit Price.", "Need!", 2);
        } else {
            String prid = pid.getText().toUpperCase();
            String prname = pname.getText().toUpperCase();
            String prgen = pgenname.getText().toUpperCase();
            String prcom = pcomname.getText().toUpperCase();
            try {
                float punt = Float.parseFloat(punit.getText());
                float pprc = Float.parseFloat(pprice.getText());
                float tot = punt * pprc;

                String shelf = psNo.getText().toUpperCase();
                String uses = puse.getText().toUpperCase();

                try {
                    //call the connection class
                    Connection con = ConnectionClass.getconnect();
//                    Class.forName("oracle.jdbc.driver.OracleDriver");
//                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");
                    Statement st = con.createStatement();
                    String insert = "insert into PRODUCT(MEDICN_NAME,QUENTITY,UNIT_PRICE,TOTAL,MEDICN_ID,SHELF_NO,USES,GENERIC_NAME,COMPANY)"
                            + "VALUES(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement psmnt = con.prepareStatement(insert);

                    psmnt.setString(1, prname);
                    psmnt.setFloat(2, punt);
                    psmnt.setFloat(3, pprc);
                    psmnt.setFloat(4, tot);
                    psmnt.setString(5, prid);
                    psmnt.setString(6, shelf);
                    psmnt.setString(7, uses);
                    psmnt.setString(8, prgen);
                    psmnt.setString(9, prcom);
                    psmnt.execute();
                    con.close();
                    JOptionPane.showMessageDialog(null, prid + " Number Product Added!", "success", -1);

                    pid.setText("");
                    pname.setText("");
                    pgenname.setText("");
                    pcomname.setText("");
                    punit.setText("");
                    pprice.setText("");
                    psNo.setText("");
                    puse.setText("");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e, "Invalid!", 2);
                }
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null, exc, "Invalid!", 2);
            }
        }

    }

    //add view method
    public void viewActionPerformed(ActionEvent evt) {
        int rc = tbl.getRowCount();
        for (int i = 0; i < rc; i++) {
            model.removeRow(0);
        }

//         Font font=new Font("Times new roman",Font.BOLD,18);
//        tbl.setBounds(550, 370, 800, 400);
//        proftable.setVisible(true);
//        Container cn=proftable.getContentPane();
//           proftable.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            //call the connection class
            Connection conn = ConnectionClass.getconnect();
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");
            Statement st = conn.createStatement();
            String joinst = "SELECT MEDICN_ID,MEDICN_NAME,GENERIC_NAME,COMPANY,QUENTITY,UNIT_PRICE,SHELF_NO,USES FROM PRODUCT  ORDER BY MEDICN_NAME";

            ResultSet resulSet = st.executeQuery(joinst);

            while (resulSet.next()) {
                String pidt = resulSet.getString(1);
                String pnam = resulSet.getString(2);
                String pgen = resulSet.getString(3);
                String pcom = resulSet.getString(4);
                float pquentity = resulSet.getFloat(5);
                float purcseRate = resulSet.getFloat(6);
                String shelf = resulSet.getString(7);
                String use = resulSet.getString(8);

                //view result in table
                model = (DefaultTableModel) tbl.getModel();
                model.addRow(new Object[]{pidt, pnam, pgen, pcom, pquentity, purcseRate, shelf, use,});
            }
//         ResultSet total=st.executeQuery("select TRUNC( SUM(PROFIT),2) FROM SELL");
//         if(total.next())
//            total.getString(1);
//         proftable.text1.setText(total.getString(1));
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Invalid!", 2);
        }
    }

    //Table row clcked method
    private void tblMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        model = (DefaultTableModel) tbl.getModel();
        int getRow = tbl.getSelectedRow();

        String tx1 = model.getValueAt(getRow, 0).toString();
        String tx2 = model.getValueAt(getRow, 1).toString();
        String tx3 = model.getValueAt(getRow, 2).toString();
        String tx4 = model.getValueAt(getRow, 3).toString();
        String tx5 = model.getValueAt(getRow, 4).toString();
        String tx6 = model.getValueAt(getRow, 5).toString();
        String tx7 = model.getValueAt(getRow, 6).toString();
        String tx8 = model.getValueAt(getRow, 7).toString();

        pid.setText(tx1);
        pname.setText(tx2);
        pgenname.setText(tx3);
        pcomname.setText(tx4);
//      punit.setText(tx5);
        pprice.setText(tx6);
        psNo.setText(tx7);
        puse.setText(tx8);

    }
    //create update method

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            String updteid = pid.getText();
            String updtename = pname.getText().toUpperCase();
            String updtegen = pgenname.getText();
            String updteCompany = pcomname.getText();
            if (punit.getText().isEmpty() == true) {
                punit.setText("0");
            } else if (pprice.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "provide unit price", "Missing", 2);
            }
            float updtequentity = Float.parseFloat(punit.getText());
            float updteprice = Float.parseFloat(pprice.getText());
            String updateshelf = psNo.getText();
            String updteuses = puse.getText();
            try {
                //call the connection class
                Connection con = ConnectionClass.getconnect();
//                Class.forName("oracle.jdbc.driver.OracleDriver");
//                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");
                Statement st = con.createStatement();
                st.executeUpdate("update PRODUCT set medicn_name='" + updtename + "',generic_name='" + updtegen + "',company='" + updteCompany
                        + "', quentity=quentity+" + updtequentity + ", unit_price=" + updteprice + ",shelf_no='" + updateshelf + "',uses='" + updteuses
                        + "' where medicn_id='" + updteid + "'");
                con.close();
                JOptionPane.showMessageDialog(null, updteid + " Number product is Updated!", "success", -1);

                pid.setText("");
                pname.setText("");
                pgenname.setText("");
                pcomname.setText("");
                punit.setText("");
                pprice.setText("");
                psNo.setText("");
                puse.setText("");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    //create delet method

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        String deletid = pid.getText();
        String deletname = pname.getText();
        if (deletid.isEmpty() == true) {
            JOptionPane.showMessageDialog(null, " prvide the accurate Medicine_Id!", "Error", 2);
        } else if (deletname.isEmpty() == true) {
            JOptionPane.showMessageDialog(null, " prvide the accurate Medicine_Name!", "Error", 2);
        } else {

            try {
                //call the connection class
                Connection con = ConnectionClass.getconnect();
//                Class.forName("oracle.jdbc.driver.OracleDriver");
//                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");
                Statement st = con.createStatement();
                st.executeUpdate("delete from PRODUCT where medicn_id='" + deletid + "' and medicn_name='" + deletname + "'");
                con.close();
                JOptionPane.showMessageDialog(null, deletid + " Number row is deleted!", "success", -1);

                pid.setText("");
                pname.setText("");
                pgenname.setText("");
                pcomname.setText("");
                punit.setText("");
                pprice.setText("");
                psNo.setText("");
                puse.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    ;
    public static void main(String[] args) {
        AddProduct adp = new AddProduct();
        adp.setVisible(true);
    }
}
