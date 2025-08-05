public class Main {
    static class Avatar {
        // Atributos
        private String nome;
        private String tipo;
        private int vida;
        private int ataque;
        
        // Construtor
        public Avatar(String nome, String tipo, int vida, int ataque) {
            this.nome = nome;
            this.tipo = tipo;
            this.vida = vida;
            this.ataque = ataque;
        }
        
        // Métodos
        public void atacar(Avatar alvo) {
            System.out.println(nome + " ataca " + alvo.nome + " com " + ataque + " de dano!");
            alvo.receberDano(this.ataque);
        }
        
        public void receberDano(int dano) {
            vida -= dano;
            System.out.println(nome + " recebeu " + dano + " de dano! Vida restante: " + Math.max(vida, 0));
        }
        
        public void mostrarStatus() {
            System.out.println("\n=== " + nome + " ===");
            System.out.println("Tipo: " + tipo);
            System.out.println("Vida: " + Math.max(vida, 0));
            System.out.println("Ataque: " + ataque);
        }

        // Método para verificar se o avatar está vivo
        public boolean estaVivo() {
            return vida > 0;
        }
    }
    
    public static void main(String[] args) {
        // Construindo os avatares
        Avatar heroi = new Avatar("Herói", "Aliado", 100, 20);
        Avatar heroina = new Avatar("Heroína", "Aliada", 90, 25);
        Avatar inimigoSoldado = new Avatar("Soldado", "Inimigo", 200, 30);
        Avatar inimigoCapanga = new Avatar("Capanga", "Inimigo", 70, 15);
        
        // Mostrando status iniciais
        System.out.println("=== STATUS INICIAIS ===");
        heroi.mostrarStatus();
        heroina.mostrarStatus();
        inimigoSoldado.mostrarStatus();
        inimigoCapanga.mostrarStatus();
        
        // Simulando batalha
        System.out.println("\n--- BATALHA ---");
        
        // Herói ataca o Capanga
        heroi.atacar(inimigoCapanga);
        
        // Heroína ataca o Soldado
        heroina.atacar(inimigoSoldado);
        
        // Soldado ataca o Herói
        inimigoSoldado.atacar(heroi);
        
        // Capanga ataca a Heroína
        inimigoCapanga.atacar(heroina);
        
        // Exemplo de uma segunda rodada de ataques para ilustrar a dinâmica
        System.out.println("\n--- SEGUNDA RODADA ---");
        
        if (heroi.estaVivo()) {
            heroi.atacar(inimigoSoldado);
        }
        
        if (heroina.estaVivo()) {
            heroina.atacar(inimigoCapanga);
        }
        
        if (inimigoSoldado.estaVivo()) {
            inimigoSoldado.atacar(heroi);
        }
        
        if (inimigoCapanga.estaVivo()) {
            inimigoCapanga.atacar(heroina);
        }

        // Status finais
        System.out.println("\n=== STATUS FINAIS ===");
        heroi.mostrarStatus();
        heroina.mostrarStatus();
        inimigoSoldado.mostrarStatus();
        inimigoCapanga.mostrarStatus();
    }
}
