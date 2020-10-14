/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import ProjectDB.DbClass;
import static ProjectDB.DbClass.Database;
import static Table.TableModel.BarBillInvoice.BAR_COL3_1;
import static Table.TableModel.BarBillInvoice.BAR_COL3_2;
import static Table.TableModel.BarBillInvoice.BAR_COL3_3;
import static Table.TableModel.BarBillInvoice.BAR_COL3_4;
import static Table.TableModel.BarBillInvoice.BAR_COL3_5;
import static Table.TableModel.BarBillInvoice.BAR_COL3_6;
import static Table.TableModel.BarBillInvoice.BAR_COL3_7;
import static Table.TableModel.BarBillInvoice.BAR_COL3_8;
import static Table.TableModel.BarBillInvoice.BAR_COL3_9;
import static Table.TableModel.BarBillInvoice.BAR_Tb_N3;
import static Table.TableModel.BookingTable.Reception_TABLE_NAME_2;
import static Table.TableModel.BookingTable.*;
import static Table.TableModel.Facility.*;
import static Table.TableModel.Facility.room_facility_name;
import static Table.TableModel.Ingredienttable.COL2_2;
import static Table.TableModel.Ingredienttable.COL2_3;
import static Table.TableModel.Ingredienttable.TABLE3_NAME;
import static Table.TableModel.ItemIngredTable.COL4_1;
import static Table.TableModel.ItemIngredTable.COL4_2;
import static Table.TableModel.ItemIngredTable.COL4_3;
import static Table.TableModel.ItemIngredTable.COL4_4;
import static Table.TableModel.ItemIngredTable.TABLE5_NAME;
import static Table.TableModel.ItemIngredvtable.FROM1;
import static Table.TableModel.ItemIngredvtable.SELECT1;
import static Table.TableModel.ItemIngredvtable.WHERE1;
import static Table.TableModel.Itemtable.COL1_1;
import static Table.TableModel.Itemtable.COL1_2;
import static Table.TableModel.Itemtable.COL1_3;
import static Table.TableModel.Itemtable.TABLE2_NAME;
import static Table.TableModel.LiquorInventory.BAR_COL_1;
import static Table.TableModel.LiquorInventory.BAR_COL_2;
import static Table.TableModel.LiquorInventory.BAR_COL_3;
import static Table.TableModel.LiquorInventory.BAR_COL_4;
import static Table.TableModel.LiquorInventory.BAR_COL_5;
import static Table.TableModel.LiquorInventory.BAR_COL_6;
import static Table.TableModel.LiquorInventory.BAR_Tb_N1;
import static Table.TableModel.MenuItemTable.COL3_1;
import static Table.TableModel.MenuItemTable.COL3_2;
import static Table.TableModel.MenuItemTable.TABLE4_NAME;
import static Table.TableModel.MenuandItemvtable.FROM;
import static Table.TableModel.MenuandItemvtable.SELECT;
import static Table.TableModel.MenuandItemvtable.WHERE;

import static Table.TableModel.Menutable.TABLE_NAME;
import static Table.TableModel.Menutable.COL1;
import static Table.TableModel.Menutable.COL2;
import static Table.TableModel.Menutable.COL3;
import static Table.TableModel.OrderItemTable.COL6_2;
import static Table.TableModel.OrderItemTable.COL6_3;
import static Table.TableModel.OrderItemTable.TABLE7_NAME;
import static Table.TableModel.OrderTable.TABLE6_NAME;
import static Table.TableModel.Package.*;
import static Table.TableModel.Package.roompackage_name;
import static Table.TableModel.PackageFacilityTable.TABLE_PackageFacility;
import static Table.TableModel.PackageFacilityvTable.FROMNew;
import static Table.TableModel.PackageFacilityvTable.SELECTNEW;
import static Table.TableModel.PackageFacilityvTable.WHERENEW;
import Table.TableModel.Room;
import static Table.TableModel.Room.*;
import static Table.TableModel.RoomOtherRequest.*;
import static Table.TableModel.customerDetailsTable.Reception_TABLE_NAME;
import static Table.TableModel.customerDetailsTable.*;
import static Table.TableModel.customerPhoneDetailsTable.Reception_TABLE_NAME_1;
import static Table.TableModel.customerPhoneDetailsTable.*;
import static Table.TableModel.OrderItemTable.*;
import java.sql.Date;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Nirmith Akash
 */
public class DBHelper {
    //Variable 
   static  Connection con =  DbClass.Database();
    //Create method to Add data into the Database
    public static void addMenu(String name, int discount){
        name = " ' "+ name +" ' ";
       //SQL - Adding Menus to the Database
        String sql = "INSERT INTO  " + TABLE_NAME +  " ( " + COL2 +", " + COL3 +"  )  VALUES (  " + name + ",  "  + discount + " )" ;
        //Hard Coded For testing.
       // String sql = "insert into menu_table(menu_name,discount,amount,price) values ( 'simple',10,10,10)";
        //Execute the query.
        try{
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            
        } catch (SQLException e){
            e.printStackTrace();
        }      
    }
    
