/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ricardo
 */
public class PessoaHibernate implements PessoaDAO {

    private Session session;

    public PessoaHibernate() {

        this.session = HibernateUtil.openSession();
    }

    @Override
    public Integer insert(Pessoa pessoa) {

        Transaction tx = null;

        try {

            this.session = HibernateUtil.openSession();
            tx = this.session.beginTransaction();
            this.session.save(pessoa);
            this.session.flush();
            tx.commit();
            return (Integer) this.session.getIdentifier(pessoa);
        } catch (Exception ex) {

            System.err.println(ex + " " + ex.getMessage());
            return -1;
        } finally {

            this.session.close();
        }
    }

    @Override
    public Pessoa get(Integer id) {

        this.session = null;
        this.session = HibernateUtil.openSession();
        Pessoa pessoa = null;

        try {

            Criteria criteria = this.session.createCriteria(Pessoa.class);
            criteria.add(Restrictions.eq("id", id));
            pessoa = (Pessoa) criteria.uniqueResult();
        } catch (Exception ex) {

            System.err.println(ex + " " + ex.getMessage());
        } finally {

            this.session.close();
            return pessoa;
        }
    }

    @Override
    public List<Pessoa> lista() {
        this.session = null;
        this.session = HibernateUtil.openSession();

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        try {
            Criteria criteria = this.session.createCriteria(Pessoa.class);
            pessoas = (List<Pessoa>) criteria.list();
        } catch (Exception ex) {

            System.err.println(ex + " " + ex.getMessage());
        } finally {

            this.session.close();
            return pessoas;
        }

    }

    @Override
    public void edit(Pessoa pessoa) {
        Transaction tx = null;

        try {
            this.session = HibernateUtil.openSession();
            tx = this.session.beginTransaction();
            this.session.update(pessoa);
            this.session.flush();
            tx.commit();
        } catch (Exception ex) {

            System.err.println(ex + " " + ex.getMessage());
        } finally {

            this.session.close();
        }

    }

    @Override
    public void delete(Pessoa pessoa) {
        Transaction tx = null;

        try {
            this.session = HibernateUtil.openSession();
            tx = this.session.beginTransaction();
            this.session.delete(pessoa);
            this.session.flush();
            tx.commit();
        } catch (Exception ex) {

            System.err.println(ex + " " + ex.getMessage());
        } finally {

            this.session.close();
        }
    }
}
