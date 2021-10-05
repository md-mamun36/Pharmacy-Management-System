package PharmecyProject;

//import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooser;
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
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class DataDetails extends JFrame {

    private Container c;
    private JLabel lab, label2, sbtabl, sbname, sbcust, sbgen, sbcom, sbquent, sbshift, sbuse, sbdate, sbdate2;
    public JComboBox meditable, mediname, ndr1, ndr2, ndr3, ndr4;
    private JTextField prof, gencusttext, comdatetext, quenttext, shifttext, usetext;
    private Font font, font1, font2, font3;
    private JTable tbl, tbl2;
    private JScrollPane jscrol, jscrol2;
    private String[] cols = {"Customer_id", "Medicine_Id", "Medicine_Name", "Sold_Unit", "Purchase_price", "Sold_Price", "Total",
        "Profit", "Sell_Date"};
    String[] rows = new String[9];
    private String[] cols2 = {"Medicine_Id", "Medicine_Name", "Generic_Name", "Company", "Quentity", "Purchase_price",
        "Shels_No", "Uses"};
    String[] rows2 = new String[8];
    private DefaultTableModel model, model2;
    private JButton show, show2, search, go, back, dtailprint, delet, exit, change;
    private JDateChooser datepic1, datepic2;
    private SimpleDateFormat dcn;

    DataDetails() {
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = windowSize.width;
        int h = windowSize.height;

        setTitle("");
        setSize(w, h);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WelcomePage.DISPOSE_ON_CLOSE);

        //calling mathod
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
        font3 = new Font("Times new Roman", Font.BOLD, 8);

        //add label
        lab = new JLabel("ALL DATA DETAILS");
        lab.setFont(font);
        lab.setBounds(0, 0, w, 50);
        lab.setOpaque(true);
        lab.setBackground(Color.ORANGE);
        lab.setHorizontalAlignment(JLabel.CENTER);
        c.add(lab);

        label2 = new JLabel("SEARCHING.......");
        label2.setBounds(490, 55, 200, 30);
        label2.setFont(font1);
        label2.setVisible(false);
        c.add(label2);

        sbtabl = new JLabel("Select Table");
        sbtabl.setBounds(10, 100, 100, 30);
        sbtabl.setFont(font2);
        sbtabl.setVisible(false);
        c.add(sbtabl);

        //add table combobox
        meditable = new JComboBox();
        meditable.setBounds(10, 130, 100, 30);
        meditable.setFont(font2);
        meditable.addItem("Select");
        meditable.addItem("Product");
        meditable.addItem("Sell");
        meditable.setVisible(false);
        c.add(meditable);

        sbname = new JLabel("By Medicine");
        sbname.setBounds(130, 100, 100, 30);
        sbname.setFont(font2);
        sbname.setVisible(false);
        c.add(sbname);
        //add name combobox
        mediname = new JComboBox();
        mediname.setBounds(130, 130, 100, 30);
        mediname.setFont(font2);
        mediname.addItem("Select");
        mediname.setVisible(false);
        c.add(mediname);

        //and or condition-1
//        ndr1 = new JComboBox();
//        ndr1.setBounds(235, 135, 45, 20);
//        ndr1.setFont(font3);
//        ndr1.addItem("OR");
//        ndr1.addItem("AND");
//        ndr1.setVisible(false);
//        c.add(ndr1);
        sbgen = new JLabel("By Generic");
        sbgen.setBounds(270, 100, 100, 30);
        sbgen.setFont(font2);
        sbgen.setVisible(false);
        c.add(sbgen);

        sbcust = new JLabel("Customer_Id");
        sbcust.setBounds(270, 100, 100, 30);
        sbcust.setFont(font2);
        sbcust.setVisible(false);
        c.add(sbcust);
        //generic/customer id textfield
        gencusttext = new JTextField();
        gencusttext.setBounds(270, 130, 100, 30);
        gencusttext.setFont(font1);
        gencusttext.setVisible(false);
        c.add(gencusttext);

        //and or condition-2
//        ndr2 = new JComboBox();
//        ndr2.setBounds(390, 135, 45, 20);
//        ndr2.setFont(font3);
//        ndr2.addItem("OR");
//        ndr2.addItem("AND");
//        ndr2.setVisible(false);
//        c.add(ndr2);
        
        sbquent = new JLabel("By Quentity");
        sbquent.setBounds(425, 100, 100, 30);
        sbquent.setFont(font2);
        sbquent.setVisible(false);
        c.add(sbquent);
        //quentity textfield
        quenttext = new JTextField();
        quenttext.setBounds(420, 130, 100, 30);
        quenttext.setFont(font1);
        quenttext.setVisible(false);;
        c.add(quenttext);

        //and or condition-2
//        ndr3 = new JComboBox();
//        ndr3.setBounds(545, 135, 45, 20);
//        ndr3.setFont(font3);
//        ndr3.addItem("OR");
//        ndr3.addItem("AND");
//        ndr3.setVisible(false);
//        c.add(ndr3);
        
        sbcom = new JLabel("By Company");
        sbcom.setBounds(580, 100, 100, 30);
        sbcom.setFont(font2);
        sbcom.setVisible(false);
        c.add(sbcom);
        //company textfield
        comdatetext = new JTextField();
        comdatetext.setBounds(575, 130, 100, 30);
        comdatetext.setFont(font1);
        comdatetext.setVisible(false);;
        c.add(comdatetext);

        sbdate = new JLabel("From Sell_Date");
        sbdate.setBounds(580, 100, 100, 30);
        sbdate.setFont(font2);
        sbdate.setVisible(false);
        c.add(sbdate);

        //date chooser1
        datepic1 = new JDateChooser();
        datepic1.setBounds(575, 130, 100, 30);
        datepic1.setVisible(false);
//        datepic1.setDate(Calendar.getInstance().getTime());
        c.add(datepic1);

        //and or condition-4
//        ndr4 = new JComboBox();
//        ndr4.setBounds(700, 135, 45, 20);
//        ndr4.setFont(font3);
//        ndr4.addItem("OR");
//        ndr4.addItem("AND");
//        ndr4.setVisible(false);
//        c.add(ndr4);
        
        sbshift = new JLabel("By Shift_No");
        sbshift.setBounds(725, 100, 100, 30);
        sbshift.setFont(font2);
        sbshift.setVisible(false);
        c.add(sbshift);

        //shift no textfield
        shifttext = new JTextField();
        shifttext.setBounds(720, 130, 100, 30);
        shifttext.setFont(font1);
        shifttext.setVisible(false);;
        c.add(shifttext);

        sbdate2 = new JLabel("To Sell Date");
        sbdate2.setBounds(725, 100, 100, 30);
        sbdate2.setFont(font2);
        sbdate2.setVisible(false);
        c.add(sbdate2);

        //date chooser2
        datepic2 = new JDateChooser();
        datepic2.setBounds(720, 130, 100, 30);
        datepic2.setVisible(false);
//        datepic2.setDate(Calendar.getInstance().getTime());
        c.add(datepic2);

        sbuse = new JLabel("By Uses");
        sbuse.setBounds(860, 100, 100, 30);
        sbuse.setFont(font2);
        sbuse.setVisible(false);
        c.add(sbuse);
        //usees textfield
        usetext = new JTextField();
        usetext.setBounds(860, 130, 100, 30);
        usetext.setFont(font1);
        usetext.setVisible(false);;
        c.add(usetext);

        //create textfield
        prof = new JTextField("TOTAL-FROFIT = ");
        prof.setBounds(1000, 600, 250, 30);
        prof.setVisible(false);
        prof.setFont(font1);
        c.add(prof);

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
        jscrol.setBounds(50, 300, 1200, 250);
        jscrol.setVisible(false);
        c.add(jscrol);

        //creating table2
        tbl2 = new JTable();
        model2 = new DefaultTableModel();
        model2.setColumnIdentifiers(cols2);
        JTableHeader tableHeader2 = tbl2.getTableHeader();
        tableHeader2.setFont(font1);

        tbl2.setModel(model2);
        tbl2.setRowHeight(22);
        tbl2.setFont(font2);

        tbl2.setSelectionForeground(Color.white);
        tbl2.setBackground(Color.white);
        tbl2.setSelectionBackground(Color.blue);

        jscrol2 = new JScrollPane(tbl2);
        jscrol2.setBounds(50, 300, 1200, 250);
        jscrol2.setVisible(false);
        c.add(jscrol2);

        //creating Button
        show = new JButton("SELL-DETAILS");
        show.setBounds(550, 150, 220, 50);
        show.setVisible(true);
        show.setFont(font1);
        c.add(show);

        show2 = new JButton("PRODUCTS-DETAILS");
        show2.setBounds(330, 150, 220, 50);
        show2.setVisible(true);
        show2.setFont(font1);
        c.add(show2);

        search = new JButton("SEARCH");
        search.setBounds(110, 150, 220, 50);
        search.setVisible(true);
        search.setFont(font1);
        c.add(search);

        dtailprint = new JButton("PRINT");
        dtailprint.setBounds(570, 580, 160, 50);
//        search.setVisible(true);
        dtailprint.setFont(font1);
        c.add(dtailprint);

        delet = new JButton("DELETE-ROW");
        delet.setBounds(400, 580, 160, 50);
//        search.setVisible(true);
        delet.setFont(font1);
        c.add(delet);

        go = new JButton("OK");
        go.setBounds(550, 200, 100, 30);
        go.setVisible(false);
        go.setFont(font1);
        c.add(go);

        back = new JButton("BACK");
        back.setBounds(400, 200, 100, 30);
        back.setVisible(false);
        back.setFont(font1);
        c.add(back);

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

        //add sell details  button listener
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });
        //add product view  button listener
        show2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show2ActionPerformed(evt);
            }
        });
        //add focus gaid listener
        mediname.addFocusListener(new FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mediname.removeAllItems();
                try {
                    //call the connection class
                            Connection conn = ConnectionClass.getconnect();
//                    Class.forName("oracle.jdbc.driver.OracleDriver");
//                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");
                    Statement st = conn.createStatement();
                    ResultSet reslt = st.executeQuery("select distinct medicn_name from PRODUCT order by medicn_name");
                    mediname.addItem("Select");
                    while (reslt.next()) {
                        String itm = reslt.getString(1);
                        mediname.addItem(itm);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex, "Error", 2);
                }

            }
        });
        //add focus lost listener
        meditable.addFocusListener(new FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (meditable.getSelectedIndex() == 1) {
                    sbcust.setVisible(false);
                    sbdate.setVisible(false);
                    sbdate2.setVisible(false);
                    datepic1.setVisible(false);
                    datepic2.setVisible(false);
                    sbgen.setVisible(true);
                    sbcom.setVisible(true);
                    sbshift.setVisible(true);
                    sbuse.setVisible(true);
                    shifttext.setVisible(true);
                    usetext.setVisible(true);
                    comdatetext.setVisible(true);
                } else if (meditable.getSelectedIndex() == 2) {
                    sbgen.setVisible(false);
                    sbcom.setVisible(false);
                    sbshift.setVisible(false);
                    sbuse.setVisible(false);
                    comdatetext.setVisible(false);
                    shifttext.setVisible(false);
                    usetext.setVisible(false);
                    sbcust.setVisible(true);
                    sbdate.setVisible(true);
                    sbdate2.setVisible(true);
                    datepic1.setVisible(true);
                    datepic2.setVisible(true);
                }

            }
        });
        //add ok search listener
        go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        //add back search listener
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label2.setVisible(false);
                sbtabl.setVisible(false);
                sbname.setVisible(false);
                sbcust.setVisible(false);
                sbgen.setVisible(false);
                sbcom.setVisible(false);
                sbquent.setVisible(false);
                sbshift.setVisible(false);
                sbuse.setVisible(false);
                sbdate.setVisible(false);
                meditable.setVisible(false);
                mediname.setVisible(false);
