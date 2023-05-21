package br.com.reservas.model;

public enum StatusReserva {

	RESERVA_REALIZADA(1, "Reserva Realizada"), 
	RESERVA_ATIVA(2, "Reserva Ativa"), 
	RESERVA_FINALIZADA(3, "Reserva Finalizada"),
	RESERVA_CANCELADA_HOTEL(4, "Reserva Cancelada pelo Hotel"), 
	RESERVA_CANCELADA_CLIENTE(5, "Reserva Cancelada pelo Cliente");

	private Integer id;

	private String nome;

	private StatusReserva(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public static StatusReserva getMenuOfId(Integer id) {
		for (StatusReserva menu : values()) {
			if (menu.getId() == id) {
				return menu;
			}
		}
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
