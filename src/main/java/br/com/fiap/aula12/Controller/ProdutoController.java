package br.com.fiap.aula12.Controller;

import br.com.fiap.aula12.Produto;
import br.com.fiap.aula12.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/produto/cadastrar")
    public String abrirFormulario(){
        return "form";
    }

    @PostMapping("/produto/cadastrar")
            public String processarForm(Produto produto){
        repository.save(produto);
        System.out.print(produto.getNome() + "" + produto.getPreco());
        return "sucesso";
    }

  @GetMapping("/produto/buscar")
        public String listaProduto(){
        return "buscar";
  }

  @PostMapping("/produto/buscar")
    public String processarLista(int codigo, Model model){
      Optional<Produto> listaProduto = repository.findById(codigo) ;
      model.addAttribute("prod", listaProduto);
      return "listarProduto";
  }

}
