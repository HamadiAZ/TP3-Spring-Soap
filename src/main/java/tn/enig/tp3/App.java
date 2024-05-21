package tn.enig.tp3;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.xml.ws.Endpoint;
import tn.enig.JaxWs.Service;
import tn.enig.dao.Dao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        Endpoint.publish("http://localhost:8088/tp3/", new Service());
    }
}
