import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class List2 {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
    
    List<Gato> meusGatos = new ArrayList<Gato>(){{
        add(new Gato("tata", "preto", 8));
        add(new Gato("tata", "azul", 4));
        add(new Gato("fafa", "braco", 9));
        add(new Gato("yaya", "lilas", 5));
    }};    

    System.out.println(meusGatos);  

    Collections.shuffle(meusGatos);

    System.out.println(meusGatos);  

    System.out.println("Ordenando por Idade");
    // Collections.sort(meusGatos, new ComparatorIdade());
    meusGatos.sort(new ComparatorIdade());
    System.out.println(meusGatos);

    System.out.println("Ordenando por Cor");
    // Collections.sort(meusGatos, new ComparatorIdade());
    meusGatos.sort(new ComparatorCor());
    System.out.println(meusGatos);

    System.out.println("Ordenando por Nome/Cor/Idade");
    // Collections.sort(meusGatos, new ComparatorIdade());
    meusGatos.sort(new ComparatorNomeCorIdade());
    System.out.println(meusGatos);

    }


}


class Gato implements Comparable<Gato>{
    private String nome, cor;
    private int idade;
    
    public Gato(String nome, String cor, int idade){
        this.nome = nome;
        this.cor = cor;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "[nome=" + nome + ", cor=" + cor + ", idade=" + idade + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    } 

    
}

class ComparatorIdade implements Comparator<Gato> {

    /* (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(Gato g1, Gato g2) {
        // TODO Auto-generated method stub

        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
    
}

class ComparatorCor implements Comparator<Gato> {

    /* (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(Gato g1, Gato g2) {
        // TODO Auto-generated method stub
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
    
}

class ComparatorNomeCorIdade implements Comparator<Gato> {

    /* (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(Gato g1, Gato g2) {

        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome !=0) return nome;

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor!=0) return cor;


        return Integer.compare(g1.getIdade(), g2.getIdade()) ;
    }
    
}