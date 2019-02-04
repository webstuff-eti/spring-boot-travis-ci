package br.eti.webstuff.api.controller;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.util.Optional;

import javax.servlet.RequestDispatcher;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.eti.webstuff.api.entities.Empresa;
import br.eti.webstuff.api.repositories.builder.DadosComuns;
import br.eti.webstuff.api.service.EmpresaService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EmpresaControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmpresaService empresaService;

	private static final String BUSCAR_EMPRESA_CNPJ_URL = "/api/empresa/cnpj/";
	
	private static final String URI_VALIDA = "/api/empresa/cnpj/";
	
	private static final String URI_INVALIDA = "/api/empresa/";
	private static final Long ID = Long.valueOf(1);
	private static final String CNPJ = "33637290000138";
	private static final String CNPJ_INEXISTENTE = "99637290019837";
	private static final String RAZAO_SOCIAL = "Web Stuff";
	
	
	@Before
	public void setUp() {
		
		BDDMockito.given(this.empresaService.buscarPorCnpj(Mockito.anyString())).willReturn(Optional.empty());
		BDDMockito.given(this.empresaService.buscarPorCnpj(Mockito.anyString())).willReturn(Optional.of(this.obterDadosEmpresa()));
	}
	
	
	@Test
    public void testBuscarEmpresaComMetodoInvalido() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(URI_INVALIDA)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isMethodNotAllowed());   	
    }
	
	@Test
    public void testBuscarEmpresaComURIInvalida() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.get(URI_INVALIDA + CNPJ)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());   
    }
	

	@Test
	public void testBuscarEmpresaCnpjValido() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(BUSCAR_EMPRESA_CNPJ_URL + CNPJ)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect( status().isOk() )
				.andExpect(jsonPath("$.data.id").value(ID))
				.andExpect(jsonPath("$.data.razaoSocial", equalTo(RAZAO_SOCIAL)))
				.andExpect(jsonPath("$.data.cnpj", equalTo(CNPJ)))
				.andExpect(jsonPath("$.errors").isEmpty());
	}
	
	@Test
	public void errorURI() throws Exception {
	    mvc.perform(get("/error")
	                    .requestAttr(RequestDispatcher.ERROR_STATUS_CODE, 400)
	                    .requestAttr(RequestDispatcher.ERROR_REQUEST_URI, "/notes")
	                    .requestAttr(RequestDispatcher.ERROR_MESSAGE, "A tag 'MockMvcRequestBuilders.get(/api/empresa/cnpj/99637290019837"))
	                    .andDo(print()).andExpect(status().isBadRequest())
	                    .andExpect(jsonPath("error", is("Bad Request")))
	                    .andExpect(jsonPath("timestamp", is(notNullValue())))
	                    .andExpect(jsonPath("status", is(400)))
	                    .andExpect(jsonPath("path", is(notNullValue()))); 
	}
	
	
	//FIXEME: Implementando Teste para CNPJ Inexistente
	/*
	@Test
    public void testBuscarEmpresaCnpjNaoExiste() throws Exception {
		
	//	BDDMockito.given(this.empresaService.buscarPorCnpj(Mockito.anyString())).willReturn(Optional.empty());
		
		mvc.perform(MockMvcRequestBuilders.get(URI_VALIDA + CNPJ_INEXISTENTE).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.errors").value(null));
    }
    */
	
	

	private Empresa obterDadosEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setId(ID);
		empresa.setRazaoSocial(RAZAO_SOCIAL);
		empresa.setCnpj(CNPJ);
		return empresa;
	}

}
