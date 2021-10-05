package PharmecyProject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

public class AddDragCompany extends JFrame {

    private Container c;
    private JLabel lab, label, label2, label3, label4, label5, label6;
    private Font font, font1, font2;
    private JTextField trid, comName, dItem, cost, given;
    private JButton save, deletbtn, shoTable, exit, change, update;
    private JTable comtbl;
    private JScrollPane jscrol;
    private String[] cols = {"Transaction_Id", "Company", "Medicine_Items", "Toatl_Cost", "Payed", "Due", "Date"};
    String[] rows = new String[7];
    private DefaultTableModel model;

    AddDragCompany() {
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = windowSize.width;
        int h = windowSize.height;

        setTitle("");
        setSize(w, h);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WelcomePage.EXIT_ON_CLOSE);
//        setResizable(false);
        initialized(w);

    }

    public void initialized(int w) {
        c = this.getContentPane();
        c.setLayout(null);

//            c.setBackground(Color.orange);
        //create font
        font = new Font("Times new Roman", Font.BOLD, 25);
        font1 = new Font("Times new Roman", Font.BOLD, 18);
        font2 = new Font("Times new Roman", Font.BOLD, 14);
        //add label
        lab = new JLabel("MEDICINE COMPANY MANAGEMENT.");
        lab.setFont(font);
        lab.setBounds(0, 0, w, 50);
        lab.setOpaque(true);
        lab.setBackground(Color.ORANGE);
        lab.setHorizontalAlignment(JLabel.CENTER);
        c.add(lab);

        label = new JLabel("Transection_Id:");
        c.add(label);
        label.setBounds(10, 70, 200, 30);
        label.setFont(font1);

        label2 = new JLabel("Company_Name:");
        c.add(label2);
        label2.setBounds(10, 120, 200, 30);
        label2.setFont(font1);

        label3 = new JLabel("Medicine_Items:");
        c.add(label3);
        label3.setBounds(10, 170, 150, 30);
        label3.setFont(font1);

        label4 = new JLabel("Total_Cost:");
        c.add(label4);
        label4.setBounds(420, 70, 150, 30);
        label4.setFont(font1);

        label5 = new JLabel("Paid_Mony:");
        c.add(label5);
        label5.setBounds(420, 120, 150, 30);
        label5.setFont(font1);
        //create textfield

        trid = new JTextField();
        trid.setBounds(190, 70, 200, 30);
        trid.setFont(font2);
        c.add(trid);

        comName = new JTextField();
        comName.setBounds(190, 120, 200, 30);
        comName.setFont(font2);
        c.add(comName);

        dItem = new JTextField();
        dItem.setBounds(190, 170, 330, 30);
        dItem.setFont(font2);
        c.add(dItem);

        cost = new JTextField();
        cost.setBounds(550, 70, 200, 30);
        cost.setFont(font2);
        c.add(cost);

        given = new JTextField();
        given.setBounds(550, 120, 200, 30);
        given.setFont(font2);
        c.add(given);

        //create button
        save = new JButton("SAVE");
        save.setBounds(320, 250, 100, 30);
        save.setFont(font2);
        c.add(save);

        deletbtn = new JButton("DELETE");
        deletbtn.setBounds(200, 250, 100, 30);
        deletbtn.setFont(font2);
        c.add(deletbtn);

        update = new JButton("UPDATE");
        update.setBounds(440, 250, 100, 30);
        update.setFont(font2);
        c.add(update);

        shoTable = new JButton("SHOW-TABLE");
        shoTable.setBounds(295, 300, 150, 30);
        shoTable.setFont(font2);
        c.add(shoTable);

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
        comtbl = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(cols);
        JTableHeader tableHeader = comtbl.getTableHeader();
        tableHeader.setFont(font1);

        comtbl.setModel(model);
        comtbl.setRowHeight(22);
        comtbl.setFont(font2);
        comtbl.setSelectionForeground(Color.white);
        comtbl.setBackground(Color.white);
        comtbl.setSelectionBackground(Color.blue);

        jscrol = new JScrollPane(comtbl);
        jscrol.setBounds(20, 380, 1000, 250);
        c.add(jscrol);

        //add save button listener
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        //add update button listener
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        //add delete button listener
        deletbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletbtnActionPerformed(evt);
            }
        });

        //add show table button listener
        shoTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoTableActionPerformed(evt);
            }
        });

        //add tbl clicked listener
        comtbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comtblMouseClicked(evt);
            }
        });

        //add exit listener
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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

    //create save method
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (trid.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Provide the trans_id", "Need!", 2);
        } else if (comName.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Provide the company Name", "Need!", 2);
        } else if (dItem.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Provide the Drags Item", "Need!", 2);
        } else if (cost.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Fill the total cost", "Need!", 2);
        } else if (given.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Fill the Given box", "Need!", 2);
        } else {
            String transId = trid.getText().toUpperCase();
            String company = comName.getText().toUpperCase();
            String dragsItem = dItem.getText().toUpperCase();
            int totalCost = Integer.parseInt(cost.getText());
            int paidMany = Integer.parseInt(given.getText());
            int dueCost = totalCost - paidMany;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();

            try {
//                Class.forName("oracle.jdbc.driver.OracleDriver");
//                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");

                //call the connection class
                Connection con = ConnectionClass.getconnect();
                Statement st = con.createStatement();
                String insert = "insert into DRAGS_COMPANY(TRANS_ID,COMPANY_NAME,DRAGS_ITEM,TOTAL_COST,PAID,DUE,TRANS_DATE)"
                        + "VALUES(?,?,?,?,?,?,?)";
                PreparedStatement psmnt = con.prepareStatement(insert);

                psmnt.setString(1, transId);
                psmnt.setString(2, company);
                psmnt.setString(3, dragsItem);
                psmnt.setInt(4, totalCost);
                psmnt.setInt(5, paidMany);
                psmnt.setInt(6, dueCost);
                psmnt.setString(7, dtf.format(now));

                psmnt.execute();
                con.close();
                JOptionPane.showMessageDialog(null, company + "'s Product Receved!", "success", -1);

                trid.setText("");
                comName.setText("");
                dItem.setText("");
                cost.setText("");
                given.setText("");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Invalid!", 2);
            }
        }

    }

    //create show tble method
    private void shoTableActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        DefaultTableModel mod = (DefaultTableModel) comtbl.getModel();
        int rows = mod.getRowCount();
        for (int i = 0; i < rows; i++) {
            mod.removeRow(0);
        }
        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");

            //call the connection class
            Connection connect = ConnectionClass.getconnect();
            Statement st = connect.createStatement();
            ResultSet rseult = st.executeQuery("select trans_id,company_name,drags_item,total_cost,paid,due,trans_date from DRAGS_COMPANY");
            while (rseult.next()) {
                String id = rseult.getString(1);
                String n = rseult.getString(2);
                String i = rseult.getString(3);
                int t = rseult.getInt(4);
                int p = rseult.getInt(5);
                int d = rseult.getInt(6);
                String dat = rseult.getString(7);

                mod.addRow(new Object[]{id, n, i, t, p, d, dat});

            }
            connect.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    //create tble clicked method

    private void comtblMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        DefaultTableModel mod = (DefaultTableModel) comtbl.getModel();
        int getRow = comtbl.getSelectedRow();

        String tx1 = mod.getValueAt(getRow, 0).toString();
        String tx2 = mod.getValueAt(getRow, 1).toString();
        String tx3 = mod.getValueAt(getRow, 2).toString();
        String tx4 = mod.getValueAt(getRow, 3).toString();
