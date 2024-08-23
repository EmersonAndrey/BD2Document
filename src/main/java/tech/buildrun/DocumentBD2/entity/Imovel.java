package tech.buildrun.DocumentBD2.entity;

import java.util.List;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Imovel{
	
	private String imovelId;
    private String tipo;
    private double preco;
    private String status;
    private Endereco endereco;
    private List<Cliente> clientesInteressados;
    
    @DynamoDbPartitionKey
	@DynamoDbAttribute("imovelId")
	public String getImovelId() {
		return imovelId;
	}
	public void setImovelId(String imovelId) {
		this.imovelId = imovelId;
	}
	
	@DynamoDbAttribute("tipo")
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@DynamoDbAttribute("endereco")
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@DynamoDbAttribute("preco")
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@DynamoDbAttribute("status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@DynamoDbAttribute("clienteInteressados")
	public List<Cliente> getClientesInteressados() {
		return clientesInteressados;
	}
	public void setClientesInteressados(List<Cliente> clientesInteressados) {
		this.clientesInteressados = clientesInteressados;
	}
    
	@DynamoDbBean
	public static class Endereco{
		
		private String rua;
		private String cidade;
		private String CEP;
		
		@DynamoDbAttribute("rua")
		public String getRua() {
			return rua;
		}
		public void setRua(String rua) {
			this.rua = rua;
		}
		
		@DynamoDbAttribute("cidade")
		public String getCidade() {
			return cidade;
		}
		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
		
		@DynamoDbAttribute("cep")
		public String getCEP() {
			return CEP;
		}
		public void setCEP(String cEP) {
			CEP = cEP;
		}
		
	}
	
}
