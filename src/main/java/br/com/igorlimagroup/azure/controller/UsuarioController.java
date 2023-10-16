package br.com.igorlimagroup.azure.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igorlimagroup.azure.model.Usuario;
import br.com.igorlimagroup.azure.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/list")
	public ResponseEntity<Object> getUsuarios() {

		List<Usuario> usuarios = null;

		try {

			usuarios = usuarioRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return generateResponse("Erro ao Retornar Dados!", HttpStatus.BAD_REQUEST, usuarios);
		}

		return generateResponse("Dados Retornados com Sucesso!", HttpStatus.OK, usuarios);
	}

	@PostMapping("/save")
	public ResponseEntity<Object> save(@RequestBody Usuario usuario) {
		Usuario usuarioJ = new Usuario();
		Usuario usuarioProd = null;
		try {
			usuarioJ.setNome(usuario.getNome());
			usuarioJ.setSobrenome(usuario.getSobrenome());
			usuarioJ.setEmail(usuario.getEmail());
			usuarioProd = usuarioRepository.save(usuarioJ);
		} catch (Exception e) {
			e.printStackTrace();

			return generateResponse("Erro ao Salvar Usuário!", HttpStatus.BAD_REQUEST, usuarioProd);
		}


		return generateResponse("Usuário Salvo com Sucesso!", HttpStatus.OK, usuarioProd);
	}

	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			map.put("message", message);
			map.put("status", status.value());
			map.put("data", responseObj);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(status);

		}

		return new ResponseEntity<Object>(map,status);
	}

}