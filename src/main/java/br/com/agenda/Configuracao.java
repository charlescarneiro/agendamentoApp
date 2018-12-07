package br.com.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Configuracao extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));

	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){//cria um bean Hibernate
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.POSTGRESQL);
		adapter.setShowSql(true);//mostrar codigo sql no console.
		adapter.setGenerateDdl(true);//habilita para que o hibernate crie as tabelas automaticamente.
		adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQL9Dialect");
		return adapter;
	}
	
}
