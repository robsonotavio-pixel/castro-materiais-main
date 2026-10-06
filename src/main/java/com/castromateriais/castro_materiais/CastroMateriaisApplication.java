package com.castromateriais.castro_materiais;

import com.castromateriais.castro_materiais.Repository.UsuarioRepository;
import com.castromateriais.castro_materiais.model.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CastroMateriaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CastroMateriaisApplication.class, args);
	}

	@Bean
	CommandLineRunner criarUsuarioPadrao(UsuarioRepository usuarioRepository) {
		return args -> {
			if (usuarioRepository.findByEmail("admin@castro.com").isEmpty()) {
				Usuario admin = new Usuario();
				admin.setEmail("admin@castro.com");
				admin.setSenha("admin123");
				usuarioRepository.save(admin);
			}
		};
	}
}
