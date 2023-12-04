/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author 54346
 */


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import model.Equipo;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;



public class EquipoDAO implements java.io.Serializable{
    
    
    private final SessionFactory sessionFactory;
    private Object equipo;
    
    public void MetodoVacio() {
    }
    
    public EquipoDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    
    public void agregarEquipo(Equipo equipo) {
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(equipo);
            transaction.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace(); 
          }
    }
    
    public void mostrarEquipos() {
        try{
            Session session = sessionFactory.openSession();
            Criteria c = session.createCriteria(model.Equipo.class);
            List<model.Equipo> equipo = c.list();
            for (model.Equipo e : equipo) {
                System.out.println("ID: " + e.getId() + " | Nombre: " + e.getNombre());               
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
          }
       
    }
    
    public void eliminarEquipo(int id) {
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            model.Equipo equipo = (model.Equipo) session.get(model.Equipo.class, id);
            if (equipo != null) {
                session.delete(equipo);
                transaction.commit();
                System.out.println("Equipo eliminado correctamente.");
            } else {
                System.out.println("Equipo no encontrado.");
            
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();

          }
    }
    
    public void modificarTitularesEquipo(int idEquipo, int nuevosTitulares) {
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            model.Equipo equipo = (model.Equipo) session.get(Equipo.class, idEquipo);
            if (equipo != null) {
                equipo.setTitulares(nuevosTitulares);
                session.update(equipo);
                transaction.commit();
                System.out.println("Titulares modificados correctamente.");
            } else {
                System.out.println("Equipo no encontrado.");
            }
        } catch (HibernateException ex) {          
            ex.printStackTrace(); 
          }
        
        } 
    
    
    public void modificarSuplentesEquipo(int idEquipo, int nuevosSuplentes) {
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            model.Equipo equipo = (model.Equipo) session.get(Equipo.class, idEquipo);
            if (equipo != null) {
                equipo.setSuplentes(nuevosSuplentes);
                session.update(equipo);
                transaction.commit();
                System.out.println("Suplentes modificados correctamente.");
            } else {
                System.out.println("Equipo no encontrado.");
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
          }
    }
} 
