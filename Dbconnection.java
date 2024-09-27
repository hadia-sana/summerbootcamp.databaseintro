/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dbconnection;

/**
 *
 * @author Hp
 */
import java.sql.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Dbconnection {

    /**
     * @param args the command line arguments
     */
    public static String takequery(){
    Scanner s=new Scanner(System.in);
    System.out.println("enter id");
    int id=s.nextInt();
    s.nextLine();
    System.out.println("enter name");
    String name=s.nextLine();
    System.out.println("enter category");
    String category=s.nextLine();
    System.out.println("enter price");
    int price=s.nextInt();
    String qry=String.format("insert into tb values(%d,'%s','%s',%d)",id,name,category,price);
    return qry;
    }
    public static String updatename(){
    Scanner s=new Scanner(System.in);
    System.out.println("enter id");
    int id=s.nextInt();
    s.nextLine();
    System.out.print("enter name");
    String name=s.nextLine();
    String qry=String.format("update tb set name='%s' where id=%d",name,id);
    return qry;
    
    }
    public static String updateprice(){
    Scanner s=new Scanner(System.in);
    System.out.println("enter id");
    int id=s.nextInt();
    s.nextLine();
    System.out.print("enter price");
    int price=s.nextInt();
    String qry=String.format("update tb set price=%d where id=%d",price,id);
    return qry;
    
    }
    public static String updatecategory(){
    Scanner s=new Scanner(System.in);
    System.out.println("enter id");
    int id=s.nextInt();
    s.nextLine();
    System.out.print("enter category");
    String category=s.nextLine();
    String qry=String.format("update tb set category='%s' where id=%d",category,id);
    return qry;
    
    }
    public static String delete(){
    Scanner s=new Scanner(System.in);
    System.out.println("enter id to be deleted");
    int id=s.nextInt();
    s.nextLine();
    String qry=String.format("delete from tb where id=%d",id);
    return qry;
    }
    public static String search(){
    
   
    
    String qry=String.format("select * from tb");
    return qry;
    
    
    }
    public static void main(String[] args) {
        String url="jdbc:mysql://127.0.0.1:3306/product1";
        String user="root";
        String password="";
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url, user, password);
         Statement st=conn.createStatement();
         System.out.println("========press=====");
          System.out.println("========1 for insertion=====");
           System.out.println("========2 for deletion=====");
            System.out.println("========3 for updation=====");
             System.out.println("========4 for search=====");
           Scanner sc=new Scanner(System.in);
           int choice=sc.nextInt();
           if(choice==1){
         
         int row=st.executeUpdate(takequery());
         
         if(row>0){
         System.out.println("inserted");
         }
         else{
         System.out.println("not inserted");
         }}
           else if(choice==2){
           st.executeUpdate(delete());
           }
           else if(choice==3){
               sc.nextLine();
               System.out.print("write what do you wanna update:");
               String s=sc.nextLine();
               
               if(s.equals("name")){
               st.executeUpdate(updatename());
               }
               else if(s.equals("category")){ st.executeUpdate(updatecategory());}
               else if(s.equals("price")){ st.executeUpdate(updateprice());}
          }
           else if(choice==4){
          ResultSet rs=st.executeQuery(search());
          System.out.print("enter what do you wanna search");
          sc.nextLine();
    String find=sc.nextLine();
    while(rs.next()){
          
          System.out.println(find+"="+rs.getString(find));}
          
           
           }
           else{
           System.out.println("invalid3");
           }
        
        } catch (ClassNotFoundException ex) {
            System.out.print(ex.getMessage());
                    
                    
        }
        catch (SQLException ex) {
             System.out.print(ex.getMessage());
        }
        //Statement st=conn.createStatement();
        
    }
    
}
