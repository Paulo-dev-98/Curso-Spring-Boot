package br.com.erudio.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.repository.UserRepository;
import br.com.erudio.seguranca.CredenciaisDeContaVO;
import br.com.erudio.seguranca.jwt.JwtTokenProvider;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtTokenProvider tokenProvider;
	
	@Autowired
	UserRepository repository;
	
	@ApiOperation("autenticando um usuario atravez de credenciais.")
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/signin",  produces = { "application/json", "application/xml", "application/x-yaml" }, 
		         consumes = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity sighin(@RequestBody CredenciaisDeContaVO data) {

		try {
			var username = data.getUsername();
			var password = data.getPassword();
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			var user = repository.findByUserName(username);
			var token = "";
			
			if(user != null) {
				token = tokenProvider.createToken(username, user.GetRoles());
			}else {
				throw new UsernameNotFoundException("username not found" + username);
			}
			
			Map<Object, Object> model = new HashMap<>();
			
			model.put("username", username);
			model.put("token", token);
			return ok(model);
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("credencial invalida");
		}
		
   }
	
}