package com.spring.blog.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Imagem")
public class ImagemController {

	@RequestMapping("/")
	public String index() {
		return "post";
	}

	private static String caminhoImagens = "/home/Pedro/Documents/imagens/";

	@GetMapping("/mostrarImagem/{imagem}")
	public byte[] retornarImagem(@PathVariable("imagem") String imagem) throws IOException {
//			System.out.println(Image);
		File imagemArquivo = new File(caminhoImagens + imagem);
		if (imagem != null || imagem.trim().length() > 0) {
			System.out.println("No IF");
			return Files.readAllBytes(imagemArquivo.toPath());
		}
		return null;
	}
}
