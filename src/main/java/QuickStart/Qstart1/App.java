package QuickStart.Qstart1;


import java.sql.*;
import java.util.*;

import java.io.*;
import java.util.concurrent.TimeoutException;


/**
 * Hello world!
 *
 */



class timerThread extends Thread
{
    int n = 0 ;
    boolean flag = false ;

    public void finish()
    {
        flag = true ;
    }

    public void run()
    {
        while(true)
        {
            System.out.println(n) ;
            n++ ;

            try
            {
                sleep(1000) ;  // 1 second
                if( flag )
                    return ;
            }
            catch ( InterruptedException e)
            {
                return ;
            }
        }
    }
}
public class App 
{
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver") ;

        //String url = "jdbc:mysql://localhost/Hotel?useSSL=false&ServerTimezone=UTC" ;
        String url = "jdbc:mysql://192.168.40.130/Hotel?useSSL=false&ServerTimezone=UTC" ;  // vmware 의 mysql
        String id = "root" ;
        String pw = "ch1003" ;

        Connection conn = DriverManager.getConnection(url,id,pw) ;

        return conn ;
    }


    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        
        timerThread th = new timerThread() ;
        th.start();
        
        try
        {
        	Thread.sleep(2000);
        	th.flag = true ;
        }
        catch ( InterruptedException e)
        {
        	e.printStackTrace();
        }
        
        
        
        /*
        try
        {
        	Connection conn = getConnection() ;
        	Thread.sleep(1000);
        	System.out.println("db connect.....");
        	
        	String sql = "select * from Reservation" ;

            Statement stmt = conn.createStatement() ;

            ResultSet rs = stmt.executeQuery(sql) ;

            ArrayList<Member> list = new ArrayList<Member>() ;

            while(rs.next())
            {
                Member member = new Member() ;

                member.setId ( Integer.parseInt( rs.getString("ID")) );
                member.setName ( rs.getString("Name") ) ;
                member.setRoomNum ( Integer.parseInt( rs.getString("RoomNum"))) ;

                list.add(member) ;
            }

            for( int i = 0 ; i < list.size() ; i++ )
            {
                System.out.println("--------------------------------------") ;
                System.out.println("ID :" + list.get(i).getId() ) ;
                System.out.println("Name :" + list.get(i).getName() ) ;
                System.out.println("Room Number :" + list.get(i).getRoomNum() ) ;
            }

        }
        catch ( Exception e )
        {
        	e.printStackTrace();
        }
        
        */
        
        
        /*
        Send send = new Send() ;
        send.qSend();
        */
        
        /*
        Recv recv = new Recv() ;
        recv.qRecv();
		*/
        
        /*
        appLogger log = new appLogger() ;
        log.outLog("test");
    	*/
        
        appRedis appredis = new appRedis() ;
    }
}
