package com.sancarest.restaurante.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sancarest.restaurante.model.Usuario;
import com.sancarest.restaurante.repository.UsuarioRepository;
import com.sancarest.restaurante.responses.BaseResponse;
import com.sancarest.restaurante.responses.CreatedUserResponse;
import com.sancarest.restaurante.responses.FailedResponse;
import com.sancarest.restaurante.responses.UserLoggedResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("usuarios")
@Api(value = "Endpoint de usuarios")
@CrossOrigin("*")
public class UsuarioEndpoint {
	
	@Autowired
	UsuarioRepository repository;
	
	@PostMapping
	@ApiOperation(value = "Cadastra um novo usuario e retorna seu id")
	public BaseResponse cadastrarUsuario(@RequestBody Usuario usuario) {
		try {
			Usuario usuarioCadastrado = repository.save(usuario);
			return new CreatedUserResponse("Usuario cadastrado com sucesso", usuarioCadastrado.getNomeUsuario());
		} catch(Exception e) {
			return new FailedResponse("Falha ao cadastrar usuario");
		}
	}
	
	@PostMapping("/token")
	@ApiOperation(value = "Autentica o usuario e retorna seu token")
	public BaseResponse recuperarTokenDeAutenticacao(@RequestBody Usuario usuario) {
		try {
			Usuario usuarioLogado = repository.findByNomeUsuarioAndSenha(usuario.getNomeUsuario(), usuario.getSenha());
			if(usuarioLogado != null) {
				return new UserLoggedResponse("Usuario logado com sucesso", usuarioLogado.getNomeUsuario());
			} else {
				return new FailedResponse("Usuario ou senha incorretos");
			}
		} catch(Exception e) {
			return new FailedResponse("Falha ao fazer login");
		}
	}

}
