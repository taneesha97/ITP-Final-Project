/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.text.SimpleDateFormat;

/**
 *
 * @author Nirmith Akash
 * //Comment created for Git 
 */
public class Border extends javax.swing.JFrame {

    /**
     * Creates new form Border
     */
    public Border() {
        initComponents();
        date_time();
        //When starting the frame load the pannel
        LoginPanel h1 = new LoginPanel();
        LayeredPane1.removeAll();
        h1.setSize(LayeredPane1.getSize());
        LayeredPane1.add(h1);
        h1.setVisible(true);
        LayeredPane1.moveToFront(h1);
    }
    
    public static void changeFunction(String name){
        //If condition
        if (name.contentEquals("Kitchen")) {
            Home h1 = new Home();
            LayeredPane1.removeAll();
            h1.setSize(LayeredPane1.getSize());
            LayeredPane1.add(h1);
            h1.setVisible(true);
            LayeredPane1.moveToFront(h1);
            System.out.println("Triggered");
        } else if (name.contentEquals("Home")) {
            MainMenuPanel h1 = new MainMenuPanel();
            LayeredPane1.removeAll();
            h1.setSize(LayeredPane1.getSize());
            LayeredPane1.add(h1);
            h1.setVisible(true);
            LayeredPane1.moveToFront(h1);
        }else if (name.contentEquals("Reception")) {
            ReceptionPannel res1 = new ReceptionPannel();
            LayeredPane1.removeAll();
            res1.setSize(LayeredPane1.getSize());
            LayeredPane1.add(res1);
            res1.setVisible(true);
            LayeredPane1.moveToFront(res1);
        }else if (name.contentEquals("Room")) {
            RoomPanel r1 = new RoomPanel();
            LayeredPane1.removeAll();
            r1.setSize(LayeredPane1.getSize());
            LayeredPane1.add(r1);
            r1.setVisible(true);
            LayeredPane1.moveToFront(r1);
        } else if(name.contentEquals("KitchenService")){
            KitchenInterfacePanel ks = new KitchenInterfacePanel();
            LayeredPane1.removeAll();
            ks.setSize(LayeredPane1.getSize());
            LayeredPane1.add(ks);
            ks.setVisible(true);
            LayeredPane1.moveToFront(ks);
        }else if(name.contentEquals("Transaction")){
            TransactionHome th = new TransactionHome();
            LayeredPane1.removeAll();
            th.setSize(LayeredPane1.getSize());
            LayeredPane1.add(th);
            th.setVisible(true);
            LayeredPane1.moveToFront(th);
        }else if(name.contentEquals("Bar")){
            BarInterface th = new BarInterface();
            LayeredPane1.removeAll();
            th.setSize(LayeredPane1.getSize());
            LayeredPane1.add(th);
            th.setVisible(true);
            LayeredPane1.moveToFront(th);
        }else if(name.contentEquals("HR")){
            HRHomePanel th = new HRHomePanel();
            LayeredPane1.removeAll();
            th.setSize(LayeredPane1.getSize());
            LayeredPane1.add(th);
            th.setVisible(true);
            LayeredPane1.moveToFront(th);
        }else if(name.contentEquals("Vehicle")){
            //Tans' Home page Navigation.
            VehicleInforPanel th = new VehicleInforPanel();
            LayeredPane1.removeAll();
            th.setSize(LayeredPane1.getSize());
            LayeredPane1.add(th);
            th.setVisible(true);
            LayeredPane1.moveToFront(th);
        }else if(name.contentEquals("AddVehicle")){
            //Tans' Internal Page Navigation
            AddVehiclePanel th = new AddVehiclePanel();
            LayeredPane1.removeAll();
            th.setSize(LayeredPane1.getSize());
            LayeredPane1.add(th);
            th.setVisible(true);
            LayeredPane1.moveToFront(th);
        }else if (name.contentEquals("VehicleHome")){
            //Tans' Internal Page Navigation
            TMS_Home_Panel th = new TMS_Home_Panel();
            LayeredPane1.removeAll();
            th.setSize(LayeredPane1.getSize());
            LayeredPane1.add(th);
            th.setVisible(true);
            LayeredPane1.moveToFront(th);
        }else if(name.contentEquals("MainMenu")){
            MainMenuPanel h1 = new MainMenuPanel();
            LayeredPane1.removeAll();
            h1.setSize(LayeredPane1.getSize());
            LayeredPane1.add(h1);
            h1.setVisible(true);
            LayeredPane1.moveToFront(h1);
        }else if(name.contentEquals("Login")){
            LoginPanel h1 = new LoginPanel();
            LayeredPane1.removeAll();
            h1.setSize(LayeredPane1.getSize());
            LayeredPane1.add(h1);
            h1.setVisible(true);
            LayeredPane1.moveToFront(h1);
        }
        //Add other functions here 
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JPanel();
        day = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        seconds = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 768));

        back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        day.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        day.setForeground(new java.awt.Color(204, 204, 204));
        day.setText("Mon");
        back.add(day, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 0, 40, 20));

        date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setText("2019/10/30");
        back.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 40, 130, 20));

        seconds.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        seconds.setForeground(new java.awt.Color(255, 255, 255));
        seconds.setText("36");
        back.add(seconds, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 20, 20, 20));

        time.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText("12:14");
        back.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, 100, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hotel Management System By XX-XX-XX-XX");
        back.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 740, -1, -1));

        LayeredPane1.setMaximumSize(new java.awt.Dimension(1360, 590));
        LayeredPane1.setMinimumSize(new java.awt.Dimension(1360, 590));

        javax.swing.GroupLayout LayeredPane1Layout = new javax.swing.GroupLayout(LayeredPane1);
        LayeredPane1.setLayout(LayeredPane1Layout);
        LayeredPane1Layout.setHorizontalGroup(
            LayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1360, Short.MAX_VALUE)
        );
        LayeredPane1Layout.setVerticalGroup(
            LayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        back.add(LayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1360, 590));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Web1366–3.png"))); // NOI18N
        back.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Border.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Border.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Border.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Border.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Border().setVisible(true);
            }
        });
    }
    
        public void date_time() {

        SimpleDateFormat hh = new SimpleDateFormat("HH:mm");
        SimpleDateFormat ee = new SimpleDateFormat("EEE");
        SimpleDateFormat dd = new SimpleDateFormat("MMMMM dd,yyyy");
        SimpleDateFormat ss = new SimpleDateFormat("ss");

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    java.util.Date d = new java.util.Date();

                    time.setText(hh.format(d));
                    seconds.setText(ss.format(d));
                    date.setText(dd.format(d));
                    day.setText(ee.format(d));

                }

            }
        }).start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLayeredPane LayeredPane1;
    private javax.swing.JPanel back;
    private javax.swing.JLabel date;
    private javax.swing.JLabel day;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel seconds;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
