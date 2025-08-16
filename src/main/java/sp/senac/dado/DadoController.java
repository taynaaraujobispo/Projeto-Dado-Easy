package sp.senac.dado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DadoController {

    private List<Dado> dados = new ArrayList<>(List.of(
        new Dado(6),
        new Dado(20)
   ));

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("dados", dados);
        return "index";
    }

    @GetMapping("/rolar")
    public String rolarDado(@RequestParam int faces, Model model) {
        Dado dado = new Dado(faces);
        int resultado = dado.rolar();
        model.addAttribute("dados", dados);
        model.addAttribute("resultado", resultado);
        return "index";
    }

    @GetMapping("/novo-dado")
    public String novoDadoForm() {
        return "novo-dado";
    }

    @PostMapping("/novo-dado")
    public String criarDado(@RequestParam int faces) {
        if (faces > 0) {
            dados.add(new Dado(faces));
        }
        return "redirect:/";
    }
}