//                prof.setVisible(false);
                gencusttext.setVisible(false);
                comdatetext.setVisible(false);
                quenttext.setVisible(false);
                shifttext.setVisible(false);
                usetext.setVisible(false);
                sbdate2.setVisible(false);
                datepic1.setVisible(false);
                datepic2.setVisible(false);
                jscrol.setVisible(false);
                jscrol2.setVisible(false);
                go.setVisible(false);
                back.setVisible(false);
//                ndr1.setVisible(false);
//                ndr2.setVisible(false);
//                ndr3.setVisible(false);
//                ndr4.setVisible(false);
                show.setVisible(true);
                show2.setVisible(true);
                search.setVisible(true);
            }
        });
        //add  search listener
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label2.setVisible(true);
                sbtabl.setVisible(true);
                sbname.setVisible(true);

                sbgen.setVisible(true);
                sbcom.setVisible(true);
                sbquent.setVisible(true);
                sbshift.setVisible(true);
                sbuse.setVisible(true);
//                ndr1.setVisible(true);
//                ndr2.setVisible(true);
//                ndr3.setVisible(true);
//                ndr4.setVisible(true);

                meditable.setVisible(true);
                mediname.setVisible(true);
//                prof.setVisible(false);
                gencusttext.setVisible(true);
                comdatetext.setVisible(true);
                quenttext.setVisible(true);
                shifttext.setVisible(true);
                usetext.setVisible(true);
                go.setVisible(true);
                back.setVisible(true);
                sbcust.setVisible(false);
                sbdate.setVisible(false);
                show.setVisible(false);
                show2.setVisible(false);
                search.setVisible(false);
                jscrol.setVisible(false);
                jscrol2.setVisible(false);
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
        dtailprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    if (jscrol.isVisible() == true && tbl.getRowCount() > 0) {
                        tbl.print();
                    } else if (jscrol2.isVisible() == true && tbl2.getRowCount() > 0) {
                        tbl2.print();
                    } else {
                        JOptionPane.showMessageDialog(null, "Your Table or Data may not exist!", "Error", 2);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        });
        //create delete listener
        delet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (jscrol.isVisible() == true) {
                    int getRow = tbl.getSelectedRow();

                    try {
                        String tx1 = model.getValueAt(getRow, 0).toString();
                        String tx2 = model.getValueAt(getRow, 1).toString();
                        String tx3 = model.getValueAt(getRow, 2).toString();
                        float tx4 = Float.parseFloat(model.getValueAt(getRow, 3).toString());
//                    float tx5 = Float.parseFloat(model.getValueAt(getRow, 4).toString());
                        float tx6 = Float.parseFloat(model.getValueAt(getRow, 5).toString());
                        float tx7 = Float.parseFloat(model.getValueAt(getRow, 6).toString());
                        float tx8 = Float.parseFloat(model.getValueAt(getRow, 7).toString());
//                    float tx9 = Float.parseFloat(model.getValueAt(getRow, 8).toString());
//                    String tx6 = model.getValueAt(getRow, 5).toString();
//                    String tx7 = model.getValueAt(getRow, 6).toString();
//                    String tx8 = model.getValueAt(getRow, 7).toString();
                        String tx9 = model.getValueAt(getRow, 8).toString();
                        //call the connection class
                            Connection con = ConnectionClass.getconnect();
//                        Class.forName("oracle.jdbc.driver.OracleDriver");
//                        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");
                        Statement st = con.createStatement();
                        st.executeUpdate("delete from sell where CUSTOMER_ID='" + tx1 + "' and MEDICN_ID='" + tx2 + "' and MEDICN_NAME='" + tx3
                                + "' and QUENTITY=" + tx4 + " and UNIT_PRICE=" + tx6 + " and TOTAL=" + tx7 + " and PROFIT=" + tx8);

                        st.executeUpdate("update product set QUENTITY=QUENTITY+" + tx4 + " where MEDICN_ID='" + tx2 + "' and MEDICN_NAME='" + tx3 + "'");

                        con.close();
                        JOptionPane.showMessageDialog(null, "Selected item has been Deleted", "Success!", -1);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex, "Error!", 2);
                    }
                } else if (jscrol2.isVisible() == true) {
                    int getRow = tbl2.getSelectedRow();

                    String px1 = model2.getValueAt(getRow, 0).toString();
                    String px2 = model2.getValueAt(getRow, 1).toString();
                    String px3 = model2.getValueAt(getRow, 2).toString();
                    String px4 = model2.getValueAt(getRow, 3).toString();

                    float px5 = Float.parseFloat(model2.getValueAt(getRow, 4).toString());
                    float px6 = Float.parseFloat(model2.getValueAt(getRow, 5).toString());
                    String px7 = model2.getValueAt(getRow, 6).toString();
                    String px8 = model2.getValueAt(getRow, 7).toString();
//                    String tx7 = model.getValueAt(getRow, 6).toString();
//                    float tx7 = Float.parseFloat(model.getValueAt(getRow, 6).toString());
//                    float tx8 = Float.parseFloat(model.getValueAt(getRow, 7).toString());
//                    float tx9 = Float.parseFloat(model.getValueAt(getRow, 8).toString());
//                    String tx6 = model.getValueAt(getRow, 5).toString();
//                    String tx7 = model.getValueAt(getRow, 6).toString();
//                    String tx8 = model.getValueAt(getRow, 7).toString();
//                    String tx9 = model.getValueAt(getRow, 8).toString();

                    try {
                        //call the connection class
                            Connection conn = ConnectionClass.getconnect();
//                        Class.forName("oracle.jdbc.driver.OracleDriver");
//                        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");
                        Statement st = conn.createStatement();
                        st.executeUpdate("delete from product where MEDICN_ID='" + px1 + "' and MEDICN_NAME='" + px2 + "' and GENERIC_NAME='" + px3
                                + "' and COMPANY='" + px4 + "' and QUENTITY=" + px5 + " and UNIT_PRICE=" + px6 + " and SHELF_NO='" + px7 + "' and USES='" + px8 + "'");

                        conn.close();
                        JOptionPane.showMessageDialog(null, "Selected item has been Deleted", "Success!", -1);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex, "Error!", 2);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Table dos not Exist! ", "Requared!", 2);
                }
            }
        });

        //create color change listener
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Color color = JColorChooser.showDialog(null, "Choose a Color", Color.red);
                c.setBackground(color);
            }
        });

    }

    //create sell details method
    private void showActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        prof.setVisible(true);
        prof.setText("");
        jscrol2.setVisible(false);
        jscrol.setVisible(true);

        int rc = tbl.getRowCount();
        for (int i = 0; i < rc; i++) {
            model.removeRow(0);
        }

        try {
            //call the connection class
                            Connection conn = ConnectionClass.getconnect();
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");
            Statement st = conn.createStatement();
            String joinst = "SELECT S.CUSTOMER_ID, P.MEDICN_ID,P.MEDICN_NAME,S.QUENTITY,P.UNIT_PRICE,S.UNIT_PRICE,S.TOTAL,"
                    + "TRUNCATE( S.PROFIT,2),SELL_DATE FROM PRODUCT P LEFT JOIN SELL S ON P.MEDICN_ID=S.MEDICN_ID ORDER BY P.MEDICN_NAME";

            ResultSet product = st.executeQuery(joinst);

            while (product.next()) {
                String cidt = product.getString(1);
                String pidt = product.getString(2);
                String pnam = product.getString(3);
//        float productUnit= product.getFloat(4);
                float soldUnit = product.getFloat(4);
                float unnitPrice = product.getFloat(5);
                float sellPrice = product.getFloat(6);
                String totalt = product.getString(7);
                float profit = product.getFloat(8);
                Date date = product.getDate(9);

                //view result in table
                model = (DefaultTableModel) tbl.getModel();
                model.addRow(new Object[]{cidt, pidt, pnam, soldUnit, unnitPrice, sellPrice, totalt, profit, date});
            }
            ResultSet total = st.executeQuery("select TRUNCATE( SUM(PROFIT),2) FROM SELL");
            if (total.next()) {
                total.getString(1);
            }
            prof.setText("TOTAL-FROFIT = " + total.getString(1));
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Invalid!", 2);
        }
    }

    //create Product view method
    private void show2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        prof.setVisible(false);
        jscrol.setVisible(false);
        jscrol2.setVisible(true);
        int rc = tbl2.getRowCount();
        for (int i = 0; i < rc; i++) {
            model2.removeRow(0);
        }

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
                model2 = (DefaultTableModel) tbl2.getModel();
                model2.addRow(new Object[]{pidt, pnam, pgen, pcom, pquentity, purcseRate, shelf, use,});
            }
            ResultSet total = st.executeQuery("select TRUNCATE( SUM(PROFIT),2) FROM SELL");
            if (total.next()) {
                total.getString(1);
            }
            prof.setText("TOTAL-FROFIT = " + total.getString(1));
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Invalid!", 2);
        }
    }

    //create search ok method
    private void okActionPerformed(java.awt.event.ActionEvent evt) {

        // TODO add your handling code here:
//        String nr1=ndr1.getSelectedItem().toString();
//        String nr2=ndr2.getSelectedItem().toString();
//        String nr3=ndr3.getSelectedItem().toString();
//        String nr4=ndr4.getSelectedItem().toString();
        if (meditable.getSelectedIndex() < 1) {
            prof.setVisible(false);
            JOptionPane.showMessageDialog(null, "You can't select any Table", "Missing", 2);
        } else if (meditable.getSelectedIndex() == 1) {
            prof.setVisible(false);
            jscrol2.setVisible(true);
            jscrol.setVisible(false);

            int rc = tbl2.getRowCount();
            for (int i = 0; i < rc; i++) {
                model2.removeRow(0);
            }
            String medic = mediname.getSelectedItem().toString();

            String tablename = meditable.getSelectedItem().toString().toUpperCase();
            String gencust = gencusttext.getText().toUpperCase();
            String comdate = comdatetext.getText().toUpperCase();
            String quent = quenttext.getText().toUpperCase();
            if (quent.isEmpty() == true) {
                quent = "0";
            }
            

            try {
                float flotquent = Float.parseFloat(quent);
            String shift = shifttext.getText().toUpperCase();
            String Use = usetext.getText().toUpperCase();
                //call the connection class
                            Connection conn = ConnectionClass.getconnect();
//                Class.forName("oracle.jdbc.driver.OracleDriver");
//                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");
                Statement st = conn.createStatement();
                ResultSet reslt = st.executeQuery("select medicn_id, medicn_name,generic_name,company,quentity,unit_price,shelf_no,uses from " + tablename + " where medicn_name='"
                        + medic + "' OR generic_name='" + gencust + "' OR company='" + comdate + "' OR quentity=" + flotquent + " OR shelf_no='" + shift + "' or uses like '" + Use + "' order by medicn_name");
                while (reslt.next()) {

                    String srcid = reslt.getString(1);
                    String srcname = reslt.getString(2);
                    String srcgen = reslt.getString(3);
                    String srccom = reslt.getString(4);
                    float srcquentity = reslt.getFloat(5);
                    float srcPrice = reslt.getFloat(6);
//                float srcTotal = reslt.getFloat(7);
                    String srcshelf = reslt.getString(7);
                    String srcuse = reslt.getString(8);
//                System.out.println(srcid + "," + srcname + ", " + srcquentity + ", " + srcshelf + ", " + srcuse);
                    model2 = (DefaultTableModel) tbl2.getModel();
                    model2.addRow(new Object[]{srcid, srcname, srcgen, srccom, srcquentity, srcPrice, srcshelf, srcuse});

                }
                conn.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            prof.setVisible(true);
            prof.setText("");
            jscrol2.setVisible(false);
            jscrol.setVisible(true);

            int rc = tbl.getRowCount();
            for (int i = 0; i < rc; i++) {
                model.removeRow(0);
            }
            //formating date picker
            dcn = new SimpleDateFormat("yyyy-MM-dd");
            String d1;
            String d2;
            if (datepic1.getDate() == null) {
                d1 = "";
            } else {
                String date1 = dcn.format(datepic1.getDate());
                d1 = date1.toUpperCase();
            }
            if (datepic2.getDate() == null) {
                d2 = "";
            } else {
                String date2 = dcn.format(datepic2.getDate());
                d2 = date2.toUpperCase();
            }

            String medic = mediname.getSelectedItem().toString();

            String tablename = meditable.getSelectedItem().toString().toUpperCase();
            String gencust = gencusttext.getText().toUpperCase();

            String quent = quenttext.getText().toUpperCase();
            if (quent.isEmpty() == true) {
                quent = "0";
            }
            
//            String shift = shifttext.getText().toUpperCase();
//            String Use = usetext.getText().toUpperCase();

            try {
                float flotquent = Float.parseFloat(quent);
                //call the connection class
                            Connection conn = ConnectionClass.getconnect();
//                Class.forName("oracle.jdbc.driver.OracleDriver");
//                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_a", "2301");
                Statement st = conn.createStatement();
                ResultSet reslt = st.executeQuery("select customer_id, medicn_id, medicn_name,quentity,unit_price,total,profit,sell_date from " + tablename + " where medicn_name='"
                        + medic + "' or customer_id='" + gencust + "' or quentity=" + flotquent + " or sell_date='" + d1 + "' or sell_date BETWEEN '" + d1 + "' and '" + d2 + "' order by medicn_name");
                while (reslt.next()) {

                    String srccusid = reslt.getString(1);
                    String srcid = reslt.getString(2);
                    String srcname = reslt.getString(3);
                    float srcquentity = reslt.getFloat(4);
                    float srcPrice = reslt.getFloat(5);
                    float srctotal = reslt.getFloat(6);
                    float srcprofit = reslt.getFloat(7);
                    Date srcdate = reslt.getDate(8);

//                float srcTotal = reslt.getFloat(7);
                    String srcsold = "--";
//                    String srcuse = reslt.getString(8);
//                System.out.println(srcid + "," + srcname + ", " + srcquentity + ", " + srcshelf + ", " + srcuse);
                    model = (DefaultTableModel) tbl.getModel();
                    model.addRow(new Object[]{srccusid, srcid, srcname, srcquentity, srcsold, srcPrice, srctotal, srcprofit, srcdate});

                }
                ResultSet total1 = st.executeQuery("select TRUNCATE( SUM(PROFIT),2) FROM SELL  where  medicn_name='" + medic + "' or customer_id='"
                        + gencust + "' or quentity=" + flotquent + " or sell_date='" + d1 + "' or sell_date BETWEEN '" + d1 + "' and '" + d2 + "'");
                if (total1.next()) {
                    total1.getString(1);
                }
                prof.setText("SEARCH BY FROFIT = " + total1.getString(1));
                conn.close();
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null, ex);
            }

        }

//        Font font = new Font("Times new roman", Font.BOLD, 18);
//        prdt.setBounds(520, 0, 850, 400);
//        prdt.setVisible(true);
//        Container cn = prdt.getContentPane();
//        prdt.scroll2.setBounds(2, 30, 830, 250);
//
//        prdt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // CLEAN THE ALL TEXTFIELD
        meditable.setSelectedIndex(0);
        mediname.setSelectedIndex(0);
        gencusttext.setText("");
        comdatetext.setText("");
        quenttext.setText("");
        shifttext.setText("");
        usetext.setText("");
        datepic1.setCalendar(null);
        datepic2.setCalendar(null);
    }

    public static void main(String[] args) {
        DataDetails sd = new DataDetails();
        sd.setVisible(true);
    }
}
