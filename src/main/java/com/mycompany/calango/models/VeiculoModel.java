/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calango.models;

import com.mycompany.calango.entidade.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DELL
 */
public class VeiculoModel {

    public EntityManager getEm() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CalangoPU");
        return factory.createEntityManager();
    }

    public void salvar(Veiculo v) throws Exception {
        EntityManager em = getEm();
        try {
            em.getTransaction().begin();
            if (v.getId() == null) {
                em.persist(v);
            } else {
                em.merge(v);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<Veiculo> listaVeiculos() {
        EntityManager em = getEm();
        try {
            return em.createQuery("select v from Veiculo v").getResultList();
        } finally {
            em.close();
        }
    }

    public void excluir(Long id) {
        EntityManager em = getEm();
        Veiculo v = em.find(Veiculo.class, id);//SELECT * FROM veiculo WHERE id = id
        try {
            em.getTransaction().begin();
            em.remove(v); //Preparando um DELETE FROM veiculo WHERE id = id
            em.getTransaction().commit(); //Executa o DELETE
        } catch (Exception e) {
            em.getTransaction().rollback();
        }finally{
            em.close();
        }

    }
}
