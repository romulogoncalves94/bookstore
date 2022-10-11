package com.romulo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romulo.bookstore.domain.Categoria;
import com.romulo.bookstore.domain.Livro;
import com.romulo.bookstore.repositories.CategoriaRepository;
import com.romulo.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros TI");
		Categoria cat2 = new Categoria(null, "Ficção", "Ficção Cientifica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");

		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "Machine", "Wells", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "War of the Word", "Wells", "Lorem ipsum", cat2);
		Livro l5 = new Livro(null, "Robot", "Asimov", "Lorem ipsum", cat3);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4));
		cat3.getLivros().addAll(Arrays.asList(l5));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
