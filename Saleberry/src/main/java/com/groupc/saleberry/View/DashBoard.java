/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.groupc.saleberry.View;

import com.groupc.saleberry.Database.MySqlConnection;
import com.groupc.saleberry.Model.RegisterModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author sabin
 */
public class DashBoard extends javax.swing.JFrame {
    Color defaultColor, clickedColor, green,same,white;
    DefaultTableModel model;
    public DashBoard() {
        initComponents();
        showPieChart();
        showLineChart();
        fetchDataFromDatabase();
        defaultColor = new Color (51,51,51);
        clickedColor = new Color(102,255,102);
        green = new Color(102,255,102);
        same = new Color(204,204,204);
        white = new Color(255,255,255);
    }
    
    public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      barDataset.setValue( "1" , Double.valueOf(20) );  
      barDataset.setValue( "SamSung Grand" , Double.valueOf(20) );   
      barDataset.setValue( "MotoG" , Double.valueOf(40) );    
      barDataset.setValue( "Nokia Lumia" , Double.valueOf(50) );  
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Top sales",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("1", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelBarChart.removeAll();
        panelBarChart.add(barChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();
        panelBarChart.repaint();
    }
     public void showLineChart(){
        //create dataset for the graph
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "january");
        dataset.setValue(150, "Amount", "february");
        dataset.setValue(18, "Amount", "march");
        dataset.setValue(100, "Amount", "april");
        dataset.setValue(80, "Amount", "may");
        dataset.setValue(250, "Amount", "june");
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("Contribution","Monthly","Amount", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204,0,51);
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        lineVariable.removeAll();
        lineVariable.add(lineChartPanel, BorderLayout.CENTER);
        lineVariable.validate();
    }
