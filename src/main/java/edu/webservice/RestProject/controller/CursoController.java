package edu.webservice.RestProject.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.webservice.RestProject.domain.Curso;

@Controller //Esta anotation marca para o Spring o responsavel por receber as requisicoes Web.
public class CursoController {
    //Atibuto para gerar um id a cada chamada do controller
    private final AtomicLong contador = new AtomicLong();
    // @GetMapping(“/curso”) usada para mapear requisições HTTP do tipo GET para um método específico. Ou seja, este método curso() será chamado quando uma solicitação GET for feita para a URL especificada.http://localhost:8080/curso.
		@GetMapping("/curso")
        @ResponseBody //Diz ao Spring Boot que o valor retornado pelo método deve ser o corpo da resposta HTTP. Ou seja, em vez de procurar uma página ou um template, o Spring apenas enviará o valor retornado diretamente na resposta HTTP.
		//O método curso() recebe um parâmetro do tipo String chamado name e, em seguida, combina esse parâmetro com a palavra "curso" no return. Passando um parametro como "Amy" na solicitação, a resposta seria "curso Amy" (http://localhost:8080/curso?name=Amy).
        // o @RequestParam diz ao Spring para esperar um valor name na solicitação, mas se não estiver lá, ele usará a palavra "World" por padrão.
		public Curso curso(@RequestParam(value = "name", defaultValue = "Curso desconhecido") String name, @RequestParam(value = "ch", defaultValue = "0") int cargaHoraria) 
		{
			return new Curso(contador.incrementAndGet(), String.format("%s", name), cargaHoraria);
		}

}
