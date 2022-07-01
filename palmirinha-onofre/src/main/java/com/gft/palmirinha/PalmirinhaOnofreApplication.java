package com.gft.palmirinha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gft.palmirinha.entities.Ingredientes;
import com.gft.palmirinha.entities.Receitas;
import com.gft.palmirinha.entities.UnidadeMedida;
import com.gft.palmirinha.repositories.IngredientesRepository;
import com.gft.palmirinha.repositories.ReceitasRepository;
import com.gft.palmirinha.repositories.UnidadeMedidaRepository;

@SpringBootApplication
public class PalmirinhaOnofreApplication implements CommandLineRunner {

	@Autowired
	private ReceitasRepository receitasRepository;
	
	@Autowired
	private IngredientesRepository ingredientesRepository;
	
	@Autowired
	private UnidadeMedidaRepository unidadeMedidaRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(PalmirinhaOnofreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ingredientes i1 = ingredientesRepository.save(new Ingredientes(1L,"Leite Condensado"));
		Ingredientes i2 = ingredientesRepository.save(new Ingredientes(2L,"Leite"));
		Ingredientes i3 = ingredientesRepository.save(new Ingredientes(3L,"Amido Milho"));
		Ingredientes i4 = ingredientesRepository.save(new Ingredientes(4L,"Ovos"));
		Ingredientes i5 = ingredientesRepository.save(new Ingredientes(5L,"Bis picado"));
		Ingredientes i6 = ingredientesRepository.save(new Ingredientes(6L,"Açucar"));
		Ingredientes i7 = ingredientesRepository.save(new Ingredientes(7L,"Creme De Leite"));
		
		Ingredientes i8 = ingredientesRepository.save(new Ingredientes(8L,"Agua"));
		Ingredientes i9 = ingredientesRepository.save(new Ingredientes(9L,"Leite em Pó"));
		Ingredientes i10 = ingredientesRepository.save(new Ingredientes(10L,"Adoçante culinario"));
		Ingredientes i11= ingredientesRepository.save(new Ingredientes(11L,"Cacau em pó"));
		Ingredientes i12 = ingredientesRepository.save(new Ingredientes(12L,"Amido Milho"));
		Ingredientes i13 = ingredientesRepository.save(new Ingredientes(13L,"Aveia"));
		Ingredientes i14 = ingredientesRepository.save(new Ingredientes(14L,"Essencia de Baunilha"));
		Ingredientes i15= ingredientesRepository.save(new Ingredientes(15L,"Granulado"));
		Ingredientes i16 = ingredientesRepository.save(new Ingredientes(16L,"Amendoin Triturado"));
		
		
		
		UnidadeMedida u = unidadeMedidaRepository.save(new UnidadeMedida(1L,"Xicara"));
		UnidadeMedida u1 = unidadeMedidaRepository.save(new UnidadeMedida(2L,"Colher Sopa"));
		UnidadeMedida u2 = unidadeMedidaRepository.save(new UnidadeMedida(3L,"Colher Cha"));
		UnidadeMedida u3 = unidadeMedidaRepository.save(new UnidadeMedida(4L,"Colher de Cafe"));
		

		
		Receitas r = new Receitas();
		r.setNome("Pave");
		r.setTempoDePreparo("50 minutos");
		r.setModoDePreparo("Misture o leite condensado, o leite, a maisena, as gemas e leve ao fogo, Mexa bem, Forme camadas de chocolate e creme,leve à geladeira até a hora de servir.");
		r.setUnidadeEingrediente("1 lata de leite condensado, 1 litro de leite, 4 colheres Amido Milho, 2 Ovos, 2 Caixas Bis, 1 xicara de Açucar, 1 lata de Creme de leite ");
		
		receitasRepository.save(r);
		
		Receitas r1 = new Receitas();
		r1.setNome("Brigadeiro");
		r1.setTempoDePreparo("30 minutos");
		r1.setModoDePreparo("Adicione todos ingredientes na panela e mexa, Diminua as mexidas quando o brigadeiro começar ferver Espere 5min e retire do fogo ,faça bolinhas e passe no granulado.");
		r1.setUnidadeEingrediente("400ml Agua,4 colheres leite em Po,4 colheres Adoçante culinario,2 colheres Cacau em po,1 colher Amido milho,1 colher Essencia Baunilha,Granulado,Amendoim triturado ");
		receitasRepository.save(r1);
		
		Receitas r2 = new Receitas();
		r2.setNome("Beijinho");
		r2.setTempoDePreparo("20 minutos");
		r2.setModoDePreparo("Numa panela, misture leite condensado,manteiga e coco, Leve ao fogo e misture por 15min, Retire a mistura do fogo e deixe mornar, Modele a massa em formato,passe no coco ralado.PRONTO.");
		r2.setUnidadeEingrediente("2 Latas de leite condensado, 2 colheres de manteiga, 300g de coco ralado, açucar, Cravos-da-India. ");
		receitasRepository.save(r2);
		
		Receitas r3 = new Receitas();
		r3.setNome("Mousse de Limão");
		r3.setTempoDePreparo("10 minutos");
		r3.setModoDePreparo(" Coloque no liquidificador o creme de leite e o leite condensado, Bata um pouco e acrecente suco de limao aos poucos, ficando consistente leve a geladeira.");
		r3.setUnidadeEingrediente("1 lata de leite condensado, 1 lata de creme de leite, 1/2 xicara de suco de limao. ");
		receitasRepository.save(r3);
		
		Receitas r4 = new Receitas();
		r4.setNome("Pudim de tapioca");
		r4.setTempoDePreparo("60 minutos");
		r4.setModoDePreparo("Leve ao fogo leite e tapioca, fazer um mingau e deixar esfriar, Acrescentar o leite conden. e o coco ralado, Bater os ovos no liquid. com o leite de coco, prepare a forma, asse em banho-maria por 40min.");
		r4.setUnidadeEingrediente("1/2 xícara de tapioca granulada, 1/2 l de leite, 1/2 garrafa pequena de leite de coco, 1 pacote de 50 g de coco ralado, 1 lata de leite condensado, 3 ovos. ");
		receitasRepository.save(r4);
	
	}


}
