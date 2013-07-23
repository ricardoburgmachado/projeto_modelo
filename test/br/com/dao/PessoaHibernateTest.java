/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Pessoa;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class PessoaHibernateTest {

    private static PessoaHibernate pessoaHibernate;
    private static Pessoa p1, p2, p3;

    public PessoaHibernateTest() {

    }

    @BeforeClass
    public static void setUpClass() {
        
        if(pessoaHibernate == null){
            
            pessoaHibernate = new PessoaHibernate();
        }

        List<Pessoa> pessoas = pessoaHibernate.lista();
        for (Pessoa pessoa : pessoas) {

            pessoaHibernate.delete(pessoa);
        }

        p1 = new Pessoa("Pessoa 1", "pessoa1@mail.com");
        p1.setDataNasc(new Date(90, 3, 2));

        p2 = new Pessoa("Pessoa 2", "pessoa2@mail.com");
        p2.setDataNasc(new Date(92, 7, 13));

        p3 = new Pessoa("Pessoa 3", "pessoa2@mail.com");
        p3.setDataNasc(new Date(91, 10, 25));
        
        pessoaHibernate.insert(p1);
        pessoaHibernate.insert(p2);
        pessoaHibernate.insert(p3);
    }

    @AfterClass
    public static void tearDownClass() {
        
        pessoaHibernate = null;
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {

    }

    /**
     * Test of insert method, of class PessoaHibernate.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Pessoa pessoa = new Pessoa("Pessoa Insert", "insert@mail.com");
        pessoa.setDataNasc(new Date(88, 6, 18));
        int id = pessoaHibernate.insert(pessoa);
        Pessoa pessoaTest = pessoaHibernate.get(id);
        assertEquals(pessoa.getId(), pessoaTest.getId());
        assertEquals(pessoa.getDataNasc(), pessoaTest.getDataNasc());
        assertEquals(pessoa.getEmail(), pessoaTest.getEmail());
        assertEquals(pessoa.getNome(), pessoaTest.getNome());
    }

    /**
     * Test of get method, of class PessoaHibernate.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Pessoa pTest = pessoaHibernate.get(p1.getId());
        assertEquals(p1.getId(), pTest.getId());
        assertEquals(p1.getDataNasc(), pTest.getDataNasc());
        assertEquals(p1.getEmail(), pTest.getEmail());
        assertEquals(p1.getNome(), pTest.getNome());
    }

    /**
     * Test of edit method, of class PessoaHibernate.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        p2.setEmail("p2alterado@gmail.com");
        p2.setNome("Pessoa alterada");
        pessoaHibernate.edit(p2);
        
        Pessoa pTest = pessoaHibernate.get(p2.getId());
        assertEquals(p2.getId(), pTest.getId());
        assertEquals(p2.getDataNasc(), pTest.getDataNasc());
        assertEquals(p2.getEmail(), pTest.getEmail());
        assertEquals(p2.getNome(), pTest.getNome());
    }

    /**
     * Test of delete method, of class PessoaHibernate.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        pessoaHibernate.delete(p3);
        Pessoa pTest = pessoaHibernate.get(p3.getId());
        assertEquals(pTest, null);
    }
}