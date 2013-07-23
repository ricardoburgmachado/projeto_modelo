/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Pessoa;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public interface PessoaDAO {
    
    public Integer insert(Pessoa pessoa);
    
    public Pessoa get(Integer id);
    
    public List<Pessoa> lista();
    
    public void edit(Pessoa pessoa);
    
    public void delete(Pessoa pessoa);
    
    
    
}
