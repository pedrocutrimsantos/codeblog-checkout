package com.spring.blog.utils;

import com.spring.blog.model.Post;
import com.spring.blog.model.Produto;
import com.spring.blog.repository.BlogRepository;
import com.spring.blog.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/PopularBanco")
public class DummyData {

	@Autowired
	BlogRepository blogRepository;
	@Autowired
	ProdutoRepository produtoRepository;

	@PostConstruct
	public void savePosts() {

		List<Post> postList = new ArrayList<>();

		Post post1 = new Post();
		post1.setAutor("Fulano de Tal");
		post1.setData(LocalDate.now());
		post1.setTitulo("Docker");
		post1.setTexto(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

		postList.add(post1);

		for (Post post : postList) {
			Post postSaved = blogRepository.save(post);
			System.out.println(postSaved.getId());
		}
	}

	@PostConstruct
	public void savePosts2() {

		List<Produto> produtoList = new ArrayList<>();

		Produto produto1 = new Produto();
		produto1.setCategoria("Beleza");
		produto1.setDescricao("ProdutoParaTodasasIdades");
		produto1.setMarca("Avon");
		produto1.setNomeImagem("img.png");
		produto1.setQuantidadeEstoque(null);
		produto1.setValorVenda(null);
		;

		produtoList.add(produto1);

		/*
		 * for(Post post: postList){ Post postSaved = produtoRepository.save(post);
		 * System.out.println(postSaved.getId()); }
		 */
	}
}
