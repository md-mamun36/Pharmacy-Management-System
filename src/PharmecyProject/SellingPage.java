package PharmecyProject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SellingPage extends JFrame {

    private Container c;
    private JLabel lab, label, label2, label3, label4, label5, label6, label7, label8;
    private Font font, font1, font2;
    private JTextField sid, sunit, suprice, custtotal, custpay, custchange, custid;
    private JTable tbl;
    public JComboBox sname;
    private JScrollPane jscrol;
    private String[] cols = {"Medicine_Id", "Medicine", "Quentity", "Unit_price", "Cost"};
    String[] rows = new String[5];
    private DefaultTableModel model;
    private JButton sell, bil, custprint, exit, change;
    private JTextArea slip;

    SellingPage() {
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = windowSize.width;
        int h = windowSize.height;

        setTitle("Frame Demu");
        setSize(w, h);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WelcomePage.DISPOSE_ON_CLOSE);
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
        lab = new JLabel("WELCOME! TO SELLING SYSTEM.");
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

        label3 = new JLabel("Quentity:");
        c.add(label3);
        label3.setBounds(10, 170, 150, 30);
        label3.setFont(font1);

        label4 = new JLabel("Unit_Price:");
        c.add(label4);
        label4.setBounds(10, 220, 150, 30);
        label4.setFont(font1);

        label5 = new JLabel("Total:");
        c.add(label5);
        label5.setBounds(420, 120, 150, 30);
        label5.setHorizontalAlignment(JLabel.CENTER);
        label5.setFont(font1);

        label6 = new JLabel("Paid:");
        c.add(label6);
        label6.setBounds(420, 170, 150, 30);
        label6.setHorizontalAlignment(JLabel.CENTER);
        label6.setFont(font1);

        label7 = new JLabel("Change:");
        c.add(label7);
        label7.setBounds(420, 220, 150, 30);
        label7.setHorizontalAlignment(JLabel.CENTER);
        label7.setFont(font1);

        label8 = new JLabel("Customer_Id:");
        c.add(label8);
        label8.setBounds(420, 70, 150, 30);
        label8.setFont(font1);

        //create textfield
        sid = new JTextField();
        sid.setBounds(190, 70, 200, 30);
        sid.setFont(font2);
        c.add(sid);

        sname = new JComboBox();
        sname.setBounds(190, 120, 200, 30);
        sname.setFont(font2);
        c.add(sname);

        sunit = new JTextField();
        sunit.setBounds(190, 170, 200, 30);
        sunit.setFont(font2);
        c.add(sunit);

        suprice = new JTextField();
        suprice.setBounds(190, 220, 200, 30);
        suprice.setFont(font2);
        c.add(suprice);

        custtotal = new JTextField();
        custtotal.setBounds(540, 120, 200, 30);
        custtotal.setFont(font2);
        c.add(custtotal);

        custpay = new JTextField();
        custpay.setBounds(540, 170, 200, 30);
        custpay.setFont(font2);
        c.add(custpay);

        custchange = new JTextField();
        custchange.setBounds(540, 220, 200, 30);
        custchange.setFont(font2);
        c.add(custchange);

        custid = new JTextField();
        custid.setBounds(540, 70, 200, 30);
        custid.setFont(font2);
        c.add(custid);

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
        jscrol.setBounds(20, 400, 670, 200);
        c.add(jscrol);

        //unic customer id
        //creating Button
        sell = new JButton("SELL");
        sell.setBounds(250, 300, 100, 30);
        sell.setFont(font2);
        c.add(sell);

//        update = new JButton("UPDATE");
//        update.setBounds(400, 300, 100, 30);
//        update.setFont(font2);
//        c.add(update);
        bil = new JButton("INVOICE");
        bil.setBounds(400, 300, 100, 30);
        bil.setFont(font2);
        c.add(bil);

        custprint = new JButton("PRINT");
        custprint.setBounds(550, 300, 100, 30);
        custprint.setFont(font2);
        c.add(custprint);

        exit = new JButton("BACK TO HOME");
//        exit.setBounds(10, 630, 100, 40);
        exit.setBounds(1050, 120, 250, 50);
        exit.setFont(font1);
        exit.setBackground(Color.RED);
        c.add(exit);

        change = new JButton("BACKGROUND COLOR");
//        change.setBounds((w - 130), 630, 100, 40);
        change.setBounds(1050, 60, 250, 50);
        change.setFont(font1);
        change.setBackground(Color.GREEN);
        c.add(change);

        //creating invoice
        Border blackline = BorderFactory.createLineBorder(Color.black);
        slip = new JTextArea();
        slip.setBounds(870, 190, 450, 450);
        slip.setBorder(blackline);
        c.add(slip);

        //add focus gaid listener
        sname.addFocusListener(new FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sname.removeAllItems();
                try {
                    //call the connection class
                    Connection conn = ConnectionClass.getconnect();
//                    Class.forName("oracle.jdbc.driver.OracleDriver");
//                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");
                    Statement st = conn.createStatement();
                    ResultSet reslt = st.executeQuery("select distinct medicn_name from PRODUCT order by medicn_name");
                    while (reslt.next()) {
                        String itm = reslt.getString(1);

                        sname.addItem(itm);
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        });
        sname.addFocusListener(new FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                String selItem = sname.getSelectedItem().toString();
                try {
                    //call the connection class
                    Connection conn = ConnectionClass.getconnect();
//                    Class.forName("oracle.jdbc.driver.OracleDriver");
//                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");
                    Statement st = conn.createStatement();
                    ResultSet reslt = st.executeQuery("select medicn_id,UNIT_PRICE from PRODUCT where medicn_name='" + selItem + "'");
                    if (reslt.next()) {
                        String itmid = reslt.getString(1);
                        String itmprice = reslt.getString(2);
//                        String convertPrice=itmprice;
                        sid.setText(itmid);
                        suprice.setText(itmprice);
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        });

        //add action listener
        sell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                custpay.setText("");

                try {
                    if (sid.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Plz provide the medicine Id !", "need!", 2);
                    }
                    if (custid.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Plz provide the Customer Id !", "need!", 2);
                    } else {
                        String cusid = custid.getText().toUpperCase();
                        String selid = sid.getText().toUpperCase();
                        String selname = sname.getSelectedItem().toString().toUpperCase();
                        float selunt = Float.parseFloat(sunit.getText());
                        float selprc = Float.parseFloat(suprice.getText());
                        float total = selunt * selprc;
                        float prodUnitPric = 0;
                        float prodUnit = 0;
//                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//                        Date date = new Date();
                        //inject data into table

//                         LocalDateTime now = LocalDateTime.now();
//                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                        String sDate1 = LocalDateTime.now().toString();
//                         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                        String string = "January 2, 2010";
//                        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//                        Date date = (Date) format.parse(string);
//                        LocalDate date = LocalDate.now();
                        try {
                            //call the connection class
                            Connection con = ConnectionClass.getconnect();
//                            Class.forName("oracle.jdbc.driver.OracleDriver");
//                            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");
                            Statement st = con.createStatement();
                            ResultSet result = st.executeQuery("SELECT UNIT_PRICE,QUENTITY from PRODUCT WHERE MEDICN_ID='" + selid + "'");
//                            ResultSet result2 = st.executeQuery(" select sysdate from dual;");
//                            if (result2.next()) {
//                                d = result.getDate(1);
//                            }

                            if (result.next()) {
                                prodUnitPric = result.getFloat(1);
                            }
                            prodUnit = result.getFloat(2);
                            if (selunt > prodUnit) {
                                JOptionPane.showMessageDialog(null, selunt + " Units Product are not Available !", "Out of Stock!", 2);
                            } else {

                                String insert = "insert into SELL(MEDICN_NAME,QUENTITY,UNIT_PRICE,TOTAL,SELL_DATE,MEDICN_ID,PROFIT,CUSTOMER_ID)"
                                        + "VALUES(?,?,?,?,curdate(),?,?,?)";
                                PreparedStatement psmnt = con.prepareStatement(insert);

                                psmnt.setString(1, selname);
                                psmnt.setFloat(2, selunt);
                                psmnt.setFloat(3, selprc);
                                psmnt.setFloat(4, total);
//                                psmnt.setDate(5, d);
                                psmnt.setString(5, selid);
                                psmnt.setFloat(6, (selprc - prodUnitPric) * selunt);
                                psmnt.setString(7, cusid);
                                psmnt.execute();

                                st.executeUpdate("update PRODUCT set QUENTITY=QUENTITY-" + selunt + " where MEDICN_ID='" + selid + "' and MEDICN_NAME='" + selname + "'");

                                con.close();
//                                JOptionPane.showMessageDialog(null, selid + " Number Product is Saled!", "Confirm", -1);

                                model = (DefaultTableModel) tbl.getModel();
                                model.addRow(new Object[]{selid, selname, selunt, selprc, total});
                                //add the all sell cost
                                float sum = 0;
                                for (int i = 0; i < tbl.getRowCount(); i++) {
                                    sum += Float.parseFloat(tbl.getValueAt(i, 4).toString());
                                }
                                custtotal.setText(Float.toString(sum));
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e, "Invalid!", 2);
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e, "Invalid!", 2);
                }

                sid.setText("");
                sunit.setText("");
                suprice.setText("");
                if (tbl.getRowCount() > 0) {
                    custid.setEditable(false);
                }

            }

        });
        //add key listiner
        custpay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                custpayKeyReleased(evt);
            }
        });
        //add bill action listiner
        bil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bilActionPerformed(evt);
            }
        });
        //print bill action listiner
        custprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custprintActionPerformed(evt);
            }
        });
        //exit button listener
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                int exit = JOptionPane.showConfirmDialog(null, "Do you want to leave this page?", "Exit", JOptionPane.YES_NO_OPTION);
//                if (exit == 0) {
//                    dispose();
//                    WelcomePage wlc=new WelcomePage();
//                    wlc.setVisible(true);
//                }
                dispose();
                WelcomePage wlc = new WelcomePage();
                wlc.setVisible(true);
            }
        });
        //background change method
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Color color = JColorChooser.showDialog(null, "Choose a Color", Color.red);
                c.setBackground(color);
            }
        });
    }

    //custpay method
    private void custpayKeyReleased(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        try {

            float cTotal = Float.parseFloat(custtotal.getText());
            float custPay = Float.parseFloat(custpay.getText());
            float custChange = custPay - cTotal;
            custchange.setText(Float.toString(custChange));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", 2);
        }
    }

    //bill set the invoice method
    private void bilActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        try {
            Float custc = Float.parseFloat(custchange.getText());
            if (tbl.getRowCount() < 1) {
                JOptionPane.showMessageDialog(null, "You Could't sell anytthing!", "Error!", 2);
            } else if (custid.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Provide valid Customer Id.", "Error!", 2);
            } else if (custpay.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Payment amount needed!", "Requird!", 2);
            } else if (custc < 0) {
                JOptionPane.showMessageDialog(null, "Insuppocient Payment!", "Requird!", 2);
            } else {
                slip.setText("");
                String cid = custid.getText();
                float cTotal = Float.parseFloat(custtotal.getText());
                float custPay = Float.parseFloat(custpay.getText());
                float custChange = custPay - cTotal;
                custchange.setText(Float.toString(custChange));

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd / MM / yyyy (HH : mm)");
                LocalDateTime now = LocalDateTime.now();

                slip.setText(slip.getText() + "\n");
                slip.setText(slip.getText() + "  \t\t  INVOICE\n");
                slip.setText(slip.getText() + " \t--------------------------------------------------------" + "\n");
                slip.setText(slip.getText() + " \t     Sells Daate : " + dtf.format(now) + "\n");
                slip.setText(slip.getText() + " \t                        Cutomer_Id :- " + cid + "\n\n");
                slip.setText(slip.getText() + "     MedicinId\t" + "Medicine\t" + " Quentity\t" + " UnitPrice\t" + " Cost " + "\n");

                for (int i = 0; i < tbl.getRowCount(); i++) {
                    String pId = tbl.getValueAt(i, 0).toString();
                    String pName = tbl.getValueAt(i, 1).toString();
                    String pQuentity = tbl.getValueAt(i, 2).toString();
                    String pUnit = tbl.getValueAt(i, 3).toString();
                    String pCost = tbl.getValueAt(i, 4).toString();
                    slip.setText(slip.getText() + "     " + pId + "\t" + pName + "\t" + pQuentity + "\t" + pUnit + "\t" + pCost + "\t" + "\n");
                }
                slip.setText(slip.getText() + " \n");
                slip.setText(slip.getText() + "\t\t\tTotal = " + cTotal + "\n");
                slip.setText(slip.getText() + "\t\t\tPaid = " + custPay + "\n");
                slip.setText(slip.getText() + "\t\t\tChange = " + custChange + "\n");
                slip.setText(slip.getText() + "     ************************************************************************************\t" + "\n");
                slip.setText(slip.getText() + "  \t\t *Thank You Come Again*\n");

                model = (DefaultTableModel) tbl.getModel();
                int rc = tbl.getRowCount();
                for (int i = 0; i < rc; i++) {
                    model.removeRow(0);
                }

                custid.setText("");

                custid.setEditable(true);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Requird!", 2);
        }
    }

    //print mathod
    private void custprintActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            slip.print();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        SellingPage sp = new SellingPage();
        sp.setVisible(true);
    }
}
