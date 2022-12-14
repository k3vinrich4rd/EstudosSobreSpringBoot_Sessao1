package vendas.vendas;
// Todos os pacotes são lidos automaticamente pelo SpringBoot
//O @ComponentScan Serve para se especificar quais são os componentes
//@ComponentScan(
//		basePackages = {
//				"vendas.vendas.controller",
//				"outropacote"
//		} )
// ou classes de configuração e pacotes que serão lidos e Scanneados
// É mais usado quando vamos ler pacotes externos

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.SpinnerUI;

@SpringBootApplication
@RestController
public class VendasApplication {


    /*	Primeira forma de se fazer (Utilizando Bean e configuration
        @Autowired
        @Qualifier("applicationName")

     */
    //Segunda forma de se fazer (Utilizando application properties e configuration)
    @Value("${application.name}")
    private String applicationName;

    @Cachorro
    private Animal animal;


    @Bean(name = "executarAnimal")
    public CommandLineRunner executar() {
        return args -> {
            animal.fazerBarulho();
        };
    }

    @GetMapping(path = "/hello")
    public String helloWorld() {
        return applicationName;
    }


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
