public class Veiculo {
    private String placa;
    private String modelo;
    private double capacidadeTanque;
    private double combustivelAtual;

    // 1. Construtor com valores padrão
    public Veiculo() {
        this.placa = "AAA-0000";
        this.modelo = "Modelo Base";
        this.capacidadeTanque = 50.0;
        this.combustivelAtual = 0.0;
    }

    // 2. Construtor parametrizado
    public Veiculo(String placa, String modelo, double capacidadeTanque, double combustivelAtual) {
        setPlaca(placa);
        this.modelo = modelo;
        this.capacidadeTanque = capacidadeTanque > 0 ? capacidadeTanque : 50.0;
        setCombustivelAtual(combustivelAtual);
    }

    // --- Métodos Específicos ---

    // Método 1: Abastecer com validação
    public void abastecer(double litros) {
        if (litros > 0 && (combustivelAtual + litros <= capacidadeTanque)) {
            this.combustivelAtual += litros;
            System.out.println("Abastecimento realizado com sucesso!");
        } else {
            System.out.println("Erro: Quantidade excede a capacidade ou valor inválido.");
        }
    }

    // Método 2: Calcular autonomia estimada (Ex: média de 10km/L)
    public double calcularAutonomia() {
        return this.combustivelAtual * 10.0;
    }

    // --- Validações e Acessores ---

    public void setPlaca(String placa) {
        if (placa != null && placa.length() >= 7) {
            this.placa = placa.toUpperCase();
        } else {
            this.placa = "INVALIDO";
        }
    }

    public void setCombustivelAtual(double combustivelAtual) {
        if (combustivelAtual >= 0 && combustivelAtual <= this.capacidadeTanque) {
            this.combustivelAtual = combustivelAtual;
        } else {
            this.combustivelAtual = 0;
        }
    }

    // Getters e Setters restantes omitidos para brevidade, mas devem ser incluídos

    // Método toString sobrescrito
    @Override
    public String toString() {
        return String.format("Veículo [Modelo: %s | Placa: %s | Tanque: %.1fL / %.1fL | Autonomia: %.1f km]",
                modelo, placa, combustivelAtual, capacidadeTanque, calcularAutonomia());
    }
}
