package br.gov.sp.fatec.controller;

import br.gov.sp.fatec.model.Caminhao;
import br.gov.sp.fatec.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@RestController
@RequestMapping(value = "/caminhoes")
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

    public void setCaminhaoService(CaminhaoService caminhaoService) {
        this.caminhaoService = caminhaoService;
    }

    @RequestMapping(value = "/get/{nome}")
    @JsonView(View.All.class)
    public ResponseEntity<Collection<Caminhao>> pesquisar(@PathVariable("nome") String nome) {
        return new ResponseEntity<Collection<Caminhao>>(caminhaoService.buscar(nome), HttpStatus.OK);
    }

    @RequestMapping(value = "/getById")
    @JsonView(View.All.class)
    public ResponseEntity<Caminhao> get(@RequestParam(value = "id", defaultValue = "1") Long id) {
        Caminhao caminhao = caminhaoService.buscarPorId(id);
        if (caminhao == null) {
            return new ResponseEntity<Caminhao>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Caminhao>(caminhao, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll")
    @JsonView(View.Alternative.class)
    public ResponseEntity<Collection<Caminhao>> getAll() {
        return new ResponseEntity<Collection<Caminhao>>(caminhaoService.carregarTodos(), HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.All.class)
    @ResponseStatus(HttpStatus.CREATED)
    public Caminhao save(@RequestBody Caminhao caminhao, HttpServletRequest request,
                        HttpServletResponse response) {
        caminhao = caminhaoService.salvar(caminhao);
        response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() +
                request.getContextPath() + "/caminhao/getById?id=" + caminhao.getId());
        return caminhao;
    }
}
