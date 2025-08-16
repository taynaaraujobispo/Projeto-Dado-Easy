package sp.senac.dado;

public class Dado {
    private int faces;

    public Dado (int faces){
        this.faces = faces;
    }

    public int rolar() {
        return (int) (Math.random() *faces) + 1;
    }

    public int getFaces(){
        return faces;
    }
}
