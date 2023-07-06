package com.puchocoding.app.categoria;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class CategoriaRepositoryTest {

	@Autowired
	private CategoriaRepository repositorio;
	
	@Test
	public void testCrearCategoria() {
		Categoria categoriaGuardada = repositorio.save(new Categoria("Electronicos"));
		assertThat(categoriaGuardada.getId()).isGreaterThan(0);
	}

}
