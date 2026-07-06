public class VertexArray {
    public static final int LineStrip = 0;

    public static class Vertice {
        public Vetor2f position;
        public Cor color;

        public Vertice() {
            this.position = new Vetor2f(0, 0);
            this.color = new Cor(255, 255, 255);
        }
    }

    private int tipoPrimitiva;
    private Vertice[] vertices;

    public VertexArray(int tipoPrimitiva, int contagem) {
        this.tipoPrimitiva = tipoPrimitiva;
        this.vertices = new Vertice[contagem];
        for (int i = 0; i < contagem; i++) {
            this.vertices[i] = new Vertice();
        }
    }

    public Vertice get(int i) {
        return vertices[i];
    }

    public int getVertexCount() {
        return vertices.length;
    }

    public int getTipoPrimitiva() {
        return tipoPrimitiva;
    }
}