//        String tx5 = mod.getValueAt(getRow, 4).toString();

        trid.setText(tx1);
        comName.setText(tx2);
        dItem.setText(tx3);
        cost.setText(tx4);
//        given.setText(tx5);

    }
    //create update method

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            String updtetransId = trid.getText();
            String updteCompany = comName.getText().toUpperCase();
            String updteItem = dItem.getText().toUpperCase();
            if (cost.getText().isEmpty() == true) {
                cost.setText("0");
            } else if (given.getText().isEmpty() == true) {
                given.setText("0");
            }
            int updteCost = Integer.parseInt(cost.getText());
            int updtePay = Integer.parseInt(given.getText());
            try {
//                Class.forName("oracle.jdbc.driver.OracleDriver");
//                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");

                //call the connection class
                Connection con = ConnectionClass.getconnect();
                Statement st = con.createStatement();
                st.executeUpdate("update DRAGS_COMPANY set company_name='" + updteCompany + "',drags_item='" + updteItem + "',total_cost=" + updteCost
                        + ", paid=paid+" + updtePay + ", due=total_cost-paid" + " where trans_id='" + updtetransId + "'");
                con.close();
                JOptionPane.showMessageDialog(null, updtetransId + " Number row is Updated!", "success", -1);

                trid.setText("");
                comName.setText("");
                dItem.setText("");
                cost.setText("");
                given.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    //crete delete method

    private void deletbtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String updtetransId = trid.getText();

        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");

            //call the connection class
                Connection con = ConnectionClass.getconnect();
            Statement st = con.createStatement();
            st.executeUpdate("delete from DRAGS_COMPANY where trans_id='" + updtetransId + "'");
            con.close();
            JOptionPane.showMessageDialog(null, updtetransId + " Number row is deleted!", "success", -1);

            trid.setText("");
            comName.setText("");
            dItem.setText("");
            cost.setText("");
            given.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void main(String[] args) {
        AddDragCompany custpage = new AddDragCompany();
        custpage.setVisible(true);
    }

}
