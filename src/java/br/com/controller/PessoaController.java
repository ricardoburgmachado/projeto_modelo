package br.com.controller;

/**
 *
 * @author Ricardo
 */
import br.com.dao.PessoaDAO;
import br.com.dao.PessoaHibernate;
import br.com.model.Pessoa;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ricardo Machado
 */
@Controller
public class PessoaController {

    
    @RequestMapping("/pessoa_adiciona")    
    public String adiciona(@ModelAttribute Pessoa p_param) {

        PessoaHibernate hibernate = new PessoaHibernate();
        System.out.println(hibernate.insert(p_param));
        
        //if (result.hasFieldErrors("errors")) {
        //    return new ModelAndView("pessoa_adiciona");
        //}
        return "redirect:pessoa_lista_show";
    }

    @RequestMapping("/pessoa_adiciona_show")
    public ModelAndView adicionaShow() {
        return new ModelAndView("pessoa_adiciona");
    }

    @RequestMapping("/pessoa_edita")
    public String edita(@ModelAttribute Pessoa p_param) {

        PessoaHibernate hibernate = new PessoaHibernate();
        hibernate.edit(p_param);

        return "redirect:pessoa_lista_show";
    }

    @RequestMapping("/pessoa_edita_show")
    public ModelAndView editaShow(@RequestParam int id) {

        PessoaHibernate hibernate = new PessoaHibernate();
        ModelAndView mv = new ModelAndView("pessoa_edita");
        mv.addObject("pessoa", hibernate.get(id));
        return mv;
    }

    @RequestMapping("/pessoa_exclui")
    public ModelAndView exclui(@RequestParam int id) {

        PessoaHibernate hibernate = new PessoaHibernate();        
        hibernate.delete(hibernate.get(id));

        ModelAndView model = new ModelAndView("pessoa_lista");
        
        model.addObject("pessoas", hibernate.lista());
        return model;
    }
    
    
    @RequestMapping("/pessoa_lista_show")
    public ModelAndView listaShow() {

        ModelAndView model = new ModelAndView("pessoa_lista");
        PessoaHibernate hibernate = new PessoaHibernate();
        model.addObject("pessoas", hibernate.lista());
        return model;
    }
}
