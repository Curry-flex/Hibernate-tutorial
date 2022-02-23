package com.Hibernate.Hibernate;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
    	/*
    	
    	//Add room object
    	List<PatientRoom> roomlist = new ArrayList<PatientRoom>();
    	roomlist.add(new PatientRoom(3, "HIV Room"));
    	
    	
    	//create name oject of type doctor
    	DoctorName name = new DoctorName();
    	name.setFirstNmae("Linda");
    	name.setLastName("Komba");
        
    	//Doctor office information
    	
    	Office office = new Office();
    	office.setOfficeID(2);
    	office.setOfficeName("STDs");
    	
    	//Insert into database
    	Doctors doc = new Doctors();
    	doc.setDoctorID(2);
    	doc.setHospital("Immec Hospital");
    	doc.setSpecialist("STDs");
    	doc.setName(name);
    	doc.setOffice(office);
    	doc.setRoomList(roomlist);
    	
    	//Create patient object
    	
    	Patient patient = new Patient();
    	patient.setPatientID(2);
    	patient.setPatientName("Nelson kemi");
    	patient.setPatientLocation("Iringa");
    	patient.setDoctor(doc);
 
    	
    
    	
    	Configuration conf = new Configuration().configure().addAnnotatedClass(Doctors.class).addAnnotatedClass(Patient.class);
    
    	SessionFactory sf = conf.buildSessionFactory();
    	
    	Session session = sf.openSession();
    	
    	Transaction ts  = session.beginTransaction();
    	
    	session.save(patient);
    	 
    	
    	ts.commit();
    	
    	*/
    	
    	
    	
    	
    	
    	//Select from database
        Configuration selectconf = new Configuration().configure().addAnnotatedClass(Doctors.class).addAnnotatedClass(Office.class).addAnnotatedClass(Patient.class).addAnnotatedClass(PatientRoom.class);
    	SessionFactory sfselect = selectconf.buildSessionFactory();
    	Session session1 =sfselect.openSession();
    	//Using hibernate
    	Transaction transaction = session1.beginTransaction();
    	Doctors doctor =session1.get(Doctors.class, 2);
    	System.out.println(doctor);
    	
    	 
    	//Using query(HQL)
       	//Query  q1 =session1.createQuery("from Office");
       	//Office office =(Office) q1.uniqueResult();
       	//System.out.println(office);
  
    	
    	//GEtting list of dooctors using (HQL)
    	 Query q2 = session1.createQuery("from Doctors");
    	   List<Doctors> doctorsList = q2.list();
    	   
    	   for(Doctors doc: doctorsList) {
    		   System.out.println(doc); 
    	   }
    	   
    	   
    	 //Select specific column
    	   /*
    	   int id =2;
           Query q3 = session1.createQuery("select name.firstNmae,hospital from Doctors where doctorID=:id");
           q3.setParameter("id", id);
           Object[] doctorinfo =(Object[]) q3.uniqueResult();
           
           for(Object o : doctorinfo) {
        	   
        	   System.out.println(o);
           }
           */
    	   
    	   
           //select specific column and return list
           
           Query q4 = session1.createQuery("select name.firstNmae,hospital from Doctors ");
            List<Object[]> doctosColumn =(List<Object[]>) q4.list();
            
            for(Object[] obj : doctosColumn) {
            	
            	System.out.println(obj[0] +" "+ obj[1]);
            }
            
            //Updae query
            
            Doctors updateDoctor =session1.get(Doctors.class, 1);
            updateDoctor.setHospital("Malangalila Referal Hospital");
            updateDoctor.setSpecialist("Kidney");
            session1.save(updateDoctor);
            
            
            //Delete query
            
            Doctors deletedDoctor =session1.get(Doctors.class, 1);
           
            session1.remove(deletedDoctor);
                             
    
    	  
    	transaction.commit();
    
    	
        
       
    }
}
