package br.com.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.pessoa.db.h2.model.Contato;
import br.com.pessoa.db.h2.model.Endereco;
import br.com.pessoa.db.h2.model.Estado;
import br.com.pessoa.db.h2.model.Municipio;
import br.com.pessoa.db.h2.model.Pessoa;
import br.com.pessoa.db.h2.model.Usuario;
import br.com.pessoa.enums.TipoPerfil;
import br.com.pessoa.enums.TipoPessoa;
import br.com.pessoa.enums.TipoSexo;
import br.com.pessoa.db.h2.repository.MunicipioRepository;
import br.com.pessoa.db.h2.repository.PessoaRepository;
import br.com.pessoa.db.h2.repository.UsuarioRepository;

@SpringBootApplication
public class PessoaApplication implements CommandLineRunner {

	@Autowired
	private MunicipioRepository municipioRepository;

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	public static void main(String[] args) {
		SpringApplication.run(PessoaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estado distritoFederal = new Estado("Distrito Federal","DF");
		Municipio brasilia = new Municipio("Brasília",distritoFederal);
		municipioRepository.save(brasilia);

		Endereco endereco = new Endereco("Cond Residencial Conjunto c casa ","23","N/a",brasilia);
		Contato contato = new Contato("daylansantos@gmail.com","32011632","6191602632");
		Pessoa pf = new Pessoa("DAILAN BUENO DOS SANTOS", null, "045.013.481-43",null, TipoSexo.MASCULINO, TipoPessoa.FISICA,contato,endereco);
		
		Contato contatoPj = new Contato("mr2inkjet@gmail.com","32011632","6191602632");

		Endereco enderecoPj = new Endereco("CA 01 CONJUNTO F LOJA" ,"58","N/A",brasilia);
		Pessoa pj = new Pessoa("MR2 INKJET LTDA", null, null,"78.460.600/0001-20", null, TipoPessoa.JURIDICA,contatoPj,enderecoPj);
		pessoaRepository.save(pf);
		pessoaRepository.save(pj);
		
		Pessoa  p = pessoaRepository.recuperarPessoaPorCpf("045.013.481-43").get(0);
		Usuario dailanUser = new Usuario("dbsantos", passwordEncoder.encode("teste"),p,TipoPerfil.ROLE_ADMIN);
		
		Endereco enderecoEndereco = new Endereco("Cond Residencial Conjunto c casa ","23","N/a",brasilia);
		Contato amandaContato = new Contato("amandadaylan@gmail.com","32011632","6191602632");
		Pessoa amanda = new Pessoa("AMANDA CRISTINA PEREIRA RODRIGUES", null, "049.302.351-89",null, TipoSexo.FEMININO, TipoPessoa.FISICA,amandaContato,enderecoEndereco);
		pessoaRepository.save(amanda);
		
		Usuario amandaUser = new Usuario("rmrodrigues", passwordEncoder.encode("teste"),amanda,TipoPerfil.ROLE_ADMIN);
		
		usuarioRepository.save(dailanUser);
		usuarioRepository.save(amandaUser);
	}
}
