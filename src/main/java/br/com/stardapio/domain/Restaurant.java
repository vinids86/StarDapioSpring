package br.com.stardapio.domain;

public class Restaurant {
	private String nome;
	private String end;
	private int picRes;

	public Restaurant() {}

	// Inicialmente sera usado para identificar o restaurante nas chamadas ao WS
	@Override
	public String toString() {
		return nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getPicRes() {
		return picRes;
	}

	public void setPicRes(int picRes) {
		this.picRes = picRes;
	}

}