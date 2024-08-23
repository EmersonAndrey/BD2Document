package tech.buildrun.DocumentBD2.entity;

import java.util.List;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Corretor {

    private String corretorId;
    private String nome;
    private String email;   
    private String telefone;   
    private List<Imovel> imoveis;
    
    @DynamoDbPartitionKey
	@DynamoDbAttribute("corretorId")
	public String getCorretorId() {
		return corretorId;
	}
	public void setCorretorId(String corretorId) {
		this.corretorId = corretorId;
	}
	
	@DynamoDbAttribute("nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@DynamoDbAttribute("email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@DynamoDbAttribute("telefone")
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@DynamoDbAttribute("imoveis")
	public List<Imovel> getImoveis() {
		return imoveis;
	}
	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}
    

}