//     public void insertUserDataIntoTable(RegisterModel user) {
//    DefaultTableModel model = (DefaultTableModel) tableUser.getModel();
//    model.addRow(new Object[]{user.getUserId(), user.getFirst_name(),user.getLast_name(),user.getContact_no(),user.getPassword()});
//}
        private void fetchDataFromDatabase() {
            MySqlConnection mysqlconnection = new MySqlConnection();
            Connection conn = mysqlconnection.openConnection();
        if (conn != null) {
            String query = "SELECT user_id, password, first_name,last_name,contact_no FROM user";

            try (PreparedStatement pstmt = conn.prepareStatement(query);
                 ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    String userId = resultSet.getString("user_id");
                    String password = resultSet.getString("password");
                    String first = resultSet.getString("first_name");
                    String last = resultSet.getString("last_name");
                    String contact = resultSet.getString("contact_no");
                    Object [] obj ={userId,first,last,contact,password};
                    model = (DefaultTableModel) tableUser.getModel();
                    model.addRow(obj);
                }

            } catch (SQLException e) {
                e.printStackTrace(); // Log the exception in a production environment
            }
        } else {
            System.out.println("Provided database connection is null. Check your connection.");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pictureBox1 = new com.groupc.saleberry.custombutton.PictureBox();
        pictureBox2 = new com.groupc.saleberry.custombutton.PictureBox();
        jLabel3 = new javax.swing.JLabel();
        pictureBox4 = new com.groupc.saleberry.custombutton.PictureBox();
        pictureBox5 = new com.groupc.saleberry.custombutton.PictureBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pictureBox3 = new com.groupc.saleberry.custombutton.PictureBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        label1 = new javax.swing.JPanel();
        label1Tab = new javax.swing.JLabel();
        pictureBox6 = new com.groupc.saleberry.custombutton.PictureBox();
        label3 = new javax.swing.JPanel();
        label3Tab = new javax.swing.JLabel();
        pictureBox13 = new com.groupc.saleberry.custombutton.PictureBox();
        label2 = new javax.swing.JPanel();
        label2Tab = new javax.swing.JLabel();
        pictureBox9 = new com.groupc.saleberry.custombutton.PictureBox();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pictureBox8 = new com.groupc.saleberry.custombutton.PictureBox();
        jPanel14 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        pictureBox15 = new com.groupc.saleberry.custombutton.PictureBox();
        label4 = new javax.swing.JPanel();
        label4Tab = new javax.swing.JLabel();
        pictureBox7 = new com.groupc.saleberry.custombutton.PictureBox();
        label5 = new javax.swing.JPanel();
        label5Tab = new javax.swing.JLabel();
        pictureBox14 = new com.groupc.saleberry.custombutton.PictureBox();
        label6 = new javax.swing.JPanel();
        label6Tab = new javax.swing.JLabel();
        pictureBox16 = new com.groupc.saleberry.custombutton.PictureBox();
        jPanel16 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        pictureBox17 = new com.groupc.saleberry.custombutton.PictureBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tab1 = new javax.swing.JPanel();
        tab11 = new javax.swing.JPanel();
        m1 = new javax.swing.JLabel();
        tab2 = new javax.swing.JPanel();
        tab22 = new javax.swing.JPanel();
        m2 = new javax.swing.JLabel();
        tab3 = new javax.swing.JPanel();
        tab33 = new javax.swing.JPanel();
        m3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        tab4 = new javax.swing.JPanel();
        tab44 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        panelRound2 = new com.groupc.saleberry.custombutton.PanelRound();
        jLabel29 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        panelRound3 = new com.groupc.saleberry.custombutton.PanelRound();
        jLabel34 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        panelRound4 = new com.groupc.saleberry.custombutton.PanelRound();
        jLabel41 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        tab5 = new javax.swing.JPanel();
        tab55 = new javax.swing.JPanel();
        panelBarChart = new javax.swing.JPanel();
        lineVariable = new javax.swing.JPanel();
        tab6 = new javax.swing.JPanel();
        tab66 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SalesBerry");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 110, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" Hi Admin");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 40, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("|");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 40, 10, -1));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 50, 30));
        jPanel1.add(pictureBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 40, 30, 30));
        jPanel1.add(pictureBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 40, 30, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("|");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 40, 10, -1));
        jPanel1.add(pictureBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 30, 40, 40));
        jPanel1.add(pictureBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 40, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1640, 80));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 51));
        jLabel6.setText("   E-Billing");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 150, 40));
        jPanel3.add(pictureBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 40, 30));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 51));
        jLabel9.setText("E-Billing");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 150, 40));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 300, 70));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 300, 70));

        label1.setBackground(new java.awt.Color(51, 51, 51));
        label1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1Tab.setBackground(new java.awt.Color(51, 51, 51));
        label1Tab.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        label1Tab.setForeground(new java.awt.Color(204, 204, 204));
        label1Tab.setText("   Admin Dashboard");
        label1Tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label1TabMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label1TabMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                label1TabMouseReleased(evt);
            }
        });
        label1.add(label1Tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, 40));
        label1.add(pictureBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel2.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 300, 70));

        label3.setBackground(new java.awt.Color(51, 51, 51));
        label3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label3Tab.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        label3Tab.setForeground(new java.awt.Color(204, 204, 204));
        label3Tab.setText("   Inventory");
        label3Tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label3TabMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label3TabMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                label3TabMouseReleased(evt);
            }
        });
        label3.add(label3Tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, 40));
        label3.add(pictureBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel2.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 300, 70));

        label2.setBackground(new java.awt.Color(51, 51, 51));
        label2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label2Tab.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        label2Tab.setForeground(new java.awt.Color(204, 204, 204));
        label2Tab.setText("   Sell Details");
        label2Tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label2TabMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label2TabMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                label2TabMouseReleased(evt);
            }
        });
        label2.add(label2Tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, 40));
        label2.add(pictureBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel2.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 300, 70));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Features");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 130, 40));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("   Log Out");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, 40));
        jPanel5.add(pictureBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 40));

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("   Tables & Data");
        jPanel14.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, 40));
        jPanel14.add(pictureBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel5.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 300, 70));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 300, 70));

        label4.setBackground(new java.awt.Color(51, 51, 51));
        label4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label4Tab.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        label4Tab.setForeground(new java.awt.Color(204, 204, 204));
        label4Tab.setText("   Form");
        label4Tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label4TabMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label4TabMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                label4TabMouseReleased(evt);
            }
        });
        label4.add(label4Tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, 40));
        label4.add(pictureBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel2.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 300, 70));

        label5.setBackground(new java.awt.Color(51, 51, 51));
        label5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label5Tab.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        label5Tab.setForeground(new java.awt.Color(204, 204, 204));
        label5Tab.setText("   Charts");
        label5Tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label5TabMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label5TabMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                label5TabMouseReleased(evt);
            }
        });
        label5.add(label5Tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, 40));
        label5.add(pictureBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel2.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 300, 70));

        label6.setBackground(new java.awt.Color(51, 51, 51));
        label6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label6Tab.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        label6Tab.setForeground(new java.awt.Color(204, 204, 204));
        label6Tab.setText("   User Data");
        label6Tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label6TabMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label6TabMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                label6TabMouseReleased(evt);
            }
        });
        label6.add(label6Tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, 40));
        label6.add(pictureBox16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel16.setBackground(new java.awt.Color(51, 51, 51));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("   Tables & Data");
        jPanel16.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, 40));
        jPanel16.add(pictureBox17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        label6.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 300, 70));

        jPanel2.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 300, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 300, 770));

        tab1.setBackground(new java.awt.Color(255, 255, 255));
        tab1.setMinimumSize(new java.awt.Dimension(1340, 760));
        tab1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab11.setBackground(new java.awt.Color(102, 255, 102));
        tab11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        m1.setText("menu");
        tab11.add(m1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 40, 40));

        tab1.add(tab11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 760));

        jTabbedPane1.addTab("tab1", tab1);

        tab2.setBackground(new java.awt.Color(255, 102, 102));
        tab2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab22.setBackground(new java.awt.Color(255, 255, 153));
        tab22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        m2.setText("Menu 2");
        tab22.add(m2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        tab2.add(tab22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 760));

        jTabbedPane1.addTab("tab2", tab2);

        tab3.setBackground(new java.awt.Color(255, 255, 255));
        tab3.setMinimumSize(new java.awt.Dimension(1340, 760));
        tab3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab33.setBackground(new java.awt.Color(153, 255, 153));
        tab33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        m3.setBackground(new java.awt.Color(255, 255, 255));
        m3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        m3.setText("       Inventory Management");
        tab33.add(m3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 260, 50));

        jPanel4.setBackground(new java.awt.Color(153, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(20, 0, 0, 0, new java.awt.Color(0, 128, 128)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel24.setText("  3");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 50, 40));

        tab33.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 150, 160, 120));

        jPanel7.setBackground(new java.awt.Color(153, 255, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(20, 0, 0, 0, new java.awt.Color(0, 128, 128)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("No Of Products");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 110, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("No Of Products");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 110, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel7.setText("1500");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 80, 40));

        tab33.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 160, 120));

        jPanel8.setBackground(new java.awt.Color(153, 255, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(20, 0, 0, 0, new java.awt.Color(0, 128, 128)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel15.setText(" 15");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 50, 40));

        tab33.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 160, 120));

        jPanel9.setBackground(new java.awt.Color(153, 255, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(20, 0, 0, 0, new java.awt.Color(0, 128, 128)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel22.setText("  5");
        jPanel9.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 50, 40));

        tab33.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 160, 120));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText(" Fast Moving Products");
        tab33.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, 180, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("      No Of Products");
        tab33.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 160, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("     No Of Categories");
        tab33.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 150, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("         Out Of Stock");
        tab33.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 160, 30));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setText("                   Inventory Table");
        tab33.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 286, 330, 40));

        tab3.add(tab33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 760));

        jTabbedPane1.addTab("tab3", tab3);

        tab4.setMinimumSize(new java.awt.Dimension(1340, 760));
        tab4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab44.setBackground(new java.awt.Color(153, 255, 102));
        tab44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 102, 0));
        jLabel28.setText("UPDATE PRODUCTS");
        tab44.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 230, 40));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setText("Price");
        panelRound2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 110, 40));

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        panelRound2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 340, 40));

        jLabel30.setText("Catergory ID");
        panelRound2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 80, 40));

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });
        panelRound2.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 340, 40));

        jLabel31.setText("Catergory Name");
        panelRound2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 110, 40));

        jLabel32.setText("Product ID");
        panelRound2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 110, 40));

        jLabel33.setText("Product Name");
        panelRound2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 110, 40));

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        panelRound2.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 340, 40));

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        panelRound2.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 340, 40));

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        panelRound2.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 340, 40));

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelRound2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, -1, 40));

        tab44.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 410, 550));

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setText("Price");
        panelRound3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 110, 40));

        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        panelRound3.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 340, 40));

        jLabel35.setText("Catergory ID");
        panelRound3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 80, 40));

        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        panelRound3.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 340, 40));

        jLabel36.setText("Catergory Name");
        panelRound3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 110, 40));

        jLabel37.setText("Product ID");
        panelRound3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 110, 40));

        jLabel38.setText("Product Name");
        panelRound3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 110, 40));

        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        panelRound3.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 340, 40));

        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        panelRound3.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 340, 40));

        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        panelRound3.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 340, 40));

        jButton2.setBackground(new java.awt.Color(255, 102, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Update");
        panelRound3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 492, -1, 40));

        tab44.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 410, 560));

        panelRound4.setBackground(new java.awt.Color(255, 255, 255));
        panelRound4.setRoundBottomLeft(20);
        panelRound4.setRoundBottomRight(20);
        panelRound4.setRoundTopLeft(20);
        panelRound4.setRoundTopRight(20);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setText("Product ID");
        panelRound4.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 80, 30));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        panelRound4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 210, 40));

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelRound4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, 30));

        tab44.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 250, 190));

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 51, 51));
        jLabel39.setText("DELETE PRODUCTS");
        tab44.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 220, 40));

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 102, 102));
        jLabel40.setText("ADD PRODUCTS");
        tab44.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 210, 40));

        tab4.add(tab44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 760));

        jTabbedPane1.addTab("tab4", tab4);

        tab5.setMinimumSize(new java.awt.Dimension(1340, 760));
        tab5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab55.setBackground(new java.awt.Color(153, 255, 204));
        tab55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBarChart.setLayout(new java.awt.BorderLayout());
        tab55.add(panelBarChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 360, 280));

        lineVariable.setLayout(new java.awt.BorderLayout());
        tab55.add(lineVariable, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 340, 290));

        tab5.add(tab55, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 760));

        jTabbedPane1.addTab("tab5", tab5);

        tab6.setMinimumSize(new java.awt.Dimension(1340, 760));
        tab6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab66.setBackground(new java.awt.Color(102, 255, 102));
        tab66.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(153, 255, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(20, 0, 0, 0, new java.awt.Color(0, 128, 128)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel16.setText("         1000");
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 160, 30));

        tab66.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 160, 130));

        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "First Name", "Last Name", "Contact No", "Password"
            }
        ));
        tableUser.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableUser.setRowHeight(40);
        jScrollPane3.setViewportView(tableUser);

        tab66.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 820, 170));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("             Total User");
        tab66.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 160, 30));

        tab6.add(tab66, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 760));

        jTabbedPane1.addTab("tab6", tab6);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 1340, 800));

        setSize(new java.awt.Dimension(1652, 856));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void label1TabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1TabMouseClicked
        jTabbedPane1.setSelectedIndex(0);
        
        
    }//GEN-LAST:event_label1TabMouseClicked

    private void label2TabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2TabMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_label2TabMouseClicked

    private void label3TabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label3TabMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_label3TabMouseClicked

    private void label1TabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1TabMousePressed
          tab11.setBackground(clickedColor);
          label1.setBackground(green);
    }//GEN-LAST:event_label1TabMousePressed

    private void label1TabMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1TabMouseReleased
          label1.setBackground(defaultColor);
    }//GEN-LAST:event_label1TabMouseReleased

    private void label2TabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2TabMousePressed
        tab22.setBackground(clickedColor);
        label2.setBackground(green);
    }//GEN-LAST:event_label2TabMousePressed

    private void label2TabMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2TabMouseReleased
        label2.setBackground(defaultColor);
    }//GEN-LAST:event_label2TabMouseReleased

    private void label3TabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label3TabMousePressed
        tab33.setBackground(clickedColor);
        label3.setBackground(green);     
    }//GEN-LAST:event_label3TabMousePressed

    private void label3TabMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label3TabMouseReleased
        label3.setBackground(defaultColor);
    }//GEN-LAST:event_label3TabMouseReleased

    private void label4TabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label4TabMouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_label4TabMouseClicked

    private void label5TabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label5TabMouseClicked
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_label5TabMouseClicked

    private void label6TabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label6TabMouseClicked
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_label6TabMouseClicked

    private void label4TabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label4TabMousePressed
        tab44.setBackground(clickedColor);
        label4.setBackground(green);
    }//GEN-LAST:event_label4TabMousePressed

    private void label4TabMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label4TabMouseReleased
        label4.setBackground(defaultColor);
    }//GEN-LAST:event_label4TabMouseReleased

    private void label5TabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label5TabMousePressed
        tab55.setBackground(clickedColor);
        label5.setBackground(green);
    }//GEN-LAST:event_label5TabMousePressed

    private void label5TabMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label5TabMouseReleased
        label5.setBackground(defaultColor);
    }//GEN-LAST:event_label5TabMouseReleased

    private void label6TabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label6TabMousePressed
        tab66.setBackground(clickedColor);
        label6.setBackground(green);
    }//GEN-LAST:event_label6TabMousePressed

    private void label6TabMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label6TabMouseReleased
        label6.setBackground(defaultColor);
    }//GEN-LAST:event_label6TabMouseReleased

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        SignUpForm sign = new SignUpForm();
        sign.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
   int a=Integer.parseInt(jTextField7.getText());
   jTextField8.setText(String.valueOf(a));// TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyPressed

    /**
     * @param args the command line arguments
     */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel label1;
    private javax.swing.JLabel label1Tab;
    private javax.swing.JPanel label2;
    private javax.swing.JLabel label2Tab;
    private javax.swing.JPanel label3;
    private javax.swing.JLabel label3Tab;
    private javax.swing.JPanel label4;
    private javax.swing.JLabel label4Tab;
    private javax.swing.JPanel label5;
    private javax.swing.JLabel label5Tab;
    private javax.swing.JPanel label6;
    private javax.swing.JLabel label6Tab;
    private javax.swing.JPanel lineVariable;
    private javax.swing.JLabel m1;
    private javax.swing.JLabel m2;
    private javax.swing.JLabel m3;
    private javax.swing.JPanel panelBarChart;
    private com.groupc.saleberry.custombutton.PanelRound panelRound2;
    private com.groupc.saleberry.custombutton.PanelRound panelRound3;
    private com.groupc.saleberry.custombutton.PanelRound panelRound4;
    private com.groupc.saleberry.custombutton.PictureBox pictureBox1;
    private com.groupc.saleberry.custombutton.PictureBox pictureBox13;
    private com.groupc.saleberry.custombutton.PictureBox pictureBox14;
    private com.groupc.saleberry.custombutton.PictureBox pictureBox15;
    private com.groupc.saleberry.custombutton.PictureBox pictureBox16;
    private com.groupc.saleberry.custombutton.PictureBox pictureBox17;
    private com.groupc.saleberry.custombutton.PictureBox pictureBox2;
    private com.groupc.saleberry.custombutton.PictureBox pictureBox3;
    private com.groupc.saleberry.custombutton.PictureBox pictureBox4;
    private com.groupc.saleberry.custombutton.PictureBox pictureBox5;
    private com.groupc.saleberry.custombutton.PictureBox pictureBox6;
    private com.groupc.saleberry.custombutton.PictureBox pictureBox7;
    private com.groupc.saleberry.custombutton.PictureBox pictureBox8;
    private com.groupc.saleberry.custombutton.PictureBox pictureBox9;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab11;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab22;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab33;
    private javax.swing.JPanel tab4;
    private javax.swing.JPanel tab44;
    private javax.swing.JPanel tab5;
    private javax.swing.JPanel tab55;
    private javax.swing.JPanel tab6;
    private javax.swing.JPanel tab66;
    private javax.swing.JTable tableUser;
    // End of variables declaration//GEN-END:variables
}
