package edu.webservice.RestProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //Esta anotation marca para o Spring o responsavel por receber as requisicoes Web.
public class MyController {
    // @GetMapping(“/hello”) usada para mapear requisições HTTP do tipo GET para um método específico. Ou seja, este método hello() será chamado quando uma solicitação GET for feita para a URL especificada.http://localhost:8080/hello.
		@GetMapping("/hello")
        @ResponseBody //Diz ao Spring Boot que o valor retornado pelo método deve ser o corpo da resposta HTTP. Ou seja, em vez de procurar uma página ou um template, o Spring apenas enviará o valor retornado diretamente na resposta HTTP.
		//O método hello() recebe um parâmetro do tipo String chamado name e, em seguida, combina esse parâmetro com a palavra "Hello" no return. Passando um parametro como "Amy" na solicitação, a resposta seria "Hello Amy" (http://localhost:8080/hello?name=Amy).
        // o @RequestParam diz ao Spring para esperar um valor name na solicitação, mas se não estiver lá, ele usará a palavra "World" por padrão.
		public String hello(@RequestParam(value = "name", defaultValue = "World") String name) 
		{
			return String.format("Hello %s!", name);
		}

        @GetMapping("/NumeroInteiro")
	    @ResponseBody //Diz ao Spring Boot que o valor retornado pelo método deve ser o corpo da resposta HTTP. Ou seja, em vez de procurar uma página ou um template, o Spring apenas enviará o valor retornado diretamente na resposta HTTP.
        public int getNumeroInteiro() {
            return 100;
        }
        //No caso deste exemplo, o valor retornado é um número inteiro (no caso, 100), e esse número será retornado como resposta diretamente ao cliente que fez a requisição GET.

}
