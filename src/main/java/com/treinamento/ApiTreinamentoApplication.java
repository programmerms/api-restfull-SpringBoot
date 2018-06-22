package com.treinamento;

import com.treinamento.api.security.entities.Usuario;
import com.treinamento.api.security.enums.PerfilEnum;
import com.treinamento.api.security.repositories.UsuarioRepository;
import com.treinamento.api.services.ExemploCacheService;
import com.treinamento.api.utils.SenhaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class ApiTreinamentoApplication {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ExemploCacheService exemploCacheService;

    public static void main(String[] args) {
        SpringApplication.run(ApiTreinamentoApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {

            Usuario usuario = new Usuario();
            usuario.setEmail("usuario@email.com");
            usuario.setPerfil(PerfilEnum.ROLE_USUARIO);
            usuario.setSenha(SenhaUtils.gerarBCrypt("123456"));
            this.usuarioRepository.save(usuario);

            Usuario admin = new Usuario();
            admin.setEmail("admin@email.com");
            admin.setPerfil(PerfilEnum.ROLE_ADMIN);
            admin.setSenha(SenhaUtils.gerarBCrypt("123456"));
            this.usuarioRepository.save(admin);

            /*
            System.out.println("Executando serviço pela primeira vez: ");
            System.out.println(this.exemploCacheService.exemploCache());

            System.out.println("Executando serviço pela segunda vez, deve obter dados do cache: ");
            System.out.println(this.exemploCacheService.exemploCache());
*/


        };

    }





}