    //Create method to add item to the database
    public static void addItem(String name, double price){
        //Create SQL type String 
        name = " ' "+ name +" ' ";
        //SQL - Add Items to the Database.
        String sql = "INSERT INTO  " + TABLE2_NAME +  " ( " + COL1_2 +", " + COL1_3 +"  )  VALUES (  " + name  + ",  "  + price + " )" ;
        //Execute  Query
            try{
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    //Create a Method to store Ingredients
    public static void AddIngred(String name){
        //Formatting the String 
        name = " ' "+ name +" ' ";
        //SQL - Adding ingredients to the database
        String sql = "INSERT INTO  " + TABLE3_NAME +  " ( " + COL2_3 +"  )  VALUES (  " + name  + " )" ;
        //executing the query
         try{
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
        
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
  
    //Create a Method to select all the records from the menu table
  ResultSet rs;
    public  ResultSet SelectMenu()
    {
        try{
        String sql = "SELECT * FROM " + TABLE_NAME;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        //Add the rs to the table
        return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error Menu Item table");
        }
        return rs;
    }
    
    //Method to get all the items from the item table 
    public ResultSet SelectItem(){
        try{
            String sql = "SELECT * FROM "+ TABLE2_NAME;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e){
            System.out.println("Some thing wrong with reading tables - Internal error in Item table ");
        }
        return rs;
    }
    
    //Creating a method to get data from the ingred table 
    public ResultSet SelectIngred(){
        try{
            String sql = "SELECT * FROM "+ TABLE3_NAME;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e){
            System.out.println("Some thing wrong with reading tables - Internal error in Item table ");
        }
        return rs;
    }
    
    //Creating a method to display Menu->Item 
    public ResultSet SelectMenuItem(){
       //Query
       try{
           //String sql = "SELECT * FROM " +  TABLE4_NAME; //Replace this with a join query.
           String sql = "SELECT "+ SELECT  +
            " FROM " + FROM +
            " WHERE "+ WHERE;
           //Preparing.
           PreparedStatement ps =  con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           return rs;
       } catch (SQLException e){
           System.out.println("Some thing wrong with reading tables - Internal error in Menu -> Item table ");
       } 
       return rs;
    }
    
    //Add Menu -> Item to the Table 
    public static boolean AddMenuItem(String menu, String Item){
        //Attributes - Tempory
        int TMP_MENU_ID=0;
        int TMP_ITEM_ID=0;
       //Creating a Instance from the Current class
       DBHelper dbhelper = new DBHelper();
        //Finding the Id of each name
        ResultSet setMenu = dbhelper.SelectMenu();
        ResultSet setItem = dbhelper.SelectItem();
        try{
            //Looping - Menu Table
        while(setMenu.next()){
            if(setMenu.getString(COL2).equals(menu)){
                TMP_MENU_ID = Integer.parseInt( setMenu.getString(COL1));
            }
        }
        //Looping - Item Table
        while(setItem.next()){
            if(setItem.getString(COL1_2).equals(Item)){
                TMP_ITEM_ID = Integer.parseInt( setItem.getString(COL1_1));
            }
        }
        } catch (SQLException e) {
            System.out.println("Error in finding IDs");
        }
        //Validation 
        if(TMP_ITEM_ID == 0 || TMP_MENU_ID==0){
            System.out.println("Error IDs contains 0s");
        }

        //Query
        String sql = "INSERT INTO  " + TABLE4_NAME +  " ( " + COL3_1 +", " + COL3_2 +"  )  VALUES (  " + TMP_MENU_ID  + ",  "  + TMP_ITEM_ID + " )" ;
         //Executing the query
         try{
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    
    //Updating the Menu table 
    public static boolean UpdateMenuItem(int id, String name, int price){
        
        //String Formatting
        name = " ' "+ name +" ' ";
        //Creating the query 
        String sql = "UPDATE " + TABLE_NAME + " SET " +COL2 +" = " + name + " , " +
                COL3 + " = " + price + " WHERE " + COL1 + " = " + id;
        
        //Execute queries 
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    
    //Delete Menu Items 
    public static boolean deleteMenu(int number){
        
        //Creating the query
        String sql = "DELETE FROM " + TABLE_NAME +  " WHERE " +  COL1 + " = " + number;
        
        //Execute queries 
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    //Update Item table
    public static boolean updateItem(int number, String name, double price){
        //String formatting 
        name = " ' "+ name +" ' ";
        
        //Creating the query
        String sql = "UPDATE " + TABLE2_NAME + " SET " +COL1_2 +" = " + name + " , " +
                COL1_3 + " = " + price + " WHERE " + COL1_1 + " = " + number;
        
        //Excute the query.
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    
    //Delete item from the item table 
    public static boolean DeleteItem(int number){
        
        //Creating the query
        String sql = "DELETE FROM " + TABLE2_NAME + " WHERE " + COL1_1 + " = "+ number ;
        
        //Execute the query
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    //Cleaning Methods -----------------------------
    //Method to clean the Menu -> Item table
    public static boolean CleanMenuItem(int choice, int number){ //this method will not work if work bench is on safe delete mode
        if(choice == 0){
            
            //Cleaning the table when menu is deleted. 
            String sql = "DELETE FROM " + TABLE4_NAME + " WHERE " +COL3_1 + " = " + number;
            
            //Execute the query
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        
        } else if (choice == 1) {
            //Cleaning the table when item is deleted.
            String sql = "DELETE FROM " + TABLE4_NAME + " WHERE " +COL3_2 + " = " + number;
            
        //Execute the query
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        }
        return false;
    }
    
    //Method to clean the Item->Ingred table
    public static boolean cleanItemIngredtable(int choice, int number){
        if(choice == 0){
            
            //Cleaning the table when item is deleted. 
            String sql = "DELETE FROM " + TABLE5_NAME + " WHERE " +COL4_2 + " = " + number;
            
            //Execute the query
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        
        } else if (choice == 1) {
            //Cleaning the table when Ingred is deleted.
            String sql = "DELETE FROM " + TABLE5_NAME + " WHERE " +COL4_3 + " = " + number;
            
        //Execute the query
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        }
        return false;
    }
    
    
    //Create a Method to update Ingredients
    public static boolean UpdateIngred (String name, int number){
        //input formating 
        name = " ' "+ name +" ' ";
        
        //Create the query
        String sql = "UPDATE " + TABLE3_NAME + " SET " +COL2_3 +" = " + name 
                + " WHERE " + COL2_2 + " = " + number;
        
        //Excute the query.
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    
    //Creating a delete method for ingredients 
    public static boolean DeleteIngred(int number){
        //Creating the SQL
        String sql = "DELETE FROM " + TABLE3_NAME + " WHERE " +COL2_2 + " = " + number;
        
        //Executing the query
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    
    //Create a Method to Add Item -> Ingred.
    public static boolean AddItemIngred(String Itemname, String Ingredname, double amount){
        
        //Attributes - Tempory
        int TMP_INGRED_ID=0;
        int TMP_ITEM_ID=0;
        //Creating a Instance from the Current class
        DBHelper dbhelper = new DBHelper();
        //Finding the Id of each name
        ResultSet setIngred = dbhelper.SelectIngred();
        ResultSet setItem = dbhelper.SelectItem();
        
        //
        try{
            //Looping - Menu Table
        while(setIngred.next()){
            if(setIngred.getString(COL2_3).equals(Ingredname)){
                TMP_INGRED_ID = Integer.parseInt(setIngred.getString(COL2_2)); 
            } else {
                //System.out.println(Ingredname + " - ");
                //System.out.println(setIngred.getString(COL2_3));
            }
            //System.out.println("Ing_check");
        }
        //Looping - Item Table
        while(setItem.next()){
            if(setItem.getString(COL1_2).equals(Itemname)){
                TMP_ITEM_ID = Integer.parseInt(setItem.getString(COL1_1)); 
            } else {
                //System.out.println(Ingredname + " - ");
                //System.out.println(setItem.getString(COL1_2));
            }
            //System.out.println("Item_check");
        }
        } catch (SQLException e) {
            System.out.println("Error in finding IDs");
        }
        
        //Validation 
        if(TMP_ITEM_ID == 0 || TMP_INGRED_ID==0){
            System.out.println("Error IDs contains 0s");
        }
        
        //Query
        String sql = "INSERT INTO  " + TABLE5_NAME +  " ( " + COL4_2 +", " + COL4_3 + ", " + COL4_4 +"  )  "
                + "VALUES (  " + TMP_ITEM_ID  + ",  "  + TMP_INGRED_ID +  ",  "  + amount + " )" ;
        
        //Executing the query
         try{
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    
    //Select from the Item -> Ingred table
    public ResultSet selectItemIngred(){
        
        //Creating the Query
        try{
            
            String sql = "SELECT "+ SELECT1 + " FROM " + FROM1 + " WHERE " + WHERE1;
            //Preparing.
           PreparedStatement ps =  con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Someting is wrong with Item -> Ingred table");
        }
        return rs;   
    }  
    
    //Create an delete method to delete Item -> Ingred.
    public static boolean deleteItemIngred(int number){
        
        //Create a SQL query to delete the item 
        String sql = "DELETE FROM " + TABLE5_NAME + " WHERE " + COL4_1 +  " = " + number; 
        
        //Execute the query
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    
    //Select all the order details from the Order table 
    public ResultSet selectOrders(){
        
        try{
        //Creating the query
        String sql = "SELECT * FROM " + TABLE6_NAME;
        //Preparing.
           PreparedStatement ps =  con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           return rs;

        } catch (SQLException e ) {
            e.printStackTrace();
            System.out.println("Something is wrong with getting information from the Order Table");
        }
        return rs;  
    }
    
    //Add orders to  'Order Table'  --> Note Order Item Table
    public boolean insertOrder(String menu, int quan, String status, String descrip, String Date, int room, String user){
        //String Formatings
        menu = " '"+ menu + "' ";
        status = " '"+ status + "' ";
        descrip = " '"+ descrip + "' ";
        Date = " '"+ Date + "' ";
        user = " '"+ user + "' ";
        System.out.println("Date check 2" + Date);
       //SQL
       String sql = "INSERT INTO `itpfinaldb`.`order_table` (`menu name`, `quantity`, `status`, `description`, `date`, `employee_name`, `room_number`, `user_name`) "
               + "VALUES ( " + menu + " , " + quan + " , " + status + " , " + descrip + ", " + Date + " , 'Pending' , " + room + " , " + user + " )";
       
       //Execute 
       //Executing the query
         try{
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false; 
    }
    
    //Create a method to populate the Jlist in the Order handling page.
    DefaultListModel list_temp = new DefaultListModel();
    public DefaultListModel MenuItemSelect(String menu_name){
        
        //Creating the query
        try{
            //Testing code.
            String sql1 = "select i.item_name\n" +
            "from menu_food_table mf\n" +
            "INNER JOIN item_table i\n" +
            "ON i.id = mf.item_id\n" +
            "where mf.menu_id = " + menu_name; //change the code later 
            
            //menu_name = ""
  
            String sql = "select i.item_name, m.menu_name\n" +
            "from menu_food_table mf\n" +
            "INNER JOIN item_table i ON i.id = mf.item_id\n" +
            "INNER JOIN menu_table m ON m.menu_id = mf.menu_id\n" +
            "where REPLACE(m.menu_name,' ','') = REPLACE( '"+menu_name+"',' ','')";
            
            //Execute the query
            PreparedStatement ps =  con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            //Creating an Object from the DefaultListModel class
            DefaultListModel list = new DefaultListModel();
            
            //Running an while loop to get the output into an DefaultListModel 
            while(rs.next()){
                String name = rs.getString("item_name");
                list.addElement(name); 
            }
            
            //return the value
            return list;
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return list_temp;
  
    }
    
    //Method to write all the order details into the database
    public static boolean enterOrderDetails(int order, String item_name){
        //Varables
        int TMP_ITEM_ID = 0;
        
        //DBHelper instance
        DBHelper dbhelper = new DBHelper();
        
        //Get the relevent item number for the name
        ResultSet items = dbhelper.SelectItem();
        
        //Loop the resultSet
        try{
            while(items.next()){
                 if(items.getString(COL1_2).equals(item_name)){
                    TMP_ITEM_ID = Integer.parseInt(items.getString(COL1_1)); 
            } else {
                     System.out.println("Looping error in Order Item transaction");
                     System.out.println(items.getString(COL1_2));
                     System.out.println(item_name);
                 }
            }
            
        } catch (SQLException e){
            System.out.println("Error in finding the Item id in order_item transaction");
        }
        //Validating the ID
        if (TMP_ITEM_ID == 0){
            System.out.println("Item id is 0 in Order Item transaction");
            return false;
        }

        //Create a SQL query
        String sql = "INSERT INTO  " + TABLE7_NAME +  " ( " + COL6_2 +", " + COL6_3 + "  )  "
                + "VALUES (  " + order  + ",  "  + TMP_ITEM_ID +  " )" ; 
        
        //Executing the query
         try{
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    
    //Add a method to get Order details
    public ResultSet selectSimpleOrder(){
         try{
        //Creating the query
        String sql = "SELECT order_id, room_number, `menu name` as 'Menu', user_name, `date`\n" +
                        "FROM order_table\n" +
                        "WHERE order_id IN (select distinct order_id\n" +
"    from order_item_table)";
        //Preparing.
           PreparedStatement ps =  con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           return rs;

        } catch (SQLException e ) {
            e.printStackTrace();
            System.out.println("Something is wrong with getting information from the Order Table");
        }
        return rs; 
    }
    
    //Select Order Details 
    public ResultSet SelectOrderDetails(){
    
        try{
        
            //String sql = "SELECT c.roomcid, c.roomcustomer_name, b.roombid FROM " + "customer c " + " , "+ "booking b "  + " WHERE c.roomcid = b.roombooking_cID"; //Customer table and Booking table s
            //String sql = "select order_id,menu name,quantity,status,description,user_name,room_number\n" +
                         //"from order_table";
            String sql = "SELECT * FROM " + TABLE6_NAME ;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(SQLException e){
       
            System.out.println("Some thing wrong with reading table");
       }
       
       return rs;
    
    }
    
    //Select Customer Room Details
    public ResultSet SelectCustomerRoomDetails(){
        
        try{
        
            //String sql = "SELECT c.roomcid, c.roomcustomer_name, b.roombid FROM " + "customer c " + " , "+ "booking b "  + " WHERE c.roomcid = b.roombooking_cID"; //Customer table and Booking table s
            String sql = "select b.Assigned_Rooms, c.CID, c.CName\n" +
                         "from booking b, customer c \n" +
                         "where b.CID = c.CID";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(SQLException e){
       
            System.out.println("Some thing wrong with reading table");
       }
       
       return rs;
    }
    
    //User report genarate method - Individual report - Nirmith Akash Anawaratne
    public static void genReportUserOrder(int number) throws JRException{
        
        //Calling the method.

        JasperDesign jdesign = JRXmlLoader.load("src\\Reports\\Update_report.jrxml");
        
        //Testing ---- 

        //JasperDesign jdesign = JRXmlLoader.load("src\\Reports\\Update_report.jrxml");

        String query = "SELECT order_id, room_number, `menu name`, user_name, `date`\n" +
        "FROM order_table\n" +
        "WHERE order_id = " + number;
        
        JRDesignQuery updateQuery = new JRDesignQuery();
        updateQuery.setText(query);
        
        jdesign.setQuery(updateQuery);
        
        //Testing - Creating a Sample Dataset to insert
        String[] ars = {"'nimal','aamal','bimal'"};
        Integer[] ari = {1,2,3};
        
        //Testing --------

        //Passing the parameters to the jasper report
        HashMap map  = new HashMap();
        map.put("Order", number); 
        //map.put("ItemName", "Testing");
        //map.put("ItemPrice", 1.0);
        
        
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(jreport, map , con);
        JasperViewer.viewReport(jprint , false);  
    }
    
    //Report genarate - Monthly report 
    public static void genReportMonth(String year, String month) throws JRException{
        
        //Creating the String date
        String date = year+"-"+month+"-%";
        System.out.println();
        
        
        //Calling the method to open the report.
        JasperDesign jdesign = JRXmlLoader.load("src\\Reports\\Month_report.jrxml"); //Addthe file name correct one.
        
        //Creating a HashMap for pass the parameters 
        HashMap map = new HashMap();
        map.put("date", date);
        
        //Calling the Jasper viewer.
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(jreport, map , con);
        //JasperViewer jv = new JasperViewer(jprint, false);
        JasperViewer.viewReport(jprint, false);
        
        //There should be a validation, where if there no olders on that month then it shouldn't print the report
    }
    
    //Report Generating method
    public static void geneReportItemIngred(int order_id) throws JRException{
                //Calling the method.

        JasperDesign jdesign = JRXmlLoader.load("src\\Reports\\Item_Ingred.jrxml");

        //Passing the parameters to the jasper report
        HashMap map  = new HashMap();
        map.put("OrderId", order_id); 
        //map.put("ItemName", "Testing");
        //map.put("ItemPrice", 1.0);
        
        
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(jreport, map , con);
        JasperViewer.viewReport(jprint , false);
    }
    
    //Creating a another method to genarate the Ingred table.
    public void genarateIngredReport(){
        //Add the statements to genarate the report.
    }
    
    
    //Creating the method to Select all the employee names from HR 
    //employee name method
    public ResultSet selectEmployee(){
        try{
        //SQL
        String sql = "SELECT name from employee";
        
        //Preparing.
           PreparedStatement ps =  con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           return rs;

        } catch (SQLException e ) {
            e.printStackTrace();
            System.out.println("Something is wrong with getting information from the Employee table");
        }
        return rs;    
    }
    
    //Update employee status in HR management 
    public boolean UpdateEmployeeStatus(String name){
        name = " '"+ name + "' ";
        //Query
        String sql = "UPDATE `itpfinaldb`.`employee` SET `available` = 'yes' WHERE name = " + name;
        
        //Execute queries 
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    
    //Login validation.
    public boolean LoginValidation(String username, String password){
        boolean status = false;
        try {
            String sql = "SELECT * FROM employee";
            //Excuting the query
            PreparedStatement ps =  con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            //Search the resultSet
            while(rs.next()){
                System.out.println("Nice");
                String name = rs.getString("name");
                System.out.println(name);
                if((username.replaceAll("\\s+","").equalsIgnoreCase(name.replaceAll("\\s+","")))){
                    String passwordD =  rs.getString("password");
                    System.out.println(password);
                    if(passwordD.equals(password)){
                        System.out.println("Internal if working");
                        status = true;
                    } else {
                        System.out.println("Password wrong");
                        status = false;
                    }
                }
            }
            return status;
            
        } catch (SQLException e){
            e.printStackTrace();
        } 
        return status;
    }
    
    //Creating a method to delete the confirmed orders
    public void deletePlacedOrders(int order_number){
        String sql = "DELETE FROM " + TABLE7_NAME + " WHERE " + COL6_2 + " = " + order_number;
        
        try{
            PreparedStatement ps2 = con.prepareStatement(sql);
            ps2.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }   
    }
    
    //Method to Assign the employee to the order (Updating the name). - Update this Table.
    public boolean assignEmployee(String name, int number){
       String sql = "UPDATE `itpfinaldb`.`order_table` SET `employee_name` = '"+name+"' WHERE (`order_id` = '"+number+"');"; 
       
       //Execute queries 
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    
    
    //------------------------------------------------------Salitha DBHelper Methods ---------------------------------------------------------------------
    //Create method to Add customer details into the Database
        public static void addCustomerdetails(String name, String address, String passport , String nationality , String nic , String email){
       //String contatanation
       name = " ' "+ name +" ' ";
       address = " ' "+ address +" ' ";
       passport = " ' "+ passport +" ' ";
       nationality = " ' "+ nationality +" ' ";
       nic = " ' "+ nic +" ' ";
       email = " ' "+ email +" ' ";
       
        String sql = "INSERT INTO  " + Reception_TABLE_NAME +  " ( " + Reception_COL2 +", " + Reception_COL3 +"," + Reception_COL4 +"," + Reception_COL5 +"," + Reception_COL6 +"," + Reception_COL7 +"  )"
                + "  VALUES (  " + name + " ," + email + ",  "  + address + " ," + nationality  + "," + nic + ", " + passport + " )" ;
        
        try{
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            System.out.println("done");
            
        } catch (SQLException e){
            System.out.println("eeeee");
            e.printStackTrace();
        }      
    }

    

    
    //select method for customer details 
     public  ResultSet SelectCustomerCustomDetails()
    {
        try{
            //sql query
        String sql = "SELECT * FROM " + Reception_TABLE_NAME;
        //prepare statement for sql query
        PreparedStatement ps = con.prepareStatement(sql);
        //add resultset of reception table 
        ResultSet rs = ps.executeQuery();
        //return the resultset
        return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error Customer Details table");
        }
        return rs;
    }
    public static boolean UpdateCustomerDetails(int id, String name, String address, String passport , String nationality , String nic , String email){
        
        name = " ' "+ name +" ' ";
       address = " ' "+ address +" ' ";
       passport = " ' "+ passport +" ' ";
       nationality = " ' "+ nationality +" ' ";
       nic = " ' "+ nic +" ' ";
       email = " ' "+ email +" ' ";
        
        String sql = "UPDATE " + Reception_TABLE_NAME + " SET " +Reception_COL2 +" = " + name + " , " +
                Reception_COL3 + " = " + email+ ", " + Reception_COL4 + " = " + address + " , " + Reception_COL5 + " = " + nationality + " , " + Reception_COL6 + " = " + nic + ""
                + ", " + Reception_COL7 + " = " + passport + " WHERE " + Reception_COL1 + " = " + id;
        
        //Execute queries 
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    public static boolean deleteCustomerdetails(int id){
        
        //Creating the query
        String sql = "DELETE FROM " + Reception_TABLE_NAME +  " WHERE " +  Reception_COL1 + " = " + id;
        
        //Execute queries 
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
     public static boolean CleanPhoneIds(int choice, int id){ 
        if(choice == 0){
            
            //Cleaning the table when menu is deleted. 
            String sql = "DELETE FROM " + Reception_TABLE_NAME_1 + " WHERE " +Reception_COL1_1 + " = " + id;
            
            //Execute the query
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        
        }
        return false;
    }
     
    public static boolean addPhoneCustomerdetails(String customerID , String phone){
        String cus_ID = null;
       //Creating a Instance from the Current class
       DBHelper dbhelper = new DBHelper();
        //Finding the Id of each name
        ResultSet setMenu = dbhelper.SelectCustomerCustomDetails();
        try{
            //Looping - Menu Table
        while(setMenu.next()){
            if(setMenu.getString(Reception_COL1).equals(customerID)){
                cus_ID = setMenu.getString(Reception_COL1);
            }
        }
        } catch (SQLException e) {
            System.out.println("Error in finding IDs");
        }
        
        if(cus_ID== null){
            System.out.println("Error ID is null");
        }
        
        phone = " ' "+ phone +" ' ";
        String sql = "INSERT INTO  " + Reception_TABLE_NAME_1 +  " ( " + Reception_COL1_1 +", " + Reception_COL2_1 +")"
                + "  VALUES (  " + cus_ID + " ," + phone + ")" ;
        
         try{
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            System.out.println("done");
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("eeeee");
        } 
         return false;
         
    }  
    //select method for customer phone details
    public ResultSet SelectCustomerContactDetails(){
       
       try{
           //sql query
           String sql = "SELECT * FROM " + Reception_TABLE_NAME_1;
           //prepare statement for sql query
           PreparedStatement ps =  con.prepareStatement(sql);
           //execute
           ResultSet rs = ps.executeQuery();
           //return the resultset
           return rs;
       } catch (SQLException e){
           
           System.out.println("Some thing wrong with reading tables ");
       } 
       return rs;
    }
    //
    public static boolean UpdateCustomerPhoneDetails(String id, String phone , String pID){
        
        id = " ' "+ id +" ' ";
       phone = " ' "+ phone +" ' ";
       pID = " ' "+ pID +" ' ";
        String sql = "UPDATE " + Reception_TABLE_NAME_1 + " SET " +Reception_COL2_1 +" = " + phone + " WHERE " + Reception_COL3_1 + " = " + pID;
        
        //Execute queries 
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    public static boolean deleteCustomerPhonedetails(String pid){
        
        //Creating the query
        String sql = "DELETE FROM " + Reception_TABLE_NAME_1 +  " WHERE " +  Reception_COL3_1 + " = " + pid;
        
        //Execute queries 
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
 
    public static void addCustomerBookingdetails(String noOfDays, String AssignedRooms , String Packages , String VIP , String cusIdcombo2 , String dates){
       //SQL - Adding Menus to the Database
       noOfDays = " ' "+ noOfDays +" ' ";
       AssignedRooms = " ' "+ AssignedRooms +" ' ";
       Packages = " ' "+ Packages +" ' ";
       VIP = " ' "+ VIP +" ' ";
       cusIdcombo2 = " ' "+ cusIdcombo2 +" ' ";
       dates = " ' "+ dates +" ' ";
       System.out.println(dates);
       
        String sql = "INSERT INTO  " + Reception_TABLE_NAME_2 +  " ( " + Reception_COL2_2 +"," + Reception_COL3_2 +", " + Reception_COL4_2 +"," + Reception_COL5_2 +"," + Reception_COL6_2 +"," + Reception_COL7_2 +" )"
                + "  VALUES (  " + dates + " , " + noOfDays + " ,  "  + VIP + " ," + AssignedRooms + "," + cusIdcombo2 + ", " + Packages + " )" ;
        
        try{
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();

            
        } catch (SQLException e){

            e.printStackTrace();
        }      
    }
    ResultSet rsbooking;
     public  ResultSet SelectCustomerBookingDetails()
    {
        try{
        String sql = "SELECT * FROM " + Reception_TABLE_NAME_2;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rsbooking = ps.executeQuery();
        //Add the rs to the table
        return rsbooking;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error Customer Booking Details table");
        }
        return rsbooking;
    }
    public static boolean UpdateBookingDetails(int id, String days, String rooms, String packages, String VIP, String customID) {
        days = " ' "+ days +" ' ";
       rooms = " ' "+ rooms +" ' ";
       packages = " ' "+ packages +" ' ";
       VIP = " ' "+ VIP +" ' ";
       customID = " ' "+ customID +" ' ";
        
        String sql = "UPDATE " + Reception_TABLE_NAME_2 + " SET " +Reception_COL3_2 +" = " + days + " , " +
                Reception_COL4_2 + " = " + VIP+ ", " + Reception_COL5_2 + " = " + rooms + " , " + Reception_COL6_2 + " = " + customID + " , " + Reception_COL7_2 + " = " + packages +  " WHERE " + Reception_COL1_2 + " = " + id;
        
        //Execute queries 
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    public static boolean deleteBookingdetails(int id) {
         //Creating the query
        String sql = "DELETE FROM " + Reception_TABLE_NAME_2 +  " WHERE " +  Reception_COL1_2 + " = " + id;
        
        //Execute queries 
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    //Temporary method from Room management - Salithas version
     public  ResultSet SelectPackageDetails()
    {
        try{
        String sql = "SELECT * FROM " + TABLE_Package;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        //Add the rs to the table
        return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error Package Details table");
        }
        return rs;
    }
      public  ResultSet SelectPackageDetailsforReception()
    {
        try{
        String sql = "SELECT * FROM " + TABLE_Package;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        //Add the rs to the table
        return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error Package Details table");
        }
        return rs;
    }
    
    //Room Management - Select room details method - Temporary method. - Sallithas version.
    public  ResultSet SelectRoomDetails()
    {
        try{
        String sql = "SELECT " + rid + " , " + room_type + " , " + floor_no + " , " + room_category + " , " + room_status + " , " + room_package + " , " + room_description + " FROM " + TABLE_Room;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        //Add the rs to the table
        return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error Room Details table");
        }
        return rs;
    }
    public static void genReportCustomerDetails(String id) throws JRException{
        
        //Calling the method.
        //C:\Users\salitha\Documents\NetBeansProjects\ITPITP-Final-Project-Version3\ITP-Final-Project\src\\Reports\\Customer.jrxml

        JasperDesign jdesign = JRXmlLoader.load("src\\Reports\\Customer.jrxml");//essential
        HashMap map  = new HashMap();//only need when parameter passing 
        map.put("CUSTOMERID", id); //only need when parameter passing 
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);//essential
        JasperPrint jprint = JasperFillManager.fillReport(jreport, map , con);//if parameter is not passing map -- null
        JasperViewer.viewReport(jprint , false);//  enssential
    }
    public static void genReportCustomerPhoneDetails(String id) throws JRException{
        
        //Calling the method.
        //C:\Users\salitha\Documents\NetBeansProjects\ITPITP-Final-Project-Version3\ITP-Final-Project\src\Reports\customPhone.jrxml

        JasperDesign jdesign = JRXmlLoader.load("src\\Reports\\customPhone.jrxml");
        HashMap map  = new HashMap();
        map.put("CUSTOMERID", id); 
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(jreport, map , con);
        JasperViewer.viewReport(jprint , false);  
    }
    public static void generateBookingMonthlyReport(String Year, String Month) throws JRException{
        
         //To change body of generated methods, choose Tools | Templates.
         String date = Year+"-"+Month+"-%";
        System.out.println(date);
        
        
        //Calling the method to open the report.
        //C:\Users\salitha\Documents\NetBeansProjects\ITPITP-Final-Project-Version3\ITP-Final-Project\src\Reports\DailyBookingReport.jrxml
       JasperDesign jdesign = JRXmlLoader.load("src\\Reports\\DailyBookingReport.jrxml"); 
        
        //Creating a HashMap for pass the parameters 
        HashMap map = new HashMap();
        map.put("Date", date);
        
        //Calling the Jasper viewer.
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(jreport, map , con);
        JasperViewer.viewReport(jprint, false);
    }
    public static void generateBookingDailyReport(String date) throws JRException{
        
         //To change body of generated methods, choose Tools | Templates.
         
        System.out.println(date);
        
        
        //Calling the method to open the report.
        //C:\Users\salitha\Documents\NetBeansProjects\ITPITP-Final-Project-Version3\ITP-Final-Project\src\Reports\DailyBookingReport.jrxml
       JasperDesign jdesign = JRXmlLoader.load("src\\Reports\\DailyBookingReport.jrxml"); 
        
        //Creating a HashMap for pass the parameters 
        HashMap map = new HashMap();
        map.put("Date", date);
        
        //Calling the Jasper viewer.
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(jreport, map , con);
        JasperViewer.viewReport(jprint, false);
    }
    
    //----------------------------------------Taneesha ----------------------------------------------------
     public static void addRoom(String type,int floor_no,String category,String status,String package_name,String phone_no,int max_adults,int max_childrens,String des){
         //Create SQL type String
         type = " ' "+ type +" ' ";
         category = " ' "+ category +" ' ";
         status = " ' "+ status +" ' ";
         package_name = " ' "+ package_name +" ' ";
         phone_no = " ' "+ phone_no +" ' ";
      
         des = " ' "+ des +" ' ";
         
         //SQL - Adding room details to the Database
        String sql = "INSERT INTO  " + TABLE_Room +  " ( " + room_type +", " + Room.floor_no +" , " + Room.room_category +", " + room_status +", " + room_package +", " + room_phoneno +" , " + room_adults +", " + room_childrens +", " + room_description +")  VALUES (  " + type + ",  "  + floor_no + ",  "  + category + ",  "  + status + ",  "  + package_name + ",  "  + phone_no + ",  "  + max_adults + ",  "  + max_childrens + ",  "  + des + " )" ;
       //String sql = "insert into room (Type,Floor_No,Category,Status,Package_name,Phone_No,Max_Adults,MaxChildren,Description) values('er',2,'lkj','uyui','hjk','op',4,7,'kjhkj')";
       
        //Execute the query.
        try{
            PreparedStatement Pstate = con.prepareStatement(sql);
            boolean status1 = Pstate.execute();
            if (status1 == true){
                System.out.println("Inserted");
            }
            Pstate.close();
            
        } catch (SQLException e){
            e.printStackTrace();
        }      
        
    }
    
     //Add package
    public static void addPackage(String name,double price,double discount){
        //Create SQL type String 
        name = " ' "+ name +" ' ";
    
         //SQL - Add package details to the Database.
        String sql = "INSERT INTO  " + TABLE_Package +  " ( " + roompackage_name +", " + package_price +", " + package_dis +" )  VALUES (  " + name  + ",  "  + price +"," + discount + " )" ;
        
        //Execute  Query
            try{
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
              
    }
    
    public static void addFacility(String name){
        //Create SQL type String 
        name = " ' "+ name +" ' ";
    
         //SQL - Add package details to the Database.
        String sql = "INSERT INTO  " + TABLE_Facility +  " ( " + room_facility_name +" )  VALUES (  " + name  + " )" ;
        
        //Execute  Query
            try{
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
            
        
    }
    
    
    public static void addInventoryRequest(String name,int quantity,double amount,String date,int customerID){
        //Create SQL type String 
        name = " ' "+ name +" ' ";
        date = " ' "+ date +" ' ";
        
        //SQL - Add package details to the Database.
        String sql = "INSERT INTO  " + TABLE_OtherRequest +  " ( " + roominventory_item +", " + inventory_item_quantity +", " + inventory_item_amount +", " + requested_date +", " + room_cutID +")  VALUES (  " + name  + ",  "  + quantity +", " + amount + ", " + date + " , " + customerID + ")" ;
        
        //Execute  Query
            try{
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    
    //Add package facility to the table
    public static boolean addPackageFacility(String packageName,String facility){
    
        //Attributes 
        int temp_package_id = 0;
        int temp_facility_id = 0;
        
        //Creating a Instance from the Current class
       DBHelper dbhelper = new DBHelper();
       
       //find the id of each name
       ResultSet setPackage = dbhelper.SelectPackage();
       ResultSet setFacility = dbhelper.SelectFacility();
       
       try{
            //Looping - Package Table
        while(setPackage.next()){
            if(setPackage.getString(roompackage_name).equals(packageName)){
                temp_package_id = Integer.parseInt(setPackage.getString(pid));
            }
        }
        //Looping - Facility Table
        while(setFacility.next()){
            if(setFacility.getString(room_facility_name).equals(facility)){
                temp_facility_id = Integer.parseInt(setFacility.getString(fid));
            }
        }
       }catch(SQLException e) {
            System.out.println("Error in finding IDs");
        }
    
       //validation
       if(temp_package_id == 0 || temp_facility_id == 0){
          System.out.println("Error IDs contains 0s"); 
       }
       
       //Query
        String sql = " INSERT INTO  " + TABLE_PackageFacility +  " ( " + pid +" , " + fid +"  )  VALUES (  " + temp_package_id  + " ,  "  + temp_facility_id + " )" ;
        
       //Executing the query
         try{
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false; 
    
    }
    
    
    //--------------------Create a Method to select all the records from the tables------------------------------
     //ResultSet rs;
    public  ResultSet SelectRoom()
    {
        try{
        String sql = "SELECT * FROM " + TABLE_Room;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        //Add the rs to the table
        return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal Room table");
        }
        return rs;
    }
    
    //method to select all the package details in package table
    public  ResultSet SelectPackage()
    {
        try{
        String sql = "SELECT * FROM " + TABLE_Package;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        //Add the rs to the table
        return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error package table");
        }
        return rs;
    }
    
    //method to select all the facilities details in facility table
    public ResultSet SelectFacility()
    {
        try{
        String sql = "SELECT * FROM " + TABLE_Facility;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        //Add the rs to the table
        return rs;
        
        }catch(SQLException e){
            System.out.println("Some thing wrong with reading tables - Internal error Facility table");
        }
        return rs;
    }
    
    //method to select all the inventory request details in Inventory requestable table
    public ResultSet SelectInventoryRequest()
    {
        try{
        String sql = "SELECT * FROM " + TABLE_OtherRequest;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        //Add the rs to the table
        return rs;
        
        }catch(SQLException e){
            System.out.println("Some thing wrong with reading tables - Internal error Inventory request table");
        }
        return rs;
    }
   
    //method to select all the customer and booking datas
    public ResultSet SelectCustomerCustom1Details(){  //Refactor the name of the method -> Should be CustomerBooking
   
       try{
        
            //String sql = "SELECT c.roomcid, c.roomcustomer_name, b.roombid FROM " + "customer c " + " , "+ "booking b "  + " WHERE c.roomcid = b.roombooking_cID"; //Customer table and Booking table s
            String sql = "select b.BID, c.CID, c.CName\n" +
"from booking b, customer c \n" +
"where b.CID = c.CID ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(SQLException e){
       
            System.out.println("Some thing wrong with reading table");
       }
       
       return rs;
   }
    
    //Read Customer Details for Room Management Requirement 
    //method to select all the customer and booking datas
    public ResultSet SelectCustomerDetails(){
   
       try{
        
            //Creating the query 
            String sql = "select b.BID, c.CID, c.CName\n" +
                         "from booking b, customer c \n" +
                         "where b.CID = c.CID ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(SQLException e){
       
            System.out.println("Some thing wrong with reading table");
       }
       
       return rs;
   }
    
    
     //Creating a method to display Package->Facility 
    public ResultSet SelectPackageFacility(){
       //Query
       try{
           //String sql = "SELECT * FROM " +  TABLE4_NAME; //Replace this with a join query.
           String sql = "SELECT "+ SELECTNEW  +
            " FROM " + FROMNew +
            " WHERE "+ WHERENEW;
           //Preparing.
           //Execute queries 
           PreparedStatement ps =  con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           return rs;
       } catch (SQLException e){
           System.out.println("Some thing wrong with reading tables - Internal error in Package -> Facility table ");
       } 
       return rs;
    }
    
    
    //--------------------------Update all tables-------------------------
    //Updating the faclity table 
    public static boolean updateFacilityTable(int id,String name){
        
        //Create SQL type String
        name = " ' "+ name +" ' ";
        //Creating the query 
        String sql = "UPDATE " + TABLE_Facility + " SET " + room_facility_name +" = " + name + " WHERE " + fid + " = " + id;
        
        //Execute queries 
         try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    
    //updating the package table
    public static boolean updatePackageTable(int id,String name,double price,double discount){
        //String Formatting
        name = " ' "+ name +" ' ";
    
        //creating the query
        String sql = "UPDATE " + TABLE_Package + " SET " + roompackage_name + " = " + name + " , " +
                    package_price + " = " + price + " , " +
                    package_dis + " = " + discount + " WHERE " + pid + " = " + id;
        
        //Execute queries 
         try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
        
    }
    
    //updating the Room table
    public static boolean updateRoomDetails(int id, String type,int floorno,String category,String status,String package_name,String phone_no,int maxAdults,int maxChildrens,String des){
        
        //Create SQL type String
         type = " ' "+ type +" ' ";
         category = " ' "+ category +" ' ";
         status = " ' "+ status +" ' ";
         package_name = " ' "+ package_name +" ' ";
         phone_no = " ' "+ phone_no +" ' ";
         des = " ' "+ des +" ' ";
         
        //Creating the query 
        String sql = "UPDATE " + TABLE_Room + " SET " +
                     room_type +" = " + type + " , " +
                     floor_no + " = " + floorno + " , " +
                     room_category + " = " + category + " , " +
                     room_status + " = " + status + " , " +
                     room_package + " = " + package_name + " , " +
                     room_phoneno + " = " + phone_no + " , " +
                     room_adults + " = " + maxAdults + " , " +
                     room_childrens + " = " + maxChildrens + " , " +
                     room_description + " = " + des + " WHERE " + rid + " = " + id;
        
        //Execute queries 
         try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    
    //----------------------------DELETE TABLE ROWS------------------------------------------------
    
    //delete facility table
    
    public static boolean deleteFacilityDetails(int id,String name){
    
         //Create SQL type String
        name = " ' "+ name +" ' ";
        
        //creating query
        String sql = " DELETE FROM " + TABLE_Facility + " WHERE " + fid + " = " + id; 
        
        //Execute queries 
         try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    
    }
    
    //delete room details
    
    public static boolean deleteRoomDetails(int id, String type,int floorno,String category,String status,String package_name,String phone_no,int maxAdults,int maxChildrens,String des){
    
        //Create SQL type String
         type = " ' "+ type +" ' ";
         category = " ' "+ category +" ' ";
         status = " ' "+ status +" ' ";
         package_name = " ' "+ package_name +" ' ";
         phone_no = " ' "+ phone_no +" ' ";
         des = " ' "+ des +" ' ";
         
         //creating query
         String sql = " DELETE FROM " + TABLE_Room + " WHERE " + rid + " = " + id; 
         //Execute queries 
         try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    
    
    //delete package details
    public static boolean deletePackageDetails(int id,String name,double price,double discount){
    
        //Create SQL type String
        name = " ' "+ name +" ' ";
        
        //creating query
         String sql = " DELETE FROM " + TABLE_Package + " WHERE " + pid + " = " + id; 
        //Execute queries 
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    
  
    }
    
    //-------------------------------ROOM Reports---------------------------------------
    
    //PACKAGE REPORT
   public static void genaratePackageReport()throws JRException{
        //set location 
        JasperDesign jdesign = JRXmlLoader.load("src\\Reports\\RoomManagment\\packageNewVersion_A4.jrxml");
        //calling the jasper Viewer
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(jreport, null , con);
        //view report and when click clase not prevent close the pannel
        JasperViewer.viewReport(jprint,false);
        
   }
    
   //ROOM REPORT
    public static void genarateRoomReport() throws JRException{
        //set location 
        JasperDesign jdesign = JRXmlLoader.load("src\\Reports\\RoomManagment\\RoomNewVersion.jrxml");
        //calling the jasper Viewer
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(jreport, null , con);
        //view report and when click clase not prevent close the pannel
        JasperViewer.viewReport(jprint, false);
    
    }
    
    //INVENTORY REPORT
    public static void genarateInventoryRequestReport(String id) throws JRException{
       /* JasperDesign jdesign = JRXmlLoader.load("src\\Reports\\RoomManagment\\RoomInventory.jrxml");
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(jreport, null , con);
        JasperViewer.viewReport(jprint);*/
       
       //set location 
       JasperDesign jdesign = JRXmlLoader.load("src\\Reports\\RoomManagment\\newIRequest_A4.jrxml");
       //Passing the parameters to the jasper report
       HashMap map  = new HashMap();
       map.put("ID", id); 
       //calling the jasper Viewer
       JasperReport jreport = JasperCompileManager.compileReport(jdesign);
       JasperPrint jprint = JasperFillManager.fillReport(jreport, map , con);
       //view report and when click clase not prevent close the pannel
       JasperViewer.viewReport(jprint , false);
       
    }
    
    
    //Tharini 
        public static void iud(String sql) throws Exception {
        if (con == null) {
            Database();
        }
        con.createStatement().executeUpdate(sql);
    }

    public static ResultSet search(String sql) throws Exception {
        if (con == null) {
            Database();
        }
        return con.createStatement().executeQuery(sql);
    }
    
    
    //Chamidu
    public static boolean addEmployee(String name, String eid, java.sql.Date DOB, String address, String email, String nic, String password, String gender, String jobtitel, String license, String phone,String available){
        
        name = " '"+ name +"' ";
        eid = " '"+ eid +"' ";
        address = " '"+ address +"' ";
        email = " '"+ email +"' ";
        nic = " '"+ nic +"' ";
        password = " '"+ password +"' ";
        gender = " '"+ gender +"' ";
        jobtitel = " '"+ jobtitel +"' ";
        license = " '"+ license +"' ";
        phone = " '"+ phone +"' ";
        available = " '"+ available +"' ";
        
        String sql = "INSERT INTO employee (eid ,name,dob,address,email,nic,gender,jobtitel,licenseno,password,phone,available) VALUES ("+eid+","+name+",'"+DOB+"',"+address+","+email+","+nic+","+gender+","+jobtitel+","+license+","+password+","+phone+","+available+")";
        
        try{     
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    } 

   public static boolean updateEmployee(String name, String eid, java.sql.Date DOB, String address, String email, String nic, String password, String gender, String jobtitel, String license, String phone){
        name = " '"+ name +"' ";
        eid = " '"+ eid +"' ";
        address = " '"+ address +"' ";
        email = " '"+ email +"' ";
        nic = " '"+ nic +"' ";
        password = " '"+ password +"' ";
        gender = " '"+ gender +"' ";
        jobtitel = " '"+ jobtitel +"' ";
        license = " '"+ license +"' ";
        phone = " '"+ phone +"' ";
       
       String sql = "UPDATE employee SET name =" +name+",dob ='"+DOB+"', address ="+address+", email ="+email+", nic="+nic+", password ="+password+", gender ="+gender+", jobtitel ="+jobtitel+", licenseno ="+license+", phone ="+phone+" WHERE eid ="+eid;
   
       try{     
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
   }

   public  static boolean deleteEmployee(String eid){
       
       eid = " '"+ eid +"' ";
       String sql = "DELETE FROM employee WHERE eid ="+ eid;
       
       try{     
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
   }

    public static boolean addSalary(String eid, Double basicsalary, Double otrate, Double othours, String year, String month, Double netsalary) {
       
      boolean sts = false;
        
      eid = " '"+ eid +"' ";
      year = " '"+ year +"' ";
      month = " '"+ month +"' ";
      String sql = "INSERT INTO salary (eid,basicsalary,otrate,othours,year,month,netsalary) VALUES ("+eid+","+basicsalary+","+otrate+","+othours+","+year+","+month+","+netsalary+")";
            
      try{     
            PreparedStatement Pstate = con.prepareStatement(sql);
            sts = Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return sts;
    }

    public static boolean updateSalary(String eid, Double basicsalary, Double otrate, Double othours, String year, String month, Double netsalary) {
        
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      String Eid=eid;
      String Year=year;
      String Month=month;

       eid = " '"+ eid +"' ";
      year = " '"+ year +"' ";
      month = " '"+ month +"' ";
      
      System.out.println(eid);
      System.out.println(month);
      System.out.println(year);
      try{
      String SQL = "SELECT * FROM salary";
        PreparedStatement ps = con.prepareStatement(SQL);
         ResultSet  rs = ps.executeQuery();
         String EID;
         String YEAR;
         String MONTH;
         
         while(rs.next()){
             
             EID=rs.getString("eid");
             YEAR=rs.getString("year");
             MONTH=rs.getString("month");
             
         System.out.println(EID);
      System.out.println(MONTH);
      System.out.println(YEAR);
         
                if(Eid.equals(EID) && Year.equals(YEAR) && Month.endsWith(MONTH)){
                    String sql = "UPDATE salary SET basicsalary =" +basicsalary+",othours ="+othours+", otrate ="+otrate+", netsalary ="+netsalary+"WHERE eid ="+eid+" AND year ="+year+" AND  month ="+month; 
                    PreparedStatement Pstate = con.prepareStatement(sql);
                    Pstate.execute();
                     Pstate.close();
                    return true;

                }
            }
         }catch(SQLException e){
                 System.out.println("salary detailes update error");
         }
        
         
      //String sql;
      /*if (rs.equals(eid)){
          return false;
      } else{
         sql = "UPDATE salary SET basicsalary =" +basicsalary+",othours ="+othours+", otrate ="+otrate+", netsalary ="+netsalary+"WHERE (eid ="+eid+" AND year ="+year+") AND  (month ="+month+")"; 
      }   
      try{    
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        } 
         //return false;*/
        return false;

    }

    public static boolean deleteSalary(String eid, String year, String month) {
       String Eid = eid;
       String Year=year;
       String Month=month;
        eid = " '"+ eid +"' ";
        year = " '"+ year +"' ";
        month = " '"+ month +"' ";
       try{
         String SQL = "SELECT * FROM salary";
         PreparedStatement ps = con.prepareStatement(SQL);
         ResultSet  rs = ps.executeQuery();
         String EID;
         String YEAR;
         String MONTH;
         
         while(rs.next()){
             
             EID=rs.getString("eid");
             YEAR=rs.getString("year");
             MONTH=rs.getString("month");
      
         
               if(Eid.equals(EID) && Year.equals(YEAR) && Month.endsWith(MONTH)){
                    String sql = "DELETE FROM salary WHERE eid ="+ eid+" AND year ="+year+" AND month = "+month; 
                    PreparedStatement Pstate = con.prepareStatement(sql);
                    Pstate.execute();
                     Pstate.close();
                    return true;

                }
            }
         }catch(SQLException e){
                 System.out.println("salary detailes deleat error");
         }
      /*String sql = "DELETE FROM salary WHERE eid ="+ eid+" AND year ="+year+" AND month = "+month;
       
       try{     
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
       return false;*/
        return false;
    }
    
   public ResultSet selectEmployeeHR(){
       ResultSet rs = null;
       try{
           String sql = "SELECT eid,name,phone,email,address,gender,nic,dob,jobtitel,licenseno FROM employee";
           PreparedStatement ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           return rs;
       } catch(SQLException e) {
           System.out.println("employee table can't read");
       } 
        return rs;     
       
   }

    public ResultSet selectPassword(String eid) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        eid = " '"+ eid +"' ";
        ResultSet rs = null;
       try{
           String sql = "SELECT password FROM employee WHERE eid ="+eid;
           PreparedStatement ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           return rs;
       } catch(SQLException e) {
           System.out.println("employee password can't read");
       } 
        return rs;
    
    }
    
    public static boolean updateAvailable(String eid, String Availability){
        String Eid= eid;
        eid = " '"+eid+"' ";
        Availability =" '"+Availability+"' ";
        
        
        try{
             String SQL = "SELECT * FROM employee";
         PreparedStatement ps = con.prepareStatement(SQL);
         ResultSet  rs = ps.executeQuery();
         String EID;
         
         while(rs.next()){
             
             EID=rs.getString("eid");
      
               if(Eid.equals(EID)){
                    String sql = "UPDATE employee SET available ="+Availability+"WHERE eid ="+eid; 
                    PreparedStatement Pstate = con.prepareStatement(sql);
                    Pstate.execute();
                     Pstate.close();
                    return true;

                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
        
    }
    
    public ResultSet selectAvailable(){
        ResultSet rs =null;
        
        String sql ="SELECT eid FROM employee WHERE available ='yes'";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            rs =PS.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("can't read avalable list");
        }
        return null;
        
    } 
    
    public ResultSet selectUnavailable(){
        ResultSet rs =null;
        
        String sql ="SELECT eid FROM employee WHERE available = 'no'";
        try {
            PreparedStatement PS = con.prepareStatement(sql);
            rs =PS.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("can't read unavalable list");
        }
        return null;
        
    }

    public ResultSet selectEID() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       ResultSet rs = null;
        try {
            String sql ="SELECT eid FROM employee";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println("can't read eid");
        }
        return rs;
       
    }

    public ResultSet selectSalary() {
        ResultSet rs = null;
       try{
           String sql = "SELECT eid,basicsalary,otrate,othours,year,month,netsalary FROM salary";
           PreparedStatement ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           return rs;
       } catch(SQLException e) {
           System.out.println("salary table can't read");
       } 
        return rs; 
    }
  
    //Reports - Employee Management.
    public static void EmployeeDetailReport() throws JRException {
        
        //E:\NetBeans\ITP-Final-Project\src\reportHR\employee.jrxml
        JasperDesign jdesign = JRXmlLoader.load("src\\reportHR\\EmployeeReport.jrxml");
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);//essential
        JasperPrint jprint = JasperFillManager.fillReport(jreport, null , con);//if parameter is not passing map -- null
        JasperViewer.viewReport(jprint , false);
    }

    public static void dailyServiceReport(String sDate) throws JRException{
        JasperDesign jdesign = JRXmlLoader.load("src\\reportHR\\DailyService.jrxml");
        HashMap map = new HashMap();
        map.put("date", sDate);
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(jreport, map , con);
        JasperViewer.viewReport(jprint, false);
    }

    public static void SalaryReport(String year, String Month) throws JRException{
        JasperDesign jdesign = JRXmlLoader.load("src\\reportHR\\salaryReport.jrxml");
        HashMap map = new HashMap();
        map.put("year", year);
        map.put("month", Month);
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(jreport, map , con);
        JasperViewer.viewReport(jprint, false);
    }
    
    
    //Transaction Management - Keshani 
    public ResultSet SelectCustomerName(String username)
    { 
        username = " '"+ username +"' "; //String only
        try{
            //getting kitchen requested food item price from the database
            String sql1 = " SELECT " + "CName"+
                          " From " + " customer " + 
                          "WHERE " + "CName = " + username;
        
            PreparedStatement ps = con.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();  
            return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error Customer table");
        }
        return rs;
    }
  
  //create  a method to rettrive customer name
  public ResultSet SelectPckageName(int CID)
    { 
        
        try{
            //getting pckage name from the database
            String sql1 = " SELECT " + "p.Name" + 
                          " FROM " + " package p, customer c, booking b "+
                          " WHERE " + " p.PID = b.PID and b.CID = c.CID and c.CID ="+ CID;
        
            PreparedStatement ps = con.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();  
            return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error Package table");
        }
        return rs;
    }
    
  //create a method to retreive to total amount of the Room Package price
    public ResultSet RoomPackagePrice(int CID)
    { 
        try{
            //getting kitchen requested food item price from the database
            String sql1 = " SELECT " + "p.price"
            + " FROM " +" booking b, package p"
            +" WHERE " +" b.PID = p.PID and b.CID =" + CID;
        
            PreparedStatement ps = con.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();  
            return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error RoomPackagePrice");
        }
        return rs;
    }
    
    //Create a Method to retrieve to total amout of the kitcehn requested food item
    public ResultSet SelectKitchenRequestedFoodItem(String username)
    { 
        username = " '"+ username +"' "; //String only
        try{
            //getting kitchen requested food item price from the database
            String sql1 = "SELECT "+ " SUM(i.price) AS 'value' "  +
            " FROM " + "order_table o, order_item_table oi, item_table i,customer c" +
            " WHERE "+ "i.id = oi.item_id and oi.order_id = o.order_id AND o.user_name =" + username;
        
            PreparedStatement ps = con.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();  
            return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error KitchenRequseted food item");
        }
        return rs;
    }
    
    
    public ResultSet SelectPackageDiscount(int CID)
    { 
        try{
            //getting kitchen requested food item price from the database
            String sql = " SELECT " + " p.Discount" +
                         " FROM " + "customer c,booking b, package p" +
                         " WHERE " + " b.PID = p.PID and b.CID =" +CID;
        
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();  
            return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error package discount");
        }
        return rs;
    }
    
    public ResultSet SelectBarPrice(int CID)
    { 
        try{
            //getting kitchen requested food item price from the database
            String sql = " SELECT "  + "bo.totalPrice " +
                         " FROM" + " barorder bo, booking b, customer c" +
                         " WHERE " + "bo.Booking_BID = b.BID and b.CID =c.CID AND c.CID = " + CID;
        
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();  
            return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error bar price");
        }
        return rs;
    }
    
    public ResultSet SelectBarDiscount(int CID)
    { 
        try{
            //getting kitchen requested food item price from the database
            String sql = " SELECT "  + "bo.Discount " +
                         " FROM" + " barorder bo, booking b, customer c" +
                         " WHERE " + "bo.Booking_BID = b.BID and b.CID =c.CID AND c.CID = " + CID;
        
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();  
            return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error bar discount");
        }
        return rs;
    }
    
    public ResultSet SelectBarTotal(int CID)
    { 
        try{
            //getting kitchen requested food item price from the database
            String sql = " SELECT "  + "bo.netAmount " +
                         " FROM" + " barorder bo, booking b, customer c" +
                         " WHERE " + "bo.Booking_BID = b.BID and b.CID =c.CID AND c.CID = " + CID;
            
            // "select bo.netAmount FROM barorder bo, booking b, customer c WHERE  bo.Booking_BID = b.BID and b.CID = c.CID AND c.CID =" +CID 
        
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();  
            return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error bar total");
        }
        return rs;
    }
    
    
    public ResultSet SelectNoOfDays(int CID)
    { 
        try{
            //getting kitchen requested food item price from the database
            String sql = " SELECT " +" b.NoofDays " +
                         " FROM " +" booking b, customer c " +
                         " WHERE " + " c.CID = b.CID and c.CID = " + CID;
        
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();  
            return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error no of days");
        }
        return rs;
    }
    
    public ResultSet SelectInventoryRequestedItemPrice(int CID)
    { 
        //Testing ResultSet
        //ResultSet rs = null;
        try{
            //getting kitchen requested food item price from the database
            String sql = " SELECT " + " sum(ror.Quantity * ror.Amount) AS  'total' "+
                         " FROM  " + " room_other_request ror, booking b, extraexpences ex, customer c"+
                         " WHERE " + " ror.Booking_BID = b.BID  and b.CID = "+ CID + 
                         " group by " + "c.CID" ;
        
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); 
            return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error inventory item price");
        }
        return rs;
    }
    
    
   //FillingTables - Customer
   public  ResultSet SelectCustomerRoomDetail()
   {
        try{
            String sql = " SELECT " + "c.cid,c.CName,p.Name " +
            " FROM " + " customer c ,  package p ,booking b "+
            " WHERE " + " c.CID = b.CID and b.PID = p.PID" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        //Add the rs to the table
        return rs;
       } catch (SQLException e) {
         System.out.println("Some thing wrong with reading tables - Internal error customer room detail table");
        }
        return rs;
    }
   
   public ResultSet SelectCustomerAdddress(int CID)
    { 
        try{
            //getting kitchen requested food item price from the database
            String sql = " SELECT " + "Address" +
                         " FROM " + " customer " + 
                         " WHERE " + " CID = " + CID;
        
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); 
            return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error customer address");
        }
        return rs;
    }
   public ResultSet SelectCustomerPhone(int CID)
    { 
        try{
            //getting kitchen requested food item price from the database
            String sql = " SELECT " + "cp.phone_num " + 
                         " FROM " + " customer c, customer_phone cp " + 
                         " WHERE " + " cp.customer_CID = c.CID and c.CID =" + CID;
        
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); 
            return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error customer phone");
        }
        return rs;
    }
   //filling the customer transaction detail table
   public  ResultSet SelectTransactionDetails()
   {
        try{
            /*String sql = " SELECT " + "ct.TranID,ct.TotalAmount, c.CName" +
                         " FROM " + " customer c, booking b, customertransaction ct, bill bl " +
                         " WHERE " + " c.CID = b.CID and b.BID = bl.BookiD and bl.transactionID = ct.TranID"; */
            String sql =  " SELECT " + "*" +
                           " FROM " + " customertransaction " ;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        //Add the rs to the table
        return rs;
       } catch (SQLException e) {
         System.out.println("Some thing wrong with reading tables - Internal error customer room detail table");
        }
        return rs;
    }
   
    /*public  ResultSet SelectTransaction()
    {
        try{
        String sql = "SELECT *" + " FROM customertransaction"  ;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        //Add the rs to the table
        return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error Transaction table");
        }
        return rs;
    }*/
    
   
   public static boolean UpdateCashPaymentDetails(double Paybleamount, double balance,int TranID){
        
        //Create the query
        String sql = "UPDATE " + "customertransaction" +
                     " SET " + "Payble_Amount = " + Paybleamount + ", Balance = " + balance +
                     " WHERE " + "TranID = " +TranID;
        
        //Excute the query.
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
   
    public static boolean UpdateCardPaymentDetails(String cardNo, int cnnNo,String cardName,int year,int month,int TranID){
        
        
        cardName = " ' " + cardName + " ' ";
        cardNo = "'" +cardNo+ "'";
        //Create the query
        String sql = "UPDATE " + "customertransaction" +
                     " SET " + "CardNo = " + cardNo + ", CVVNo = " + cnnNo + ", CardName = " + cardName +", Year = " + year + ", Month = " + month +
                     " WHERE " + "TranID = " +TranID;
        
        //Excute the query.
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    
    public static boolean deletePaymentDetails(int TranID){
     
        //Create the query
        String sql =   " DELETE " + 
                       " FROM " + " customertransaction " +
                       " WHERE " + " TranID ="  +  TranID;
        
        //Excute the query.
        try{
             
            PreparedStatement Pstate = con.prepareStatement(sql);
            Pstate.execute();
            Pstate.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } 
         return false;
    }
    
    
  
   public static void InsertPaymentDetail(String sql) throws Exception{
       if(con == null){
           DbClass.Database();
       }
       con.createStatement().executeUpdate(sql);
   }
   
   public static void InsertCustomerPaymentDetail(String sql) throws Exception{
       if(con == null){
           DbClass.Database();
       }
       con.createStatement().executeUpdate(sql);
   }
   
   public ResultSet SelectSuplierDetails() {
        try{
            String sql =  " SELECT " + " SupID , Name ,  Address , contact_1 , contact_2 , email "+
                           " FROM " + " supplier " ;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        //Add the rs to the table
        return rs;
       } catch (SQLException e) {
         System.out.println("Some thing wrong with reading tables - Internal error supplier detail table");
        }
        return rs;
    }
   
   public ResultSet calculateTotalAmount(String SID){
     try{
         
            SID = " '" + SID + "' ";
            //username = " '"+ username +"' ";
            //getting kitchen requested food item price from the database
            String sql = "select" + " sum(gs.subTotal) as 'TotalAmount'"+
                         " from " + " grn_supplier gs, supplier s " +
                         " where "  + "  s.SupID = gs.supplierId and  supplierId = " + SID;
        
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); 
            return rs;
        } catch (SQLException e) {
            System.out.println("Some thing wrong with reading tables - Internal error in supplier table");
        }
        return rs;  
   }
   
   public ResultSet SelectcompanyTransactionDetails() {
        //To change body of generated methods, choose Tools | Templates.
        try{
            String sql =  " select " + " TranID,TotalAmount,sName,Adreess,Email,SupID "  +
                          " from " + " companytransaction " ;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        //Add the rs to the table
        return rs;
       } catch (SQLException e) {
         System.out.println("Some thing wrong with reading tables - Internal error customer room detail table");
        }
        return rs;
    }
    
   
   //-----------------------------------------------------------------------||Menakas DB Methods||-------------------------------------------------------
   //insert method
    public void AddTocustomerbill(double id,double qun,int bid){
        ResultSet rs = null;
        boolean value = false;
        try{
            String sql = "SELECT * FROM "+ BAR_Tb_N1 + " WHERE "+ BAR_COL_1 +" = "+id;
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            String iid = rs.getString(BAR_COL_1);
            String name = rs.getString(BAR_COL_2);
            String size = rs.getString(BAR_COL_3);
            String brand = rs.getString(BAR_COL_4);
            Double price = Double.parseDouble(rs.getString(BAR_COL_6));
            Double TotPrice;
            TotPrice = price * qun;
            
            String sql2 = "INSERT INTO "+BAR_Tb_N3+" ("+BAR_COL3_2+","+BAR_COL3_3+","+BAR_COL3_4+","+BAR_COL3_5+","+BAR_COL3_6+","+BAR_COL3_7+","+BAR_COL3_8+","+BAR_COL3_9+") VALUES ("+iid+",'"+name+"','"+brand+"','"+size+"',"+price+","+qun+","+TotPrice+","+bid+")" ;
            PreparedStatement ps2 = con.prepareStatement(sql2);
            value = ps2.execute();
            System.out.println(value);
            
            
        }catch(NumberFormatException e){
            System.out.println("AddTocustomerbill NUMBER Exception detected");
        }catch(SQLException e){
            System.out.println("AddTocustomerbill SQL Exception detected");
            e.printStackTrace();
        }
    }
    //
    public boolean AddToBarBill(int bid,double tot,double dis,double net,int boid){
        boolean stat = false;
        try{
            String SQL = "INSERT INTO BarOrder (BarID ,totalPrice , Discount , netAmount , Booking_BID ) VALUES ("+bid+","+tot+","+dis+","+net+","+boid+")";
            PreparedStatement ps = con.prepareStatement(SQL);
            stat = ps.execute();
            System.out.println(stat);
            
        }catch(Exception e){
            System.out.println("AddToBarBill Exception detected");
            e.printStackTrace();
        }
        
        return stat;
    }
    //delete method
    public int deleteFromcustomerbill(int ivid){
        int msg = 0;
        try{
            String SQL = "DELETE FROM "+BAR_Tb_N3 +" WHERE "+BAR_COL3_1+" = "+ivid;
            PreparedStatement ps2 = con.prepareStatement(SQL);
            msg = ps2.executeUpdate();
            //System.out.println(msg);
        }catch(Exception e){
            System.out.println("deleteFromcustomerbill Exception detected");
        }
        return msg;
    }
    
    //updating the table
    public boolean updateFromcustomerbill(int ivid , int qun){
        boolean msg = false;
        ResultSet rs = null;
        try{
            String sql = "SELECT UnitPrice FROM bar_bill_invoice WHERE bb_invoice_No = "+ivid;
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            
            double price = Double.parseDouble(rs.getString("UnitPrice"));
            double TotPrice = price *(double) qun;
            
            String SQL = "UPDATE " +BAR_Tb_N3+ " SET "+BAR_COL3_7 +" = "+qun+" , "+BAR_COL3_8+" = "+TotPrice+" WHERE "+BAR_COL3_1+" = "+ivid;
            System.out.println(SQL);
            PreparedStatement ps2 = con.prepareStatement(SQL);
            ps2.executeUpdate();
            
        }catch(Exception e){
            System.out.println("updateFromcustomerbill Exception detected");
            e.printStackTrace();
        }
        return msg;
    }
    //calcutate total
    public double CalcFromcustomerbill(int bid){
        double total = 0;
        ResultSet rs = null;
        try{
            String SQL = "SELECT SUM(TotalPrice) as 'total' FROM bar_bill_invoice WHERE BarID = "+bid+" GROUP BY BarID";
            PreparedStatement ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            rs.next();
            total = Double.parseDouble(rs.getString("total"));
            
        }catch(Exception e){
            System.out.println("CalcFromcustomerbill Exception detected");
            e.printStackTrace();

        }
        return total;
    }
    
    //retirving from the table
    public ResultSet getFromcustomerbill(int bid){
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM "+ BAR_Tb_N3+" WHERE "+BAR_COL3_9+" = "+bid;
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        }catch(SQLException
                e){
            System.out.println("getFromcustomerbill Exception detected");
        }
        
        return rs;
    }

    //checkig wether the cusomer is available in the databse 
    public boolean checkCustomer(String BID){
        boolean val = false;
        ResultSet rs = null;
        try{
            
            String sql = "SELECT * FROM "+ Reception_TABLE_NAME_2  +" WHERE "+Reception_COL1_2+" = "+BID;
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                val = true;
            }else{
                val = false;
            }
        }catch(Exception e){
            System.out.println("checkCustomer Exception detected");
        }
        return val;
    }
    
    
    //getting customer name according to booking id
    public String getcustomerName(String BID){
        String name = null;
        ResultSet rs = null;
        try{
            
            String sql =  " SELECT c.CName "+" FROM  customer c, booking b"+
                          " WHERE c.CID = b.CID AND b.BID = "+BID;
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            name = rs.getString(Reception_COL2);
        }catch(Exception e){
            System.out.println("getcustomerName Exception detected");
            e.printStackTrace();
        }
        return name;
    }
    
    //get table quantity
    public int getQunFromcustomerbill(int id){
        int qun = 0;
        ResultSet rs = null;
        try{
            String SQL = "SELECT Quntity FROM bar_bill_invoice WHERE bb_invoice_No = "+id;
            PreparedStatement ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            rs.next();
            qun = Integer.parseInt(rs.getString("Quntity"));
            System.out.println(qun);
        }catch(Exception e){
            System.out.println("getQunFromcustomerbill Exception detected");
            e.printStackTrace();
        }
        return qun;
    }
    
    //select method
    public ResultSet getInventory(){
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM "+ BAR_Tb_N1;
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        }catch(SQLException e){
            System.out.println("getInventory Exception detected");
        }
        
        return rs;
    }
    //Add Items To Inventory table
    public boolean AddToInventory (String Iname,String Isize,String Ibrand ,int Istock,double IUprice){
        boolean stat = false;
        try{
            String SQL = "INSERT INTO liquoritemsinventory ("+BAR_COL_2+","+BAR_COL_3+","+BAR_COL_4+","+BAR_COL_5+","+BAR_COL_6+") VALUES ('"+Iname+"','"+Isize+"','"+Ibrand+"',"+Istock+","+IUprice+")";
            PreparedStatement ps = con.prepareStatement(SQL);
            stat = ps.execute();
            System.out.println(stat);
            
        }catch(Exception e){
            System.out.println("AddToInventory Exception detected");
            e.printStackTrace();
        }
        
        return stat;
    }
    
    //upadate LiquorInventor table
    public boolean UpdateToInventory (int Iid, String Iname, String Isize, String Ibrand ,int Istock,double IUprice){
        boolean msg = false;
        ResultSet rs = null;
        try{
            String SQL = "UPDATE liquoritemsinventory SET Name = '"+Iname+"', Size = '"+Isize+"', Brand = '"+Ibrand+"', NoOfStock = "+Istock+", UnitPrice = "+IUprice+" WHERE InID = "+Iid;
            
            System.out.println(SQL);
            PreparedStatement ps2 = con.prepareStatement(SQL);
            ps2.executeUpdate();
            
        }catch(Exception e){
            System.out.println("UpdateToInventory Exception detected");
            e.printStackTrace();
        }
        return msg;
    }
    //delete a row from LiquorInventory Table
    public int DeleteInventoryRow (int ivid){
        int msg = 0;
        try{
            String SQL = "DELETE FROM liquoritemsinventory WHERE InID = " + ivid;
            PreparedStatement ps2 = con.prepareStatement(SQL);
            msg = ps2.executeUpdate();
            //System.out.println(msg);
        }catch(Exception e){
            System.out.println("DeleteInventoryRow Exception detected");
        }
        return msg;
    }
    
    
    //-----------------------------------------------------------------------||Tan DB Mehtods
    public static void  addVehicle(String name, String chassis, String version, String VCondition, String Mrecord, String file,String file2, String ory ){

        String sql = "INSERT INTO vehicle (TMS_vname, TMS_ChassisNo,TMS_Features, TMS_Condition,TMS_MRecord,Vehiclecol,TMS_Documents, TMS_VImg)"+" VALUES ( '"+name +"' , '"+chassis +"' , '"+ version+"' , '"+VCondition +"', '"+Mrecord +"' , '"+ory +"','"+file+"' , '"+ file2+"')";
;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }

    public static boolean DeleteV(int i, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public ResultSet SelectVehicle(){
        try{
            String sql = "SELECT * FROM vehicle";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            return rs;
        }catch(SQLException e){
            System.out.println("some thing wrong with reading tables - internal error in Item table");
        }
        return rs;
        
    }
    
    public boolean DeleteV (int id){
            try{
                String sql = "DELETE FROM vehicle WHERE (TMS_ID = " + id + ");";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.execute();
                        ps.close();
                        
                    return true;
            }catch(SQLException e){
                System.out.println("some thing wrong with deleting table - internal error in item ");
                return false;
            }
    }
    
    //Method to select all the drivers in the database.
    public ResultSet selectDriver(){
        //SQL
        try{
            String sql = "SELECT * FROM `employee` WHERE `jobtitel` = " + "Driver";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            return rs;
        }catch(SQLException e){
            System.out.println("Some thing wrong with reading tables - internal error in Item table");
        }
        return rs;
    }
    
    //Method to select vehicle status details 
    public ResultSet selectVehicleStatus(){
        //SQL
        try{
            String sql = "SELECT TMS_vname AS 'Vehicle Name', Vehiclecol AS 'Vehicle Status'  FROM vehicle";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(SQLException e){
            System.out.println("some thing wrong with reading tables - internal error in Item table");
        }
        return rs;
    }


    public ResultSet selectServiceListHR() {
         ResultSet rs = null;
       try{
           String sql = "SELECT employee_name,user_name,room_number,date FROM order_table";
           PreparedStatement ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           return rs;
       } catch(SQLException e) {
           System.out.println("order table can't read");
       } 
        return rs; 
    }

    

    
    
}
